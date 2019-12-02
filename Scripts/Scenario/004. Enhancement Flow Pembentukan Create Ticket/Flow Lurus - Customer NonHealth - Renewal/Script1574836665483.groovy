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
def Product = 'Non Health'
def ChannelType = 'WhatsApp' //Bebas
def ContactName = findTestData('ContactName').getValue(1, 1)
def ContactType = 'Teman' //Bebas
def ServiceType = 'Renewal'
def InterruptedCall = null //Yes or Null
def CustomerPhone = '081240722346'
def GenderCT = 'Male'
def ProviderName = 'OJKSH00001'
def ProviderPhoneNumber = null
def Email = null
def Fax = null
def GLType = 'Awal'

//Choose Customer
def ChooseCategoryCustomer = 'Policy Holder / Relatives'// Policy Holder / Relatives or Others
def SearchBy = 'Policy Number'
def Parameter = findTestData('ParameterPolicyNo').getValue(4, 1)

//Query DB
def queryContactName = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'Automation Tester\')+1 WHERE Name = \'Automation Tester\''

def queryNewMemberName = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'Automation GA\')+1 WHERE Name = \'Automation GA\''

def queryNewEmployeeID = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'EmployeeID\')+1 WHERE Name = \'EmployeeID\''

CustomKeywords.'querySQL.update.connectDB'('172.16.94.48', 'litt', 'sa', 'Password95')

CustomKeywords.'querySQL.update.execute'(queryContactName)

CustomKeywords.'querySQL.update.execute'(queryNewMemberName)

CustomKeywords.'querySQL.update.execute'(queryNewEmployeeID)

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Login/Login'),
	[('UserID') : UserID,
		('Password') : Password])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Home/Home - Create Ticket'), [:])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'),
	[('ContactLine') : ContactLine,
		('Product') : Product,
		('ChannelType') : ChannelType,
		('ContactName') : ContactName,
		('ContactType') : ContactType,
		('ServiceType') : ServiceType,
		('InterruptedCall') : InterruptedCall,
		('CustomerPhone') : CustomerPhone,
		('GenderCT') : GenderCT,
		('ProviderName') : ProviderName,
		('ProviderPhoneNumber') : ProviderPhoneNumber,
		('Email') : Email,
		('Fax') : Fax,
		('GLType') : GLType])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Choose Customer/Choose Customer'),
	[('ChooseCategoryCustomer') : ChooseCategoryCustomer,
		('SearchBy') : SearchBy,
		('Parameter') : Parameter], FailureHandling.STOP_ON_FAILURE)