package settings_example.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;


/**
 * Einstellungs Klasse. Diese Klasse bekommt die Instanz
 * des Menu mit aus dem diese Instanz erstellt wurde.
 * 
 * @author recke
 */
public class Settings {
	
	/** Enum mit allen Stadien */
	public enum stadium {CAMP_NOU, ALLIANZ, NETHER };
	
	/** Instanz des Menu das die Einstellungen aufgerufen hat */
	private Menu menu;
	
	// Die ComboBox muss hier deklariert werden, damit von der ganzen Klasse aus drauf zugegriffen werden kann, wichtig
	// TODO parameterize
	/** ComboBox für die Stadien */
	private JComboBox<String> comboBoxStadiums;
	
	
	/**
	 * Konstruktor für die Einstellungen. Es wird eine Instanz von Menu übergeben.
	 * Das ist wichtig, damit man später die Stadion und PlayerCount Variable von
	 * Menu ändern kann. Durch das übergeben der Menu Instanz ist das möglich (siehe "changedStadium()")
	 * 
	 * @param menu - die Instanz des Menu, von dem die Einstellungen aufgerufen wurden
	 */
	public Settings(Menu menu) {
		this.menu = menu;
		
		JFrame frame = new JFrame();
		
		// Frame formatieren
		frame.setBounds(200,200,400,400);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		// COMBOBOX für die Stadien
		String comboBoxAuswahl[] = {stadium.CAMP_NOU.toString(), stadium.ALLIANZ.toString(), stadium.NETHER.toString()};
		comboBoxStadiums = new JComboBox(comboBoxAuswahl);
		comboBoxStadiums.setBounds(200,100,100,100);
		
		// Wenn sich der Wert der Stadien veärndert wird changedStadium() aufgerufen
		comboBoxStadiums.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changedStadium();
			}
		});
		
		
		// Hinzufügen der ComboBox auf das Frame
		frame.add(comboBoxStadiums);
	}
	
	
	/**
	 * Aktualisiert das Stadion und teilt dem Menü mit, das
	 * sich das Stadion geändert hat.
	 */
	private void changedStadium() {
		this.menu.setStadium(stadium.valueOf((String) comboBoxStadiums.getSelectedItem()));
	}
	
	
}