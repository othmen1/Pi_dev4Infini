package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Answer
 *
 */
@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	Admin admin;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Description")
	private String Description;
	public Answer() {
		super();
	}
   
}
