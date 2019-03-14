package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Loan")
public class Loan implements Serializable {
	@ManyToOne
	Client client ;
	@ManyToOne
	Product product ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="loan")
	private Set<Installment> accountInstallments;

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	

}
