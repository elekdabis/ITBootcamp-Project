package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInForm {

	public static final String URL = "http://localhost/izlet/";

	public static void navigateTo(WebDriver driver) {
		driver.navigate().to(URL);
		;
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

	// LogIn Button
	public static WebElement getLogInButton(WebDriver driver) {
		WebElement logInButton = driver.findElement(By.xpath(LOGIN_BUTTON));
		return logInButton;
	}

	public static void clickLogInButton(WebDriver driver) {
		getLogInButton(driver).click();
	}

	// LogOut Button
	public static WebElement getLogoutButton(WebDriver driver) {
		WebElement logoutButton = driver.findElement(By.xpath(LOGOUT_BUTTON));
		return logoutButton;
	}

	public static void clickLogoutButton(WebDriver driver) {
		getLogoutButton(driver).click();
	}

	// Xpaths
	private static String USER_NAME = "//input[@placeholder='username']";
	private static String PASSWORD = "//input[@placeholder='password']";
	private static String LOGIN_BUTTON = "//input[@value='Log in']";
	private static String LOGOUT_BUTTON = "//a[contains(text(),'Logout')]";
}
