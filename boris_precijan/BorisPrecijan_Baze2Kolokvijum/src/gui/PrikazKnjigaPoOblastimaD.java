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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PrikazKnjigaPoOblastimaD extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JComboBox<Oblast> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PrikazKnjigaPoOblastimaD dialog = new PrikazKnjigaPoOblastimaD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PrikazKnjigaPoOblastimaD() {
		setResizable(false);
		Crud crud = new Crud();
		setModal(true);
		setTitle("Prikaz knjiga po oblastima");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 409);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Izaberite oblast");
			lblNewLabel.setBounds(10, 10, 92, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			comboBox = new JComboBox<Oblast>();
			List<Oblast> oblasti = crud.sveOblasti();
			for(Oblast o : oblasti) {
				comboBox.addItem(o);
			}
			comboBox.setBounds(112, 6, 287, 21);
			contentPanel.add(comboBox);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 506, 294);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		{
			JButton btnNewButton = new JButton("Prikazi");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Oblast o = (Oblast) comboBox.getSelectedItem();
					List<Knjiga> lista = crud.sveKnjige(o);
					TableModelKnjiga tmk = new TableModelKnjiga(lista);
					table.setModel(tmk);
				}
			});
			btnNewButton.setBounds(431, 6, 85, 21);
			contentPanel.add(btnNewButton);
		}
	}
}
