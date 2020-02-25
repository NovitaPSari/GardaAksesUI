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

//Login//
String UserID = 'DNS'

String Password = 'Password95'

//Home
String Menu = 'General'

String SubMenu = 'Create Ticket'

//Create Ticket//
String ContactLine = 'Customer'

String Product = 'Non Health'

String ChannelType = 'Twitter'

String ContactName = findTestData('ContactName').getValue(1, 1)

String ContactType = 'Teman'

String ServiceType = 'Cancellation'

String InterruptedCall = 'No'

String CustomerGender = 'Male'

String ActionCT = 'Next'

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'),
	[('UserID') : UserID
		, ('Password') : Password])

//==================== PHASE 1 ====================
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'),
	[('Menu') : Menu
		, ('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'),
	[('ContactLine') : ContactLine
		, ('Product') : Product
		, ('ChannelType') : ChannelType
		, ('ContactName') : ContactName
		, ('ContactType') : ContactType
		, ('ServiceType') : ServiceType
		, ('InterruptedCall') : InterruptedCall
		, ('CustomerGender') :CustomerGender
		, ('Action') : ActionCT])

CustomKeywords.'querySQL.Query.QueryContactName'()