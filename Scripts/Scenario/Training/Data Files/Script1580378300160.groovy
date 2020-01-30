import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


//ArrayList TestData = findTestData("trainingKatalon").getAllData()
//
//println ((TestData[0])[0] + " saya adalah " + (TestData[1])[1])

def TestVariable1 = findTestData("trainingKatalon").getValue(2, 2)

println TestVariable1

def queryContactName = 'UPDATE GardaAkses_MasterID SET Number = Number+1 WHERE Name = \'Automation Tester\''

CustomKeywords.'querySQL.update.connectDB'('172.16.94.48', 'litt', 'sa', 'Password95')

CustomKeywords.'querySQL.update.execute'(queryContactName)

String Value = a

def query2 = 'UPDATE GardaAkses_MasterID SET Number = Number+1 WHERE Name = \'Automation Tester\''

CustomKeywords.'querySQL.update.connectDB'('172.16.94.70', 'litt', 'sa', 'Password95')

CustomKeywords.'querySQL.update.execute'(query2)

def TestVariable2 = findTestData("trainingKatalon").getValue(2, 2)

String Value2 = a



println TestVariable2