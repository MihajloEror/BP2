package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import crud.NastavnikCrud;
import crud.PredmetCrud;
import model.Nastavnik;
import model.Predmet;

public class DPrikazPredavaca extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	JComboBox<Predmet> cbPredmet;
	PredmetCrud pc = new PredmetCrud();
	NastavnikCrud nc = new NastavnikCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPrikazPredavaca dialog = new DPrikazPredavaca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPrikazPredavaca() {
		setTitle("Prikaz predavaca");
		setBounds(100, 100, 616, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblIzaberitePredmet = new JLabel("Izaberite predmet:");
				panel.add(lblIzaberitePredmet);
			}
			{
				cbPredmet = new JComboBox<Predmet>();
				List<Predmet> predmeti = pc.listPredmeti();
				for(Predmet p : predmeti){
					cbPredmet.addItem(p);
				}
				panel.add(cbPredmet);
			}
			{
				JButton btnPrikazi = new JButton("Prikazi");
				btnPrikazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Predmet p = (Predmet)cbPredmet.getSelectedItem();
						List<Nastavnik> predavaci = nc.listPredavaci(p);
						TableModelNastavnik tmn = new TableModelNastavnik(predavaci);
						table.setModel(tmn);
					}
				});
				panel.add(btnPrikazi);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
