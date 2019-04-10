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
	@Column(name = "Domain")
	DomainType domain;
	@Column(name = "salary_client")
	float salaryClient ;
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
		return domain;
	}
	public void setDomain(DomainType domain) {
		this.domain = domain;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public float getSalaryClient() {
		return salaryClient;
	}
	public void setSalaryClient(float salaryClient) {
		this.salaryClient = salaryClient;
	}
	
	

}
