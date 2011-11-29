package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

/**
 * Handle Occupations
 * @author kurt
 * @version $Revision: 1.0 $
 */
public abstract class Occupation implements Serializable { // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.preferInterfacesToAbstractClasses
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -6040773823566650272L;
	
	/**
	 * Get list of occupations
	 * @return Occupation[]
	 */
	public static Occupation[] getOccupations(){
		final Occupation[] occs = new Occupation[3]; // $codepro.audit.disable numericLiterals
		occs[0] = new Banker();
		occs[1] = new Carpenter();
		occs[2] = new Farmer();  // $codepro.audit.disable numericLiterals
		return occs;
	}
	
	/**
	 * Get the label.
	 * @return String
	 */
	@Override
	public abstract String toString(); // $codepro.audit.disable overridingNonAbstractMethod
	
	/**
	 * Get starting money.
	 * @return int
	 */
	public abstract int getStartingMoney();
	
	/**
	 * Get description
	 * @return String
	 */
	public abstract String getDescription();
}