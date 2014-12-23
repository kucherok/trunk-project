package by.kucher.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hiddenups database table.
 * 
 */
@Entity
@Table(name="hiddenups")
@NamedQuery(name="Hiddenup.findAll", query="SELECT h FROM Hiddenup h")
public class Hiddenup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, length=36)
	private String resonatorid;

	@Column(nullable=false)
	private int msgts;

	@Column(nullable=false, length=34)
	private String playerguid;

	@Column(nullable=false, length=35)
	private String portalgid;

	@Column(nullable=false)
	private byte resonatorlevel;

	public Hiddenup() {
	}

	public String getResonatorid() {
		return this.resonatorid;
	}

	public void setResonatorid(String resonatorid) {
		this.resonatorid = resonatorid;
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

	public String getPortalgid() {
		return this.portalgid;
	}

	public void setPortalgid(String portalgid) {
		this.portalgid = portalgid;
	}

	public byte getResonatorlevel() {
		return this.resonatorlevel;
	}

	public void setResonatorlevel(byte resonatorlevel) {
		this.resonatorlevel = resonatorlevel;
	}

}