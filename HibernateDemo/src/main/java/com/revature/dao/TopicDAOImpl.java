package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Flashcard;
import com.revature.beans.Topic;
import com.revature.util.ConnectionUtil;

public class TopicDAOImpl implements TopicDAO{
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	public Topic getById(int id) {
		Topic tc = null;
		try(Session s = sf.openSession()) {
			tc = s.get(Topic.class, id);
			System.out.println(s.getStatistics());
		}
		return tc;
	}

	public List<Topic> getAll() {
		List<Topic> topicList = new ArrayList<>();
		// use a Query
		try(Session s = sf.openSession()) {
			topicList = s.createQuery("from Topic").getResultList();
		}
		return topicList;
	}

	public boolean addTopic(Topic topic) {
		boolean added = false;
		// try-with-resources on an AutoCloseable resource 
		// closes at end of control
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.persist(topic);
			tx.commit();
			added = true;
		}
		return added;
	}

	public boolean updateTopic(Topic topic) {
		boolean updated = false;
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.update(topic);
			tx.commit();
			updated = true;
		}
		return updated;
	}

	public boolean deleteTopic(Topic topic) {
		boolean deleted = false;
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.delete(topic);
			tx.commit();
			deleted = true;
		}
		return deleted;
	}
	
	public List<Topic> getByTopicName(String topicName) {
		List<Topic> TopicList = new ArrayList<>();
		List<Topic> output = new ArrayList<>();

		try (Session s = sf.openSession()) {
			TopicList = s.createQuery("from Topic").getResultList();
				System.out.println(s.getStatistics());
		}
		for(int i = 0; i < TopicList.size();i++) {
			if( TopicList.get(i).getName().equals(topicName))
				output.add(TopicList.get(i));
		}
		return output;

	}

}
