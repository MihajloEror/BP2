package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.Crud;
import model.Knjiga;
import model.Oblast;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PovezivanjeKnjigeSaOblastimaD extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Knjiga> knjige;
	private JComboBox<Oblast> oblasti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PovezivanjeKnjigeSaOblastimaD dialog = new PovezivanjeKnjigeSaOblastimaD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PovezivanjeKnjigeSaOblastimaD() {
		setResizable(false);
		Crud crud = new Crud();
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Povezivanje knjige sa oblastima");
		setBounds(100, 100, 434, 126);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Knjiga");
			lblNewLabel.setBounds(10, 10, 45, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Oblast");
			lblNewLabel_1.setBounds(10, 33, 45, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			knjige = new JComboBox<Knjiga>();
			List<Knjiga> lista = crud.sveKnjige();
			for(Knjiga k : lista) {
				knjige.addItem(k);
			}
			knjige.setBounds(65, 6, 305, 21);
			contentPanel.add(knjige);
		}
		{
			oblasti = new JComboBox<Oblast>();
			List<Oblast> oblastiLista = crud.sveOblasti();
			for(Oblast o : oblastiLista) {
				oblasti.addItem(o);
			}
			oblasti.setBounds(65, 29, 305, 21);
			contentPanel.add(oblasti);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Knjiga k = (Knjiga) knjige.getSelectedItem();
						Oblast o = (Oblast) oblasti.getSelectedItem();
						if(!crud.poveziKnjiguIOblast(k, o)) {
							System.err.println("Greska prilikom povezivanja knjige i oblasti!");
						} else {
							System.out.println("Uspesno ste povezali knjigu i oblast.");
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
