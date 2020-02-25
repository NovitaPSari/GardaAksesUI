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
import com.kms.katalon.core.testdata.DBData as DBData

//Login//
def UserID = 'DNS'

def Password = 'Password95'

//Home
def Menu = 'General'

def SubMenu = 'Create Ticket'

//Create Ticket//
def ContactLine = 'Provider'

def Product = 'Health'

def ChannelType = 'Call'

def ContactName = findTestData('ContactName').getValue(1, 1)

def ContactType = 'Lainnya'

def ServiceType = 'Approval Tindakan/Terapi/Obat'

def InterruptedCall = null //Yes or null

def ProviderName = 'OJKSH00001'

def Action = 'Next'

//Service Type
def MemberName = findTestData('MemberNameClient').getValue(1, 1)
//def MemberName = findTestData('MemberNameNonClient').getValue(1, 1)
//def MemberName = 'NBH - Member Baru'

def SubServiceType = 'Approve Tindakan/Terapi/Obat'

def MedicalTreatment = 'Rontgen'

def Remarks = 'Currently testing by Automation. Thanks. Regards - Me'

def NeedFollowUp = 'Yes'

def PatientPhoneNumber = GlobalVariable.PhoneNumber

def ActionST = 'Proses'

//Exit Confirmation
def ECAction1 = 'Tidak'

def ECAction2 = 'Puas'

//Home
def Menu2 = 'General'

def SubMenu2 = 'Follow Up'

//Follow UP Ticket Away
def StatusFUTA = 'Pray'

//Follow UP Ticket
def StatusFUT = 'Available'

//Follow Up APTTO

def PIC = 'Doctor'

def DoctorName = 'Irna Putri Perdana'

def Confirmation = 'Need Confirmation Letter'

def Mandatory = 'No'

def ConfirmationLetterType = 'Benjolan'

def RemarksFUA = 'Currently testing by Automation. Thanks. Regards - Me'

def ActionAC = 'Save'

////Query DB

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserID, ('Password') : Password])

WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : Menu, ('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('ProviderName') : ProviderName, ('Action') : Action])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO'), [('MemberName') : MemberName
        , ('SubServiceType') : SubServiceType, ('MedicalTreatment') : MedicalTreatment, ('Remarks') : Remarks, ('NeedFollowUp') : NeedFollowUp
        , ('PatientPhoneNumber') : PatientPhoneNumber, ('Action') : ActionST])

//def TRID = findTestData('CheckTRID').getValue(1, 1)
//
//WebUI.comment(TRID)
//
//WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
//        , ('ECAction2') : ECAction2])
//
//WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : Menu2, ('SubMenu') : SubMenu2])
//
//WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Follow Up/Ticket Follow Up - Away'), [('Status') : StatusFUTA])
//
//DBData CheckPICTicket_1 = findTestData('Check PIC Ticket')
//
//CheckPICTicket_1.query = CheckPICTicket_1.query.replace('999', TRID)
//
//CheckPICTicket_1.fetchedData = CheckPICTicket_1.fetchData()
//
//def FollowUpTicketHistoryID = CheckPICTicket_1.getValue(1, 1)
//
//WebUI.comment(FollowUpTicketHistoryID)
//
//def UpdatePICTicket = ('UPDATE  ContactCenter.FollowUpTicketHistory SET UserID = \'DNS\' WHERE FollowUpTicketHistoryID = \'' + 
//FollowUpTicketHistoryID) + '\''
//
//CustomKeywords.'querySQL.DefaultQuery.connectDB'('172.16.94.70', 'SEA', 'sa', 'Password95')
//
//CustomKeywords.'querySQL.DefaultQuery.execute'(UpdatePICTicket)
//
//WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Follow Up/Ticket Follow Up'), [('Status') : StatusFUT])
//
//WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Follow Up/Follow Up APTTO'), 
//	[('PIC') : PIC,
//		('TRID') : TRID,
//		('DoctorName') : DoctorName,
//		('Confirmation') : Confirmation,
//		('Mandatory') : Mandatory,
//		('ConfirmationLetterType') : ConfirmationLetterType,
//		('RemarksFUA') : RemarksFUA,
//		('ActionAC') : ActionAC])