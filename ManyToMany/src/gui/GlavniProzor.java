package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GlavniProzor {

	private JFrame frmNastava;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frmNastava.setVisible(true);
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
		frmNastava = new JFrame();
		frmNastava.setTitle("Nastava");
		frmNastava.setBounds(100, 100, 450, 364);
		frmNastava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNastava.getContentPane().setLayout(null);
		
		JButton btnUnosNastavnika = new JButton("Unos nastavnika");
		btnUnosNastavnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//otvori prozor za unos nastavnika
				DUnosNastavnika du = new DUnosNastavnika();
				du.setVisible(true);
			}
		});
		btnUnosNastavnika.setBounds(33, 31, 161, 23);
		frmNastava.getContentPane().add(btnUnosNastavnika);
		
		JButton btnUnosPredavanja = new JButton("Unos predavanja");
		btnUnosPredavanja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DUnosPredaje dp = new DUnosPredaje();
				dp.setVisible(true);
			}
		});
		btnUnosPredavanja.setBounds(33, 93, 161, 23);
		frmNastava.getContentPane().add(btnUnosPredavanja);
		
		JButton btnBrisanjeNastavnika = new JButton("Brisanje nastavnika");
		btnBrisanjeNastavnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBrisanjeNastavnika db = new DBrisanjeNastavnika();
				db.setVisible(true);
			}
		});
		btnBrisanjeNastavnika.setBounds(33, 155, 161, 23);
		frmNastava.getContentPane().add(btnBrisanjeNastavnika);
		
		JButton btnPromeniZvanje = new JButton("Promeni zvanje");
		btnPromeniZvanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DPromenaZvanja dpz = new DPromenaZvanja(frmNastava, true);
				dpz.setVisible(true);
			}
		});
		btnPromeniZvanje.setBounds(33, 213, 161, 23);
		frmNastava.getContentPane().add(btnPromeniZvanje);
		
		JButton btnPrikazPredavaa = new JButton("Prikaz predava\u010Da");
		btnPrikazPredavaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DPrikazPredavaca dpp = new DPrikazPredavaca();
				dpp.setVisible(true);
			}
		});
		btnPrikazPredavaa.setBounds(33, 278, 161, 23);
		frmNastava.getContentPane().add(btnPrikazPredavaa);
	}
}
