package tn.esprit.macdoloan.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Salary")
    private int salary;
}
