package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<Loan> productLoans;

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	@Column(name = "Name")
	String name;
	@Column(name = "AmountMax")
	int amountMax;
	@Column(name = "AmountMin")
	int amountMin;
	@Column(name = "InterestRate")
	float interestRate;
	@Column(name = "Fees")
	float fees;
	@Column(name = "DurationMax")
	int durationMax;
	@Column(name = "DurationMin")
	int durationMin;
	@Column(name = "Description")
	String description;
	public Set<Loan> getProductLoans() {
		return productLoans;
	}
	public void setProductLoans(Set<Loan> productLoans) {
		this.productLoans = productLoans;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmountMax() {
		return amountMax;
	}
	public void setAmountMax(int amountMax) {
		this.amountMax = amountMax;
	}
	public int getAmountMin() {
		return amountMin;
	}
	public void setAmountMin(int amountMin) {
		this.amountMin = amountMin;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public int getDurationMax() {
		return durationMax;
	}
	public void setDurationMax(int durationMax) {
		this.durationMax = durationMax;
	}
	public int getDurationMin() {
		return durationMin;
	}
	public void setDurationMin(int durationMin) {
		this.durationMin = durationMin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
