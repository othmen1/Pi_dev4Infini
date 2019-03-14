package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity
@Table(name = "Claim")
public class Claim implements Serializable {

	@ManyToOne
	Client client;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Object")
	private String Object;
	@Column(name = "Description")
	private String Description;
	private static final long serialVersionUID = 1L;

	public Claim() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getObject() {
		return this.Object;
	}

	public void setObject(String Object) {
		this.Object = Object;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
   
}
