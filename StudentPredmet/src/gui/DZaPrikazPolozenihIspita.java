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

import crud.PolozioCrud;
import crud.StudentCrud;
import model.Apolozio;
import model.Astudent;

public class DZaPrikazPolozenihIspita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	JComboBox<Astudent> cbStudent;
	StudentCrud sc = new StudentCrud();
	PolozioCrud pc = new PolozioCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DZaPrikazPolozenihIspita dialog = new DZaPrikazPolozenihIspita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DZaPrikazPolozenihIspita() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblIzaberiteStudenta = new JLabel("Izaberite studenta:");
				panel.add(lblIzaberiteStudenta, BorderLayout.WEST);
			}
			{
				cbStudent = new JComboBox<Astudent>();
				List<Astudent> studenti = sc.listStudenti();
				for(Astudent s : studenti){
					cbStudent.addItem(s);
				}
				panel.add(cbStudent, BorderLayout.CENTER);
			}
			{
				JButton btnPrikazi = new JButton("Prikazi");
				btnPrikazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Astudent s = (Astudent)cbStudent.getSelectedItem();						
						List<Apolozio> polozeniIspiti = pc.polozeniIspiti(s);
						TableModelPolozio tmp = new TableModelPolozio(polozeniIspiti);
						table.setModel(tmp);						
					}
				});
				panel.add(btnPrikazi, BorderLayout.EAST);
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
