package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
@SequenceGenerator(name = "brind_sequence", sequenceName = "brind_id_seq")


public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brind_sequence")
	private Integer brojindeksa;

	private String ime;

	private String prezime;

	public Student() {
	}

	public Integer getBrojindeksa() {
		return this.brojindeksa;
	}

	public void setBrojindeksa(Integer brojindeksa) {
		this.brojindeksa = brojindeksa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return "Student [brojindeksa=" + brojindeksa + ", ime=" + ime + ", prezime=" + prezime + "]";
	}

}