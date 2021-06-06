package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Knjiga;

public class TableModelKnjiga extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Knjiga> lista;
	private String[] kolone = {"Naziv", "Autor"};
	
	public TableModelKnjiga(List<Knjiga> lista) {
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Knjiga k = lista.get(rowIndex);
		switch(columnIndex){
		case 0:
			return k.getKnjigaNaziv();
		case 1:
			return k.getAutor().getAutorIme() + " " + k.getAutor().getAutorPrezime();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

}
