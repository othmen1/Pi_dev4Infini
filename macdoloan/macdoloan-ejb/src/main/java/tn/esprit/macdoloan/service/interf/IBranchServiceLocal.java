package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.macdoloan.entity.Branch;

@Local
public interface IBranchServiceLocal {
	public List<Branch> findAllBranchs();
	public int addBranch(Branch branch);
	public void removeBranch(int id);
	public void updateBranch(Branch branch);
	public Branch findBranchById(int id);
}
