package test;

import java.util.Scanner;

import metier.Compte;
import metier.IMetier;
import metier.MetierImpl;

public class App {

	public static void main(String[] args) {

		new App().start();
	}

	private void start() {
		System.out.println("Demarrage de l'application");
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner le code du compte : ");
		Long code = sc.nextLong();
		System.out.println("Donner le solde initiale du compte : ");
		double solde = sc.nextDouble();
		IMetier metier = new MetierImpl();
		metier.addCompte(new Compte(code, solde));
		
		while(true) {
			
			try {
				
				System.out.println("Type operation : ");
				String type = sc.next();
				if(type.equals("quitter")) break;
				System.out.println("Montant : ");
				double montant = sc.nextDouble();
				
				switch(type) {
				case "r" : 
					metier.retirer(code, montant);
					break;
				case "v" :
					metier.verser(code, montant);
					break;
				}
				
				System.out.println("Etat du compte : " + metier.consulter(code));
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		sc.close();
		System.out.println("Fin de l'application");
	}

}
