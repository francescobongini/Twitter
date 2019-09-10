package com.francesco.Twitter;

public class Tweet {
	private Integer sentiment; //0 tweeet positivo, 1 tweet negativo
	private String text; //testo del tweet

	public Tweet(){
    }
	
	public Tweet(Integer sentiment, String text) {
		super();
		this.sentiment = sentiment;
	    this.text = text;
	  }
	public Integer getSentiment() {
		return sentiment;
	}
	public String getText() {
		return text;
	}

	public String text() {
		return text;
	}
	public void setV1(Integer intero)
	{
		this.sentiment = intero;
	}
	
	public void setV6(String intero)
	{
		this.text = intero;
	}
}
