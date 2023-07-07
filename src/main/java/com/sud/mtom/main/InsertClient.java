package com.sud.mtom.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sud.mtom.model.Cart;
import com.sud.mtom.model.Item;
import com.sud.mtom.util.HibernateUtil;

public class InsertClient {

	public static void main(String[] args) {
		Item item1 = new Item();
		item1.setDescription("Iphone"); 
		item1.setPrice(300);
		
		Item item2 = new Item();
		item2.setDescription("MI Redmi");
		item2.setPrice(200);
		
		Cart cart = new Cart();
		cart.setTotal(500);
		Set<Item> items = new HashSet<Item>();
		items.add(item1);
		items.add(item2);
		cart.setItems(items);
		

		Cart cart1 = new Cart();
		cart1.setTotal(580);
		Set<Item> items1 = new HashSet<Item>();
		items1.add(item1); 
		items1.add(item2);
		cart1.setItems(items);
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(cart);
		session.save(cart1);
		tx.commit();
		sessionFactory.close();
		
		System.out.println("Cart ID="+cart.getId());
		System.out.println("Item1 ID="+item1.getId());
		System.out.println("Item2 ID="+item2.getId());
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
	}

}
