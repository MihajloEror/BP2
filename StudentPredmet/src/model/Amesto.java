package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the AMESTO database table.
 * 
 */
@Entity
@NamedQuery(name="Amesto.findAll", query="SELECT a FROM Amesto a")
public class Amesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AMESTO_IDM_GENERATOR", sequenceName="AMESTO_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AMESTO_IDM_GENERATOR")
	private long idm;

	private String nazivmesta;

	//bi-directional many-to-one association to Astudent
	@OneToMany(mappedBy="mesto")
	private List<Astudent> studenti;

	public Amesto() {
		this.studenti = new ArrayList<Astudent>();
	}

	public long getIdm() {
		return this.idm;
	}

	public void setIdm(long idm) {
		this.idm = idm;
	}

	public String getNazivmesta() {
		return this.nazivmesta;
	}

	public void setNazivmesta(String nazivmesta) {
		this.nazivmesta = nazivmesta;
	}

	public List<Astudent> getStudenti() {
		return this.studenti;
	}

	public void setStudenti(List<Astudent> studenti) {
		this.studenti = studenti;
	}

	public Astudent addStudenti(Astudent studenti) {
		getStudenti().add(studenti);
		studenti.setMesto(this);

		return studenti;
	}

	public Astudent removeStudenti(Astudent studenti) {
		getStudenti().remove(studenti);
		studenti.setMesto(null);

		return studenti;
	}

}