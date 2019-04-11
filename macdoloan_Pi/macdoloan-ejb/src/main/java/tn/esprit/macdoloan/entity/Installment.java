package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Installment
 *
 */
@Entity
@Table(name = "Installment")
public class Installment implements Serializable {
	@ManyToOne
	Loan loan ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="installment")
	private Set<Penalty> installmentPenalties;
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	public Installment() {
		super();
	}
   
}
