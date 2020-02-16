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

def ChannelType = 'Email' //Bebas

def ContactName = findTestData('ContactName').getValue(1, 1)

def ContactType = 'Teman' //Bebas

def ServiceType = 'Inquiry'

def InterruptedCall = null //Yes or Null

def GenderCT = 'Male'

def CustomerPhone = '081240722346'

def ProviderName = 'OJKSH00001'

def ProviderPhoneNumber = null

def Email = 'automationtest@asuransiastra.com'

def Fax = null

def GLType = 'Awal'

def ActionCT = 'Next'

//Inquiry//
def MemberName = findTestData('MemberNoAll').getValue(1, 1)

def ProviderName2 = 'OJKSH00001'

def SubServiceType = 'Quotation'

def Remarks = 'Currently testing by Automation. Thanks. Regards - Me'

def NeedFollowUp = null

def Action = 'Proses'

def MultipleServiceType = null

def ButtonDirection1 = 'Back'

def ButtonDirection2 = 'Process'

def ExitConfirmation1 = 'No'

def ExitConfirmation2 = 'Puas'

def ExitConfirmation3 = null

def Comment = null

//Query DB
def queryContactName = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'Automation Tester\')+1 WHERE Name = \'Automation Tester\''

CustomKeywords.'querySQL.DefaultQuery.connectDB'('172.16.94.48', 'litt', 'sa', 'Password95')

CustomKeywords.'querySQL.DefaultQuery.execute'(queryContactName)

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Login/Login'),
	[('UserID') : UserID,
		('Password') : Password])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Home/Home - Create Ticket'), [:])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('CustomerPhone') : CustomerPhone, ('CustomerGender') : GenderCT, ('ProviderName') : ProviderName
        , ('ProviderPhoneNumber') : ProviderPhoneNumber, ('Email') : Email, ('Fax') : Fax, ('GLType') : GLType, ('Action') : ActionCT])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Inquiry'), 
	[('MemberName') : MemberName, 
		('ContactLine') : ContactLine, 
		('Product') : Product, 
		('ProviderName') : ProviderName2, 
		('SubServiceType') : SubServiceType, 
		('Remarks') : Remarks, 
		('NeedFollowUp') : NeedFollowUp, 
		'MultipleServiceType' : MultipleServiceType,
		'Action' : Action,
		('ButtonDirection') : ButtonDirection2, 
		('ExitConfirmation1') : ExitConfirmation1, 
		('ExitConfirmation2') : ExitConfirmation2, 
		('ExitConfirmation3') : ExitConfirmation3, 
		('Comment') : Comment])