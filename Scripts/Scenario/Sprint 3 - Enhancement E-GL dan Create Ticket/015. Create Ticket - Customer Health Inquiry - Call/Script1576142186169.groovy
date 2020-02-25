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
String SubMenu = 'Create Ticket'

//Create Ticket//
def ContactLine = 'Customer'

def Product = 'Health'

def ChannelType = 'Call' //Bebas

def ContactName = findTestData('ContactName').getValue(1, 1)

def ContactType = 'Teman' //Bebas

def ServiceType = 'Inquiry'

def InterruptedCall = 'No' //Yes or Null

String CustomerGender = 'Male'

def ActionCT = 'Next'

//Inquiry//
def MemberName = findTestData('MemberNameAll').getValue(1, 1)

def SubServiceType = 'Quotation'

def Remarks = 'Currently testing by Automation. Thanks. Regards - Me'

def NeedFollowUp = 'No'

def ActionI = 'Process'

//Exit Confirmation
String ECAction1 = 'Tidak'

String ECAction2 = 'Puas'

String Comment = 'Currently testing by Automation. Thanks. Regards - Me'

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserID, ('Password') : Password])

WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('CustomerGender') : CustomerGender, ('Action') : ActionCT])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Customer - Health - Inquiry'), 
	[('MemberName') : MemberName, 
		('SubServiceType') : SubServiceType, 
		('Remarks') : Remarks, 
		('NeedFollowUp') : NeedFollowUp,
		('ActionI') : ActionI,
		('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
	, ('ECAction2') : ECAction2, ('Comment') : Comment])

WebUI.comment(GlobalVariable.TicketID1)