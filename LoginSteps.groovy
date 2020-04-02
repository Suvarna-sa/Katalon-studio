package account
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class LoginSteps {
	@Given("I am in login page")
	public void i_am_in_login_page() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.testurl)
		WebUI.maximizeWindow()
	}

	@When("I enter the Admin Email and Admin Password")
	public void i_enter_the_Admin_Email_and_Admin_Password() {
		WebUI.setText(findTestObject('Object Repository/Account/Login/Email_input'), GlobalVariable.adminEmail)
		WebUI.setEncryptedText(findTestObject('Object Repository/Account/Login/Password_input'), GlobalVariable.adminPwd)
	}

	@When("I click the Secure login button")
	public void i_click_the_Secure_login_button() {
		WebUI.click(findTestObject('Object Repository/Account/Login/Secure_Login_button'))
	}

	@Then("I see the Home pages for Admin")
	public void i_see_the_Home_pages_for_Admin() {
		WebUI.waitForElementPresent(findTestObject('Account/Login/Admin_mailStatusCount_header'), 120, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Account/Login/Admin_mailStatusCount_header'), 120, FailureHandling.STOP_ON_FAILURE)
	}

	@When("I enter the User Email and User Password")
	public void i_enter_the_User_Email_and_User_Password() {
		WebUI.setText(findTestObject('Object Repository/Account/Login/Email_input'), GlobalVariable.userEmail)
		WebUI.setEncryptedText(findTestObject('Object Repository/Account/Login/Password_input'), GlobalVariable.userPwd)
	}

	@Then("I see the Home pages for User")
	public void i_see_the_Home_pages_for_User() {
		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Dashboard/HomePage/WorkList_Dashboard/OverdueClaims/OverDueClaims_Dashboard/DashboardTitle_text'), 120, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Dashboard/HomePage/WorkList_Dashboard/OverdueClaims/OverDueClaims_Dashboard/DashboardTitle_text'), 120, FailureHandling.STOP_ON_FAILURE)
	}
}