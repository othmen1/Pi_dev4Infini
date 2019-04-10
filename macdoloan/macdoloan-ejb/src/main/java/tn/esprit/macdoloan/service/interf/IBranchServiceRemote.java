package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Admin;
import tn.esprit.macdoloan.entity.Branch;

@Remote
public interface IBranchServiceRemote {
	public List<Branch> findAllBranchs();
	public int addBranch(Branch branch);
	public void removeBranch(int id);
	public void updateBranch(Branch branch);
	public Branch findBranchById(int id);
	
}
