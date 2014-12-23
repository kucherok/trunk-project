package by.kucher.project.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the portaladdr database table.
 * 
 */
@Entity
@Table(name = "portaladdr")
// @NamedQuery(name = "Portaladdr.findAll", query = "SELECT p FROM Portaladdr p")
public class Portaladdr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true, nullable = false, length = 35)
	private String portalgid;

	@Column(nullable = false, length = 255)
	private String portaladdr;

	@Column(nullable = false, length = 255)
	private String portaltitle;

	public Portaladdr() {
	}

	public String getPortalgid() {
		return this.portalgid;
	}

	public void setPortalgid(String portalgid) {
		this.portalgid = portalgid;
	}

	public String getPortaladdr() {
		return this.portaladdr;
	}

	public void setPortaladdr(String portaladdr) {
		this.portaladdr = portaladdr;
	}

	public String getPortaltitle() {
		return this.portaltitle;
	}

	public void setPortaltitle(String portaltitle) {
		this.portaltitle = portaltitle;
	}

}