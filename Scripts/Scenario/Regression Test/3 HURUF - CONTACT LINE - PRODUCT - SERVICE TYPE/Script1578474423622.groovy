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

//Home//
def Menu = 'General'

def SubMenu = 'Create Ticket'

//Create Ticket//
def ContactLine = 'Customer'

def Product = 'Non Health'

def ChannelType = 'Call'

def ContactName = findTestData('ContactName').getValue(1, 1)

def ContactType = 'Teman'

def ServiceType = 'Cancellation'

def InterruptedCall = null //Yes or null

def ProviderName = 'OJKSH00001'

def CustomerGender = 'Male'

def ActionCreateTicket = 'Next'

//Choose Customer//
def ChooseCategoryCustomer = 'Policy Holder / Relatives'

def ActionChooseCustomer1 = 'Next'

def SearchBy = 'Customer Name'

def Parameter = 'Teguh'

//Query DB
def queryContactName = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'Automation Tester\')+1 WHERE Name = \'Automation Tester\''

CustomKeywords.'querySQL.update.connectDB'('172.16.94.48', 'litt', 'sa', 'Password95')

CustomKeywords.'querySQL.update.execute'(queryContactName)

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Login/Login'), [('UserID') : UserID, ('Password') : Password])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Home/Home'), [('Menu') : Menu, ('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('ProviderName') : ProviderName, ('CustomerGender') : CustomerGender, ('Action') : ActionCreateTicket])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Choose Customer/Choose Customer'), 
	[('ChooseCategoryCustomer') : ChooseCategoryCustomer, 
		('Action') : ActionChooseCustomer1,
		('SearchBy') : SearchBy,
		('Parameter') : Parameter])