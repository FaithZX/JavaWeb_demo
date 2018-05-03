package com.entity;

public class IdCard {

	private int card_id;
	private String cardNum;
	
	
	
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	@Override
	public String toString() {
		return "IdCard [card_id=" + card_id + ", cardNum=" + cardNum + "]";
	}

	
	
	
	
}
