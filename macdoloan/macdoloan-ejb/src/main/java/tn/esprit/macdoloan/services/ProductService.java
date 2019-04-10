package tn.esprit.macdoloan.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.Client;
import tn.esprit.macdoloan.entity.Product;
import tn.esprit.macdoloan.entity.User;
import tn.esprit.macdoloan.interfaces.IproductServiceLocal;
import tn.esprit.macdoloan.interfaces.IproductServiceRemote;

@Stateless

public class ProductService implements IproductServiceLocal, IproductServiceRemote {
	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;

	@Override
	public int addProduit(Product produit) {
		System.out.println("In addUser : ");
		em.persist(produit);

		System.out.println("Out of addUser" + produit.getId());
		return produit.getId();
	}

	@Override
	public void removeProduct(int id) {
		System.out.println("In removeUser : ");
		em.remove(em.find(Product.class, id));
		System.out.println("Out of removeUser : ");
	}

	@Override
	public void updateProduct(Product produit) {
		System.out.println("In updateUser : ");
		Product p = em.find(Product.class, produit.getId());
		p.setAmountMax(produit.getAmountMax());
		p.setAmountMin(produit.getAmountMin());
		p.setDescription(produit.getDescription());
		p.setName(produit.getName());
		p.setDurationMax(produit.getDurationMax());
		p.setDurationMin(produit.getDurationMin());
		p.setFees(produit.getFees());
		p.setInterestRate(produit.getInterestRate());
		em.merge(p);
		System.out.println("Out of updateUser : ");
	}

	@Override
	public Product findProductById(int id) {
		Product product = em.find(Product.class, id);

		return product;
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> users = em.createQuery("from Product", Product.class).getResultList();
		System.out.println("Out of findAllUsers : ");
		return users;
	}

	@Override
	public List<Object[]> productPerSector() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = em.createQuery("SELECT count (c)  , c.product FROM Loan c group by c.product ");

		return query.getResultList();
	}

	@Override
	public List<Object[]> productPerMonth() {

		javax.persistence.Query query = em
				.createQuery("SELECT count (c)  , c.startDate FROM Loan c group by c.startDate ");

		return query.getResultList();
	}

	@Override
	public List<Object[]> amountPerProduct() {

		javax.persistence.Query query = em
				.createQuery("SELECT SUM (c.amount)  , c.product FROM Loan c group by c.product ");

		return query.getResultList();
	}

	@Override
	public double allAmounts() {

		javax.persistence.Query query = em.createQuery("SELECT SUM (c.amount) FROM Loan c ");

		return (double) query.getSingleResult();
	}

	@Override
	public double amountsAfter() {
		List<Object[]> list = this.amountPerProduct();
		double somme = 0;
		for (Object[] o : list) {

			Product p = (Product) o[1];
			somme = somme + (double) o[0] + (double) o[0] * p.getInterestRate();
			// System.out.println(o[0] ) ;
			// System.out.println(o[1] ) ;
		}
		System.out.println(somme);
		return somme;
	}

	@Override
	public List<Product> productsnotbought() {
		// System.out.println("salut salut");
		List<Product> products = this.findAllProducts();

		// System.out.println("salut");

		List<Product> productsnotbought1 = new ArrayList<Product>();
		for (Product p : products) {

			System.out.println("aaaaa    " + p.getId());
			javax.persistence.Query query = em.createQuery("SELECT count (c) FROM Loan c where c.product=:p");
			query.setParameter("p", p);
			long n = (long) query.getSingleResult();
			// System.out.println(n);

			if (n == 0) {

				productsnotbought1.add(p);

			}
		}

		return productsnotbought1;
	}

	@Override
	public List<Client> getAllFreeUser() {
		// TODO Auto-generated method stub
		TypedQuery<Client> queryAll = em.createQuery("Select c from Client c ", Client.class);

		TypedQuery<Client> query = em
				.createQuery("Select c from Client c inner join c.clientLoans l where c = l.client    ", Client.class);
		List<Client> freeUsers = new ArrayList<>();

		for (Client c : queryAll.getResultList()) {
			if (!query.getResultList().contains(c)) {
				freeUsers.add(c);
			}
		}
		return freeUsers;
	}

	@Override
	public List<Product> recommandProductPerClient(Client u) {

		javax.persistence.Query queryAll = em
				.createQuery(" SELECT l.product from Client c inner join c.clientLoans l " + "where l.client = c "
						+ "AND c.domain=:domain " + "AND c.salaryClient<=:max " + "AND c.salaryClient>=:min   " + "");
		queryAll.setParameter("domain", u.getDomain());   

		queryAll.setParameter("max", u.getSalaryClient() + 1500);
		
		queryAll.setParameter("min", u.getSalaryClient() - 1500);
		queryAll.getResultList().remove(u);
		Product pmax = new Product();
		long max = 0;
		// List<Long> counts = new ArrayList<>();

		// List<Object[]> listproduit = null ;
		HashMap<Product, Long> map = new HashMap<>();
		for (Product p : (List<Product>) queryAll.getResultList()) {
			javax.persistence.Query query = em.createQuery(
					" SELECT count (*) AS total , p.product from Loan p where p.product=:product ORDER BY total DESC ");

			query.setParameter("product", p);
			// List<Object[]> sorted = (List<Object[]>)query.getResultList();

			for (Object[] o : (List<Object[]>) query.getResultList()) {
				// counts.add((long)o[0]);

				Product p1 = (Product) o[1];
				map.put((Product) o[1], (long) o[0]);
				// System.out.println("produit : " + p1.getId());
				// System.out.println("count : " + o [0]);
				/*
				 * if ((long)o[0] > max) { max = (long)o[0] ; pmax = p1 ;
				 * 
				 * 
				 * }
				 */

			}
		}
		List<Product>list= new ArrayList<>();
		Map<Object, Long> sortedMap = map.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		for (Entry<Object, Long> entry : sortedMap.entrySet()) {

			System.out.println(((Product) entry.getKey()).getId());
			System.out.println(entry.getValue());
			list.add((Product)entry.getKey());
			
			// traitements
		} 
		
		
		/*
		 * for ( long i : counts){ System.out.println(i); }
		 */

		// System.out.println("produit : "+pmax.getId());
		// System.out.println("counyt "+max);

		return list;
	}

	public Boolean verifprod(Product p) {
		javax.persistence.Query query = em.createQuery("SELECT c.product FROM Loan c where c.product=:p ");
		query.setParameter("p", p);
		Boolean verif = false;
		for (Product a : (List<Product>) query.getResultList()) {
			if (a.getId() == p.getId()) {
				verif = true;
				System.out.println(verif);
			}
		}
		return verif;

	}

}
