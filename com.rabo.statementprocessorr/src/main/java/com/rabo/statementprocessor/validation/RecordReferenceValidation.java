package com.rabo.statementprocessor.validation;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.rabo.statementprocessor.validation.*;

import java.math.BigDecimal;

/**
 * this class compares the reference of each customer and stores details,and
 * removes the failed references.
 */

public class RecordReferenceValidation {
	/**
	 * 
	 * @param customerData
	 * @ In this method the customerData has taken as the string array and unique
	 * records were added to the list of valid records and failed records were added
	 * to the failed records.
	 * @exception IOException,ClassNotFoundException
	 *                On input error.
	 * @see IOException,ClassNotFoundException.
	 */
	public static ArrayList<String> InvalidRecords;
	public static ArrayList<String> failedrecords;

	public static ArrayList<String> validationMethod(String[] customerData) throws IOException, ClassNotFoundException {
		InvalidRecords = new ArrayList<String>(Arrays.asList(customerData));
		failedrecords = new ArrayList<String>();
		Arrays.sort(customerData);
		for (int i = 1; i < customerData.length; i++) {
			if (customerData[i].substring(0, 6).equals(customerData[i - 1].substring(0, 6))) {
				InvalidRecords.remove(customerData[i]);
				failedrecords.add(customerData[i]);
			}
		}
		return failedrecords;
	}
}
