package page.test;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.PostPage;

public class PostPageTest {

	// Metoda za brisanje postova
	public static void deletePosts(WebDriver driver, int brPostova) throws Exception {
		try {
			int brPostovaKorisnika = PostPage.userPosts(driver);
			if (brPostova < 0) {
				System.out.println("Izabrali ste broj manji od nule.");
			} else if (brPostova == 0) {
				System.out.println("Nije obrisan ni jedan post.");
			} else if (brPostovaKorisnika < brPostova) {
				System.out.println("Izabrali ste da obrišete više postova nego što imate.");
			} else {
				for (int i = 1; i <= brPostova; i++) {
					PostPage.deletePostButton(driver);
					System.out.println("Uspešno ste obrisali "+brPostova+" postova");
				}
			}

		} catch (Exception e) {
			throw (e);
		}
	}

	// Metoda za menjanje postova
	public static void editPost(WebDriver driver) throws Exception {
		try {
			Scanner sc = new Scanner(System.in);

			PostPage.editPostButton(driver);
			PostPage.deleteEditPostText(driver);
			Thread.sleep(2000);
			
			System.out.println("Unesite novi opis:");
			PostPage.clickEditPostText(driver);
			PostPage.deleteEditPostText(driver);
			String opis = sc.nextLine();
			PostPage.sendEditPostText(driver, opis);

			PostPage.clickEditPostButton(driver);

		} catch (Exception e) {
			throw (e);
		}
	}

}
