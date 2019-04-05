package page.test;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.LogInForm;
import page.objects.PostPage;
import page.objects.RegistrationForm;
import utility.Constant;
import utility.ExcelUtils;

public class LogInFormTest {

	// Metoda za logovanje jednog korisnika unošenjem podataka
	public static void fillForm(WebDriver driver) throws Exception {
		try {
			Scanner sc = new Scanner(System.in);

			// Username
			System.out.println("Username:");
			LogInForm.clickUserName(driver);
			String username = sc.nextLine();
			LogInForm.sendUserName(driver, username);

			// Password
			System.out.println("Password:");
			LogInForm.clickPassword(driver);
			String password = sc.nextLine();
			LogInForm.sendPassword(driver, password);

			LogInForm.clickLogInButton(driver);
			
			if (driver.getCurrentUrl().equals(PostPage.URL)) {
				System.out.println("Korisnik "+username+" je uspešno ulogovan");
			} else {
				System.out.println("korisnk "+username+"nije uspešno ulogovan");
			}

		} catch (Exception e) {

			throw (e);
		}
	}

	// Metoda za logovanje više korisnika preko unosa
	public static void multipleFillForm(WebDriver driver, int brKorisnika) throws Exception {
		for (int i = 1; i <= brKorisnika; i++) {
			fillForm(driver);
			RegistrationForm.navigateTo(driver);
		}
	}

	// Metoda za logovanje jednog korisnika iz tabele
	public static void fillFormFromExSheet(WebDriver driver, int i) throws Exception {
		try {
			String data;
			ExcelUtils.getExcelFile(Constant.data, Constant.sheetNameRegistracija);
			if (i > 0) {
				// Username
				LogInForm.clickUserName(driver);
				data = ExcelUtils.getCellData(i, 2);
				LogInForm.sendUserName(driver, data);

				// Password
				LogInForm.clickPassword(driver);
				data = ExcelUtils.getCellData(i, 4);
				LogInForm.sendPassword(driver, data);

				LogInForm.clickLogInButton(driver);

			} else {
				System.out.println("Neodastaju podaci u " + i + " redu");
			}

		} catch (Exception e) {

			throw (e);
		}
	}

	// Metoda za logovanje svih korisnika iz tabele
	public static void fillFormAllElements(WebDriver driver) throws Exception {

		ExcelUtils.getExcelFile(Constant.path + Constant.data, Constant.sheetNameRegistracija);

		for (int i = 1; i <= ExcelUtils.getExcelSheet().getLastRowNum(); i++) {
			fillFormFromExSheet(driver, i);
			if (driver.getCurrentUrl().equals(PostPage.URL)) {
				ExcelUtils.setCellData("pass", i, 6);
				LogInForm.clickLogoutButton(driver);
				System.out.println("Korisnik " + i + " uspešno ulogovan");
			} else {
				ExcelUtils.setCellData("fail", i, 6);
				System.out.println("Korisnik " + i + " nije uspešno ulogovan");
			}
			LogInForm.navigateTo(driver);
		}

	}
}
