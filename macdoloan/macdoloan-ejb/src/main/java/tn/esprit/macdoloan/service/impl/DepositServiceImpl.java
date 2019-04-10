package tn.esprit.macdoloan.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.Deposit;
import tn.esprit.macdoloan.entity.Withdrawal;
import tn.esprit.macdoloan.service.interf.IdepositServiceLocal;
import tn.esprit.macdoloan.service.interf.IdepositServiceRemote;

@Stateless
public class DepositServiceImpl implements IdepositServiceLocal, IdepositServiceRemote {
	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;
	Connection connexion;

	@Override
	public int addDeposit(Deposit deposit) {
		System.out.println("In addDeposit : ");
		em.persist(deposit);
		System.out.println("Out of AddDeposit" + deposit.getId());
		Account ac = new Account();
		ac = deposit.getAccount();
		ac.getId();
		deposit1(ac, deposit.getAmount());
		return deposit.getId();
	}

	@Override
	public int addwithdraw(Withdrawal withdrawel) {
		System.out.println("In AddWithDrawel : ");
		em.persist(withdrawel);
		System.out.println("Out of addAccount" + withdrawel.getId());
		Account ac = new Account();
		ac = withdrawel.getAccount();
		ac.getId();
		withdraw1(ac, withdrawel.getAmount());
		return withdrawel.getId();
	}

	// ************fonction ajouter deposit et ajouter withdrawel

	public void deposit1(Account c, float amount) {
		Account account = em.find(Account.class, c.getId());
		account.setBalance(account.getBalance() + amount);
	}

	public void withdraw1(Account c, float amount) {
		Account account = em.find(Account.class, c.getId());
		if (account.getBalance() < amount)
			throw new RuntimeException("The balance in the account is insufficient  ");
		account.setBalance(account.getBalance() - amount);
	}

	@Override
	public Deposit findDepositById(int id) {
		Deposit depo = em.find(Deposit.class, id);
		return depo;

	}

	@Override
	public List<Deposit> findDepositsByAccount(Account acc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deposit> findAllDeposits() {
		List<Deposit> l = em.createQuery("Select e from Deposit e", Deposit.class).getResultList();
		return l;
	}

	@Override
	public List<String> getCinClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AffectDepositToAccount(Account c, Deposit d) {
		Account account = em.find(Account.class, c.getId());
		Deposit deposit = em.find(Deposit.class, d.getId());
		System.out.println("hhhhh");
		// System.out.println("out of AffectDepositToAccount: Account: "+
		// IdAccount+" Deposit: "+IdDeposit);
		account.setBalance(account.getBalance() + deposit.getAmount());

	}

	@Override

	public int RecupererID(float amout) {

		Query query = (Query) em.createQuery("select c from Deposit c WHERE c.amount=:amout", Deposit.class);
		((javax.persistence.Query) query).setParameter("amount", amout);
		System.out.println("Out of findAccountsByUserId : ");
		return (int) ((javax.persistence.Query) query).getSingleResult();

	}

	@Override
	public void deposit(Account c, float amount) {
		Account account = em.find(Account.class, c.getId());
		account.setBalance(account.getBalance() + amount);
	}

	public void withdraw(Account c, float amount) {
		Account account = em.find(Account.class, c.getId());
		if (account.getBalance() < amount)
			throw new RuntimeException("The balance in the account is insufficient  ");
		account.setBalance(account.getBalance() - amount);
	}

	@Override
	public Account RecupererIDAccount(String RIB) {
		/*
		 * List<Account> client =
		 * em.createQuery("select c from Account c WHERE c.rIB=:RIB",Account.
		 * class).getResultList();
		 * System.out.println("Out of findAccountsByUserId : "); return
		 * (Account) client;
		 */
		javax.persistence.Query query = em.createQuery("select e from Account e where e.RIB=:RIB", Account.class);
		query.setParameter("RIB", RIB);

		@SuppressWarnings("unchecked")
		List<Account> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	// ***********************

	// ***************

	@Override
	public Account getAccountById(int balance) {
		/*
		 * Deposit c = em.find(Deposit.class, balance); return c.getId();
		 */
		javax.persistence.Query query = em.createQuery("select e from Account e where e.Balance=:balance",
				Account.class);
		query.setParameter("balance", balance);

		@SuppressWarnings("unchecked")
		List<Account> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

}
