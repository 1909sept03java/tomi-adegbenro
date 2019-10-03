  
package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOImpl;
import com.revature.beans.Topic;
import com.revature.dao.TopicDAO;
import com.revature.dao.TopicDAOImpl;

public class Driver {

	public static void main(String[] args) {
		// System.out.println(ConnectionUtil.getSessionFactory());
		// SessionFactory sf = ConnectionUtil.getSessionFactory();
		// Session s = sf.openSession();
		// System.out.println(s.getStatistics());
		// s.close();
		
		
		// Flashcard actions
		Topic top = new Topic();
		FlashcardDAO fd = new FlashcardDAOImpl();
		fd.addFlashcard(new Flashcard("what are you wearing?","30", top));
		//fd.updateFlashcard(new Flashcard(1, "what are you having for dinner now?", "34", new Topic("Chemistry")));
		for(Flashcard f : fd.getAll()) {
			System.out.println(f);
		}
		//fd.getById(1);
		//Flashcard fc = fd.addFlashcard(new Flashcard("what are we watching?","31"));
		//Flashcard ff = fd.getById(3);
		//System.out.println(ff);
		boolean b = false;
		//fd.deleteFlashcard(ff);
		List<Flashcard> fg = fd.getByQuestion("what are you wearing?");
		System.out.println(fg);
		
		//Topic Table actions
		List<Flashcard> flash = new ArrayList<Flashcard>();
		TopicDAO td = new TopicDAOImpl();
		td.addTopic(new Topic("Biology", flash));
		//td.addTopic(new Topic("Chemistry"));
		//td.addTopic(new Topic("Physics"));

		
		
		
	}

}