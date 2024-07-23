package com.practise.challenge.problems;

import java.io.Serializable;

public class ChallengeEntity implements Serializable,Comparable<ChallengeEntity>{
	private static final long serialVersionUID = -4510457418113993517L;
	
	private String name;
	private int id;
	
	public ChallengeEntity(int id , String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
    
	@Override
	public int hashCode(){
		int primeNumber = 31 ; 
		return this.id + primeNumber;
	}
	
	@Override
	public boolean equals(Object obj){
		if ( null == this || null == obj) return false;
		if ( !(obj instanceof ChallengeEntity)) return false;
		ChallengeEntity entity = (ChallengeEntity) obj;
		if (this.id != entity.id) return false;
		return true;
		
	}

	public int compareTo(ChallengeEntity o) {
		// TODO Auto-generated method stub
		return 1;
	}
}
