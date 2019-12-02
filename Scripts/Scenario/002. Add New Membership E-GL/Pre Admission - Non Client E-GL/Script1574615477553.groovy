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
def ContactLine = 'Provider'

def Product = 'Health'

def ChannelType = 'Call'

def ContactName = findTestData('ContactName').getValue(1, 1)

def ContactType = 'Farmasi'

def ServiceType = 'Claim'

def InterruptedCall = null //Yes or null

def GenderCT = null

def CustomerPhone = null

def ProviderName = 'OJKSH00001'

def ProviderPhoneNumber = null

def Email = null

def Fax = null

//Inquiry//
def SearchBy = null

def SearchBy2 = 'TicketNo'

//Claim
//Member = Existing  / New / Check
def Member = 'Existing'

def Member2 = 'New'

def Member3 = 'Check'

// MemberStatus = Non Client / Client
def MemberStatus = 'Non Client'

def NewMemberType = 'Employee'

def MemberName = findTestData('MemberNameClient').getValue(1, 1)

def NewMemberName = findTestData('ParameterPolicyNo').getValue(1, 1)

//NewMemberName =
//PT SHOWA INDONESIA MANUFACTURING // PT BANK PERMATA TBK
def ClientName = 'PT SHOWA INDONESIA MANUFACTURING'

def EmployeeID = findTestData('NewEmployeeID').getValue(1, 1)

def Year = '1996'

def Month = 'Aug'

//Level 13-14A // Gol. V  / IP-1590 / Kls VIP
def Classification = 'Gol. V  / IP-1590 / Kls VIP'

def Gender = 'Male'

def FamilyPhoneNo = '081214998614'

def ProductType = 'Inpatient'

def GLType = 'Awal'

def GLType2 = 'Lanjutan'

def GLType3 = 'Akhir'

def Date = new Date()

def DiagnosisStatus = 'Initial Primary'

def DiagnosisID = 'A09 '

def DoctorName = 'Betsy Kalianda'

//Rujuk = yes / no
def Rujuk = 'No'

def Reason = 'Yes'

def TotalBilled = '3000000'

def NPNFU = 'Yess'

def Status = 'Process'

def Status2 = 'Reject'

def Status3 = 'InteruptedCall'

def Status4 = 'PreAdmission'

def Summary = GlobalVariable.SummaryPreAdmission

def Summary2 = null

def Summary3 = null

def Validasi = null

def Validasi2 = null

def Validasi3 = null

//Query DB
def queryContactName = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'Automation Tester\')+1 WHERE Name = \'Automation Tester\''

def queryNewMemberName = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'Automation GA\')+1 WHERE Name = \'Automation GA\''

def queryNewEmployeeID = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'EmployeeID\')+1 WHERE Name = \'EmployeeID\''

CustomKeywords.'querySQL.update.connectDB'('172.16.94.48', 'litt', 'sa', 'Password95')

CustomKeywords.'querySQL.update.execute'(queryContactName)

CustomKeywords.'querySQL.update.execute'(queryNewMemberName)

CustomKeywords.'querySQL.update.execute'(queryNewEmployeeID)

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Login/Login'), [('UserID') : UserID, ('Password') : Password])

//==================== PHASE 1 ====================
WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Home/Home - Create Ticket'), [:])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('CustomerPhone') : CustomerPhone, ('GenderCT') : GenderCT, ('ProviderName') : ProviderName
        , ('ProviderPhoneNumber') : ProviderPhoneNumber, ('Email') : Email, ('Fax') : Fax, ('GLType') : GLType])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/GL Inquiry/GL Inquiry'), [('GLType') : GLType, ('TicketID') : null
        , ('NewMemberName') : null])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Claim V.2'), [('Member') : Member2, ('NewMemberType') : NewMemberType
        , ('NewMemberName') : NewMemberName, ('ClientName') : ClientName, ('EmployeeID') : EmployeeID, ('Year') : Year, ('Month') : Month
        , ('Classification') : Classification, ('Gender') : Gender, ('MemberStatus') : MemberStatus, ('MemberName') : MemberName
        , ('FamilyPhoneNo') : FamilyPhoneNo, ('ProductType') : ProductType, ('GLType') : GLType, ('DiagnosisStatus') : DiagnosisStatus
        , ('DiagnosisID') : DiagnosisID, ('DoctorName') : DoctorName, ('Rujuk') : null, ('NPNFU') : null, ('Status') : Status4
        , ('Summary') : Summary, ('Validasi') : Validasi, ('InterruptedCall') : InterruptedCall])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('CustomerPhone') : CustomerPhone, ('GenderCT') : GenderCT, ('ProviderName') : ProviderName
        , ('ProviderPhoneNumber') : ProviderPhoneNumber, ('Email') : Email, ('Fax') : Fax, ('GLType') : GLType2])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/GL Inquiry/GL Inquiry'), [('TicketID') : GlobalVariable.TicketIDAwal
        , ('GLType') : GLType2, ('Member') : Member])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Claim V.2'), [('Member') : Member3, ('MemberStatus') : null
        , ('NewMemberName') : NewMemberName, ('MemberName') : null, ('FamilyPhoneNo') : null, ('ProductType') : null, ('GLType') : null
        , ('DiagnosisStatus') : null, ('DiagnosisID') : null, ('DoctorName') : null, ('Rujuk') : null, ('NPNFU') : null, ('Status') : null
        , ('Summary') : null, ('Validasi') : null, ('InterruptedCall') : InterruptedCall])

