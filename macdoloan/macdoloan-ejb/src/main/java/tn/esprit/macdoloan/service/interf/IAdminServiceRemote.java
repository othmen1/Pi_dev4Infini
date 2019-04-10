package tn.esprit.macdoloan.service.interf;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Admin;

@Remote
public interface IAdminServiceRemote {
	
	public int addAdmin(Admin admin); 

}
