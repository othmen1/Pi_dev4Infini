package tn.esprit.macdoloan.service.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import tn.esprit.macdoloan.entity.Client;
import tn.esprit.macdoloan.service.interf.IClientServiceLocal;
import tn.esprit.macdoloan.service.interf.IClientServiceRemote;

@Stateless
public class ClientService implements IClientServiceRemote,IClientServiceLocal  {
	
	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;


	@Override
	public int addClient(Client client) {
		System.out.println("In addClient : ");
		em.persist(client);
		System.out.println("Out of addUser" + client.getId());
		return client.getId();		
	}
	
}
