package tn.esprit.macdoloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.Client;
import tn.esprit.macdoloan.service.interf.IAccountServiceLocal;
import tn.esprit.macdoloan.service.interf.IAccountServiceRemote;


@Stateless
public class AccountServiceImpl implements IAccountServiceLocal, IAccountServiceRemote {

	@PersistenceContext(unitName="macdoloan-ejb")
	EntityManager em;
	@Override
	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		System.out.println("In addAccount : ");
		em.persist(account);
		System.out.println("Out of addAccount" + account.getId());
		return account.getId();
	}

	@Override
	public void removeAccount(int accountId) {
		// TODO Auto-generated method stub
		em.remove(em.find(Account.class, accountId));
		
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		Account newAccount =em.find(Account.class, account.getId());
		newAccount.setBalance(account.getBalance());
		newAccount.setOpeningDate(account.getOpeningDate());
		newAccount.setRIB(account.getRIB());
		newAccount.setType(account.getType());
	}

	@Override
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		System.out.println("In findAccountById : ");
		Account account = em.find(Account.class, id);
		System.out.println("Out of findAccountById : ");
		return account;
	}

	@Override
	public List<Account> findAllAccounts() {
		System.out.println("In findAllUsers : ");
		List<Account> accounts = em.createQuery("from Account", Account.class).getResultList();
		System.out.println("Out of findAllAccounts : ");
		return accounts;
	}

	@Override
	public List<Account> findAccountsByUserId(int id) {
		List<Account> accounts = em.createQuery("select a from Account e WHERE e.client=:id", Account.class).getResultList();
		System.out.println("Out of findAccountsByUserId : ");
		return accounts;

	}

	@Override
	public void AffectAccountToClient(int IdAccount, int IdClient) {
		// TODO Auto-generated method stub
		Client ClientManagedEntity = em.find(Client.class, IdClient);
		Account AccountManagedEntity = em.find(Account.class, IdAccount);
		AccountManagedEntity.setClient(ClientManagedEntity);
		
	}

	@Override
	public List<String> getCinClients() {
		List<Client> clients = em.createQuery("select c from Client c", Client.class).getResultList();
		List<String> cin = new ArrayList<>();
		for (Client client: clients){
			cin.add(client.getCin());
		}
		System.out.println("Out of getCinClients : ");
		return cin;
	}

	@Override
	public List<Client> getAllClients() {
		System.out.println("In getAllClients : ");
		List<Client> client = em.createQuery("from Client", Client.class).getResultList();
		System.out.println("Out of getAllClients : ");
		return client;
	}
	


}
