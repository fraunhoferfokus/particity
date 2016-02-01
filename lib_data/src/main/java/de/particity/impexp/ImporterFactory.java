package de.particity.impexp;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.theme.ThemeDisplay;

import de.particity.impexp.imp.Importer100;

/**
 * Internally provides importer implementations for different schema versions
 * 
 * @author sma
 *
 */
public class ImporterFactory {
	
	private static Log m_objLog = LogFactoryUtil.getLog(ImporterFactory.class);
	
	protected static E_SchemaVersion getSchemaVersionFromXmlData(InputStream xmlData) throws ImportFailedException {
		E_SchemaVersion result = null;
		
		try {
			
			// mark begin of stream
			if (xmlData.markSupported())
				xmlData.mark(xmlData.available());
			
			// parse using SAX
			String value = null;
			SchemaVersionHandler svp = new SchemaVersionHandler();
			try {
		        SAXParserFactory spf= SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
				// parse() throws the exception below, if the version is found
				// this way we don't need to read the whole stream
	            sp.parse(xmlData, svp);
			} catch (SchemaVersionEscapeException e) {
	            // get parse result
				value = svp.getVersion();
				if (value != null) {
		            // reset stream back to begin
					xmlData.reset();
				}
			}
			
			if (value != null) {
				result = E_SchemaVersion.valueOf(value);
			}
        } catch (Throwable e) {
	        m_objLog.error("Error parsing version from input source",e);
	        throw new ImportFailedException(ImportFailedException.IMPORT_VERSIONPARSE_FAIL);
        }
		
		return result;
	}
	
	public static Map<String, String> importData(InputStream xmlData, long companyId, long groupId, long userId) throws ImportFailedException {
		Map<String, String> log = null;
		E_SchemaVersion ver = getSchemaVersionFromXmlData(xmlData);
		if (ver != null) {
			List<E_SchemaVersion> upgradePath = E_SchemaVersion.getUpgradePath(ver);
			JAXBElement objData = null;
			for (int i=upgradePath.size()-1;i>=0;i--) {
				I_Importer importer = getImporter(upgradePath.get(i));
				if (importer != null) {
					if (objData == null) {
						objData = importer.importData(xmlData);
					} else {
						objData = importer.convertData(objData);
					}
				} else {
					throw new ImportFailedException(ImportFailedException.IMPORT_IMPL_MISSING);
				}
			}
			if (objData != null) {
				ImportWriter writer = new ImportWriter(userId,groupId,companyId);
				writer.write(objData);
				log = writer.getLog();
				writer.cleanup();
			} else
				throw new ImportFailedException(ImportFailedException.IMPORT_LOAD_FAIL);
		} else {
			throw new ImportFailedException(ImportFailedException.IMPORT_VERSIONPARSE_FAIL);
		}
		return log;
	}
	
	protected static I_Importer getImporter(E_SchemaVersion version) {
		I_Importer result = null;
		
		try {
			if (version != null) {
				switch (version) {
					case V100:
						result = new Importer100();
						break;
				}
			}
		} catch (Throwable t) {
			m_objLog.error("Could not initialize importer for version "+version,t);
		}
		
		return result;
	}
	
}
