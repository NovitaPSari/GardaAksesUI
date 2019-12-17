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

//Login//
def UserID = 'DNS'
def Password = 'Password95'

//Create Ticket//
def ContactLine = 'Provider'
def Product = 'Health'
def ChannelType = 'Call'
def ContactName = findTestData('ContactName').getValue(1, 1)
def ContactType = 'Lainnya'
def ServiceType = 'Claim'
def InterruptedCall = null //Yes or null
def GenderCT = null
def CustomerPhone = null
def ProviderName = 'OJKSH00001'
def ProviderPhoneNumber = null
def Email = null
def Fax = null

//Inquiry//
def SearchBy = 'TicketNo'
def SearchBy2 = 'TicketNo'
def SearchBy3 = 'TicketNo'

//Claim
//Member = Existing  / New / Check
def Member = 'Existing'
def Member2 = null
def Member3 = null
def Member4 = null
def Member5 = null
// MemberStatus = Non Client / Client
def MemberStatus = 'Client'
def MemberName = findTestData('MemberNameClient').getValue(1, 1)
def NewMemberType = null
def NewMemberName = findTestData('ParameterPolicyNo').getValue(1, 1)
//PT SHOWA INDONESIA MANUFACTURING // PT BANK PERMATA TBK
def ClientName = null
def EmployeeID = null
def Year = null
def Month = null
//Level 13-14A // Gol. V  / IP-1590 / Kls VIP
def Classification = null
def Gender = null
def FamilyPhoneNo = '081214998614'
def ProductType = 'Inpatient'
def GLType = 'Awal'
def DiagnosisStatus = 'Initial Primary'
def Diagnosis = 1
def DiagnosisID = 'A09 '
def DoctorName = 'Betsy Kalianda'
//Rujuk = yes / no
def Rujuk = null
def Reason = null
def TotalBilled = null
def NPNFU = null
def Status = 'Process'
def Summary = GlobalVariable.SummaryDijaminkan
def Validasi = null

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

//Query DB
def queryContactName = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'Automation Tester\')+1 WHERE Name = \'Automation Tester\''
CustomKeywords.'querySQL.update.connectDB'('172.16.94.48', 'litt', 'sa', 'Password95')
CustomKeywords.'querySQL.update.execute'(queryContactName)

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/GL Inquiry/GL Inquiry'), 
	[('GLType') : GLType,
		('TicketID') : null,
		('NewMemberName') : null])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'), 
	[('Member') : Member, 
		('MemberStatus') : MemberStatus, 
		('MemberName') : MemberName,
		('FamilyPhoneNo') : FamilyPhoneNo, 
		('ProductType') : ProductType, 
		('GLType') : GLType, 
		('DiagnosisStatus') : DiagnosisStatus, 
		'Diagnosis' : Diagnosis,
		('DiagnosisID') : DiagnosisID, 
		('DoctorName') : DoctorName, 
		('Rujuk') : null,
		('NPNFU') : null,
		('Status') : Status, 
		('Summary') : Summary, 
		('Validasi') : Validasi,
		('InterruptedCall') : InterruptedCall])