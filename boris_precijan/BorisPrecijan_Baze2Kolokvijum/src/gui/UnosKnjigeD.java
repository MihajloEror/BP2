package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.Crud;
import model.Autor;
import model.Knjiga;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class UnosKnjigeD extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UnosKnjigeD dialog = new UnosKnjigeD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UnosKnjigeD() {;
		setModal(true);
		setResizable(false);
		setTitle("Unos knjige");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 361, 140);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv knjige");
		lblNewLabel.setBounds(10, 10, 75, 13);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setBounds(10, 33, 75, 13);
		contentPanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(95, 7, 231, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JComboBox<Autor> comboBox = new JComboBox<Autor>();
		Crud crud = new Crud();
		List<Autor> lista = crud.sviAutori();
		for (Autor a : lista) {
			comboBox.addItem(a);
		}
		comboBox.setBounds(95, 29, 231, 21);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textField.getText().trim().equals("")) {
							Knjiga knjiga = new Knjiga();
							knjiga.setKnjigaNaziv(textField.getText());
							Autor autor = (Autor) comboBox.getSelectedItem();
							knjiga.setAutor(autor);
							if(crud.insertKnjiga(knjiga))
								System.out.println("Uspesno ste uneli knjigu.");
							else
								System.err.println("Greska prilikom unosa knjige!");
						} else {
							System.err.println("Polje za naziv knjige je prazno!");
						}
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
