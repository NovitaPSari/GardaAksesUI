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

def ContactType = 'Farmasi'

def ServiceType = 'Claim'

def InterruptedCall = null //Yes or null

def GenderCT = null

def CustomerPhone = null

def ProviderName = 'OJKSH00001'

def ProviderName2 = 'OJKRP00008'

def ProviderPhoneNumber = null

def Email = null

def Fax = null

def ActionCT = 'Next'

//Inquiry//
def SearchBy = null

def SearchBy2 = 'TicketNo'

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

def GLType2 = 'Awal'

def GLType3 = null

def GLType4 = null

def GLType5 = null

def DiagnosisStatus = 'Initial Primary'

def DiagnosisID = 'A09 '

def DoctorName = 'Betsy Kalianda'

//Rujuk = yes / no
def Rujuk = 'Yes'

def Reason = null

def TotalBilled = null

def NPNFU = 'Yes'

def Status = 'Process'

def Status2 = 'Process'

def Status3 = null

def Status4 = null

def Status5 = null

def Summary = GlobalVariable.ValidasiDijaminkan

def Summary2 = GlobalVariable.ValidasiTidakDijaminkan

def Summary3 = null

def Summary4 = null

def Summary5 = null

def Validasi = null

def Validasi2 = null

def Validasi3 = null

def Validasi4 = null

def Validasi5 = null

//Query DB
def queryContactName = 'UPDATE GardaAkses_MasterID SET Number = (SELECT Number FROM GardaAkses_MasterID WHERE Name = \'Automation Tester\')+1 WHERE Name = \'Automation Tester\''

CustomKeywords.'querySQL.DefaultQuery.connectDB'('172.16.94.48', 'litt', 'sa', 'Password95')

CustomKeywords.'querySQL.DefaultQuery.execute'(queryContactName)

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserID, ('Password') : Password])

//==================== PHASE 1 ====================
WebUI.callTestCase(findTestCase('null'), [:])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('CustomerPhone') : CustomerPhone, ('GenderCT') : GenderCT, ('ProviderName') : ProviderName
        , ('ProviderPhoneNumber') : ProviderPhoneNumber, ('Email') : Email, ('Fax') : Fax, ('GLType') : GLType, ('Action') : ActionCT])

WebUI.callTestCase(findTestCase('null'), [('SearchBy') : SearchBy, ('GLType') : GLType
        , ('NewMemberName') : NewMemberName, ('Member') : Member])

WebUI.callTestCase(findTestCase('null'), [('Member') : Member, ('MemberStatus') : MemberStatus
        , ('MemberName') : MemberName, ('NewMemberType') : null, ('NewMemberName') : null, ('ClientName') : null, ('EmployeeID') : null
        , ('Year') : null, ('Month') : null, ('Classification') : null, ('FamilyPhoneNo') : FamilyPhoneNo, ('ProductType') : ProductType
        , ('GLType') : GLType, ('DiagnosisStatus') : DiagnosisStatus, ('DiagnosisID') : DiagnosisID, ('DoctorName') : DoctorName
        , ('Rujuk') : null, ('NPNFU') : null, ('Status') : Status, ('Summary') : Summary, ('Validasi') : Validasi, ('InterruptedCall') : InterruptedCall])

//==================== PHASE 2 ====================
WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('CustomerPhone') : CustomerPhone, ('GenderCT') : GenderCT, ('ProviderName') : ProviderName2
        , ('ProviderPhoneNumber') : ProviderPhoneNumber, ('Email') : Email, ('Fax') : Fax, ('GLType') : GLType, ('Action') : ActionCT])

WebUI.callTestCase(findTestCase('null'), [('SearchBy') : SearchBy2, ('TicketID') : GlobalVariable.TicketIDAwal
        , ('GLType') : GLType2, ('Member') : Member])

WebUI.callTestCase(findTestCase('null'), [('Member') : Member, ('MemberStatus') : MemberStatus
        , ('MemberName') : MemberName, ('NewMemberType') : null, ('NewMemberName') : null, ('ClientName') : null, ('EmployeeID') : null
        , ('Year') : null, ('Month') : null, ('Classification') : null, ('FamilyPhoneNo') : FamilyPhoneNo, ('ProductType') : ProductType
        , ('GLType') : GLType, ('DiagnosisStatus') : DiagnosisStatus, ('DiagnosisID') : DiagnosisID, ('DoctorName') : DoctorName
        , ('Rujuk') : Rujuk, ('NPNFU') : null, ('Status') : Status, ('Summary') : Summary, ('Validasi') : Validasi2, ('InterruptedCall') : InterruptedCall])

