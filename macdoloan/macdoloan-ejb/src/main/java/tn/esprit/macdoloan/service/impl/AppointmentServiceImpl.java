package tn.esprit.macdoloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.Agent;
import tn.esprit.macdoloan.entity.Appointment;
import tn.esprit.macdoloan.entity.Client;
import tn.esprit.macdoloan.service.interf.IAppointmentServiceLocal;
import tn.esprit.macdoloan.service.interf.IAppointmentServiceRemote;

@Stateless
public class AppointmentServiceImpl implements IAppointmentServiceLocal, IAppointmentServiceRemote {

	@PersistenceContext(unitName="macdoloan-ejb")
	EntityManager em;
	
	@Override
	public int addAppointment(Appointment appointment) {
		System.out.println("In addAppointment : ");
		em.persist(appointment);
		System.out.println("Out of addAppointment" + appointment.getId());
		return appointment.getId();
	}

	@Override
	public void removeAppointment(int AppointmentId) {
		em.remove(em.find(Appointment.class, AppointmentId));
		
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		Appointment newAppointment =em.find(Appointment.class, appointment.getId());
		newAppointment.setObject(appointment.getObject());
		newAppointment.setDescription(appointment.getDescription());
		newAppointment.setCity(appointment.getCity());
		newAppointment.setGovernorate(appointment.getGovernorate());
		newAppointment.setPlace(appointment.getPlace());
		newAppointment.setDate(appointment.getDate());
	}

	@Override
	public Appointment findAppointmentById(int id) {
		System.out.println("In findAppointmentById : ");
		Appointment appointment = em.find(Appointment.class, id);
		System.out.println("Out of findAppointmentById : ");
		return appointment;
	}

	@Override
	public List<Appointment> findAllAppointments() {
		System.out.println("In findAllAppointments : ");
		List<Appointment> appointments = em.createQuery("from Appointment", Appointment.class).getResultList();
		System.out.println("Out of findAllAppointments : ");
		return appointments;
	}

	@Override
	public List<String> getCinClients() {
		List<Client> clients = em.createQuery("select c from Client c", Client.class).getResultList();
		List<String> cin = new ArrayList<>();
		for (Client client: clients){
			cin.add(client.getCin());
		}
		System.out.println("Out of getCinClients : ");
		return cin;
	}

	@Override
	public List<Client> getAllClients() {
		System.out.println("In getAllClients : ");
		List<Client> client = em.createQuery("from Client", Client.class).getResultList();
		System.out.println("Out of getAllClients : ");
		return client;
	}

	@Override
	public List<Agent> getAllAgents() {
		System.out.println("In getAllAgents : ");
		List<Agent> agent = em.createQuery("from Agent", Agent.class).getResultList();
		System.out.println("Out of getAllAgents : ");
		return agent;
	}

	@Override
	public List<Appointment> findAppointmentByClient(Client cl) {
		System.out.println("Out of findAppointmentByClient : ");
		TypedQuery<Appointment> appointments = em.createQuery("select a from Appointment a WHERE a.client=:cl", Appointment.class);
		appointments.setParameter("cl", cl);
		System.out.println("Out of findAppointmentByClient : ");
		return appointments.getResultList();
	}

	@Override
	public List<Appointment> findAppointmentByAgent(Agent ag) {
		System.out.println("Out of findAppointmentByAgent : ");
		TypedQuery<Appointment> appointments = em.createQuery("select a from Appointment a WHERE a.agent=:ag", Appointment.class);
		appointments.setParameter("ag", ag);
		System.out.println("Out of findAppointmentByAgent : ");
		return appointments.getResultList();
	}

	@Override
	public void AffectAppointmentToAgent(int IdAppointment, int IdAgent) {
		Agent AgentManagedEntity = em.find(Agent.class, IdAgent);
		Appointment AppointmentManagedEntity = em.find(Appointment.class, IdAppointment);
		AppointmentManagedEntity.setAgent(AgentManagedEntity);
	}

	@Override
	public int addClient(Client client) {
		em.persist(client);
		return client.getId();
	}

	@Override
	public Agent findAgentById(int id) {
		Agent agent = em.find(Agent.class, id);
		return agent;
	}

	@Override
	public Client findClientById(int id) {
		Client client = em.find(Client.class, id);
		return client;
	}

	@Override
	public Client findClientByCin(String cin) {
		TypedQuery<Client> client = em.createQuery("select c from Client c WHERE c.cin=:cin",Client.class);
		client.setParameter("cin", cin);
		System.out.println("Out of findAccountsByUserId : ");
		return client.getSingleResult();
	}

	@Override
	public Agent findAgentByCin(String cin) {
		TypedQuery<Agent> agent = em.createQuery("select a from Agent a WHERE a.cin=:cin",Agent.class);
		agent.setParameter("cin", cin);
		System.out.println("Out of findAgentByCin : ");
		return agent.getSingleResult();
	}

	@Override
	public void updateAppointmentStatus(Appointment appointment) {
		Appointment newAppointment =em.find(Appointment.class, appointment.getId());
		newAppointment.setStatus(true);		
	}

	@Override
	public int addAgent(Agent agent) {
		em.persist(agent);
		return agent.getId();
	}

}
