package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STAVKA database table.
 * 
 */
@Entity
@NamedQuery(name="Stavka.findAll", query="SELECT s FROM Stavka s")
public class Stavka implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StavkaPK id;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	private Proizvod proizvod;

	//bi-directional many-to-one association to Racun
	@ManyToOne
	@MapsId("racunRacunId")
	private Racun racun;
	
	private int kolicina;

	public Stavka() {
	}

	public StavkaPK getId() {
		return this.id;
	}

	public void setId(StavkaPK id) {
		this.id = id;
	}

	public Proizvod getProizvod() {
		return this.proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public Racun getRacun() {
		return this.racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	@Override
	public String toString() {
		return "Stavka [id=" + id + ", proizvod=" + proizvod + ", racun=" + racun + ", kolicina=" + kolicina + "]";
	}
	
	

}