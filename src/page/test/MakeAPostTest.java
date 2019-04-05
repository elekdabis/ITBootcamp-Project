package page.test;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.LogInForm;
import page.objects.PostPage;
import utility.Constant;
import utility.ExcelUtils;

public class MakeAPostTest {

	// Metoda za ubacivanje jednog opisa putem unosa
	public static void makePost(WebDriver driver) throws Exception {
		try {
			Scanner sc = new Scanner(System.in);

			// Naziv
			PostPage.clickNaziv(driver);
			System.out.println("Naziv:");
			String naziv = sc.nextLine();
			PostPage.sendNaziv(driver, naziv);

			// Lokacija
			PostPage.clickLokacija(driver);
			System.out.println("Lokacija:");
			String lokacija = sc.nextLine();
			PostPage.sendLokacija(driver, lokacija);

			// Transport
			System.out.println("Transport:");
			String transport = sc.nextLine();
			PostPage.selectTransport(driver, transport);

			// Post text
			System.out.println("Opis:");
			PostPage.clickPostText(driver);
			String opis = sc.nextLine();
			PostPage.sendPostText(driver, opis);

			PostPage.clickPostButton(driver);

		} catch (Exception e) {

			throw (e);
		}
	}

	// Metoda za ubacivanje više opisa preko unosa
	public static void multipleMakePost(WebDriver driver, int brPostova) throws Exception {
		for (int i = 1; i <= brPostova; i++) {
			makePost(driver);
			PostPage.clickMakeAPostButton(driver);
		}
	}

	// Metoda za ubacivanje jednog opisa iz tabele
	public static void postFromExSheet(WebDriver driver, int i) throws Exception {
		try {
			String data;
			ExcelUtils.getExcelFile(Constant.path + Constant.data, Constant.sheetNameTekst);
			if (i > 0 && ExcelUtils.getExcelSheet().getRow(i) != null) {

				PostPage.clickMakeAPostButton(driver);

				// Naziv
				PostPage.clickNaziv(driver);
				PostPage.sendNaziv(driver, "Proba");

				// Lokacija
				PostPage.clickLokacija(driver);
				PostPage.sendLokacija(driver, "Proba");

				// Transport
				PostPage.selectTransport(driver, "Walk");

				// Post text
				PostPage.clickPostText(driver);
				data = ExcelUtils.getCellData(i, 0);
				PostPage.sendPostText(driver, data);

				PostPage.clickPostButton(driver);
			} else {
				System.out.println("Nema podataka za " + (i) + " red");
			}

		} catch (Exception e) {

			throw (e);
		}
	}

	// Metoda za ubacivanje svih opisa iz tabele
	public static void allPostsFromExSheet(WebDriver driver) throws Exception {
		String data;
		ExcelUtils.getExcelFile(Constant.path + Constant.data, Constant.sheetNameTekst);
		for (int i = 1; i <= ExcelUtils.getExcelSheet().getLastRowNum(); i++) {
			postFromExSheet(driver, i);
		}
	}

}
