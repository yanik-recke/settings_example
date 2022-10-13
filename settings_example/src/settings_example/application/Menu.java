package settings_example.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Die Klasse aus der ein Spiel gestartet werden kann oder
 * die Einstellungen aufgerufen werden können.
 * 
 * @author recke
 */
public class Menu {
	
	/** Aktuell ausgewähltes Stadion (Standard Wert = Camp Nou) */
	private Settings.stadium stadium = Settings.stadium.CAMP_NOU;
	/** Instanz des Spiels */
	private Game game;
	
	
	/**
	 * Konstruktor für das Menü. 
	 * Hinzufügen der Buttons zum Spielstart und
	 * der Einstellungen.
	 */
	public Menu() {
		JFrame frame = new JFrame();
		
		
		// BUTTON FÜR NEUES SPIEL
		JButton bttnNewGame = new JButton();
		// Größe des Buttons
		bttnNewGame.setBounds(100,100,100,100);
		bttnNewGame.setText("Spiel starten");
		
		// Bei einem Klick auf diesen Button wird die Methode "openSettings()" aufgerufen
		bttnNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		
		
		// BUTTON FÜR EINSTELLUNGEN
		JButton bttnSettings = new JButton();
		// Größe des Buttons
		bttnSettings.setBounds(200,100,100,100);
		bttnSettings.setText("Einstellungen");
			
		// Bei einem Klick auf diesen Button wird die Methode "startGame()" aufgerufen
		bttnSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openSettings();
			}
		});
		
		
		
		// Frame formatieren
		frame.setBounds(200,200,400,400);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		frame.add(bttnNewGame);
		frame.add(bttnSettings);
	}
	
	
	/**
	 * Setzt das aktuell ausgewählte Stadium auf den übergebenen Wert
	 * 
	 * @param stadium - das neue Stadium
	 */
	public void setStadium(Settings.stadium stadium) {
		this.stadium = stadium;
	}
	
	
	/**
	 * Öffnet die Einstellungen
	 */
	public void openSettings() {
		new Settings(this);
	}
	
	
	/**
	 * Startet ein neues Spiel
	 */
	public void startGame() {
		this.game = new Game(this.stadium);
	}

}