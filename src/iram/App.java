/***
 * @author E. Dauvin
 * 
 */
package iram;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner lireClavier = new Scanner(System.in);
		ArrayList<String>listeEmail = new ArrayList<String>();
		
		// Menu
		int choix;
		do {
			System.out.println("\n\tMenu\nEntrez votre choix : ");
			System.out.println("[1] Enregistrer une adresse email");
			System.out.println("[2] Lister les adreses email");
			System.out.println("[5] sortir");
			choix = lireClavier.nextInt();
			switch (choix) {
			case 1:
				enregistrerAdresse(listeEmail);
				break;
			case 2:
				afficherEmail(listeEmail);
				break;
			case 5:
				break;
			default:
				System.out.println("\nErreur\n");
			}
		} while(choix != 5);
		System.out.println("Terminé");
	} // fin main

	public static void enregistrerAdresse(ArrayList<String> tab) {
		Scanner lireClavier = new Scanner(System.in);
		String email;
		int i=tab.size();

		System.out.println("Nombre d'adresses encodées : " + tab.size());
		System.out.print("Encoder l'adresse email no " + (i+1) + " : ");
		email = lireClavier.nextLine().toLowerCase();
		
		if (isValid(email)) {
			// Ajouter l'adresse à la liste
			tab.add(email);
		}
		else {
			// Erreur, ne pas ajouter l'adresse
			System.out.println("L'adresse n'est pas bonne.");
		}
	}// fin fonction

	public static void afficherEmail (ArrayList<String> tab) {
		System.out.println("Liste des adresses enregistrées");
		System.out.println(tab.toString());
		
	}//fin fonction
	
	
	public static boolean isValid(String email) {
		boolean isValid = true;
		char c;
		
		if (email.length() == 0) {
			// l'adresse ne peut pas être vide
			System.out.println("L'adresse est vide");
			isValid=false;
		}
		else {
			for (int i=0; i < email.length(); ++i) {
				c = email.charAt(i);
				if ((c != '@') && (c != '.') && ((c < 'a') || (c > 'z'))) {
					// le caractère n'est pas valide
					isValid=false;
					System.out.println("caractère non valide en position : " + i);
				}// fin if
			}// fin for
		}// fin if-else

		if (isValid == true) {
			int nombreDeAt = 0; // cette variable est utilisée pour comptre le nombre de @ dans l'adresse, il ne doit y en avoir qu'un seul.
			int positionDuAt = 0; // cette variable est utilisée pour vérifier à quelle position se trouve le @ dans l'adresse

			for (int i=0; i<email.length(); ++i) {
				if (email.charAt(i) == '@') {
					nombreDeAt++;
					positionDuAt = i;
				}// fin if
			}// fin for
			if (nombreDeAt != 1) {
				isValid = false;
				System.out.println("le nombre de @ n'est pas correct : " + nombreDeAt);
			}
			else if (positionDuAt == 0 || positionDuAt == email.length()-1) {
				isValid = false;
				System.out.println("le @ n'est pas en bonne position : " + positionDuAt);
			}
			else if ((email.charAt(0) == '.') || 
					 (email.charAt(email.length()-1) == '.') ||
					 (email.charAt(positionDuAt-1) == '.') ||
					 (email.charAt(positionDuAt+1) == '.')) {
				isValid = false;
				System.out.println("le . n'est pas en bonne position : " + positionDuAt);
			}
		}// fin if
		
		return (isValid);
	}// fin fonction
	
}// fin programme