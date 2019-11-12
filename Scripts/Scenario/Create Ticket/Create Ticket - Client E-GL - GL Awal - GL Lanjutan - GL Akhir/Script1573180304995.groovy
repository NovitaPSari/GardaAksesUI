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

def ChannelType = 'SMS'

def ContactName = 'NBH'

def ContactType = 'Farmasi'

def ServiceType = 'Claim'

def ProviderName = 'OJKSH00001'

def PhoneNumber = '081233464072'

def Email = 'nbh@gmail.com'

def Fax = '021873627'

//Claim//
def MemberStatus = 1

//Status Member 1 = Membuat Member baru. Kosongkan data member bila mengambil status 1
//Status Member 2 = Mengambil data member yang sudah ada. Kosongkan data StatusMember, NewMemberType, NewMemberName, ClientName, EmployeeID, Year, Month, Classification, Gender
def StatusMember = '2'

def NewMemberType = 'Employee'

def NewMemberName = findTestData('NewMemberName').getValue(1, 1)

def ClientName = 'PT BANK PERMATA TBK'

def EmployeeID = '78912'

def Year = '1996'

def Month = 'Aug'

def Classification = 'Level 13-14A'

def Gender = 'Male'

def Member = findTestData('MemberNameClient').getValue(1, 1)

def FamilyPhoneNo = '012387563928'

def ProductType = 'Inpatient'

def GLType1 = 'Awal'

def GLType2 = 'Lanjutan'

def GLType3 = 'Akhir'

def DiagnosisID = 'A09 '

def DiagnosisStatus = 'Initial Primary'

def DoctorName = 'Betsy Kalianda'

def Rujuk = 0

def Status = GlobalVariable.Dijaminkan

def Validasi = GlobalVariable.ValidasiSukses

def NPNFU = 0

def NPNFU2 = 1

//Update DB//
if (StatusMember == '1') {
    def queryNewMemberName = 'UPDATE litt.dbo.masterid SET number = (SELECT number FROM litt.dbo.masterid WHERE id = \'Automation GA\')+1 WHERE id = \'Automation GA\''

    CustomKeywords.'querySQL.update.connectDB'('172.16.94.48', 'litt', 'sa', 'Password95')

    CustomKeywords.'querySQL.update.execute'(queryNewMemberName)
}

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/Login/Login'), [('UserID') : UserID, ('Password') : Password])

WebUI.callTestCase(findTestCase('Pages/Web/Home/Home - Create Ticket'), [:])

WebUI.callTestCase(findTestCase('Pages/Web/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('ProviderName') : ProviderName, ('PhoneNumber') : PhoneNumber, ('Email') : Email, ('Fax') : Fax, ('GLType') : GLType1])

WebUI.callTestCase(findTestCase('Pages/Web/GL Inquiry/GL Inquiry'), [('GLType') : GLType1, ('Member') : Member])

WebUI.callTestCase(findTestCase('Pages/Web/Claim/Claim'), [('MemberStatus') : MemberStatus, ('StatusMember') : StatusMember, ('NewMemberType') : NewMemberType
        , ('NewMemberName') : NewMemberName, ('ClientName') : ClientName, ('EmployeeID') : EmployeeID, ('Year') : Year, ('Month') : Month
        , ('Classification') : Classification, ('Gender') : Gender, ('Member') : Member, ('FamilyPhoneNo') : FamilyPhoneNo
        , ('ProductType') : ProductType, ('GLType') : GLType1, ('DiagnosisID') : DiagnosisID, ('DiagnosisStatus') : DiagnosisStatus
        , ('DoctorName') : DoctorName, ('Rujuk') : Rujuk, ('Status') : Status, ('Validasi') : Validasi, ('NPNFU') : NPNFU])

WebUI.callTestCase(findTestCase('Pages/Web/Home/Home - Create Ticket'), [:])

WebUI.callTestCase(findTestCase('Pages/Web/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('ProviderName') : ProviderName, ('PhoneNumber') : PhoneNumber, ('Email') : Email, ('Fax') : Fax, ('GLType') : GLType2])

WebUI.callTestCase(findTestCase('Pages/Web/GL Inquiry/GL Inquiry'), [('TicketID') : GlobalVariable.TicketIDAwal, ('GLType') : GLType2])

WebUI.callTestCase(findTestCase('Pages/Web/Claim/Claim'), [('MemberStatus') : MemberStatus, ('StatusMember') : StatusMember, ('GLType') : GLType2, ('Rujuk') : Rujuk, ('Status') : Status, ('Validasi') : Validasi, ('NPNFU') : NPNFU])

WebUI.callTestCase(findTestCase('Pages/Web/Home/Home - Create Ticket'), [:])

WebUI.callTestCase(findTestCase('Pages/Web/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('ProviderName') : ProviderName, ('PhoneNumber') : PhoneNumber, ('Email') : Email, ('Fax') : Fax, ('GLType') : GLType3])

WebUI.callTestCase(findTestCase('Pages/Web/GL Inquiry/GL Inquiry'), [('TicketID') : GlobalVariable.TicketIDLanjutan, ('GLType') : GLType3])

WebUI.callTestCase(findTestCase('Pages/Web/Claim/Claim'), [('MemberStatus') : MemberStatus, ('StatusMember') : StatusMember, ('GLType') : GLType3, ('Rujuk') : Rujuk, ('Status') : Status, ('Validasi') : Validasi, ('NPNFU') : NPNFU])

