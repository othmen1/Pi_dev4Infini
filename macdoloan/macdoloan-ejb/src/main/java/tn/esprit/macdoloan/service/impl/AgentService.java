package tn.esprit.macdoloan.service.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.macdoloan.entity.Agent;
import tn.esprit.macdoloan.service.interf.IAgentServiceRemote;


@Stateless
public class AgentService implements IAgentServiceRemote {

	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;

	@Override
	public int addAgent(Agent agent) {
		System.out.println("In addUser : ");
		em.persist(agent);
		System.out.println("Out of addUser" + agent.getId());
		return agent.getId();
         }
}
