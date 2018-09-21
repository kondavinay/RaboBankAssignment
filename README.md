Rabobank Customer Statement Processor Rabobank receives monthly deliveries of customer statement records. This information is delivered in two formats, CSV and XML. These records need to be validated.

Requirements:

> all transaction references should be unique the end balance needs to be validated

Field	: Description

A numeric value : Transaction reference

Account number : An IBAN

Start Balance: The starting balance in Euros

Mutation : Either and addition (+) or a deducation (-)

Description : Free text

End Balance : The end balance in Euros

com.rabo.statementprocessor1 project:

com.rabo.statementprocessor FileReader: FileReader Package:

This package consists of two classes

csv file reader : csv file reader class implements Fileprocessor interface and reads the csv file.

Xml file reader : xml file reader class implements Fileprocessor interface and reads the xml file.

com.rabo.statementprocessor.pojo

CsvAndXmlPojo: This pojo class was used in the File Reader Package classes.

com.rabo.statementprocessor.validation:

RecordReferenceValidation:This class validates the record references and validationMethod in this class returns the failedrecords.

FailedRecordReferences:This class has the method of duplicateReferences which print the duplicate record references.

EndBalanceValidation:This class validates the end balances based on the valid references returned by the RecordReferenceValidation class and print return the failed endbalances.

InvalidEndBalances:This class has the method duplicateEndBalances prints the failed endBalances.

FileProcessor Interface:This interface has the method process whic was implements in the FileReader Package classes.

com.rabo.statementprocessor:

Fileconfigclass: The configuration and componentscan annotations were used in this class for assigining the base packages.

Statementprocessorclass: This class consists of the method csvandxmlFileReading which was autowired.

CustomerDetailsClass: This is the main class by using applicationcontext reference the csv and xml reader class can be invoked by using primary annotation in filereaderpackage classes.

input.csv is the file i have used has the reference file in CsvFileReader.

input.xml is the file i have used has the reference file in XmlFileReader.
