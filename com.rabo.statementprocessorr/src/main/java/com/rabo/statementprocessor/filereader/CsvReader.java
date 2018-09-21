package com.rabo.statementprocessor.filereader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.rabo.statementprocessor.validation.RecordReferenceValidation;
import com.rabo.statementprocessorInterface.FileProcessor;
import com.rabo.statementprocessor.pojo.CsvANDXmlPojo;
import com.rabo.statementprocessor.validation.*;

/**
 * 
 * this class reads the csv file and converts each customer records into string
 * and store that into array for further validation.
 */
@Component
@Primary
public class CsvReader implements FileProcessor {

	ArrayList<CsvANDXmlPojo> csvPojoList = new ArrayList<CsvANDXmlPojo>();
	String[] cusDetails;

	@SuppressWarnings({ "deprecation", "unchecked" })
	/**
	 * This is the Method implemented from the FileProcessor Interface,in this the
	 * csv file will be read by ColumnPositionMappingStrategy
	 * 
	 * @param args
	 *            Unused.
	 * 
	 * 
	 */

	public String[] process() throws IOException, SAXException, ParserConfigurationException, ClassNotFoundException {
		CSVReader csvreader = null;
		try {
			csvreader = new CSVReader(new FileReader("input.csv"), ',', '"', 1);

			@SuppressWarnings("rawtypes")
			ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
			strategy.setType(CsvANDXmlPojo.class);
			String[] csv = { "reference", "accountNumber", "description", "startBal", "mutation", "endBal" };
			strategy.setColumnMapping(csv);

			@SuppressWarnings("rawtypes")
			CsvToBean ctb = new CsvToBean();
			@SuppressWarnings({ "rawtypes", "unused" })
			ArrayList csvList = (ArrayList) ctb.parse(strategy, csvreader);
			CsvANDXmlPojo[] csvarr = (CsvANDXmlPojo[]) csvList.toArray(new CsvANDXmlPojo[csvList.size()]);

			cusDetails = new String[csvarr.length];

			for (int i = 0; i < csvarr.length; i++) {
				cusDetails[i] = csvarr[i].getReference() + "," + csvarr[i].getAccountNumber() + ","
						+ csvarr[i].getDescription() + "," + csvarr[i].getStartBal() + "," + csvarr[i].getMutation()
						+ "," + csvarr[i].getEndBal();
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}

		finally {
			try {
				// closing the reader
				csvreader.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		return cusDetails;

	}

}