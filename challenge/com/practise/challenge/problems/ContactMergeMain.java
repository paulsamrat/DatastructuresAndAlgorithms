package com.practise.challenge.problems;

import java.util.ArrayList;
import java.util.List;

public class ContactMergeMain {
	
	public List<ContactEntity> mergeContacts(List<ContactEntity> contactEntityListPrimary , List<ContactEntity> contactEntityListSecondary )
	{	
		List<ContactEntity> mergedContactsList = new ArrayList<ContactEntity>();
	
		mergedContactsList = contactEntityListPrimary.isEmpty()  ? contactEntityListSecondary: contactEntityListPrimary;
//		if (contactEntityListPrimary.isEmpty() && !contactEntityListSecondary.isEmpty()) return contactEntityListSecondary;
//		if (!contactEntityListPrimary.isEmpty() && contactEntityListSecondary.isEmpty()) return contactEntityListSecondary;
		
		//if both contacts are having email
		// merge into a single contact
		
		
		
		//if both contacts are having same email but different ph numbers 
		// add the ph numberfrom secondary contact as alt ph number
		
		
		
		
		return null;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
