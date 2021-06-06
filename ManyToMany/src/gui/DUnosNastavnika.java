package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import crud.NastavnikCrud;
import model.Nastavnik;

public class DUnosNastavnika extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfIme;
	private JTextField tfPrezime;
	private JTextField tfZvanje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosNastavnika dialog = new DUnosNastavnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosNastavnika() {
		setTitle("Unos nastavnika");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUnestireIme = new JLabel("Unestire ime:");
		lblUnestireIme.setBounds(10, 46, 99, 14);
		contentPanel.add(lblUnestireIme);
		
		JLabel lblUnesitePrezime = new JLabel("Unesite prezime:");
		lblUnesitePrezime.setBounds(10, 106, 99, 14);
		contentPanel.add(lblUnesitePrezime);
		
		JLabel lblUnesiteZvanje = new JLabel("Unesite zvanje:");
		lblUnesiteZvanje.setBounds(10, 166, 99, 14);
		contentPanel.add(lblUnesiteZvanje);
		
		tfIme = new JTextField();
		tfIme.setBounds(119, 42, 269, 20);
		contentPanel.add(tfIme);
		tfIme.setColumns(10);
		
		tfPrezime = new JTextField();
		tfPrezime.setBounds(119, 104, 269, 20);
		contentPanel.add(tfPrezime);
		tfPrezime.setColumns(10);
		
		tfZvanje = new JTextField();
		tfZvanje.setBounds(119, 166, 269, 20);
		contentPanel.add(tfZvanje);
		tfZvanje.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime = tfIme.getText();
						String prezime = tfPrezime.getText();
						String zvanje = tfZvanje.getText();
						Nastavnik n = new Nastavnik();
						n.setIme(ime);
						n.setPrezime(prezime);
						n.setZvanje(zvanje);
						NastavnikCrud nc = new NastavnikCrud();
						nc.insertNastavnik(n);
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
