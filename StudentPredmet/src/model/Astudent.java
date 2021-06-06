package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the ASTUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Astudent.findAll", query="SELECT a FROM Astudent a")
public class Astudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASTUDENT_BRI_GENERATOR", sequenceName="ASTUDENT_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASTUDENT_BRI_GENERATOR")
	private long bri;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Apolozio
	@OneToMany(mappedBy="student")
	private List<Apolozio> polozeniIspiti;

	//bi-directional many-to-many association to Apredmet
	@ManyToMany
	@JoinTable(
		name="ASLUSA"
		, joinColumns={
			@JoinColumn(name="STUDENT_BRI")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PREDMET_SPR")
			}
		)
	private List<Apredmet> predmeti;

	//bi-directional many-to-one association to Amesto
	@ManyToOne
	private Amesto mesto;

	public Astudent() {
		this.polozeniIspiti = new ArrayList<Apolozio>();
		this.predmeti = new ArrayList<Apredmet>();
	}

	public long getBri() {
		return this.bri;
	}

	public void setBri(long bri) {
		this.bri = bri;
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

	public List<Apolozio> getPolozeniIspiti() {
		return this.polozeniIspiti;
	}

	public void setPolozeniIspiti(List<Apolozio> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}

	public Apolozio addPolozeniIspiti(Apolozio polozeniIspiti) {
		getPolozeniIspiti().add(polozeniIspiti);
		polozeniIspiti.setStudent(this);

		return polozeniIspiti;
	}

	public Apolozio removePolozeniIspiti(Apolozio polozeniIspiti) {
		getPolozeniIspiti().remove(polozeniIspiti);
		polozeniIspiti.setStudent(null);

		return polozeniIspiti;
	}

	public List<Apredmet> getPredmeti() {
		return this.predmeti;
	}

	public void setPredmeti(List<Apredmet> predmeti) {
		this.predmeti = predmeti;
	}

	public Amesto getMesto() {
		return this.mesto;
	}

	public void setMesto(Amesto mesto) {
		this.mesto = mesto;
	}

	@Override
	public String toString() {
		return "Astudent [bri=" + bri + ", ime=" + ime + ", prezime=" + prezime + "]";
	}
	
	

}