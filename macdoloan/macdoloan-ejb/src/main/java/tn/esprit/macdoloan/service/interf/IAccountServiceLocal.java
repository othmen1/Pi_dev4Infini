package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.Client;
import tn.esprit.macdoloan.entity.User;

@Local
public interface IAccountServiceLocal {
	
	public int addAccount(Account account);

	public void removeAccount(int id);

	public void updateAccount(Account account);

	public Account findAccountById(int id);

	public List<Account> findAllAccounts();
	
	public List<String> getCinClients();
	
	public List<Client> getAllClients();
	
	public List<User> getAllUsers();
	
	public List<Account> findAccountsByClient(Client cl);

	void AffectAccountToClient(int IdAccount, int IdClient);
	
	public int addClient(Client client);
	
	public Client findClientByCin(String cin);
	
	public Client findClientById(int id);

}
