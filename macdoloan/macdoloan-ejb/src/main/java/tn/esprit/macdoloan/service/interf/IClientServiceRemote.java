package tn.esprit.macdoloan.service.interf;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Client;

@Remote
public interface IClientServiceRemote {

	
	public int addClient(Client client); 

}
