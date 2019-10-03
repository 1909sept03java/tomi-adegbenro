package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Flashcard;
import com.revature.util.ConnectionUtil;

public class FlashcardDAOImpl implements FlashcardDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public Flashcard getById(int id) {
		Flashcard fc = null;
		try(Session s = sf.openSession()) {
			fc = s.get(Flashcard.class, id);
			System.out.println(s.getStatistics());
		}
		return fc;
	}

	@Override
	public List<Flashcard> getAll() {
		List<Flashcard> flashcardList = new ArrayList<>();
		// use a Query
		try(Session s = sf.openSession()) {
			flashcardList = s.createQuery("from Flashcard").getResultList();
		}
		return flashcardList;
	}

	@Override
	public boolean addFlashcard(Flashcard flashcard) {
		boolean added = false;
		// try-with-resources on an AutoCloseable resource 
		// closes at end of control
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.persist(flashcard);
			tx.commit();
			added = true;
		}
		return added;
	}

	@Override
	public boolean updateFlashcard(Flashcard flashcard) {
		boolean updated = false;
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.update(flashcard);
			tx.commit();
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean deleteFlashcard(Flashcard flashcard) {
		boolean deleted = false;
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.delete(flashcard);
			tx.commit();
			deleted = true;
		}
		return deleted;
	}
	
	@Override
	public List<Flashcard> getByQuestion(String question) {
		List<Flashcard> flashcardList = new ArrayList<>();
		List<Flashcard> output = new ArrayList<>();

		try (Session s = sf.openSession()) {
				flashcardList = s.createQuery("from Flashcard").getResultList();
				System.out.println(s.getStatistics());
		}
		for(int i = 0; i < flashcardList.size();i++) {
			if( flashcardList.get(i).getQuestion().equals(question))
				output.add(flashcardList.get(i));
		}
		return output;

	}

}