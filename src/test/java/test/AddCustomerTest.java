package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
WebDriver driver;
	
	ExcelReader reader = new ExcelReader("./data/TF_TestData.xlsx");
	String userName = reader.getCellData("LoginInfo", "UserName", 2);
	String password = reader.getCellData("LoginInfo", "Password", 2);
	String fullName = reader.getCellData("AddContactInfo", "FullName", 2);
	String company = reader.getCellData("AddContactInfo", "Company Name", 2);
	String email = reader.getCellData("AddContactInfo", "Email", 2);
	String phoneNum = reader.getCellData("AddContactInfo", "Phone", 2);
	String address = reader.getCellData("AddContactInfo", "Address", 2);
	String city = reader.getCellData("AddContactInfo", "City", 2);
	String state = reader.getCellData("AddContactInfo", "State", 2);
	String zip = reader.getCellData("AddContactInfo", "Zip", 2);
	String group = reader.getCellData("AddContactInfo", "Group", 2);
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSignInButton();
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.verifyDashBoardElement();
		
		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.clickCustomersButton();
		addCustomer.clickAddCustomerButton();
		addCustomer.insertFullName(fullName);
		addCustomer.insertCompanyName(company);
		addCustomer.insertEmail(email);
		addCustomer.insertPhoneNumber(phoneNum);
		addCustomer.insertAddress(address);
		addCustomer.insertCity(city);
		addCustomer.insertState(state);
		addCustomer.insertZip(zip);
		addCustomer.insertGroup(group);
		addCustomer.clickOnSaveButton();
		addCustomer.clickOnListCustomersButton();
		addCustomer.verifyEnteredCustomerAndDelete();
		
		
		//BrowserFactory.tearDown();
		
	}

}
