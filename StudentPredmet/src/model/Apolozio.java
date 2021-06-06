package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the APOLOZIO database table.
 * 
 */
@Entity
@NamedQuery(name="Apolozio.findAll", query="SELECT a FROM Apolozio a")
public class Apolozio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ApolozioPK id;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private int ocena;

	//bi-directional many-to-one association to Apredmet
	@ManyToOne
	@MapsId("predmetSpr")
	private Apredmet predmet;

	//bi-directional many-to-one association to Astudent
	@ManyToOne
	@MapsId("studentBri")
	private Astudent student;

	public Apolozio() {
	}

	public ApolozioPK getId() {
		return this.id;
	}

	public void setId(ApolozioPK id) {
		this.id = id;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Apredmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Apredmet predmet) {
		this.predmet = predmet;
	}

	public Astudent getStudent() {
		return this.student;
	}

	public void setStudent(Astudent student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Apolozio [datum=" + datum + ", ocena=" + ocena + ", predmet=" + predmet + ", student=" + student + "]";
	}
	
	

}