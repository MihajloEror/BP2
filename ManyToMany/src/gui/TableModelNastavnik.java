package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Nastavnik;

public class TableModelNastavnik extends AbstractTableModel{
	
	String[] kolone = {"Ime", "Prezime", "Zvanje"};
	private List<Nastavnik> nastavnici = null;
	
	public TableModelNastavnik(List<Nastavnik> nastavnici){
		this.nastavnici = nastavnici;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return nastavnici.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		Nastavnik n = nastavnici.get(arg0);
		switch(arg1){
		case 0 : return n.getIme();
		case 1 : return n.getPrezime();
		case 2 : return n.getZvanje();
		}
		return null;
	}
	
	public String getColumnName(int i){
		return kolone[i];
	}

}
