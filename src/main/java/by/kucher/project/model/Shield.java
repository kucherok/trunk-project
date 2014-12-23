package by.kucher.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the shields database table.
 * 
 */
@Entity
@Table(name="shields")
@NamedQuery(name="Shield.findAll", query="SELECT s FROM Shield s")
public class Shield implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShieldPK id;

	private byte mitigation;

	@Column(length=34)
	private String ownguid;

	public Shield() {
	}

	public ShieldPK getId() {
		return this.id;
	}

	public void setId(ShieldPK id) {
		this.id = id;
	}

	public byte getMitigation() {
		return this.mitigation;
	}

	public void setMitigation(byte mitigation) {
		this.mitigation = mitigation;
	}

	public String getOwnguid() {
		return this.ownguid;
	}

	public void setOwnguid(String ownguid) {
		this.ownguid = ownguid;
	}

}