package de.particity.impexp;

import java.io.InputStream;

import javax.xml.bind.JAXBElement;

public interface I_Importer {

	public JAXBElement importData(InputStream xmlData);

	public JAXBElement convertData(JAXBElement xmlObj);
}
