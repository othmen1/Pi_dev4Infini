package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Admin extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Salary")
    private int salary;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy="admin")
	private Set<Answer> adminAnswers;
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Set<Answer> getAdminAnswers() {
		return adminAnswers;
	}
	public void setAdminAnswers(Set<Answer> adminAnswers) {
		this.adminAnswers = adminAnswers;
	}
	
	
}
