package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavniProzor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUnosStudenta = new JButton("Unos studenta");
		btnUnosStudenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DUnosStudenta du = new DUnosStudenta();
				du.setVisible(true);
			}
		});
		btnUnosStudenta.setBounds(26, 26, 139, 23);
		frame.getContentPane().add(btnUnosStudenta);
		
		JButton btnBrisanjeStudenta = new JButton("Brisanje studenta");
		btnBrisanjeStudenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBrisanjeStudenta db = new DBrisanjeStudenta();
				db.setVisible(true);
			}
		});
		btnBrisanjeStudenta.setBounds(26, 73, 139, 23);
		frame.getContentPane().add(btnBrisanjeStudenta);
		
		JButton btnPrikazSvihStudenata = new JButton("Prikaz svih studenata");
		btnPrikazSvihStudenata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DPrikazStudenata dp = new DPrikazStudenata();
				dp.setVisible(true);
			}
		});
		btnPrikazSvihStudenata.setBounds(26, 122, 139, 23);
		frame.getContentPane().add(btnPrikazSvihStudenata);
		
		JButton btnZatvoriProgram = new JButton("Zatvori program");
		btnZatvoriProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnZatvoriProgram.setBounds(26, 168, 139, 23);
		frame.getContentPane().add(btnZatvoriProgram);
	}
}
