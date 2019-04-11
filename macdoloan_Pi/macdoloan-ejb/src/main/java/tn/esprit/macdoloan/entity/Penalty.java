package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Penalty
 *
 */
@Entity
@Table(name = "Penalty")
public class Penalty implements Serializable {
	@ManyToOne
	Installment installment ;
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	public Penalty() {
		super();
	}
   
}
