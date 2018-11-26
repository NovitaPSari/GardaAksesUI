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

GlobalVariable.policyno = findTestData("Policy").getValue(1, 1)

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Choose Customer/EXP_SEARCH_BY_PARAMETER'))

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Choose Customer/LST_SEARCH_BY_PARAMETER', [('parameter') : 'Policy Number']))

WebUI.delay(1)

WebUI.setText(findTestObject('Claim MV/Choose Customer/TXT_SEARCH_BY_INPUT'), GlobalVariable.policyno)

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Choose Customer/BTN_SEARCH'))

WebUI.delay(15)

WebUI.click(findTestObject('Claim MV/Choose Customer/LST_POLICY_NUMBER'))

WebUI.delay(1)

WebUI.click(findTestObject('Claim MV/Choose Customer/BTN_NEXT'))

WebUI.delay(5)

WebUI.click(findTestObject('Claim MV/Choose Customer/BTN_FINISH'))

WebUI.delay(2)

WebUI.click(findTestObject('Claim MV/Choose Customer/BTN_YES'))

WebUI.delay(7)

