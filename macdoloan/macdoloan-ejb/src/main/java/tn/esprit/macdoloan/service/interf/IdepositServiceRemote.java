package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.*;

@Remote
public interface IdepositServiceRemote {

	public int addDeposit(Deposit deposit);

	public int addwithdraw(Withdrawal withdrawel);

	public Deposit findDepositById(int id);

	public List<Deposit> findDepositsByAccount(Account acc);

	public List<Deposit> findAllDeposits();

	public List<String> getCinClients();

	public void AffectDepositToAccount(Account c, Deposit d);

	public void deposit(Account c, float amount);

	public Account RecupererIDAccount(String RIB);

	public Account getAccountById(int balance);

	public int RecupererID(float amout);

}
