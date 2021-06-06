package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oblast database table.
 * 
 */
@Entity
@NamedQuery(name="Oblast.findAll", query="SELECT o FROM Oblast o")
public class Oblast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oblastId;

	private String oblastNaziv;

	//bi-directional many-to-many association to Knjiga
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="pripada"
		, joinColumns={
			@JoinColumn(name="oblastId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="knjigaId")
			}
		)
	private List<Knjiga> knjige;

	public Oblast() {
	}

	public int getOblastId() {
		return this.oblastId;
	}

	public void setOblastId(int oblastId) {
		this.oblastId = oblastId;
	}

	public String getOblastNaziv() {
		return this.oblastNaziv;
	}

	public void setOblastNaziv(String oblastNaziv) {
		this.oblastNaziv = oblastNaziv;
	}

	public List<Knjiga> getKnjige() {
		return this.knjige;
	}

	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}

	@Override
	public String toString() {
		return oblastId + " " + oblastNaziv;
	}

}