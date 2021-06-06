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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the PREDMET database table.
 * 
 */
@Entity
@NamedQuery(name="Predmet.findAll", query="SELECT p FROM Predmet p")
public class Predmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PREDMET_PREDMETID_GENERATOR", sequenceName="PREDMET_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PREDMET_PREDMETID_GENERATOR")
	@Column(name="PREDMET_ID")
	private long predmetId;

	private String naziv;

	//bi-directional many-to-many association to Nastavnik
	@ManyToMany
	@JoinTable(
		name="PREDAJE"
		, joinColumns={
			@JoinColumn(name="PREDMET_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="NASTAVNIK_ID")
			}
		)
	private List<Nastavnik> nastavniks;

	public Predmet() {
		this.nastavniks = new ArrayList<Nastavnik>();
	}

	public long getPredmetId() {
		return this.predmetId;
	}

	public void setPredmetId(long predmetId) {
		this.predmetId = predmetId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Nastavnik> getNastavniks() {
		return this.nastavniks;
	}

	public void setNastavniks(List<Nastavnik> nastavniks) {
		this.nastavniks = nastavniks;
	}

	@Override
	public String toString() {
		return "Predmet [predmetId=" + predmetId + ", naziv=" + naziv + "]";
	}
	
	

}