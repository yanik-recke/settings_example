package settings_example.application;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Spielklasse
 * 
 * @author recke
 */
public class Game {
	/** Stadion */
	private Settings.stadium stadium;
	/** Label das das aktuelle Stadion anzeigt */
	private JLabel label;
	
	/**
	 * Konstruktor für ein neues Spiel. Ist nur dafür da, die aktuellen Einstellungen
	 * einmal auszugeben, um zu kontrollieren, ob die Einstellungen
	 * durch das Einstellungsfenster gesetzt werden können.
	 * 
	 * @param stadium - Stadion
	 */
	public Game(Settings.stadium stadium) {
		this.stadium = stadium;
		
		JFrame frame = new JFrame();
		
		// Frame formatieren
		frame.setBounds(200,200,400,400);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		// Label zum Anzeigen des Stadions
		label = new JLabel();
		label.setSize(500,500);
		
		frame.add(label);
		
		printCurrentSettings();
	}
	
	
	/**
	 * Gibt die aktuellen Einstellungen auf dem Bildschirm wieder
	 */
	private void printCurrentSettings() {
		label.setText("Aktuelles Stadion: " + this.stadium.toString());
		System.out.println("Aktuelles Stadion: " + this.stadium.toString());
	}

}