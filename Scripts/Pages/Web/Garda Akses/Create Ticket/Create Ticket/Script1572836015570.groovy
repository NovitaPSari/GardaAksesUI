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

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Contact Line', [('ContactLine') : ContactLine]))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Radio Button - Product', [('Product') : Product]))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Channel Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Channel Type', [('ChannelType') : ChannelType]))

WebUI.setText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Contact Name'), ContactName)

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Contact Name'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Contact Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Contact Type', [('ContactType') : ContactType]))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Service Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Service Type', [('ServiceType') : ServiceType]))

WebUI.setText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Provider Name'), ProviderName)

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Choose - Provider Name', [('ProviderName') : ProviderName]))

WebUI.delay(GlobalVariable.Delay1)

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Next'))

if (GLType == 'Awal') {
    def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Text - Ticket ID'))

    GlobalVariable.TicketIDAwal = result.substring(10, 18)

    println(GlobalVariable.TicketIDAwal)
} else if (GLType == 'Lanjutan') {
    def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Text - Ticket ID'))

    GlobalVariable.TicketIDLanjutan = result.substring(10, 18)

    println(GlobalVariable.TicketIDLanjutan)
} else {
    def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Text - Ticket ID'))

    GlobalVariable.TicketIDAkhir = result.substring(10, 18)

    println(GlobalVariable.TicketIDAkhir)
}

WebUI.getText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Text - Ticket ID'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Button - Close'))

