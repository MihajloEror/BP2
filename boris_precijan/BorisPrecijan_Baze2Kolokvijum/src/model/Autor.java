package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int autorId;

	private String autorIme;

	private String autorPrezime;

	//bi-directional many-to-one association to Knjiga
	@OneToMany(mappedBy="autor", fetch = FetchType.EAGER)
	private List<Knjiga> knjige;

	public Autor() {
	}

	public int getAutorId() {
		return this.autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	public String getAutorIme() {
		return this.autorIme;
	}

	public void setAutorIme(String autorIme) {
		this.autorIme = autorIme;
	}

	public String getAutorPrezime() {
		return this.autorPrezime;
	}

	public void setAutorPrezime(String autorPrezime) {
		this.autorPrezime = autorPrezime;
	}

	public List<Knjiga> getKnjige() {
		return this.knjige;
	}

	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}

	public Knjiga addKnjige(Knjiga knjige) {
		getKnjige().add(knjige);
		knjige.setAutor(this);

		return knjige;
	}

	public Knjiga removeKnjige(Knjiga knjige) {
		getKnjige().remove(knjige);
		knjige.setAutor(null);

		return knjige;
	}

	@Override
	public String toString() {
		return autorId + " " + autorIme + " " + autorPrezime;
	}

}