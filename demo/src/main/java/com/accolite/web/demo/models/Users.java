package com.accolite.web.demo.models;

public class Users {
	private int id;
	private int salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	public boolean runInGround(String location) {
	    if(location.equals("ground")) {
	      System.out.println("The person runs in the " + location);
	      return true;
	    } else {
	      System.out.println("The person doesn't run in the " +   location);
	      return false;
	    }

	  }

	  public boolean isPlay() {

	    if(this.runInGround("ground")) {
	      System.out.println("The person plays.");
	      return true;
	    }
	    else {
	      System.out.println("The person doesn't play");
	      return false;
	    }
	  }
}
	
	

