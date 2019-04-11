package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Withdrawal
 *
 */
@Entity
@Table(name = "Withdrawal")
public class Withdrawal implements Serializable {
	@ManyToOne
	Account account ;
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	public Withdrawal() {
		super();
	}
   
}
