package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the APOLOZIO database table.
 * 
 */
@Embeddable
public class ApolozioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="STUDENT_BRI", insertable=false, updatable=false)
	private long studentBri;

	@Column(name="PREDMET_SPR", insertable=false, updatable=false)
	private long predmetSpr;

	public ApolozioPK() {
	}
	public long getStudentBri() {
		return this.studentBri;
	}
	public void setStudentBri(long studentBri) {
		this.studentBri = studentBri;
	}
	public long getPredmetSpr() {
		return this.predmetSpr;
	}
	public void setPredmetSpr(long predmetSpr) {
		this.predmetSpr = predmetSpr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ApolozioPK)) {
			return false;
		}
		ApolozioPK castOther = (ApolozioPK)other;
		return 
			(this.studentBri == castOther.studentBri)
			&& (this.predmetSpr == castOther.predmetSpr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.studentBri ^ (this.studentBri >>> 32)));
		hash = hash * prime + ((int) (this.predmetSpr ^ (this.predmetSpr >>> 32)));
		
		return hash;
	}
}