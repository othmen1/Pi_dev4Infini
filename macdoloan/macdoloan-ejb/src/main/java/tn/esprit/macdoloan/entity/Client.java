package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Client extends User implements Serializable{
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
	@Column(name="ChildrenNumber")
	private int nbrchild;
	@Column(name="SocialStatus")
	private String status;
	@Column(name="domain")
	private DomainType Domain;
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
	public Set<Loan> getClientLoans() {
		return clientLoans;
	}
	public void setClientLoans(Set<Loan> clientLoans) {
		this.clientLoans = clientLoans;
	}
	public Set<Appointment> getClientAppointments() {
		return clientAppointments;
	}
	public void setClientAppointments(Set<Appointment> clientAppointments) {
		this.clientAppointments = clientAppointments;
	}
	public Set<Claim> getClientClaims() {
		return clientClaims;
	}
	public void setClientClaims(Set<Claim> clientClaims) {
		this.clientClaims = clientClaims;
	}
	public Set<Account> getClientAccounts() {
		return clientAccounts;
	}
	public void setClientAccounts(Set<Account> clientAccounts) {
		this.clientAccounts = clientAccounts;
	}
	public DomainType getDomain() {
		return Domain;
	}
	public void setDomain(DomainType domain) {
		Domain = domain;
	}
	

}
