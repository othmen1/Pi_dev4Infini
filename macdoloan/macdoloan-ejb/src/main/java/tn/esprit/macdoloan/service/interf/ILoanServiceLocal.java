package tn.esprit.macdoloan.service.interf;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Timer;

import tn.esprit.macdoloan.entity.*;

@Local
public interface ILoanServiceLocal {
	public void AcceptCredit(Loan loan);

	public void refuseCredit(Loan loan);

	public Loan findLoanById(int id);

	public List<Loan> findAllLoan();

	public List<Loan> LoanInProcess();

	public float getprix(Date s, Date g, float amo, float taux, int k);

	public int addInstalement(Installment installment);

	public List<Installment> findAllinstallement();

	public List<Installment> findAllinstallementByloanId(int id);

	public List<Installment> findAllinstallementInProcessByloanId(int id);

	public void Payerinstalment(Installment ins);

	public void addLoan(Loan loan);

	public List<Loan> findUserLoan(int userid);

	public String getDate();

	public String convertDate(Date date);

	public void AlertEndInstallment(Timer timer);

	public int addPenality(Penalty penality);
	
	public float getamount(Date s,float amo);
	
	public List<Penalty> findAllPenalityByInstallmentId(int id);
	
	public List<Penalty> findAllPenalities(int id);



}
