package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import crud.NastavnikCrud;
import model.Nastavnik;

public class DPromenaZvanja extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfZvanje;
	JComboBox<Nastavnik> cbNastavnik;
	NastavnikCrud nc = new NastavnikCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPromenaZvanja dialog = new DPromenaZvanja(null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPromenaZvanja(JFrame f, boolean modal) {
		super(f,modal);
		setTitle("Promena zvanja");
		setBounds(100, 100, 525, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIzaberiteNastavnika = new JLabel("Izaberite nastavnika:");
			lblIzaberiteNastavnika.setBounds(10, 23, 117, 14);
			contentPanel.add(lblIzaberiteNastavnika);
		}
		{
			cbNastavnik = new JComboBox<Nastavnik>();
			List<Nastavnik> nastavnici = nc.listNastavnici();
			for(Nastavnik n : nastavnici){
				cbNastavnik.addItem(n);
			}
			cbNastavnik.setBounds(137, 20, 362, 20);
			contentPanel.add(cbNastavnik);
		}
		{
			JLabel lblUnesiteNovoZvanje = new JLabel("Unesite novo zvanje:");
			lblUnesiteNovoZvanje.setBounds(10, 73, 117, 14);
			contentPanel.add(lblUnesiteNovoZvanje);
		}
		{
			tfZvanje = new JTextField();
			tfZvanje.setBounds(137, 70, 203, 20);
			contentPanel.add(tfZvanje);
			tfZvanje.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Promeni");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Nastavnik n = (Nastavnik)cbNastavnik.getSelectedItem();
						String zvanje = tfZvanje.getText();
						boolean uspesno = nc.updateNastavnik(n, zvanje);	
						if(uspesno){
							JOptionPane.showMessageDialog(DPromenaZvanja.this, "Uspesno je promenjeno zvanje.");
						}else{
							JOptionPane.showMessageDialog(DPromenaZvanja.this, "Doslo je do neke greške!");
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
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	
}
