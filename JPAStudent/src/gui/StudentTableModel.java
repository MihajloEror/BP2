package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Student;

public class StudentTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4827186496228801681L;
	String[] columns = { "BROJ INDEKSA", "IME", "PREZIME" };
	private List<Student> studenti;

	
	
	public StudentTableModel(List<Student> studenti) {
		this.studenti = studenti;
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return studenti.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Student s = studenti.get(arg0);
		switch (arg1) {
		case 0:
			return s.getBrojindeksa();
		case 1:
			return s.getIme();
		case 2:
			return s.getPrezime();
		}
		return null;
	}

	@Override
	public String getColumnName(int col) {
		return columns[col];
	}


}
