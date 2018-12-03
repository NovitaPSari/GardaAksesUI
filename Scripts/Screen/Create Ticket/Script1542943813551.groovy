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

WebUI.delay(3)

WebUI.setText(findTestObject('Claim MV/Create Ticket/TXT_CALLER_NAME'), 'BTE')

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Create Ticket/RDB_MALE'))

WebUI.delay(1)

WebUI.setText(findTestObject('Claim MV/Create Ticket/TXT_EMAIL'), 'bte@mailinator.com')

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Create Ticket/EXP_RELATIONSHIP'))

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Create Ticket/LST_RELATIONSHIP', [('relation') : 'Adik']))

WebUI.delay(1)

WebUI.setText(findTestObject('Claim MV/Create Ticket/TXT_COUNTRY'), '62')

WebUI.delay(1)

WebUI.setText(findTestObject('Claim MV/Create Ticket/TXT_AREA_CODE'), '21')

WebUI.delay(1)

WebUI.setText(findTestObject('Claim MV/Create Ticket/TXT_PHONE_NUMBER'), '232323')

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Create Ticket/BTN_NEXT_1'))

WebUI.delay(12)

WebUI.click(findTestObject('Claim MV/Create Ticket/LST_CALLER_1'))

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Create Ticket/BTN_NEXT_2'))

WebUI.delay(8)

WebUI.click(findTestObject('Object Repository/Claim MV/Create Ticket/BTN_SAVE'))

WebUI.delay(3)

WebUI.click(findTestObject('Claim MV/Create Ticket/BTN_SAVE_YES'))

WebUI.delay(8)

