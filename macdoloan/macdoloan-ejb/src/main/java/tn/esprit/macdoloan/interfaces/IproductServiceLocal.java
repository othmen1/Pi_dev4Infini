package tn.esprit.macdoloan.interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Product;



@Local 

public interface IproductServiceLocal { 
	public int addProduit(Product produit); 
	public void removeProduct(int id); 
	public void updateProduct(Product produit) ; 
	public Product  findProductById(int id);
	public List<Product> findAllProducts();	

}
