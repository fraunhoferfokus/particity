package de.particity.impexp;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBElement;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.particity.impexp.imp.Importer100;

public class ImporterFactory {
	
	private Log m_objLog = LogFactoryUtil.getLog(ImporterFactory.class);
	
	protected int[] getSchemaVersionFromXmlData(InputStream xmlData) {
		int[] result = new int[]{-1,-1,-1};
		
		return result;
	}
	
	public void importData(InputStream xmlData) {
		int[] ver = getSchemaVersionFromXmlData(xmlData);
		List<E_SchemaVersion> upgradePath = E_SchemaVersion.getUpgradePath(ver[0], ver[1], ver[2], true);
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
