import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//Choose Customer 1
//WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Button - X'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Radio Button - Category', [('ChooseCategoryCustomer') : ChooseCategoryCustomer]))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Button - Next'))

//Choose Customer 2
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Button - Search By'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Choose - Parameter Search By', [('SearchBy') : SearchBy]))

WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Input - Parameter Search'), Parameter)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Button - Search'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Button - Choose Customer'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Button - Next'))

//Choose Customer 3
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Button - Policy Summary'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Choose - Policy Summary'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Button - Finish'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Button - Yes Save Customer'))


