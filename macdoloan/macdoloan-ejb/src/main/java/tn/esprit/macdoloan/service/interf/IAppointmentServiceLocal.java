package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.macdoloan.entity.Agent;
import tn.esprit.macdoloan.entity.Appointment;
import tn.esprit.macdoloan.entity.Client;

@Local
public interface IAppointmentServiceLocal {
	
	public int addAppointment(Appointment appointment);

	public void removeAppointment(int id);

	public void updateAppointment(Appointment appointment);
	
	public void updateAppointmentStatus(Appointment appointment);

	public Appointment findAppointmentById(int id);

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
	
	public Agent findAgentById(int id);
	
	public Client findClientById(int id);
	
	public Client findClientByCin(String cin);
	
	public Agent findAgentByCin(String cin);

}
