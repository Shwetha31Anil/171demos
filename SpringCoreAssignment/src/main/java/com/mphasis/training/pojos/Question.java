package com.mphasis.training.pojos;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question {

	private int qid;
	private String que;
	private List<Answer> answers;
	private Map<Person, Answer> pans;
	public Question() {
		
	}
	public Question(int qid, String que, List<Answer> answers, Map<Person, Answer> pans) {
		super();
		this.qid = qid;
		this.que = que;
		this.answers = answers;
		this.pans = pans;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Map<Person, Answer> getPans() {
		return pans;
	}
	public void setPans(Map<Person, Answer> pans) {
		this.pans = pans;
	}
	
	
	
}
