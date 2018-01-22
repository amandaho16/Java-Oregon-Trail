package com.lmig.gfc.oregon_trail.models;

import java.util.Random;

public class Traveler {
	
	protected int amountFood;
	protected String name;
	protected boolean isHealthy;
	
	public Traveler(int amountFood, String name, boolean isHealthy) {
		this.amountFood = amountFood;
		this.name = name;
		this.isHealthy = isHealthy;
	}
	public int getAmountFood() {
		return amountFood;
	}
	public void setAmountFood(int amountFood) {
		this.amountFood = amountFood;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHealthy() {
		return isHealthy;
	}
	public void setHealthy(boolean isHealthy) {
		this.isHealthy = isHealthy;
	}
	
	public void hunt() {
		//50% chance to increase the traveler's food by 100(successful hunt)
		//50% chance to increase by 0 (unsuccessful hunt)
		
		int huntSuccess = this.randomNumber(1, 2);
		
		if(huntSuccess == 2) {
			this.setAmountFood(this.getAmountFood() + 100);
		} else {
			this.setAmountFood(this.getAmountFood() + 0);
		}
	
	}
	
	public void eat() {
		//consumes 20 of the traveler's food
		this.setAmountFood(this.getAmountFood() - 20);
	
		//if the traveler has no food, he/she is no longer healthy
		if(this.getAmountFood() <= 20) {
			this.setHealthy(true);
		} else {
			this.setHealthy = false;
		}	
		
	}
	
	public int randomNumber(int min, int max) {
		Random random = new Random();
		int randomNumber = random.nextInt((max - min) + 1) + min; 
		return randomNumber;
		
	}
	
	

}
