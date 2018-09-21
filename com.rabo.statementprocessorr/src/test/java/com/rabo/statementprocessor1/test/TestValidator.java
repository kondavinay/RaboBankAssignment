package com.rabo.statementprocessor1.test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import com.rabo.statementprocessor.validation.RecordReferenceValidation;
public class TestValidator{
	
	String[] record = {"123456Richard", "123456John"};
    ArrayList<String> dataList = new ArrayList<String>();
    
    @Before
    public void setUp(){
    dataList.add("123456Richard");
    }
    
	@Test
	public void testValidateData() throws Exception
	{
	assertEquals(dataList, RecordReferenceValidation.validationMethod(record));
	}	
}