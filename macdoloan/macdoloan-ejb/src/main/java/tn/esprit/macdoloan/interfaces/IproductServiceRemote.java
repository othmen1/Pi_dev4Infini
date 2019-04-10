package tn.esprit.macdoloan.interfaces;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.Client;
import tn.esprit.macdoloan.entity.Product;
import tn.esprit.macdoloan.entity.User; 
@Remote

public interface IproductServiceRemote {
	public int addProduit(Product produit); 
	public void removeProduct(int id); 
	public void updateProduct(Product produit) ;
	public Product  findProductById(int id);
	public List<Product> findAllProducts();	
	public List<Object []> productPerSector () ;
	public List<Object []> productPerMonth () ;
	public List<Object []> amountPerProduct () ;
	public double allAmounts() ;
	public double amountsAfter () ;
	public List<Product> productsnotbought();
	public List<Client> getAllFreeUser ();
	public List<Product> recommandProductPerClient (Client u) ;
	public Boolean verifprod (Product p );
	
}
