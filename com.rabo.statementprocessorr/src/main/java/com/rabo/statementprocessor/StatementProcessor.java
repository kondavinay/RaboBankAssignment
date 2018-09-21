package com.rabo.statementprocessor;

import com.rabo.statementprocessor.validation.EndBalanceValidation;
import com.rabo.statementprocessor.validation.FailedRecordReferences;
import com.rabo.statementprocessor.validation.InvalidEndBalances;
import com.rabo.statementprocessor.validation.RecordReferenceValidation;
import com.rabo.statementprocessorInterface.FileProcessor;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

@Component
public class StatementProcessor {

	@Autowired
	FileProcessor file;

	public FileProcessor getFile() {
		return file;
	}

	public void setFile(FileProcessor file) {
		this.file = file;
	}

	public void csvAndXmlFileReading() throws ClassNotFoundException {
		System.out.println("file reading");
		try {
			FailedRecordReferences.duplicateReferences(RecordReferenceValidation.validationMethod(file.process()));
			InvalidEndBalances.duplicateEndBalances(EndBalanceValidation.details(RecordReferenceValidation.InvalidRecords));
		} catch (IOException e) {

			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		}
	}
}
