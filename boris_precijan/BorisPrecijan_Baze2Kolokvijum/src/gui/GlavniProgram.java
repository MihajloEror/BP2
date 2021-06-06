package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProgram {

	private JFrame frmKolokvijum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProgram window = new GlavniProgram();
					window.frmKolokvijum.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavniProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.err.println("Greska prilikom podesavanja izgleda korisnickog interfejsa!");
		}
		frmKolokvijum = new JFrame();
		frmKolokvijum.setTitle("Boris Precijan (86/18) - Kolokvijum");
		frmKolokvijum.setResizable(false);
		frmKolokvijum.setBounds(100, 100, 333, 261);
		frmKolokvijum.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKolokvijum.getContentPane().setLayout(null);
		
		JButton btnUnosKnjige = new JButton("Unos knjige");
		btnUnosKnjige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnosKnjigeD ukd = new UnosKnjigeD();
				ukd.setVisible(true);
			}
		});
		btnUnosKnjige.setBounds(46, 29, 237, 21);
		frmKolokvijum.getContentPane().add(btnUnosKnjige);
		
		JButton btnPoveziKnjiguIOblast = new JButton("Povezivanje knjige sa oblastima");
		btnPoveziKnjiguIOblast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PovezivanjeKnjigeSaOblastimaD pkso = new PovezivanjeKnjigeSaOblastimaD();
				pkso.setVisible(true);
			}
		});
		btnPoveziKnjiguIOblast.setBounds(46, 79, 237, 21);
		frmKolokvijum.getContentPane().add(btnPoveziKnjiguIOblast);
		
		JButton btnObrisiKnjigu = new JButton("Brisanje knjige");
		btnObrisiKnjigu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrisanjeKnjigeD bk = new BrisanjeKnjigeD();
				bk.setVisible(true);
			}
		});
		btnObrisiKnjigu.setBounds(46, 129, 237, 21);
		frmKolokvijum.getContentPane().add(btnObrisiKnjigu);
		
		JButton btnNewButton = new JButton("Prikaz knjiga po oblastima");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrikazKnjigaPoOblastimaD pkpo = new PrikazKnjigaPoOblastimaD();
				pkpo.setVisible(true);
			}
		});
		btnNewButton.setBounds(46, 179, 237, 21);
		frmKolokvijum.getContentPane().add(btnNewButton);
	}
}
