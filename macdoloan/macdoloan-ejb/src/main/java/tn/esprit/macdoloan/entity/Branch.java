package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Branch
 *
 */
@Entity
@Table(name = "Branch")
public class Branch implements Serializable {
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy="branch")
	private Set<User> branchUsers;
	
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Street")
	private String street;
	@Column(name = "PostalCode")
	private String postalCode;
	@Column(name = "City")
	private String city;
	@Column(name = "Name")
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(name="Governorate")
	private Governorate governorate;
	
	private static final long serialVersionUID = 1L;
	
	

	public Branch() {
		
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set<User> getBranchUsers() {
		return branchUsers;
	}
	public void setBranchUsers(Set<User> branchUsers) {
		this.branchUsers = branchUsers;
	}
	public Governorate getGovernorate() {
		return governorate;
	}
	public void setGovernorate(Governorate governorate) {
		this.governorate = governorate;
	}
	
	
}
