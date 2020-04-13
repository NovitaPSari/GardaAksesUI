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
import com.keyword.GEN5 as GEN5
import com.keyword.UI as UI

//Login//
String UserID = 'DNS'

String Password = 'Password95'

//Home
String Menu = 'General'

String SubMenu = 'Create Ticket'

//Create Ticket//
String ContactLine = 'Customer'

String Product = 'Non Health'

String ChannelType = 'Call'

String ContactName = findTestData('ContactName').getValue(1, 1)

String ContactType = 'Teman'

String ServiceType = 'Endorsement'

String InterruptedCall = 'No'

String CustomerGender = 'Female'

String ActionCT = 'Next'

//Choose Customer
String ChooseCategoryCustomer = 'Policy Holder / Relatives'

String ActionCC1 = 'Next'

String SearchBy = 'Policy Number'

String Parameter = findTestData('ParameterPolicyNo').getValue(4, 1)

String ActionCC2 = 'Next'

String ActionCC3 = 'Finish'

//Endorsementd
String ProductE = 'Garda Oto'

String SearchByE = 'Workshop'

String ParameterE = 'Name'

String SearchParameter = 'AUTO 2000 CILANDAK JAKARTA'

String SurveySchedule = 'No'

String EndorsementCategory = 'Internal'

String FUStatus = 'On Progress'

String FURemarks = 'Automation Test - RRU'

String ActionC = 'Save'

//Exit Confirmation
String ECAction1 = 'Tidak'

String ECAction2 = 'Puas'

String Comment = 'Currently testing by Automation. Thanks. Regards - Me'

//Script//
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Login/Login'), [('UserID') : UserID, ('Password') : Password])

//==================== PHASE 1 ====================
WebUI.callTestCase(findTestCase('Pages/Web/GEN5/Home/Home'), [('Menu') : Menu, ('SubMenu') : SubMenu])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Create Ticket/Create Ticket'), 
	[('ContactLine') : ContactLine, ('Product') : Product
        , ('ChannelType') : ChannelType, ('ContactName') : ContactName, ('ContactType') : ContactType, ('ServiceType') : ServiceType
        , ('InterruptedCall') : InterruptedCall, ('CustomerGender') : CustomerGender, ('Action') : ActionCT])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Choose Customer/Choose Customer'), [('ChooseCategoryCustomer') : ChooseCategoryCustomer
        , ('ActionCC1') : ActionCC1, ('SearchBy') : SearchBy, ('Parameter') : Parameter, ('ActionCC2') : ActionCC2, ('ActionCC3') : ActionCC3])

CustomKeywords.'querySQL.Query.QueryContactName'()

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement'), 
	[('Product') : ProductE
		,('SearchBy') : SearchByE
		,('Parameter') : ParameterE
		,('SearchParameter') : SearchParameter
		,('SurveySchedule') : SurveySchedule
		,('EndorsementCategory') : EndorsementCategory
		,('FUStatus') : FUStatus
		,('FURemarks') : FURemarks
		,('Action') : ActionC
		,('Phase') : '1'])

WebUI.callTestCase(findTestCase('Pages/Web/Garda Akses/Exit Confirmation/Exit Confirmation'), [('ECAction1') : ECAction1
	, ('ECAction2') : ECAction2, ('Comment') : Comment])

WebUI.comment(GlobalVariable.TicketID1)
