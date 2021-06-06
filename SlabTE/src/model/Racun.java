package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the RACUN database table.
 * 
 */
@Entity
@NamedQuery(name="Racun.findAll", query="SELECT r FROM Racun r")
public class Racun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RACUN_RACUNID_GENERATOR", sequenceName="RACUN_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RACUN_RACUNID_GENERATOR")
	@Column(name="RACUN_ID")
	private long racunId;

	private String klijent;

	private double total;

	//bi-directional many-to-one association to Stavka
	@OneToMany(mappedBy="racun")
	private List<Stavka> stavke;

	public Racun() {
		this.stavke = new ArrayList<Stavka>();
	}

	public long getRacunId() {
		return this.racunId;
	}

	public void setRacunId(long racunId) {
		this.racunId = racunId;
	}

	public String getKlijent() {
		return this.klijent;
	}

	public void setKlijent(String klijent) {
		this.klijent = klijent;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Stavka> getStavke() {
		return this.stavke;
	}

	public void setStavke(List<Stavka> stavke) {
		this.stavke = stavke;
	}

	public Stavka addStavke(Stavka stavke) {
		getStavke().add(stavke);
		stavke.setRacun(this);

		return stavke;
	}

	public Stavka removeStavke(Stavka stavke) {
		getStavke().remove(stavke);
		stavke.setRacun(null);

		return stavke;
	}

	@Override
	public String toString() {
		return "Racun [racunId=" + racunId + ", klijent=" + klijent + ", total=" + total + "]";
	}

}