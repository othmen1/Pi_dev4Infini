package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Appointment
 *
 */
@Entity
@Table(name = "Appointment")
public class Appointment implements Serializable {
	@ManyToOne
	private Agent agent;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Branch branch;
	private static final long serialVersionUID = 1L;

	   
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name= "object")
	private String object;
	@Column(name= "description" )
	private String description;
	@Column(name="appointment_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Enumerated(EnumType.STRING)
	@Column(name="governorate")
	private Governorate governorate;
	@Column(name= "city" )
	private String city;
	@Column(name= "place" )
	private String place;
	@Column(name="status")
	private boolean status;

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Governorate getGovernorate() {
		return governorate;
	}
	public void setGovernorate(Governorate governorate) {
		this.governorate = governorate;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	
   
}
