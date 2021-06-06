package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.NastavnikCrud;
import crud.PredmetCrud;
import model.Nastavnik;
import model.Predmet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DUnosPredaje extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosPredaje dialog = new DUnosPredaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosPredaje() {
		setTitle("Unos predavanja");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIzaberiteNastavnika = new JLabel("Izaberite nastavnika:");
			lblIzaberiteNastavnika.setBounds(23, 39, 109, 14);
			contentPanel.add(lblIzaberiteNastavnika);
		}
		
		NastavnikCrud nc = new NastavnikCrud();
		JComboBox<Nastavnik> cbNastavnik = new JComboBox<Nastavnik>();
		List<Nastavnik> nastavnici = nc.listNastavnici();
		for(Nastavnik n: nastavnici){
			cbNastavnik.addItem(n);
		}
		cbNastavnik.setBounds(142, 36, 282, 20);
		contentPanel.add(cbNastavnik);
		
		JLabel lblIzaberitePredmet = new JLabel("Izaberite predmet:");
		lblIzaberitePredmet.setBounds(23, 116, 109, 14);
		contentPanel.add(lblIzaberitePredmet);
		
		PredmetCrud pc = new PredmetCrud();
		JComboBox<Predmet> cbPredmet = new JComboBox<Predmet>();
		List<Predmet> predmeti = pc.listPredmeti();
		for(Predmet p : predmeti){
			cbPredmet.addItem(p);
		}
		cbPredmet.setBounds(142, 113, 282, 20);
		contentPanel.add(cbPredmet);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Nastavnik n = (Nastavnik)cbNastavnik.getSelectedItem();
						Predmet p = (Predmet)cbPredmet.getSelectedItem();
						nc.poveziNastavnikaIPredmet(n, p);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Zatvori");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
