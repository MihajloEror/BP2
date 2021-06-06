package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the STAVKA database table.
 * 
 */
@Embeddable
public class StavkaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="STAVKA_ID")
	private long stavkaId;

	@Column(name="RACUN_RACUN_ID", insertable=false, updatable=false)
	private long racunRacunId;

	public StavkaPK() {
	}
	public long getStavkaId() {
		return this.stavkaId;
	}
	public void setStavkaId(long stavkaId) {
		this.stavkaId = stavkaId;
	}
	public long getRacunRacunId() {
		return this.racunRacunId;
	}
	public void setRacunRacunId(long racunRacunId) {
		this.racunRacunId = racunRacunId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StavkaPK)) {
			return false;
		}
		StavkaPK castOther = (StavkaPK)other;
		return 
			(this.stavkaId == castOther.stavkaId)
			&& (this.racunRacunId == castOther.racunRacunId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.stavkaId ^ (this.stavkaId >>> 32)));
		hash = hash * prime + ((int) (this.racunRacunId ^ (this.racunRacunId >>> 32)));
		
		return hash;
	}
}