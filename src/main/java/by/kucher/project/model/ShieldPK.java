package by.kucher.project.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the shields database table.
 * 
 */
@Embeddable
public class ShieldPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private byte slot;

	@Column(unique=true, nullable=false, length=35)
	private String portalgid;

	public ShieldPK() {
	}
	public byte getSlot() {
		return this.slot;
	}
	public void setSlot(byte slot) {
		this.slot = slot;
	}
	public String getPortalgid() {
		return this.portalgid;
	}
	public void setPortalgid(String portalgid) {
		this.portalgid = portalgid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ShieldPK)) {
			return false;
		}
		ShieldPK castOther = (ShieldPK)other;
		return 
			(this.slot == castOther.slot)
			&& this.portalgid.equals(castOther.portalgid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.slot);
		hash = hash * prime + this.portalgid.hashCode();
		
		return hash;
	}
}