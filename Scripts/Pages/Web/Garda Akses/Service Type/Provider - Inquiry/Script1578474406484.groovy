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

//Member Name
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Member Name'), MemberName)

WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Member Name'), MemberName)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Choose - Member Name'))

//Provider Name
not_run: WebUI.delay(GlobalVariable.Delay1)

not_run: if ((ContactLine == 'Customer') && (Product == 'Health')) {
    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Provider Name'), 
        ProviderName)

    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Provider Name'), 
        ProviderName)

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Choose - Provider Name'))
} else {
    WebUI.delay(0)
}

//Sub Service Type
not_run: WebUI.delay(GlobalVariable.Delay1)

not_run: WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Sub Service Type'))

not_run: WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Choose - Sub Service Type', 
        [('SubServiceType') : SubServiceType]))

//Remarks
not_run: WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Remarks'), Remarks)

//Need Follow Up
not_run: if (NeedFollowUp == 'Yes') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Check Box - Need Follow Up'))
} else {
    WebUI.delay(0)
}

//Button Direction
not_run: if (Action == 'Proses') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Process'))

    WebUI.delay(GlobalVariable.Delay1)

    if (MultipleServiceType == 'Yes') {
        def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Text - Ticket Number'))

        GlobalVariable.TicketIDRevisi = result.substring(9, 17)

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Button - OK'))
    } else {
        def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Text - Ticket Number'))

        GlobalVariable.TicketIDAwal = result.substring(9, 17)

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Button - OK'))
    }
    
    //Exit Confirmation 1 - Apakah ada hal lain yang dapat dibantu, Pak/Bu?
    if (ExitConfirmation1 == 'Yes') {
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 1 Yes')) //Exit Confirmation 2 - Sebelum mengakhiri percakapan, boleh kami dibantu untuk pertanyaan penutup yaitu Apakah Bapak/Ibu PUAS dengan informasi yang telah saya berikan?
    } else {
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 1 No'))

        if (ExitConfirmation2 == 'Puas') {
            WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 2 Puas'))
        } else {
            WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 2 Tidak Puas'))

            WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Exit Confirmation 3 Add Comment'), 
                Comment)

            WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 3 Ok'))
        }
        
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Show Thanks'))

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Close App'))
    }
} else if (Action == 'Back') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Back'))
} else {
    WebUI.delay(0)
}

