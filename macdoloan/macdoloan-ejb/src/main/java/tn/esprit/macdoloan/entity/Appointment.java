package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Appointment
 *
 */
@Entity
@Table(name = "Appointment")
public class Appointment implements Serializable {
	@ManyToOne
	Agent agent;
	@ManyToOne
	Client client;
	   
	@Id
	private int id;
	private String object;
	private static final long serialVersionUID = 1L;

	public Appointment() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}
   
}
