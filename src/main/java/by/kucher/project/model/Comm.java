package by.kucher.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comm database table.
 * 
 */
@Entity
@Table(name="comm")
@NamedQuery(name="Comm.findAll", query="SELECT c FROM Comm c")
public class Comm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, length=35)
	private String msgid;

	private float lat;

	private float lon;

	@Column(nullable=false)
	private int msgts;

	@Column(nullable=false, length=34)
	private String playerguid;

	@Column(length=16)
	private String plextType;

	@Column(length=5)
	private String team;

	@Column(length=1024)
	private String text;

	public Comm() {
	}

	public String getMsgid() {
		return this.msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
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

	public int getMsgts() {
		return this.msgts;
	}

	public void setMsgts(int msgts) {
		this.msgts = msgts;
	}

	public String getPlayerguid() {
		return this.playerguid;
	}

	public void setPlayerguid(String playerguid) {
		this.playerguid = playerguid;
	}

	public String getPlextType() {
		return this.plextType;
	}

	public void setPlextType(String plextType) {
		this.plextType = plextType;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}