package service;

import javax.persistence.Persistence;

// Zum testen ob die Verbindung zur Datenbank vorhanden ist
public class Main {

	public static void main(String[] args) {
		
		System.out.println("Verbindung zur MySQL-Datenbank via EclipseLink vorhanden?");
		
		System.out.println(Persistence.createEntityManagerFactory("Parts4Games_Parts4Games").isOpen());

	}

}
