package com.rabo.statementprocessor.validation;

import java.util.ArrayList;

public class InvalidEndBalances {
	public static void duplicateEndBalances(ArrayList<String> failedvalidations) {
		System.out.println("\nfailed  EndBalance validation records");
		for (String endBalFailedRecords : failedvalidations) {

			System.out.println(endBalFailedRecords);
		}
	}
}
