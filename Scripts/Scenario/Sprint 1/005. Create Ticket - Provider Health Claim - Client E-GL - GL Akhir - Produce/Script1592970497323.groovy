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

import com.keyword.GEN5

//Login//
String UserID = 'DNS'

String Password = 'Password95'

//Home
String Menu = 'General'

String SubMenu = 'Create Ticket'

//Create Ticket//
String ContactLine = 'Provider'

String Product = 'Health'

String ChannelType = 'Call'

String ContactName = findTestData('ContactName').getValue(1, 1)

String ContactType = 'Farmasi'

String ServiceType = 'Claim'

String InterruptedCall = 'No'

String ProviderName = 'OJKSH00001 - SILOAM HOSPITALS KEBON JERUK'

String ActionCT = 'Next'

//Inquiry//
String Phase = '1'

//Claim
String Member = 'Existing' //Member = Existing  / New / Check

String MemberName = findTestData('MemberNameClient').getValue(1, 1)

String ProductType = 'Inpatient'

String GLType = 'Akhir'

String EditTreatmentPeriodStart = 'No'

String EditTreatmentPeriodEnd = 'No'

String SpecialCondition = 'No'

String SpecialConditionReason = ''

ArrayList Diagnosis = ['New']

ArrayList StatusDiagnosa = ['Initial Primary']

ArrayList DiagnosisID = ['A09']

String RemarksDiagnosa = 'Testing Diagnosis - Katalon'

String RemarksDiagnosis = 'Testing Additional Info - Katalon'

String DoctorName = 'Automation Doctor - Me'

String Rujuk = 'No'

String Reason = ''

String AppropriateRBClass = 'BASIC'

String TreatmentRBClass = 'BASIC'

String RoomOptionAvailability = 'On Plan'

String TotalBilled = '1000000'

String NewDocument = 'No'

String EditDocument = 'No'

String DeleteDocument = 'No'

String ActionGL = 'Process'

ArrayList Validasi = [GlobalVariable.ValidasiDijaminkan]

//Exit Confirmation
String ECAction1 = 'Tidak'

String ECAction2 = 'Puas'

String Comment = 'Currently testing by Automation. Thanks. Regards - Me'

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserID, ('Password') : Password])

//==================== PHASE 1 ====================
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : Menu, ('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), [('ContactLine') : ContactLine, ('Product') : Product
		, ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
		, ('InterruptedCall') : InterruptedCall, ('ProviderName') : ProviderName, ('Action') : ActionCT])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry'), [('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim'), [('Member') : Member, ('MemberName') : MemberName
        , ('ProductType') : ProductType, ('GLType') : GLType, ('SpecialCondition') : SpecialCondition, ('EditTreatmentPeriodStart') : EditTreatmentPeriodStart
        , ('EditTreatmentPeriodEnd') : EditTreatmentPeriodEnd, ('Diagnosis') : Diagnosis, ('StatusDiagnosa') : StatusDiagnosa
        , ('DiagnosisID') : DiagnosisID, 
        , ('RemarksDiagnosa') : RemarksDiagnosa,  ('RemarksDiagnosis') : RemarksDiagnosis
        , ('DoctorName') : DoctorName, ('Rujuk') : Rujuk, ('Reason') : Reason, ('SpecialCondition') : SpecialCondition, ('AppropriateRBClass') : AppropriateRBClass
        , ('TreatmentRBClass') : TreatmentRBClass, ('AppropriateRBClass') : AppropriateRBClass, ('TreatmentRBClass') : TreatmentRBClass
        , ('SpecialConditionReason') : SpecialConditionReason, ('RoomOptionAvailability') : RoomOptionAvailability
        , ('NewDocument') : NewDocument, ('EditDocument') : EditDocument, ('DeleteDocument') : DeleteDocument, ('ActionGL') : ActionGL
        , ('Validasi') : Validasi, ('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
		, ('ECAction2') : ECAction2, ('Comment') : Comment])

WebUI.comment(GlobalVariable.TicketID1)

String URL = '172.16.94.70'
String DB_Name = 'SEA'
String Query = 'SELECT UPPER(CONCAT(RTRIM(ProviderID), SPACE(1), \'-\', SPACE(1), RTRIM(( ProviderName )))) AS ProviderName, ProviderPhoneNo AS ProviderPhoneNo, ProviderEmail AS ProviderEmail, TicketNo AS TicketNo, UPPER(CONCAT(RTRIM(EmpID), SPACE(1), \'-\', SPACE(1), RTRIM(LTRIM(MemberNo)), SPACE(1), \'-\', SPACE(1), RTRIM(MemberName), SPACE(1), \'-\', SPACE(1), RTRIM(ClientName))) AS MemberName, FamilyPhone AS FamilyPhone, Doctor AS Doctor FROM CONTACTCENTER.TempGL WHERE TicketNo = \'' + GlobalVariable.TicketID1 +'\' ORDER BY CreatedDate DESC'
ArrayList VerifyTicket1 = [ProviderName, GlobalVariable.PhoneNumber, GlobalVariable.Email, GlobalVariable.TicketID1, MemberName, GlobalVariable.PhoneNumber, DoctorName]
GEN5.compareRowDBtoArray(URL, DB_Name, Query, VerifyTicket1)