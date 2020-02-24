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
String ContactLine = 'Provider'

String Product = 'Health'

String ChannelType = 'Call'

String ContactName = findTestData('ContactName').getValue(1, 1)

String ContactType = 'Lainnya'

String ServiceType = 'Inquiry'

String InterruptedCall = 'No'

String ProviderName = 'OJKSH00001'

String ActionCT = 'Next'

//Inquiry//
def MemberName = findTestData('MemberNoAll').getValue(1, 1)

def SubServiceType = 'Quotation'

def Remarks = 'Currently testing by Automation. Thanks. Regards - Me'

def NeedFollowUp = null

def Action = 'Process'

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Login/Login'), 
	[('UserID') : UserID
		, ('Password') : Password])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Home/Home'), 
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
		, ('ProviderName') : ProviderName
		, ('Action') : ActionCT])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Approval Tindakan Terapi Obat'), [('ServiceType') : ServiceType, ('MemberName') : MemberName
        , ('SubServiceType') : SubServiceType, ('Remarks') : Remarks, ('NeedFollowUp') : NeedFollowUp, ('Action') : Action, MultipleServiceType : MultipleServiceType
		,'ExitConfirmation1' : ExitConfirmation1, 'ExitConfirmation2' : ExitConfirmation2, 'ExitConfirmation3' : ExitConfirmation3], FailureHandling.STOP_ON_FAILURE)