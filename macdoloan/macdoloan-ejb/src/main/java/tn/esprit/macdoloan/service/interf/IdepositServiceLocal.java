package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.macdoloan.entity.*;

@Local

public interface IdepositServiceLocal {

	public int addDeposit(Deposit deposit);

	public int addwithdraw(Withdrawal withdrawel);

	public Deposit findDepositById(int id);

	public List<Deposit> findDepositsByAccount(Account acc);

	public List<Deposit> findAllDeposits();

	public List<String> getCinClients();

	public void AffectDepositToAccount(Account c, Deposit d);

	public void deposit(Account c, float amount);

	public Account RecupererIDAccount(String RIB);

	public int RecupererID(float amout);

	public Account getAccountById(int balance);

}
