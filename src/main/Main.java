package main;

import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import page.objects.LogInForm;
import page.objects.PostPage;
import page.objects.RegistrationForm;

import page.test.LogInFormTest;
import page.test.MakeAPostTest;
import page.test.PostPageTest;
import page.test.RegistrationFormTest;

public class Main {

	public static void main(String[] args) throws Exception {
		// Otvaranje Google Chroma
		WebDriver driver = new ChromeDriver();
		// Stavljanje prozora na ceo ekran
		driver.manage().window().maximize();
		try {
			// URL Stranice
			RegistrationForm.navigateTo(driver);

     		// Test registrovanja svih korisnika iz eksel tabele
			RegistrationFormTest.allExcelElements(driver);

			// Test logovanja svih korisnika prethodno registrovanih iz eksel tabele
			LogInFormTest.fillFormAllElements(driver);

			// Test logovanja jednog korisnika iz eksel tabele
			LogInFormTest.fillFormFromExSheet(driver, 4);

			// Test postavljanje svih postova iz eksel tabele
			MakeAPostTest.allPostsFromExSheet(driver);

			// Test brisanja postova tog korisnika
			PostPageTest.deletePosts(driver, 95);

			// Test menjanja opisa posta
			PostPageTest.editPost(driver);

			Thread.sleep(5000);
			driver.quit();

		} catch (Exception e) {
			throw (e);
		}

	}

}
