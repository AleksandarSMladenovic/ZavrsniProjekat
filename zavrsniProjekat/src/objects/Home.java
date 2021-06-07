package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

	public static final String LOGIN_BTN_XPATH = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";
	
	public static final String HOME = "https://www.humanity.com/";
	
	public static void pressLogin(WebDriver driver) {
		driver.findElement(By.xpath(LOGIN_BTN_XPATH)).click();
	}
}

/*
 * ZADACI:
 * 
 * a) pocetna strana
 * 
 * Doci do stranice ABOUT US i napraviti screenshot strane Proveriti da li
 * postojeci user uspesno moze da se loguje
 * 
 * b) vasaFirma/humanity
 * 
 * Proveriti sve elemente iz gornjeg menija - da li naziv iz menija odgovara
 * strani na koju sajt redirektuje prilikom kliktanja na dugme Dodati novog
 * zaposlenog i proveriti uspesnost dodavanja Zaposlenom promeniti ime 3.1.
 * Dodatni zadatak: zaposlenom dodati fotografiju Koristeci apachePOI
 * (ucitavanjem iz excel tabele), automatski dodati minimum 5 novih zaposlenih i
 * proveriti uspesnost dodavanja. Sami kreirate tabelu sa potrebnim podacima.
 * 
 * c) settings
 * 
 * Promeniti jezik Odcekirati (disable) notifikacije
 * 
 * d) profile
 * 
 * Omoguciti da se barata podesavanjima profila (izmene po vasem izboru,
 * najmanje 2).
 */