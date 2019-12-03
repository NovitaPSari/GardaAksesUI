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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.delay(GlobalVariable.Delay3)

WebUI.delay(GlobalVariable.Delay3)

//Contact Line
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Contact Line', [('ContactLine') : ContactLine]))

//Product
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Product', [('Product') : Product]))

//Channel Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Channel Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Channel Type', [('ChannelType') : ChannelType]))

//Contact Name
WebUI.setText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Contact Name'), ContactName)

def AutoComplete = WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Autocomplete Contact Name'), 
    GlobalVariable.Delay1)

if (AutoComplete == true){
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Choose - Autocomplete Contact Name'))
} else {
    WebUI.delay(0)
}

//Contact Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Contact Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Contact Type', [('ContactType') : ContactType]))

//Service Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Service Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Service Type', [('ServiceType') : ServiceType]))

//Interrupted Contact
if (InterruptedCall == 'Yes') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Check Box - Interrupted Contact'))
} else {
    WebUI.delay(0)
}

//Customer Phone
if (InterruptedCall == null) {
    if (((ContactLine == 'Customer') && (Product == 'Health')) || ((ContactLine == 'Customer') && (Product == 'Non Health'))) {
        WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Customer Phone'), CustomerPhone)
    } else {
        WebUI.delay(0)
    }
} else {
    WebUI.delay(0)
}

//Gender
if (InterruptedCall == null) {
    if (((ContactLine == 'Customer') && (Product == 'Health')) || ((ContactLine == 'Customer') && (Product == 'Non Health'))) {
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Radio Button - Customer Gender', 
                [('GenderCT') : GenderCT]))
    } else {
        WebUI.delay(0)
    }
} else {
    WebUI.delay(0)
}

//Provider Name
if ((((((InterruptedCall != null) && (ContactLine == 'Provider')) && (Product == 'Health')) && (ServiceType == 'Approval Tindakan/Terapi/Obat')) || 
((((InterruptedCall != null) && (ContactLine == 'Provider')) && (Product == 'Health')) && (ServiceType == 'Inquiry'))) || 
(InterruptedCall == null)) {
    if (((ContactLine == 'Provider') && (Product == 'Health')) || ((ContactLine == 'Provider') && (Product == 'Non Health'))) {
        WebUI.setText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Provider Name'), ProviderName)

        WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Provider Name', [('ProviderName') : ProviderName]))
    } else {
        WebUI.delay(0)
    }
} else {
    WebUI.delay(0)
}

//Phone Number
if (InterruptedCall == null) {
    if (((ContactLine == 'Provider') && (Product == 'Health')) || ((ContactLine == 'Provider') && (Product == 'Non Health'))) {
        def CheckPhoneNumber = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Phone Number'), 
            'value')

        if (CheckPhoneNumber == '') {
            WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Phone Number'), 
                ProviderPhoneNumber)
        } else {
            WebUI.delay(0)
        }
    } else {
        WebUI.delay(0)
    }
} else {
    WebUI.delay(0)
}

//Email
if (InterruptedCall == null) {
    if ((ContactLine == 'Provider') && (Product == 'Health')) {
        def CheckEmail = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Email'), 
            'value')

        if (CheckEmail == '') {
            WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Email'), Email)
        } else {
            WebUI.delay(0)
        }
    } else {
        WebUI.delay(0)
    }
} else {
    WebUI.delay(0)
}

//Fax
if (InterruptedCall == null) {
    if ((ContactLine == 'Provider') && (Product == 'Health')) {
        def CheckFax = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Fax'), 
            'value')

        if (CheckFax == '') {
            WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Fax'), Fax)
        } else {
            WebUI.delay(0)
        }
    } else {
        WebUI.delay(0)
    }
} else {
    WebUI.delay(0)
}

WebUI.delay(GlobalVariable.Delay1)

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Next'))

if (InterruptedCall == 'Yes') {
	if (GLType == 'Awal') {
		def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - Interrupted Ticket ID'))
		
		GlobalVariable.TicketIDAwal = result.substring(22, 30)
	
		println(GlobalVariable.TicketIDAwal)
	} else if (GLType == 'Lanjutan') {
		def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - Interrupted Ticket ID'))
	
		GlobalVariable.TicketIDLanjutan = result.substring(22, 30)
	
		println(GlobalVariable.TicketIDLanjutan)
	} else {
		def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - Interrupted Ticket ID'))
	
		GlobalVariable.TicketIDAkhir = result.substring(22, 30)
	
		println(GlobalVariable.TicketIDAkhir)
	}
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Interrupted Close'))
} else {
	WebUI.delay(0)
}

