package by.kucher.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The persistent class for the portals database table.
 * 
 */
@Entity
@Table(name = "portals")
// @NamedQuery(name = "Portal.findAll", query = "SELECT p FROM Portal p")
public class Portal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true, nullable = false, length = 35)
	private String portalgid;

	@Column(length = 34)
	private String capplid;

	@Column(nullable = false)
	private int captime;

	@Column(nullable = false)
	private int lastupd;

	private float lat;

	private float lon;

	@Column(length = 5)
	private String team;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Portaladdr portaladdr;

	public Portal() {
	}

	public String getPortalgid() {
		return this.portalgid;
	}

	public void setPortalgid(String portalgid) {
		this.portalgid = portalgid;
	}

	public String getCapplid() {
		return this.capplid;
	}

	public void setCapplid(String capplid) {
		this.capplid = capplid;
	}

	public int getCaptime() {
		return this.captime;
	}

	public void setCaptime(int captime) {
		this.captime = captime;
	}

	public int getLastupd() {
		return this.lastupd;
	}

	public void setLastupd(int lastupd) {
		this.lastupd = lastupd;
	}

	public float getLat() {
		return this.lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return this.lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Portaladdr getPortaladdr() {
		return portaladdr;
	}

	public void setPortaladdr(Portaladdr portaladdr) {
		this.portaladdr = portaladdr;
	}

}