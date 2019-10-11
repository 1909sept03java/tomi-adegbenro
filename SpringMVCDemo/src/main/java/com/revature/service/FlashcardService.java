package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.FlashcardDAO;
import com.revature.model.Flashcard;

@Service
public class FlashcardService {
	
	/*{
		//this instance block is executed just before the class is instantiated
		Topic t1 = new Topic(1, "coding");
		Topic t2 = new Topic(4, "entemology");
		this.cardList = new ArrayList<Flashcard>();
		this.cardList.add(new Flashcard(2, "what is the answer of life, the unverse and everythign else?", "42", t1));
		this.cardList.add(new Flashcard(5, "what is tJava?", "42", t1));
		this.cardList.add(new Flashcard(2, "How many kinds of spiders are there?", "42", t2));
		this.cardList.add(new Flashcard(2, "what does the venus flytrap eat?", "42", t2));
		
	}
	
	private List<Flashcard> cardList;
	*/
	private FlashcardDAO flashcardDAO;
	
	@Autowired
	public FlashcardService(FlashcardDAO flashcardDAO) {
		this.flashcardDAO = flashcardDAO;
	}
	public List<Flashcard> allFlashcards(){
		//return this.cardList; //Remember this is just for demo, real services will only pass DAO Impl methods etc.
		return this.flashcardDAO.allFlashcards();
	}
	
	public Flashcard getFlashcardById(int id) { 
		/*Flashcard f = null; //Remember this is just for demo, real services will only pass DAO Impl methods etc.
		for (Flashcard c : this.cardList) {
			if (c.getId() == id) {
				f = c;
				break;
			}
		}
		return f;*/
		return this.flashcardDAO.getFlashcardById(id);
	}
	
	public void addFlashcard(Flashcard f) {
		//this.cardList.add(f); //Remember this is just for demo, real services will only pass DAO Impl methods etc.
		this.flashcardDAO.createFlashcard(f);
	}
	
}
