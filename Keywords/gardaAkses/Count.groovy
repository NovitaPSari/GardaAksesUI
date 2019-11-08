package gardaAkses
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By as By

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Count {

	@Keyword
	def Additional_Info(){
		
		WebDriver driver = DriverFactory.getWebDriver()
		
		WebUI.switchToFrame(findTestObject('Object Repository/Pages/Web/Garda Akses/Frame'), 3)
		
		WebElement diagnosis = driver.findElement(By.xpath('//*[@id="DiagnosisInfoPopUpSectionFullText-0"]/div[1]/div/div[3]/a2is-datatable/div[2]/div/table/tbody'))
		
		List<WebElement> additional_info = diagnosis.findElements(By.tagName('tr'))
		
		int yes = additional_info.size()
		
		return yes
		
	}
}
