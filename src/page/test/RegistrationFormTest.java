package page.test;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.RegistrationForm;
import utility.Constant;
import utility.ExcelUtils;

public class RegistrationFormTest {

	// Registrovanje jednog korisnika ubacivanjem podataka
	public static void fillForm(WebDriver driver) throws Exception {
		try {
			Scanner sc = new Scanner(System.in);

			// First Name
			System.out.println("First Name:");
			RegistrationForm.clickFirstName(driver);
			String firstName = sc.nextLine();
			RegistrationForm.sendFirstName(driver, firstName);

			// Last Name
			System.out.println("Last Name:");
			RegistrationForm.clickLastName(driver);
			String lastName = sc.nextLine();
			RegistrationForm.sendLastName(driver, lastName);

			// Username
			System.out.println("Username:");
			RegistrationForm.clickUserName(driver);
			String username = sc.nextLine();
			RegistrationForm.sendUserName(driver, username);

			// eMail
			System.out.println("eMail:");
			RegistrationForm.clickEMail(driver);
			String eMail = sc.nextLine();
			RegistrationForm.sendEMail(driver, eMail);

			// Pasword
			System.out.println("Password:");
			RegistrationForm.clickPassword(driver);
			String password = sc.nextLine();
			RegistrationForm.sendPassword(driver, password);

			RegistrationForm.clickRegistrationButton(driver);
			
			if (driver.getCurrentUrl().equals("http://localhost/izlet/index.php")) {
				System.out.println("Korisnik "+username+" je uspešno registrovan");
			} else {
				System.out.println("korisnk "+username+"nije uspešno registrovan");
			}

		} catch (Exception e) {

			throw (e);
		}
	}

	// Metoda za registrovanje više korisnika preko unosa
	public static void multipleFillForm(WebDriver driver, int brKorisnika) throws Exception {
		for (int i = 1; i <= brKorisnika; i++) {
			fillForm(driver);
			RegistrationForm.navigateTo(driver);
		}
	}

	// Metoda za registrovanje jednog korisnika iz tabele
	public static void fillFormFromExcel(WebDriver driver, int i) throws Exception {
		try {
			String data;
			ExcelUtils.getExcelFile(Constant.path + Constant.data, Constant.sheetNameRegistracija);
			if (i > 0) {
				// First Name
				RegistrationForm.clickFirstName(driver);
				data = ExcelUtils.getCellData(i, 0);
				RegistrationForm.sendFirstName(driver, data);

				// Last Name
				RegistrationForm.clickLastName(driver);
				data = ExcelUtils.getCellData(i, 1);
				RegistrationForm.sendLastName(driver, data);

				// Username
				RegistrationForm.clickUserName(driver);
				data = ExcelUtils.getCellData(i, 2);
				RegistrationForm.sendUserName(driver, data);

				// eMail
				RegistrationForm.clickEMail(driver);
				data = ExcelUtils.getCellData(i, 3);
				RegistrationForm.sendEMail(driver, data);

				// Pasword
				RegistrationForm.clickPassword(driver);
				data = ExcelUtils.getCellData(i, 4);
				RegistrationForm.sendPassword(driver, data);

				RegistrationForm.clickRegistrationButton(driver);
			} else {
				System.out.println("Nema podataka za " + i + " red");
			}
			String regStatus;
			if (driver.getCurrentUrl().equals("http://localhost/izlet/index.php")) {
				regStatus = "pass";
				System.out.println("Korisnik "+i+" je uspešno registrovan");
			} else {
				regStatus = "fail";
				System.out.println("korisnk "+i+"nije uspešno registrovan");
			}
			ExcelUtils.setCellData(regStatus, i, 5);

		} catch (Exception e) {

			throw (e);
		}
	}

	// Metoda za registrovanje svih korisnika iz tabele
	public static void allExcelElements(WebDriver driver) throws Exception {
		String data;
		ExcelUtils.getExcelFile(Constant.path + Constant.data, Constant.sheetNameRegistracija);
		for (int i = 1; i <= ExcelUtils.getExcelSheet().getLastRowNum(); i++) {
			fillFormFromExcel(driver, i);
			RegistrationForm.navigateTo(driver);
		}
	}
}
