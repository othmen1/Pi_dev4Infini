package tn.esprit.macdoloan.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.macdoloan.entity.Branch;
import tn.esprit.macdoloan.service.interf.IBranchServiceLocal;
import tn.esprit.macdoloan.service.interf.IBranchServiceRemote;

@Stateless
public class BranchServiceImpl implements IBranchServiceLocal, IBranchServiceRemote {
	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;

	@Override
	public List<Branch> findAllBranchs() {
		return em.createQuery("select u from Branch u", Branch.class).getResultList();
	}

	@Override
	public int addBranch(Branch branch) {
		em.persist(branch);
		return branch.getId();
	}

	@Override
	public void removeBranch(int id) {
		em.remove(em.find(Branch.class, id));
		
	}

	@Override
	public void updateBranch(Branch branch) {
		Branch initialBranch = em.find(Branch.class, branch.getId());
		initialBranch.setStreet(branch.getStreet());
		initialBranch.setPostalCode(branch.getPostalCode());
		initialBranch.setCity(branch.getCity());
		initialBranch.setName(branch.getName());
	}

	@Override
	public Branch findBranchById(int id) {
		Branch branch = em.find(Branch.class, id);
		return branch;
	}

}
