package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Agent extends User implements Serializable {
	@OneToMany(cascade = CascadeType.ALL, mappedBy="agent")
	private Set<Appointment> agentAppointments;
	

	private static final long serialVersionUID = 1L;
	@Column(name = "Post")
    private String post;
	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}

}
