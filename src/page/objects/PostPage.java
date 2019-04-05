package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PostPage {

	public static final String URL = "http://localhost/izlet/dashboard.php";

	// Naziv
	public static WebElement getNaziv(WebDriver driver) {
		WebElement naziv = driver.findElement(By.xpath(NAZIV));
		return naziv;
	}

	public static void clickNaziv(WebDriver driver) {
		getNaziv(driver).click();
	}

	public static void sendNaziv(WebDriver driver, String naziv) {
		getNaziv(driver).sendKeys(naziv);
	}

	// Lokacija
	public static WebElement getLokacija(WebDriver driver) {
		WebElement lokacija = driver.findElement(By.xpath(LOKACIJA));
		return lokacija;
	}

	public static void clickLokacija(WebDriver driver) {
		getLokacija(driver).click();
	}

	public static void sendLokacija(WebDriver driver, String lokacija) {
		getLokacija(driver).sendKeys(lokacija);
	}

	// Transport
	public static WebElement getTransport(WebDriver driver) {
		WebElement transport = driver.findElement(By.xpath(TRANSPORT));
		return transport;
	}

	public static void selectTransport(WebDriver driver, String transport) {
		Select selectTransport = new Select(getTransport(driver));
		selectTransport.selectByVisibleText(transport);
	}

	// Post text
	public static WebElement getPostText(WebDriver driver) {
		WebElement postText = driver.findElement(By.xpath(POST_TEXT));
		return postText;
	}

	public static void clickPostText(WebDriver driver) {
		getPostText(driver).click();
	}

	public static void sendPostText(WebDriver driver, String postText) {
		getPostText(driver).sendKeys(postText);
	}

	// Make a post button
	public static WebElement getMakeAPostButton(WebDriver driver) {
		WebElement makeAPostButton = driver.findElement(By.xpath(MAKEAPOSTBUTTON));
		return makeAPostButton;
	}

	public static void clickMakeAPostButton(WebDriver driver) {
		getMakeAPostButton(driver).click();
	}

	// Post button
	public static WebElement getPostButton(WebDriver driver) {
		WebElement postButton = driver.findElement(By.xpath(POSTBUTTON));
		return postButton;
	}

	public static void clickPostButton(WebDriver driver) {
		getPostButton(driver).click();
	}

	public static WebElement getDeleteButton(WebDriver driver) {
		WebElement deleteButton = driver.findElement(By.xpath(DELETEBUTTON));
		return deleteButton;
	}

	// Dugme za biranje opcija za post
	public static void chooseOptionsButton(WebDriver driver) {
		List<WebElement> chooseOptions = driver.findElements(By.className(POSTOPTIONBUTTON));
		chooseOptions.get(0).click();
	}

	// Dugme za brisanje postova
	public static void deletePostButton(WebDriver driver) {
		chooseOptionsButton(driver);
		List<WebElement> deleteFirstPost = driver.findElements(By.className(POSTDELETEBUTTON));
		deleteFirstPost.get(0).click();
	}

	// Dugme za menjanje postova
	public static void editPostButton(WebDriver driver) {
		chooseOptionsButton(driver);
		List<WebElement> editFirstPost = driver.findElements(By.className(POSTEDITBUTTON));
		editFirstPost.get(0).click();
	}

	// Edit text - delete and write old post

	public static WebElement getEditPost(WebDriver driver) {
		WebElement editPost = driver.findElement(By.cssSelector(EDITPOST));
		return editPost;
	}

	public static void clickEditPostText(WebDriver driver) {
		getEditPost(driver).click();
	}

	public static void deleteEditPostText(WebDriver driver) {
		getEditPost(driver).clear();
	}

	public static void sendEditPostText(WebDriver driver, String opis) {
		getEditPost(driver).sendKeys(opis);
	}

	// Dugme za postovanje editovanih komentara

	public static WebElement getEditPostButton(WebDriver driver) {
		WebElement editPostButton = driver.findElement(By.xpath(EDITPOSTBUTTON));
		return editPostButton;
	}

	public static void clickEditPostButton(WebDriver driver) {
		getEditPostButton(driver).click();
	}

	// Metoda za dobijanje koliko postova imam korisnik
	public static int userPosts(WebDriver driver) {
		List<WebElement> userPosts = driver.findElements(By.className(POSTOPTIONBUTTON));
		int brPostovaKor = userPosts.size();
		return brPostovaKor;
	}

	// Xpaths and Class Names
	private static String MAKEAPOSTBUTTON = "//a[contains(text(),'Make a post')]";
	private static String NAZIV = "//input[@placeholder='Naziv']";
	private static String LOKACIJA = "//input[@placeholder='Lokacija']";
	private static String TRANSPORT = "//select[@name='transport']";
	private static String POST_TEXT = "//textarea[@placeholder='Opis']";
	private static String POSTBUTTON = "//input[@value='Post']";
	private static String DELETEBUTTON = "//a[@href='delete.php?idPost=43']//i[@class='fas fa-trash-alt']";
	private static String POSTOPTIONBUTTON = "fa-ellipsis-v";
	private static String POSTDELETEBUTTON = "fa-trash-alt";
	private static String POSTEDITBUTTON = "fa-edit";
	private static String EDITPOST = "#description";
	private static String EDITPOSTBUTTON = "//div[@class='popupEdit']//input[@value='Post']";

}
