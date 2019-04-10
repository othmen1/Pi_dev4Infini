package tn.esprit.macdoloan.service.interf;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Admin;
import tn.esprit.macdoloan.entity.Answer;
import tn.esprit.macdoloan.entity.Claim;
@Remote
public interface IClaimServiceRemote {
	public List<Claim> findAllClaims();
	public List<Claim> findNotAnswredClaims();
	public List<Claim> findAnswredClaims();
	public List<Claim> findUserClaims(int userid);
	public int addClaim(Claim claim);
	public void removeClaim(int id);
	public void updateClaim(Claim claim);
	public Claim findClaimById(int id);
	public int answerClaim(Claim claim, Answer answer);
	public List<Admin> findAllAdmins();
	public Map<String,Integer> CountByObject();
}