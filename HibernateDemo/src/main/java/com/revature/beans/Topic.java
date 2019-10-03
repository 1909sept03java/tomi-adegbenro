package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.beans.Flashcard;

@Entity
@Table(name="TOPIC")
public class Topic {
	@Id //indicates that this is the primary key! ("persistent identity" of a Topic)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TopicSequence")
	@SequenceGenerator(allocationSize=1, name="TopicSequence", sequenceName="SQ_TOPIC_PK")
	@Column(name="TOPIC_ID")
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic", targetEntity= Flashcard.class)
	private int id;
	@Column(name="TOPIC_NAME")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic", targetEntity= Flashcard.class)
	private List<Flashcard> flashcards;
	
	public Topic() {
		super();
	}

	public Topic(int id, String name, List<Flashcard> flashcards) {
		super();
		this.id = id;
		this.name = name;
		this.flashcards = flashcards;
	}

	public Topic(String name, List<Flashcard> flashcards) {
		super();
		this.name = name;
		this.flashcards = flashcards;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flashcard> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(List<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flashcards == null) ? 0 : flashcards.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (flashcards == null) {
			if (other.flashcards != null)
				return false;
		} else if (!flashcards.equals(other.flashcards))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", flashcards=" + flashcards + "]";
	}

	
	

}
