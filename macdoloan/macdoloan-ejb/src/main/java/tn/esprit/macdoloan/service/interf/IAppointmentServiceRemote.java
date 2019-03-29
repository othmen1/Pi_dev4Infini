package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Agent;
import tn.esprit.macdoloan.entity.Appointment;
import tn.esprit.macdoloan.entity.Client;

@Remote
public interface IAppointmentServiceRemote {
	
	public int addAppointment(Appointment appointment);

	public void removeAppointment(int id);

	public void updateAppointment(Appointment appointment);
	
	public void updateAppointmentStatus(Appointment appointment);

	public Appointment findAppointmentById(int id);
	
	public List<Appointment> findAppointmentByGover(String Gov);

	public List<Appointment> findAllAppointments();
	
	public List<String> getCinClients();
	
	public List<Client> getAllClients();
	
	public List<Agent> getAllAgents();
	
	public List<Appointment> findAppointmentByClient(Client cl);
	
	public List<Appointment> findAppointmentByAgent(Agent ag);
	
	public void AffectAppointmentToAgent(int IdAppointment, int IdAgent);
	
	public void AffectAppointmentToClient(int IdAppointment, int IdClient);
	
	public void AffectAppointmentToBranch(int IdAppointment, int IdBranch);
	
	public int addClient(Client client);
	
	public int addAgent(Agent agent);
	
	public Agent findAgentById(int id);
	
	public Client findClientById(int id);
	
	public Client findClientByCin(String cin);
	
	public Agent findAgentByCin(String cin);	
	

}
