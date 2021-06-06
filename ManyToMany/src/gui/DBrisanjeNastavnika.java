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
import model.Nastavnik;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBrisanjeNastavnika extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<Nastavnik> cbNastavnik;
	NastavnikCrud nc = new NastavnikCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBrisanjeNastavnika dialog = new DBrisanjeNastavnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBrisanjeNastavnika() {
		setTitle("Brisanje nastavnika");
		setBounds(100, 100, 553, 117);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblIzaberiteNastavnika = new JLabel("Izaberite nastavnika:");
			contentPanel.add(lblIzaberiteNastavnika);
		}
		{
			cbNastavnik = new JComboBox<Nastavnik>();
			List<Nastavnik> nastavnici = nc.listNastavnici();
			for(Nastavnik n : nastavnici){
				cbNastavnik.addItem(n);
			}
			contentPanel.add(cbNastavnik);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Izbrisi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Nastavnik n = (Nastavnik)cbNastavnik.getSelectedItem();
						nc.deleteNastavnik(n);
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
