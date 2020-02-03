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
def UserID = 'DNS'

def Password = 'Password95'

//Create Ticket//
def ContactLine = 'Customer'

def Product = 'Health'

def ChannelType = 'Call' //Bebas

def ContactName = findTestData('ContactName').getValue(1, 1)

def ContactType = 'Saudara' //Bebas

def ServiceType = 'Complaint'

def InterruptedCall = null //Yes or Null

def GenderCT = 'Male'

def CustomerPhone = '081240722346'

def ProviderName = 'OJKSH00001'

def ProviderPhoneNumber = null

def Email = null

def Fax = null

def GLType = 'Awal'

def ActionCT = 'Next'

//Inquiry Complaint//
def VerifyTicket = 'Yes'

def NewComplaint = 'Yes'

//Complaint//
def MemberNo = findTestData('MemberNoAll').getValue(1, 1)

def ComplaintCategory = 'Aplikasi'

def ComplaintSubCategory = 'Aplikasi Medcare'

def ComplaintSubCategory2 = 'HR Akses'

def ComplaintDescription = 'Currently testing by Automation. Thanks. Regards - Me'

def TicketStatus = 'Need FU - CMU'

def ButtonDirection = 'Back'

def ButtonDirection2 = 'Save'

def MultipleServiceType = null

def ExitConfirmation1 = 'No'

def ExitConfirmation2 = 'Puas'

def ExitConfirmation3 = null

def Comment = 'Currently testing by Automation. Thanks. Regards - Me'

//Query DB
def queryContactName = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'Automation Tester\')+1 WHERE Name = \'Automation Tester\''

CustomKeywords.'querySQL.Template.connectDB'('172.16.94.48', 'litt', 'sa', 'Password95')

CustomKeywords.'querySQL.Template.execute'(queryContactName)

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Login/Login'), [('UserID') : UserID, ('Password') : Password])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Home/Home - Create Ticket'), [:])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('CustomerPhone') : CustomerPhone, ('CustomerGender') : GenderCT, ('ProviderName') : ProviderName
        , ('ProviderPhoneNumber') : ProviderPhoneNumber, ('Email') : Email, ('Fax') : Fax, ('GLType') : GLType, ('Action') : ActionCT])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Complaint Inquiry'), [('VerifyTicket') : VerifyTicket
        , ('NewComplaint') : null])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Verify Create Ticket'), [('ContactName') : ContactName])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Complaint Inquiry'), [('VerifyTicket') : null, ('NewComplaint') : NewComplaint])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Complaint'), 
	[('NewComplaint') : NewComplaint, 
		('MemberNo') : MemberNo, 
		('ComplaintCategory') : ComplaintCategory,
		('ComplaintSubCategory') : ComplaintSubCategory,
		('ComplaintDescription') : ComplaintDescription,
		('TicketStatus') : TicketStatus,
		('ButtonDirection') : ButtonDirection2,
		('MultipleServiceType') : MultipleServiceType,
		('ExitConfirmation1') : ExitConfirmation1,
		('ExitConfirmation2') : ExitConfirmation2,
		('ExitConfirmation3') : ExitConfirmation3])