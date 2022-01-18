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

import crud.StudentCrud;
import model.Student;

public class DUnosStudenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textImeStudenta;
	private JTextField textPrezimeStudenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosStudenta dialog = new DUnosStudenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosStudenta() {
		setTitle("Unos studenta");
		setBounds(100, 100, 450, 203);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUnesiteImeStudenta = new JLabel("Unesite ime studenta:");
		lblUnesiteImeStudenta.setBounds(31, 33, 130, 14);
		contentPanel.add(lblUnesiteImeStudenta);
		
		textImeStudenta = new JTextField();
		textImeStudenta.setBounds(188, 30, 163, 20);
		contentPanel.add(textImeStudenta);
		textImeStudenta.setColumns(10);
		
		JLabel lblUnesitePrezimeStudenta = new JLabel("Unesite prezime studenta:");
		lblUnesitePrezimeStudenta.setBounds(31, 86, 143, 14);
		contentPanel.add(lblUnesitePrezimeStudenta);
		
		textPrezimeStudenta = new JTextField();
		textPrezimeStudenta.setBounds(188, 83, 163, 20);
		contentPanel.add(textPrezimeStudenta);
		textPrezimeStudenta.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime = textImeStudenta.getText();
						String prezime = textPrezimeStudenta.getText();
						Student s = new Student();
						s.setIme(ime);
						s.setPrezime(prezime);
						StudentCrud sc = new StudentCrud();
						sc.insertStudent(s);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
