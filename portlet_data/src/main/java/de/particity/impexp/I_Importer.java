package de.particity.impexp;

import java.io.InputStream;

import javax.xml.bind.JAXBElement;

/**
 * An interface for implementations that provide import functionality for
 * different versions of an XML-schema
 * 
 * @author sma
 *
 */
public interface I_Importer {

	/**
	 * Parse input data and provide the JAXBElement for the XML-schema
	 * supported that specific implementation
	 * 
	 * @param xmlData The XML-data as stream
	 * @return The JAXBElement containing a XML-structured version of the input stream
	 */
	public JAXBElement importData(InputStream xmlData) throws ImportFailedException;

	/**
	 * Convert data from another version (always the former schema version)
	 * to the format supported by this specific implementation
	 * 
	 * @param xmlObj structured XML from a previous schema-version
	 * @return structured XML converted to the current schema-version provided by this specific implementation
	 */
	public JAXBElement convertData(JAXBElement xmlObj) throws ImportFailedException;
}
