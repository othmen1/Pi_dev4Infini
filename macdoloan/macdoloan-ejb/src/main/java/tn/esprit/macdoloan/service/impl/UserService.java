package tn.esprit.macdoloan.service.impl;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.macdoloan.entity.User;
import tn.esprit.macdoloan.service.interf.IUserServiceRemote;

@Stateless
public class UserService implements IUserServiceRemote{

	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;

	@Override
	public int addUser(User user) {
		System.out.println("In addUser : ");
		em.persist(user);
		System.out.println("Out of addUser" + user.getId());
		return user.getId();
	}
	
	
	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = em.createQuery("SELECT u FROM User u WHERE u.login=:l AND u.password=:p", User.class)
					.setParameter("l", login).setParameter("p", password).getSingleResult();
		} catch (Exception e) {
		}
		return user;
	}
	
	
	@Override
	public User UserExist(String login) {
		User user = null;
		try {
			user = em.createQuery("SELECT u FROM User u WHERE u.login=:l", User.class)
					.setParameter("l", login).getSingleResult();
		} catch (Exception e) {
		}
		return (user);
	}
	
	@Override
	public List<User> getAdmins() {

		List<User>user = em.createQuery("SELECT u FROM User u WHERE u.Role='Admin'", User.class)
				.getResultList();
		return user;
	}
	
		@Override
		public List<User> getAgents() {
			List<User>user = em.createQuery("SELECT u FROM User u WHERE u.Role='Agent'", User.class)
					.getResultList();
			return user;		}

	@Override
	public List<User> getClients() {
		List<User>user = em.createQuery("SELECT u FROM User u WHERE u.Role='Client'", User.class)
				.getResultList();
		return user;		
		
	}
	
	@Override
	public void deleteUser(int id) {
		em.remove(em.find(User.class, id));
		
	}
	
	
	
	@Override
	public void modif(int userid, String firstname, String lastname, String Adress, String email, String phone, Date birthdate, String cin, String login) {
		User user = em.find(User.class, userid);
		user.setAdress(Adress);
		user.setAdresseMail(email);
		user.setBirthDate(birthdate);
		user.setCin(cin);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setLogin(login);
		user.setPhone(phone);
		
		
	}
	
	@Override
	public void modifpassword(int userid, String password)
	{
		User user = em.find(User.class, userid);
		user.setPassword(password);
	}
	
	@Override
	public User FindUserById(int id_user) {
        User user =em.find(User.class, id_user);
		
		return user;
	}

}
