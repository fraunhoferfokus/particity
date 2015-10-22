package de.particity.impexp;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.particity.impexp.imp.Importer100;

public class ImporterFactory {
	
	private Log m_objLog = LogFactoryUtil.getLog(ImporterFactory.class);
	
	protected E_SchemaVersion getSchemaVersionFromXmlData(InputStream xmlData) {
		E_SchemaVersion result = null;
		
		try {
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			InputSource inputSource = new InputSource(xmlData);
			String value = (String) xpath.evaluate("/ImportExportRoot/@Version", inputSource,XPathConstants.STRING);
			if (value != null) {
				result = E_SchemaVersion.valueOf(value);
			}
        } catch (Throwable e) {
	        m_objLog.error("Error parsing version from input source",e);
        }
		
		return result;
	}
	
	public void importData(InputStream xmlData) {
		E_SchemaVersion ver = getSchemaVersionFromXmlData(xmlData);
		if (ver != null) {
			List<E_SchemaVersion> upgradePath = E_SchemaVersion.getUpgradePath(ver);
			JAXBElement objData = null;
			for (int i=upgradePath.size()-1;i>=0;i--) {
				I_Importer importer = getImporter(upgradePath.get(i));
				if (importer != null) {
					if (objData == null) {
						// TODO - add exception handling
						objData = importer.importData(xmlData);
					} else {
						// TODO - add exception handling
						objData = importer.convertData(objData);
					}
				}
			}
			if (objData != null) {
				ImportWriter writer = new ImportWriter();
				writer.write(objData);
			}
		}
	}
	
	protected I_Importer getImporter(E_SchemaVersion version) {
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
