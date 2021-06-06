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
 * The persistent class for the PROIZVOD database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvod.findAll", query="SELECT p FROM Proizvod p")
public class Proizvod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROIZVOD_PROIZVODID_GENERATOR", sequenceName="PROIZVOD_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROIZVOD_PROIZVODID_GENERATOR")
	@Column(name="PROIZVOD_ID")
	private long proizvodId;

	private double cena;

	private String naziv;

	//bi-directional many-to-one association to Stavka
	@OneToMany(mappedBy="proizvod")
	private List<Stavka> stavke;

	public Proizvod() {
		this.stavke = new ArrayList<Stavka>();
	}

	public long getProizvodId() {
		return this.proizvodId;
	}

	public void setProizvodId(long proizvodId) {
		this.proizvodId = proizvodId;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Stavka> getStavke() {
		return this.stavke;
	}

	public void setStavke(List<Stavka> stavke) {
		this.stavke = stavke;
	}

	public Stavka addStavke(Stavka stavke) {
		getStavke().add(stavke);
		stavke.setProizvod(this);

		return stavke;
	}

	public Stavka removeStavke(Stavka stavke) {
		getStavke().remove(stavke);
		stavke.setProizvod(null);

		return stavke;
	}

	@Override
	public String toString() {
		return "Proizvod [proizvodId=" + proizvodId + ", cena=" + cena + ", naziv=" + naziv + "]";
	}

}