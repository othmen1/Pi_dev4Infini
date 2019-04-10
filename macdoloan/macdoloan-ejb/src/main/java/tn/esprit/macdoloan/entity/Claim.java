package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity
@Table(name = "Claim")
public class Claim implements Serializable {

	@ManyToOne
	private Client client;
	@OneToOne
	private Answer answer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Object")
	private String Object;
	@Column(name = "Description")
	private String Description;
	@Column(name = "DateSend")
	private Date dateSend;
	@Column(name = "State")
	private String state;
	private static final long serialVersionUID = 1L;
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDateSend() {
		return dateSend;
	}
	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}



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
