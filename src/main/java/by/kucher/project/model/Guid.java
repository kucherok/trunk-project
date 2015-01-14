package by.kucher.project.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the guids database table.
 * 
 */
@Entity
@Table(name = "guids")
// @NamedQuery(name="Guid.findAll", query="SELECT g FROM Guid g")
public class Guid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique = true, nullable = false, length = 34)
	private String guid;

	@Column(length = 50)
	private String nickname;

	public Guid() {
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}