package com.rabo.statementprocessor.validation;

import java.util.ArrayList;

public class FailedRecordReferences {

	public static void duplicateReferences(ArrayList<String> failedReferences) {
		System.out.println("failed record references");
		for (String failedRecords : failedReferences) {
			System.out.println(failedRecords);
		}
	}
}
