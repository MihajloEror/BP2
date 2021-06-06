package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the APREDMET database table.
 * 
 */
@Entity
@NamedQuery(name="Apredmet.findAll", query="SELECT a FROM Apredmet a")
public class Apredmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APREDMET_SPR_GENERATOR", sequenceName="APREDMET_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APREDMET_SPR_GENERATOR")
	private long spr;

	private String naziv;

	//bi-directional many-to-one association to Apolozio
	@OneToMany(mappedBy="predmet")
	private List<Apolozio> studentiKojiSuPolozili;

	//bi-directional many-to-many association to Astudent
	@ManyToMany(mappedBy="predmeti")
	private List<Astudent> studenti;

	public Apredmet() {
		this.studenti = new ArrayList<Astudent>();
		this.studentiKojiSuPolozili = new ArrayList<Apolozio>();
	}

	public long getSpr() {
		return this.spr;
	}

	public void setSpr(long spr) {
		this.spr = spr;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Apolozio> getStudentiKojiSuPolozili() {
		return this.studentiKojiSuPolozili;
	}

	public void setStudentiKojiSuPolozili(List<Apolozio> studentiKojiSuPolozili) {
		this.studentiKojiSuPolozili = studentiKojiSuPolozili;
	}

	public Apolozio addStudentiKojiSuPolozili(Apolozio studentiKojiSuPolozili) {
		getStudentiKojiSuPolozili().add(studentiKojiSuPolozili);
		studentiKojiSuPolozili.setPredmet(this);

		return studentiKojiSuPolozili;
	}

	public Apolozio removeStudentiKojiSuPolozili(Apolozio studentiKojiSuPolozili) {
		getStudentiKojiSuPolozili().remove(studentiKojiSuPolozili);
		studentiKojiSuPolozili.setPredmet(null);

		return studentiKojiSuPolozili;
	}

	public List<Astudent> getStudenti() {
		return this.studenti;
	}

	public void setStudenti(List<Astudent> studenti) {
		this.studenti = studenti;
	}

	@Override
	public String toString() {
		return "Apredmet [spr=" + spr + ", naziv=" + naziv + "]";
	}
	
	

}