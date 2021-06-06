package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the knjiga database table.
 * 
 */
@Entity
@NamedQuery(name="Knjiga.findAll", query="SELECT k FROM Knjiga k")
public class Knjiga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int knjigaId;

	private String knjigaNaziv;

	//bi-directional many-to-one association to Autor
	@ManyToOne
	@JoinColumn(name="autorId")
	private Autor autor;

	//bi-directional many-to-many association to Oblast
	@ManyToMany(mappedBy="knjige")
	private List<Oblast> oblasti;

	public Knjiga() {
	}

	public int getKnjigaId() {
		return this.knjigaId;
	}

	public void setKnjigaId(int knjigaId) {
		this.knjigaId = knjigaId;
	}

	public String getKnjigaNaziv() {
		return this.knjigaNaziv;
	}

	public void setKnjigaNaziv(String knjigaNaziv) {
		this.knjigaNaziv = knjigaNaziv;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Oblast> getOblasti() {
		return this.oblasti;
	}

	public void setOblasti(List<Oblast> oblasti) {
		this.oblasti = oblasti;
	}

	@Override
	public String toString() {
		return knjigaId + " " + knjigaNaziv + ", " + autor;
	}
	

}