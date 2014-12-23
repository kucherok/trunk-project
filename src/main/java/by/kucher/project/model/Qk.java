package by.kucher.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qk database table.
 * 
 */
@Entity
@Table(name="qk")
@NamedQuery(name="Qk.findAll", query="SELECT q FROM Qk q")
public class Qk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, length=16)
	private String qk;

	private int maxLatE6;

	private int maxLngE6;

	private int minLatE6;

	private int minLngE6;

	public Qk() {
	}

	public String getQk() {
		return this.qk;
	}

	public void setQk(String qk) {
		this.qk = qk;
	}

	public int getMaxLatE6() {
		return this.maxLatE6;
	}

	public void setMaxLatE6(int maxLatE6) {
		this.maxLatE6 = maxLatE6;
	}

	public int getMaxLngE6() {
		return this.maxLngE6;
	}

	public void setMaxLngE6(int maxLngE6) {
		this.maxLngE6 = maxLngE6;
	}

	public int getMinLatE6() {
		return this.minLatE6;
	}

	public void setMinLatE6(int minLatE6) {
		this.minLatE6 = minLatE6;
	}

	public int getMinLngE6() {
		return this.minLngE6;
	}

	public void setMinLngE6(int minLngE6) {
		this.minLngE6 = minLngE6;
	}

}