package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.macdoloan.entity.Answer;
import tn.esprit.macdoloan.entity.Claim;

@Local
public interface IClaimServiceLocal {
	public List<Claim> findAllClaims();
	public List<Claim> findNotAnswredClaims();
	public List<Claim> findAnswredClaims();
	public List<Claim> findUserClaims(int userid);
	public int addClaim(Claim claim);
	public void removeClaim(int id);
	public void updateClaim(Claim claim);
	public Claim findClaimById(int id);
	public int answerClaim(Claim claim, Answer answer);
}
