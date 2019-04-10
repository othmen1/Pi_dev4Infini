package tn.esprit.macdoloan.service.interf;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.*;

@Remote
public interface ILoanServiceRemote {

	public void AcceptCredit(Loan loan);

	public void refuseCredit(Loan loan);

	public Loan findLoanById(int id);

	public List<Loan> findAllLoan();

	public List<Loan> LoanInProcess();

	public float getprix(Date s, Date g, float amo, float taux, int k);

	public int addInstalement(Installment installment);
	
	public List<Installment> findAllinstallement();

	public List<Installment> findAllinstallementByloanId(int id);

}