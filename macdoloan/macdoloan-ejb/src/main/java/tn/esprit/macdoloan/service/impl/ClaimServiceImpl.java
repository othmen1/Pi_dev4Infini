package tn.esprit.macdoloan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.macdoloan.entity.Admin;
import tn.esprit.macdoloan.entity.Answer;
import tn.esprit.macdoloan.entity.Claim;
import tn.esprit.macdoloan.service.interf.IClaimServiceLocal;
import tn.esprit.macdoloan.service.interf.IClaimServiceRemote;

@Stateless
public class ClaimServiceImpl implements IClaimServiceRemote, IClaimServiceLocal {
	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;
	@Override
	public List<Claim> findAllClaims() {
		return em.createQuery("select u from Claim u", Claim.class).getResultList();
	}

	@Override
	public List<Claim> findNotAnswredClaims() {
		return em.createQuery("select u from Claim u where u.state = ?1", Claim.class).setParameter(1, "NotAnswred").getResultList();
	}

	@Override
	public List<Claim> findAnswredClaims() {
		return em.createQuery("select u from Claim u where u.state = ?1", Claim.class).setParameter(1, "Answred").getResultList();
	}

	@Override
	public List<Claim> findUserClaims(int userid) {
		try{
			//return em.createQuery("select u from Claim u where u.clien = ?1", Claim.class).setParameter(1, userid).getResultList();
			List<Claim> resultList = em.createNativeQuery("SELECT * FROM `claim` WHERE `client_Id` = ?1").setParameter(1, userid).getResultList();
			return resultList;
		}
		catch (Exception e) {
			return new ArrayList<Claim>();
		}
	}

	@Override
	public void removeClaim(int id) {
		em.remove(em.find(Claim.class, id));

	}

	@Override
	public void updateClaim(Claim claim) {
		Claim initialClaim = em.find(Claim.class, claim.getId());
		initialClaim.setDescription(claim.getDescription());
		initialClaim.setObject(claim.getObject());

	}

	@Override
	public Claim findClaimById(int id) {
		Claim claim = em.find(Claim.class, id);
		return claim;
	}

	@Override
	public int addClaim(Claim claim) {
		em.persist(claim);		
		return claim.getId();
	}

	@Override
	public int answerClaim(Claim claim, Answer answer) {
		em.persist(answer);
		Claim initialClaim = em.find(Claim.class, claim.getId());
		initialClaim.setAnswer(answer);
		initialClaim.setState("Answred");
		return answer.getId();
	}

	@Override
	public List<Admin> findAllAdmins() {
		return em.createQuery("select u from Admin u", Admin.class).getResultList();
	}

	@Override
	public Map<String, Integer> CountByObject() {
		ArrayList<Claim> listeAllClaims = (ArrayList<Claim>) findAllClaims();
		ArrayList<String> listeDistinctObject =new ArrayList<>();
		ArrayList<String> listeAllObject =new ArrayList<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Claim c : listeAllClaims) {
			listeAllObject.add(c.getObject());
		}
		listeAllObject.stream().distinct().forEach(e->listeDistinctObject.add(e));
		for (String string : listeDistinctObject) {
			map.put(string, listeAllObject.stream().filter(e->e.equals(string)).toArray().length);
		}
		return map;
	}

}
