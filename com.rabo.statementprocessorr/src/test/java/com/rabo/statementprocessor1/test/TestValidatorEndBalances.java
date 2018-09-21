package com.rabo.statementprocessor1.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.rabo.statementprocessor.validation.EndBalanceValidation;

public class TestValidatorEndBalances {

ArrayList<String>FailedEndBalances = new ArrayList<String>();

	ArrayList<String> endTest=new ArrayList<String>();
	
	@Before
	public void setUp(){
		endTest.add("194261,NL91RABO0315273637,Clothes from Jan Bakker,21.6,-41.83,-20.23");
		endTest.add("195446,NL74ABNA0248990274,Flowers for Willem Dekker,26.32,48.98,75.3");
		FailedEndBalances.add("\nRecord\nTransaction Reference : " + 195446 + "\nDescription  : "
				+"Flowers for Willem Dekker");
	}
	
	@Test
	public void testValidator() throws IOException 
	{
		assertEquals(FailedEndBalances,EndBalanceValidation.details(endTest));
	}
	
	
	
}
