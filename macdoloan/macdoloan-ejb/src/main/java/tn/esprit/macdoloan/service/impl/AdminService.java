package tn.esprit.macdoloan.service.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.macdoloan.entity.Admin;
import tn.esprit.macdoloan.service.interf.IAdminServiceRemote;


@Stateless
public class AdminService implements IAdminServiceRemote{

	
	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;

	
@Override
	public int addAdmin(Admin admin) {
	System.out.println("In addClient : ");
	em.persist(admin);
	System.out.println("Out of addUser" + admin.getId());
	return admin.getId();		
	}
	
}
