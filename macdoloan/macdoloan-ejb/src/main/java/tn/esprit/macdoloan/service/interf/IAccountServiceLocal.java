package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.Client;

@Local
public interface IAccountServiceLocal {
	
	public int addAccount(Account account);

	public void removeAccount(int id);

	public void updateAccount(Account account);

	public Account findAccountById(int id);

	public List<Account> findAllAccounts();
	
	public List<String> getCinClients();
	
	public List<Client> getAllClients();
	
	public List<Account> findAccountsByUserId(int id);

	void AffectAccountToClient(int IdAccount, int IdClient);

}
