package com.sud.mtom.main;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sud.mtom.model.Cart;
import com.sud.mtom.model.Item;
import com.sud.mtom.util.HibernateUtil;

public class SelectClient {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Cart c= session.get(Cart.class, 2L);
		System.out.println(c.getId());
		System.out.println(c.getTotal());
		Set<Item> i= c.getItems();
		
		for(Item ii : i) {
			System.out.println(ii.getDescription());
			System.out.println(ii.getPrice());
		}
		
		tx.commit();
		session.close();
	}

}
