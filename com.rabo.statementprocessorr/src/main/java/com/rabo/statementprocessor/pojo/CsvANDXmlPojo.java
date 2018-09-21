package com.rabo.statementprocessor.pojo;

public class CsvANDXmlPojo {

	private String reference;
	private String accountNumber;
	private String Description;
	private String StartBal;
	private String mutation;
	private String endBal;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getStartBal() {
		return StartBal;
	}

	public void setStartBal(String startBal) {
		StartBal = startBal;
	}

	public String getMutation() {
		return mutation;
	}

	public void setMutation(String mutation) {
		this.mutation = mutation;
	}

	public String getEndBal() {
		return endBal;
	}

	public void setEndBal(String endBal) {
		this.endBal = endBal;
	}
}
