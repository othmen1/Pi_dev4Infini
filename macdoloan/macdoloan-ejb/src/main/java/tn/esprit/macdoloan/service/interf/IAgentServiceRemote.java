package tn.esprit.macdoloan.service.interf;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Agent;

@Remote
public interface IAgentServiceRemote {

	public int addAgent(Agent agent); 
}
