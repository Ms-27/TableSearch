package ms.fr;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class TableSearch {
	static WebDriver driver;
	
	public static int[] returnRowCol(String s){ 
		// on initialise les coordonnées de notre cellule
		int[] cell = {1, 1};
		// on instancie la liste de ligne avec le xpath du tableau
		List<WebElement> list_row = driver.findElements(By.xpath("//table/tbody/tr"));
		// 1ere boucle qui balaye les lignes
		for(WebElement row : list_row) {
		// on instancie la liste des colonnes
			List<WebElement> list_col = row.findElements(By.xpath("td"));
		// on reset la valeur de colonne avant de balayer la ligne
			cell[1] = 0;
			for(WebElement col : list_col) {
		// on balaye chaque colonne en cherchant la correspondance de la cellule avec la valeur s
				if(col.getText().equals(s)) {
					return cell;
				}
		// on incrémente la valeur de colonne
				cell[1]++;
			}
		// on incrémente la valeur de ligne
			cell[0]++;
		}
		// on retourne les valeurs -1,-1 si <s> n'est pas dans le tableau
		cell[0] = -1;
		cell[1] = -1;
		return cell;	
	}


}
