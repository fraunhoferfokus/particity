package de.particity.impexp.imp;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import de.particity.impexp.E_SchemaVersion;
import de.particity.impexp.I_Importer;
import de.particity.schemagen.impexpv100.ImportExportRoot;

public class Importer100 implements I_Importer {

	private JAXBContext m_objCtx = null;
	private static final E_SchemaVersion SUPPORTED_PRE = E_SchemaVersion.V100;
	
	public Importer100() throws JAXBException {
		m_objCtx = JAXBContext.newInstance("de.particity.schemagen.impexpv100");
	}
	
	@Override
	public JAXBElement<ImportExportRoot> importData(InputStream xmlData) {
		JAXBElement<ImportExportRoot> result = null;
		try {
			Unmarshaller um = m_objCtx.createUnmarshaller();
			Object obj = um.unmarshal(xmlData);
			if (obj instanceof ImportExportRoot) {
				result = new JAXBElement<ImportExportRoot>(new QName(E_SchemaVersion.V100.name(),"root"), ImportExportRoot.class, (ImportExportRoot) obj);
			} else {
				// TODO - throw exception
			}
		} catch (UnmarshalException e) {
			// TODO - throw own exception
		} catch (IllegalArgumentException e) {
			// TODO - throw own exception
		} catch (JAXBException e) {
	        // TODO - throw own exception
        }
		
		return result;
	}

	@Override
    public JAXBElement<ImportExportRoot> convertData(JAXBElement xmlObj) {
		JAXBElement<ImportExportRoot> result = null;
		
		// TODO - throw exception for previous versions
		
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
		
		return result;
    }
	
}
