package by.kucher.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the portallifetime database table.
 * 
 */
@Entity
@Table(name="portallifetime")
@NamedQuery(name="Portallifetime.findAll", query="SELECT p FROM Portallifetime p")
public class Portallifetime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int captime;

	private int losttime;

	@Column(nullable=false, length=35)
	private String portalgid;

	@Column(length=5)
	private String team;

	public Portallifetime() {
	}

	public int getCaptime() {
		return this.captime;
	}

	public void setCaptime(int captime) {
		this.captime = captime;
	}

	public int getLosttime() {
		return this.losttime;
	}

	public void setLosttime(int losttime) {
		this.losttime = losttime;
	}

	public String getPortalgid() {
		return this.portalgid;
	}

	public void setPortalgid(String portalgid) {
		this.portalgid = portalgid;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}