package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the NASTAVNIK database table.
 * 
 */
@Entity
@NamedQuery(name="Nastavnik.findAll", query="SELECT n FROM Nastavnik n")
public class Nastavnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NASTAVNIK_NASTAVNIKID_GENERATOR", sequenceName="NASTAVNIK_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NASTAVNIK_NASTAVNIKID_GENERATOR")
	@Column(name="NASTAVNIK_ID")
	private long nastavnikId;

	private String ime;

	private String prezime;

	private String zvanje;

	//bi-directional many-to-many association to Predmet
	@ManyToMany(mappedBy="nastavniks")
	private List<Predmet> predmets;

	public Nastavnik() {
		this.predmets = new ArrayList<Predmet>();
	}

	public long getNastavnikId() {
		return this.nastavnikId;
	}

	public void setNastavnikId(long nastavnikId) {
		this.nastavnikId = nastavnikId;
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

	public String getZvanje() {
		return this.zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public List<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	@Override
	public String toString() {
		return "Nastavnik [nastavnikId=" + nastavnikId + ", ime=" + ime + ", prezime=" + prezime + ", zvanje=" + zvanje
				+ "]";
	}
	
	

}