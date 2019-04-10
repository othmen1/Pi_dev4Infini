package tn.esprit.macdoloan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.Installment;
import tn.esprit.macdoloan.entity.Loan;
import tn.esprit.macdoloan.entity.State;
import tn.esprit.macdoloan.service.interf.ILoanServiceLocal;
import tn.esprit.macdoloan.service.interf.ILoanServiceRemote;

@Stateless
public class LoanServiceImpl implements ILoanServiceLocal, ILoanServiceRemote {
	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;

	@Override
	public void AcceptCredit(Loan loanNewValues) {

		System.out.println(loanNewValues.getId());

		Loan loan = em.find(Loan.class, loanNewValues.getId());
		loan.setState((State.PRECESSING));
		System.out.println("Out of acceptloan : ");

	}

	@Override
	public void refuseCredit(Loan loanNewValues) {
		System.out.println("In RefuseLoan : ");
		Loan loan = em.find(Loan.class, loanNewValues.getId());
		loan.setState(State.REFUSE);
		System.out.println("Out of Refuseloan : ");
	}

	@Override
	public Loan findLoanById(int id) {
		System.out.println("In findUserById : ");
		Loan Loane = em.find(Loan.class, id);
		System.out.println("Out of findUserById : ");
		return Loane;
	}

	@Override
	public List<Loan> findAllLoan() {
		List<Loan> l = em.createQuery("Select e from Loan e where e.state='INPRGRESS'", Loan.class).getResultList();
		return l;

	}

	@Override
	public List<Loan> LoanInProcess() {
		List<Loan> l1 = em.createQuery("Select e from Loan e where e.state='PRECESSING'", Loan.class).getResultList();
		return l1;

	}

	@SuppressWarnings("deprecation")
	@Override
	public float getprix(Date s, Date g, float amo, float taux, int k) {

		float x;
		float e;
		int nbmois;
		nbmois = ((g.getYear() - s.getYear()) * 12) + (g.getMonth() - s.getMonth());
		e = 1 + (taux / k);
		e = (float) Math.pow(e, nbmois);
		x = (amo * e) / ((e - 1) * 100);
		return x;

	}
	
	/*Account ac = new Account();
	ac = deposit.getAccount();
	ac.getId();
	deposit1(ac, deposit.getAmount());
	return deposit.getId();

}*/

	@Override
	public int addInstalement (Installment installment) {
		System.out.println("In addDeposit : ");
		em.persist(installment);
		System.out.println("Out of AddDeposit" + installment.getId());
		return installment.getId();
	}
	
	
	@Override
	public List<Installment> findAllinstallement() {
		List<Installment> l = em.createQuery("Select e from Installment e", Installment.class).getResultList();
		return l;

	}
	@Override
	public List<Installment> findAllinstallementByloanId(int id)
	{
		
		List<Installment> il = new ArrayList<>();
		Loan l = em.find(Loan.class, id);
		List<Installment> installments = em.createQuery("Select e from Installment e", Installment.class).getResultList();
		for(Installment i :installments)
		{
		if(i.getLoan().equals(l))
			il.add(i);
		}
		
		return il;
	}
}