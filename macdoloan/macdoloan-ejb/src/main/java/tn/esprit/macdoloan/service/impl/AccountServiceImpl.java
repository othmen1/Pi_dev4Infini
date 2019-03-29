package tn.esprit.macdoloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.Agent;
import tn.esprit.macdoloan.entity.Client;
import tn.esprit.macdoloan.entity.User;
import tn.esprit.macdoloan.service.interf.IAccountServiceLocal;
import tn.esprit.macdoloan.service.interf.IAccountServiceRemote;

@Stateless
public class AccountServiceImpl implements IAccountServiceLocal, IAccountServiceRemote {

	@PersistenceContext(unitName="macdoloan-ejb")
	EntityManager em;
	@Override
	public int addAccount(Account account) {
		System.out.println("In addAccount : ");
		account.setIsclosed(false);
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
		if (account== null){ return null; }
		else{
		Account oppenedAccount=new Account();
		if (account.isIsclosed()==false){ oppenedAccount=account;}
		System.out.println("Out of findAccountById : ");
		return oppenedAccount;}
	}

	@Override
	public List<Account> findAllAccounts() {
		System.out.println("In findAllUsers : ");
		List<Account> accounts = em.createQuery("from Account", Account.class).getResultList();
		List<Account> oppenedAccounts=new ArrayList<>();
		for (int i=0;i<accounts.size();i++){
			if (accounts.get(i).isIsclosed()==false){ oppenedAccounts.add(accounts.get(i));}
		}
		System.out.println("Out of findAllAccounts : ");
		return oppenedAccounts;
	}

	@Override
	public List<Account> findAccountsByClient(Client cl) {
		System.out.println("Out of findAccountsByClientId : ");
		TypedQuery<Account> accounts = em.createQuery("select a from Account a WHERE a.client=:cl", Account.class);
		accounts.setParameter("cl", cl);
		List<Account> oppenedAccounts=new ArrayList<>();
		for (int i=0;i<accounts.getResultList().size();i++){
			if (accounts.getResultList().get(i).isIsclosed()==false){ oppenedAccounts.add(accounts.getResultList().get(i));}
		}
		System.out.println("Out of findAccountsByClientId : ");
		return oppenedAccounts;

	}

	@Override
	public void AffectAccountToClient(int IdAccount, int IdClient) {
		// TODO Auto-generated method stub
		Client ClientManagedEntity = em.find(Client.class, IdClient);
		Account AccountManagedEntity = em.find(Account.class, IdAccount);
		System.out.println("out of AffectAccountToClient: Account: "+ IdAccount+" Client: "+IdClient);
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

	@Override
	public List<User> getAllUsers() {
		System.out.println("In getAllUsers : ");
		List<User> user = em.createQuery("select u from User u", User.class).getResultList();
		System.out.println("Out of getAllUsers : ");
		return user;
	}

	@Override
	public Client findClientByCin(String cin) {
		TypedQuery<Client> client = em.createQuery("select c from Client c WHERE c.cin=:cin",Client.class);
		client.setParameter("cin", cin);
		System.out.println("Out of findAccountsByUserId : ");
		return client.getSingleResult();

	}
	@Override
	public int addClient(Client client) {
		em.persist(client);
		return client.getId();
	}

	@Override
	public Client findClientById(int id) {
		Client client = em.find(Client.class, id);
		return client;
	}

	@Override
	public void AffectAgentToOppenAccount(int IdAccount, int IdAgent) {
		Agent AgentManagedEntity = em.find(Agent.class, IdAgent);
		Account AccountManagedEntity = em.find(Account.class, IdAccount);
		System.out.println("out of AffectAgentToOppenAccount: Account: "+ IdAccount+" Agent: "+IdAgent);
		AccountManagedEntity.setAgentOppenAccount(AgentManagedEntity);
		
	}

	@Override
	public void AffectAgentToCloseAccount(int IdAccount, int IdAgent) {
		Agent AgentManagedEntity = em.find(Agent.class, IdAgent);
		Account AccountManagedEntity = em.find(Account.class, IdAccount);
		AccountManagedEntity.setIsclosed(true);
		System.out.println("out of AffectAgentToCloseAccount: Account: "+ IdAccount+" Agent: "+IdAgent);
		AccountManagedEntity.setAgentCloseAccount(AgentManagedEntity);
		
	}
	


}
