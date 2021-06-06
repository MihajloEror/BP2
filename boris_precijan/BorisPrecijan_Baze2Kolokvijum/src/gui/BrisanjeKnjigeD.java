package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.Crud;
import model.Knjiga;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BrisanjeKnjigeD extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Knjiga> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BrisanjeKnjigeD dialog = new BrisanjeKnjigeD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BrisanjeKnjigeD() {
		Crud crud = new Crud();
		setModal(true);
		setTitle("Brisanje knjige");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 419, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Izaberite knjigu");
			lblNewLabel.setBounds(10, 10, 94, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			comboBox = new JComboBox<Knjiga>();
			List<Knjiga> lista = crud.sveKnjige();
			for(Knjiga k : lista) {
				comboBox.addItem(k);
			}
			comboBox.setBounds(102, 6, 296, 21);
			contentPanel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Obrisi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Knjiga k = (Knjiga) comboBox.getSelectedItem();
						if(crud.deleteKnjiga(k)) {
							comboBox.removeItem(k);
							System.out.println("Uspesno ste obrisali knjigu.");
						} else {
							System.err.println("Greska prilikom brisanja knjige!");
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
