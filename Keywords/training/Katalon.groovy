package training

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Katalon {

	@Keyword
	def loginGen5 (String URL, String Username, String Password) {
		WebUI.openBrowser(URL)

		WebUI.maximizeWindow()

		WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Login/Input - Username'), Username)

		WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Login/Input - Password'), Password)

		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Login/Button - Masuk'))

		WebUI.delay(GlobalVariable.Delay0)

		WebUI.dismissAlert()
	}

	@Keyword
	def select(hbt, hbt2){
		ArrayList animal = ["singa", "burung", "ikan", "anjing", "garuda", "paus"]
		ArrayList habitat = ["darat", "udara", "air"]

		if (hbt == "singa" && hbt2 == "anjing"){
			String res = habitat[0]

			return res
		} else if ((hbt == "burung" && hbt2 == "garuda") || (hbt == "garuda" && hbt2 == "burung")) {
			String res = habitat[1]

			return res
		} else {
			String res = habitat[2]

			return res
		}
	}
}




