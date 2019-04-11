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
	

}
