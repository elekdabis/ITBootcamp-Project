package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationForm {

	public static final String URL = "http://localhost/izlet/";

	public static void navigateTo(WebDriver driver) {
		driver.navigate().to(URL);
		;
	}

	// First Name
	public static WebElement getFirstName(WebDriver driver) {
		WebElement firstName = driver.findElement(By.xpath(FIRST_NAME));
		return firstName;
	}

	public static void clickFirstName(WebDriver driver) {
		getFirstName(driver).click();
	}

	public static void sendFirstName(WebDriver driver, String data) {
		getFirstName(driver).sendKeys(data);
	}

	// Last Name
	public static WebElement getLastName(WebDriver driver) {
		WebElement lastName = driver.findElement(By.xpath(LAST_NAME));
		return lastName;
	}

	public static void clickLastName(WebDriver driver) {
		getLastName(driver).click();
	}

	public static void sendLastName(WebDriver driver, String data) {
		getLastName(driver).sendKeys(data);
	}

	// Username
	public static WebElement getUserName(WebDriver driver) {
		WebElement userName = driver.findElement(By.xpath(USER_NAME));
		return userName;
	}

	public static void clickUserName(WebDriver driver) {
		getUserName(driver).click();
	}

	public static void sendUserName(WebDriver driver, String data) {
		getUserName(driver).sendKeys(data);
	}

	// eMail
	public static WebElement getEMail(WebDriver driver) {
		WebElement eMail = driver.findElement(By.xpath(EMAIL));
		return eMail;
	}

	public static void clickEMail(WebDriver driver) {
		getEMail(driver).click();
	}

	public static void sendEMail(WebDriver driver, String data) {
		getEMail(driver).sendKeys(data);
	}

	// Password
	public static WebElement getPassword(WebDriver driver) {
		WebElement password = driver.findElement(By.xpath(PASSWORD));
		return password;
	}

	public static void clickPassword(WebDriver driver) {
		getPassword(driver).click();
	}

	public static void sendPassword(WebDriver driver, String data) {
		getPassword(driver).sendKeys(data);
	}

	// Registration Button
	public static WebElement getRegisterButton(WebDriver driver) {
		WebElement registrationButton = driver.findElement(By.xpath(REG_BUTTON));
		return registrationButton;
	}

	public static void clickRegistrationButton(WebDriver driver) {
		getRegisterButton(driver).click();
	}

	// Xpaths
	private static String FIRST_NAME = "//input[@name='firstname']";
	private static String LAST_NAME = "//input[@name='lastname']";
	private static String USER_NAME = "//form[@action='processregister.php']//input[@name='username']";
	private static String EMAIL = "//input[@name='email']";
	private static String PASSWORD = "//form[@action='processregister.php']//input[@name='password']";
	private static String REG_BUTTON = "//input[@id='blue_btn']";

}
