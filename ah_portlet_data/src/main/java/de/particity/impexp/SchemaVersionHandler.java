package de.particity.impexp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SchemaVersionHandler extends DefaultHandler {

	private Log m_objLog = LogFactoryUtil.getLog(SchemaVersionHandler.class);
	
	private String m_strVersion = null;
	
	@Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
		
	    if (qName.equals("ImportExportRoot")) {
	    	//m_objLog.info("Found root elem");
	    	if (attributes != null) {
	    		for (int i=0; i<attributes.getLength();i++) {
	    			//m_objLog.info("Found attribute with local "+attributes.getLocalName(i)+", qName "+attributes.getQName(i));
	    			if (attributes.getQName(i).equals("Version")) {
	    				//m_objLog.info("Found attributes!");
	    				m_strVersion = attributes.getValue(i);
	    			}
	    		}
	    	}
	    	// root element has been parsed,
	    	// regardless of the result, stop right here
	    	throw new SchemaVersionEscapeException();
	    }
    }
	
	public String getVersion() {
		return m_strVersion;
	}

}
