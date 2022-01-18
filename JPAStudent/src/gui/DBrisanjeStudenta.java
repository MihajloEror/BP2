package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.StudentCrud;
import model.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBrisanjeStudenta extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBrisanjeStudenta dialog = new DBrisanjeStudenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBrisanjeStudenta() {
		setTitle("Brisanje studenta");
		setBounds(100, 100, 450, 184);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIzaberiteStudentaKog = new JLabel("Izaberite studenta kog \u017Eelite da izbri\u0161ete:");
			lblIzaberiteStudentaKog.setBounds(23, 25, 269, 14);
			contentPanel.add(lblIzaberiteStudentaKog);
		}
		
		JComboBox<Student> cbStudent = new JComboBox<Student>();
		cbStudent.setBounds(23, 65, 371, 20);
		contentPanel.add(cbStudent);
		StudentCrud sc = new StudentCrud();
		List<Student> studenti = sc.listStudent();
		for(Student s : studenti){
			cbStudent.addItem(s);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Student s = (Student)cbStudent.getSelectedItem();
						if(sc.deleteStudent(s)){
							JOptionPane.showMessageDialog(DBrisanjeStudenta.this, "Uspesno obrisan student");
							cbStudent.removeItem(s);
						}else{
							JOptionPane.showMessageDialog(DBrisanjeStudenta.this, "Student nije obrisan");
						}
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
