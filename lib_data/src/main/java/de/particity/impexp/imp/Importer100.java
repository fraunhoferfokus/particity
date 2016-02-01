package de.particity.impexp.imp;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.particity.impexp.E_SchemaVersion;
import de.particity.impexp.I_Importer;
import de.particity.impexp.ImportFailedException;
import de.particity.schemagen.impexpv100.ImportExportRoot;

public class Importer100 implements I_Importer {

	private Log m_objLog = LogFactoryUtil.getLog(Importer100.class);
	
	private JAXBContext m_objCtx = null;
	private static final E_SchemaVersion SUPPORTED_PRE = E_SchemaVersion.V100;
	
	public Importer100() throws JAXBException {
		m_objCtx = JAXBContext.newInstance("de.particity.schemagen.impexpv100");
	}
	
	@Override
	public JAXBElement<ImportExportRoot> importData(InputStream xmlData) throws ImportFailedException {
		JAXBElement<ImportExportRoot> result = null;
		try {
			Unmarshaller um = m_objCtx.createUnmarshaller();
			Object obj = um.unmarshal(xmlData);
			if (obj instanceof ImportExportRoot) {
				result = new JAXBElement<ImportExportRoot>(new QName("http://github.com/fraunhoferfokus/particity/ImportExport","ImportExportRoot"), ImportExportRoot.class, (ImportExportRoot) obj);
			}
		} catch (Throwable t) {
			m_objLog.warn("Error unmarshalling import data",t);
			throw new ImportFailedException(ImportFailedException.IMPORT_UNMARSHAL_FAIL);
		}
		
		return result;
	}

	@Override
    public JAXBElement<ImportExportRoot> convertData(JAXBElement xmlObj) throws ImportFailedException {
		//JAXBElement<ImportExportRoot> result = null;
		
		throw new ImportFailedException(ImportFailedException.IMPORT_VERSION_UNSUPPORTED);
		
		/**
		 * Example
		 */
		/*if (xmlObj != null) {
			String ver = xmlObj.getName().getNamespaceURI();
			E_SchemaVersion verObj = ver != null ? E_SchemaVersion.valueOf(ver) : null;
			if (verObj != null) {
				
				if (verObj.equals(SUPPORTED_PRE)) {
					
					
					
				} else {
					// TODO - throw exception
				}
			} else {
				// TODO - throw exception
			}
		}*/
		
		//return result;
    }
	
}
