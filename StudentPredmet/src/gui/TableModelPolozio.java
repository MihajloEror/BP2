package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Apolozio;

public class TableModelPolozio extends AbstractTableModel{
	
	String[] kolone = {"Predmet", "Ocena", "Datum"};
	private List<Apolozio> ispiti = null;
	
	public TableModelPolozio(List<Apolozio> ispiti){
		this.ispiti = ispiti;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ispiti.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Apolozio ispit = ispiti.get(arg0);
		switch(arg1){
		case 0 : return ispit.getPredmet();
		case 1 : return ispit.getOcena();
		case 2 : return ispit.getDatum();
		}
		return null;
	}
	
	public String getColumnName(int i){
		return kolone[i];
	}

}
