package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Admin;
import tn.esprit.macdoloan.entity.Client;
import tn.esprit.macdoloan.entity.User;
@Remote
public interface IUserServiceRemote {
	//public User findUserByLogin(String login,String password);
	//public int addAdmin(Admin a);
	//public int addClient(Client a);
	int addUser(User user); 
	User login(String login, String password);
	User UserExist(String login);
	List<User> getClients();
	List<User> getAgents();
	List<User> getAdmins();
	void deleteUser(int id);
	void modif(int userid, String firstname, String lastname, String Adress, String email, String phone, java.sql.Date birthdate,
			String cin, String login);
	void modifpassword(int userid, String password);
	User FindUserById(int id_user);
}
