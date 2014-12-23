package by.kucher.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cookies database table.
 * 
 */
@Entity
@Table(name="cookies")
@NamedQuery(name="Cooky.findAll", query="SELECT c FROM Cooky c")
public class Cooky implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, length=34)
	private String playerguid;

	private short active;

	@Lob
	private String cookie;

	@Column(length=32)
	private String csrftoken;

	@Column(nullable=false)
	private int lastaccesstime;

	@Column(length=5)
	private String team;

	@Column(length=1024)
	private String useragent;

	public Cooky() {
	}

	public String getPlayerguid() {
		return this.playerguid;
	}

	public void setPlayerguid(String playerguid) {
		this.playerguid = playerguid;
	}

	public short getActive() {
		return this.active;
	}

	public void setActive(short active) {
		this.active = active;
	}

	public String getCookie() {
		return this.cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getCsrftoken() {
		return this.csrftoken;
	}

	public void setCsrftoken(String csrftoken) {
		this.csrftoken = csrftoken;
	}

	public int getLastaccesstime() {
		return this.lastaccesstime;
	}

	public void setLastaccesstime(int lastaccesstime) {
		this.lastaccesstime = lastaccesstime;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getUseragent() {
		return this.useragent;
	}

	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}

}