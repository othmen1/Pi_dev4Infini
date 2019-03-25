package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Client extends User implements Serializable {
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Loan> clientLoans;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Appointment> clientAppointments;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Claim> clientClaims;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Account> clientAccounts;
	private static final long serialVersionUID = 1L;
	
	@Column(name="Salary")
	private float Salary;
	@Column(name="Job")
	private String Job;
	@Column(name="Number of Children")
	private int nbrchild;
	@Column(name="Social Status")
	private String status;
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public int getNbrchild() {
		return nbrchild;
	}
	public void setNbrchild(int nbrchild) {
		this.nbrchild = nbrchild;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
