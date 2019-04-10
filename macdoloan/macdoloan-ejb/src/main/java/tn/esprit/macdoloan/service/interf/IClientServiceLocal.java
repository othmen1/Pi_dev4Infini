package tn.esprit.macdoloan.service.interf;

import javax.ejb.Local;

import tn.esprit.macdoloan.entity.Client;
@Local
public interface IClientServiceLocal {
	public int addClient(Client client); 

}
