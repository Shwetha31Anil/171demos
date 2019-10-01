package com.mphasis.training.pojos;

public class Answer {

	private int ansId;
	private String answer;
	public Answer() {
		
	}
	@Override
	public String toString() {
		return "Answer [ansId=" + ansId + ", answer=" + answer + "]";
	}
	public Answer(int ansId, String answer) {
		super();
		this.ansId = ansId;
		this.answer = answer;
	}
	public int getAnsId() {
		return ansId;
	}
	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
