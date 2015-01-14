package by.kucher.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the syscomm database table.
 * 
 */
@Entity
@Table(name = "syscomm")
// @NamedQuery(name = "Syscomm.findAll", query = "SELECT s FROM Syscomm s")
public class Syscomm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true, nullable = false, length = 34)
	private String msgid;

	@Column(length = 16)
	private String eventtype;

	@Column(nullable = false)
	private long msgts;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "playerguid")
	private Guid playerguid;

	// @Column(nullable=false, length=34)
	// private String playerguid;

	@Column(length = 16)
	private String plextType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "portalgid")
	private Portal portal;
	
	// @Column(nullable = false, length = 35)
	// private String portalgid;

	private int resonatorlevel;

	@Column(nullable = false, length = 5)
	private String team;

	@Lob
	@Column(nullable = false)
	private String text;

	public Syscomm() {
	}

	public String getMsgid() {
		return this.msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getEventtype() {
		return this.eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}

	public long getMsgts() {
		return this.msgts;
	}

	public void setMsgts(int msgts) {
		this.msgts = msgts;
	}

	// public String getPlayerguid() {
	// return this.playerguid;
	// }
	//
	// public void setPlayerguid(String playerguid) {
	// this.playerguid = playerguid;
	// }

	public Guid getPlayerguid() {
		return playerguid;
	}

	public void setPlayerguid(Guid playerguid) {
		this.playerguid = playerguid;
	}

	public String getPlextType() {
		return this.plextType;
	}

	public void setPlextType(String plextType) {
		this.plextType = plextType;
	}
	
	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}

	// public String getPortalgid() {
	// return this.portalgid;
	// }
	//
	// public void setPortalgid(String portalgid) {
	// this.portalgid = portalgid;
	// }

	public int getResonatorlevel() {
		return this.resonatorlevel;
	}

	public void setResonatorlevel(int resonatorlevel) {
		this.resonatorlevel = resonatorlevel;
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