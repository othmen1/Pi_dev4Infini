package tn.esprit.macdoloan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.ejb.Timer;

import javax.ejb.Schedule;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.macdoloan.entity.Installment;
import tn.esprit.macdoloan.entity.Loan;
import tn.esprit.macdoloan.entity.Penalty;
import tn.esprit.macdoloan.entity.State;
import tn.esprit.macdoloan.service.interf.ILoanServiceLocal;
import tn.esprit.macdoloan.service.interf.ILoanServiceRemote;

@Stateless
@LocalBean
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

	@Override
	public List<Loan> findUserLoan(int userid) {
		List<Loan> l1 = em
				.createQuery("Select e from Loan e where e.state='PRECESSING' and e.client.id = ?1", Loan.class)
				.setParameter(1, userid).getResultList();
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

	/*
	 * Account ac = new Account(); ac = deposit.getAccount(); ac.getId();
	 * deposit1(ac, deposit.getAmount()); return deposit.getId();
	 * 
	 * }
	 */

	@Override
	public int addInstalement(Installment installment) {

		em.persist(installment);
		System.out.println("Out of AddDeposit" + installment.getId());
		installment.setVerif(false);
		return installment.getId();
	}

	@Override
	public List<Installment> findAllinstallement() {
		List<Installment> l = em.createQuery("Select e from Installment e", Installment.class).getResultList();
		return l;

	}

	@Override
	public List<Installment> findAllinstallementByloanId(int id) {

		List<Installment> il = new ArrayList<>();
		Loan l = em.find(Loan.class, id);
		List<Installment> installments = em.createQuery("Select e from Installment e", Installment.class)
				.getResultList();
		for (Installment i : installments) {
			if (i.getLoan().equals(l))
				il.add(i);
		}

		return il;
	}

	@Override
	public List<Installment> findAllinstallementInProcessByloanId(int id) {
		List<Installment> il = new ArrayList<>();
		Loan l = em.find(Loan.class, id);
		List<Installment> installments = em
				.createQuery("Select e from Installment e where e.verif='false'", Installment.class).getResultList();
		for (Installment i : installments) {
			if (i.getLoan().equals(l))
				il.add(i);
		}

		return il;
	}

	@Override
	public void Payerinstalment(Installment ins) {
		System.out.println(ins.getId());

		Installment i = em.find(Installment.class, ins.getId());
		i.setVerif(true);

	}

	@Override
	public void addLoan(Loan loan) {
		System.out.println("In addLoan : ");
		// Loan l = em.find(Loan.class, loan.getId());
		// l.setState((State.PRECESSING));
		loan.setState(State.INPRGRESS);
		System.out.println(loan.getState());
		em.persist(loan);

	}

	/* thread */

	public String getDate() {
		String DATE_FORMAT = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		// Get current date
		Date currentDate = new Date();
		LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		// plus one
		localDateTime = localDateTime.plusDays(1);

		// convert LocalDateTime to date
		Date currentDatePlus = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		return dateFormat.format(currentDatePlus);

	}

	public String convertDate(Date date) {
		String DATE_FORMAT = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		return dateFormat.format(date);
	}

	@Schedule(second = "00", minute = "39", hour = "02")
	public void AlertEndInstallment(Timer timer) {
		System.out.println(getDate());
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		TypedQuery<Installment> query = em.createQuery("SELECT  m FROM Installment m  ", Installment.class);

		try {
			List<Installment> Installments = query.getResultList();

			Installments.forEach(e -> {
				if (getDate().equals(convertDate(e.getRefunddatenddate())))
					System.out.println("msg envoyé");
			});
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("liste vide");
		}

	}

	@Override
	public int addPenality(Penalty penality) {
		em.persist(penality);
		System.out.println("Out of Addpenality" + penality.getId());
		return penality.getId();
	}

	@Override
	public float getamount(Date s, float amo) {
		float taux = 0.24f;
		int k =365;
		int nbjourretard;
		float x;
		float e;
		Date h = new Date();
		long startTime = s.getTime();
		long endTime = h.getTime();
		long diffTime = Math.abs(endTime - startTime);
		long diffDays = diffTime / (1000 * 60 * 60 * 24);
		System.out.println(s.toString());
		System.out.println(h.toString());
		System.out.println(diffDays);
		e = (taux / k);
		x = diffDays * e * amo;
		return x;
	}

	@Override
	public List<Penalty> findAllPenalityByInstallmentId(int id) {
		List<Penalty> il = new ArrayList<>();
		Installment l = em.find(Installment.class, id);
		List<Penalty> penality = em.createQuery("Select p from Penalty p", Penalty.class).getResultList();
		for (Penalty i : penality) {
			if (i.getInstallment().equals(l))
				il.add(i);
		}

		return il;
	}
	
	public List<Penalty> findAllPenalities(int id) {
		List<Penalty> penality = em.createQuery("Select p from Penalty p", Penalty.class).getResultList();
		return penality;
	}
		

}