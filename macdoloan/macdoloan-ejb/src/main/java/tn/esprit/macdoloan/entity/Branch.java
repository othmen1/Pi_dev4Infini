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
	@OneToMany(cascade = CascadeType.ALL, mappedBy="branch")
	private Set<User> branchUsers;
	
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Lat")
	private long lat;
	@Column(name = "Lng")
	private long lng;
	@Column(name = "Adress")
	private String adress;
	@Column(name = "Name")
	private String name;
	/*@Column(name="Governorate")
	private Governorate governorate;*/
	private static final long serialVersionUID = 1L;
	
	

	public Branch() {
		
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public long getLat() {
		return this.lat;
	}

	public void setLat(long lat) {
		this.lat = lat;
	}   
	public long getLng() {
		return this.lng;
	}

	public void setLng(long lng) {
		this.lng = lng;
	}   
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
