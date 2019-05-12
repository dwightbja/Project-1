package com.revature.beans;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int reimbursementID;
	private double reimbursementAmount;
	private Timestamp reimbursementSubmitted;
	private Timestamp reimbursementResolved;
	private String reimbursementDescription;
	private int reimbursementAuthorID;
	private int reimbursementResolverID;
	private int reimbursementStatusID;
	private int reimbursementTypeID;
	private String reimbursementReceipt;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbursementID, double reimbursementAmount, Timestamp reimbursementSubmitted,
			Timestamp reimbursementResolved, String reimbursementDescription, int reimbursementAuthorID,
			int reimbursementResolverID, int reimbursementStatusID, int reimbursementTypeID,
			String reimbursementReceipt) {
		super();
		this.reimbursementID = reimbursementID;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementSubmitted = reimbursementSubmitted;
		this.reimbursementResolved = reimbursementResolved;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementAuthorID = reimbursementAuthorID;
		this.reimbursementResolverID = reimbursementResolverID;
		this.reimbursementStatusID = reimbursementStatusID;
		this.reimbursementTypeID = reimbursementTypeID;
		this.reimbursementReceipt = reimbursementReceipt;
	}
	public Reimbursement(int reimbursementID, double reimbursementAmount, Timestamp reimbursementSubmitted,  String reimbursementDescription,
			int reimbursementAuthorID,int reimbursementResolverID, int reimbursementStatusID, int reimbursementTypeID, String reimbursementReceipt) {
		this.reimbursementID = reimbursementID;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementSubmitted = reimbursementSubmitted;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementAuthorID = reimbursementAuthorID;
		this.reimbursementResolverID = reimbursementResolverID;
		this.reimbursementStatusID = reimbursementStatusID;
		this.reimbursementTypeID = reimbursementTypeID;
		this.reimbursementReceipt = reimbursementReceipt;
	}

	public void Reimbursment(double reimbursementAmount, Timestamp reimbursementSubmitted, Timestamp reimbursementResolved, 
			int reimbursementAuthorID, String reimbursementDescription, int reimbursementResolverID, int reimbursementStatusID, int reimbursementTypeID,
			String reimbursementReceipt) {
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementSubmitted = reimbursementSubmitted;
		this.reimbursementResolved = reimbursementResolved;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementAuthorID = reimbursementAuthorID;
		this.reimbursementResolverID = reimbursementResolverID;
		this.reimbursementStatusID = reimbursementStatusID;
		this.reimbursementTypeID = reimbursementTypeID;
		this.reimbursementReceipt = reimbursementReceipt;
	}

	public int getReimbursementID() {
		return reimbursementID;
	}

	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}

	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public Timestamp getReimbursementSubmitted() {
		return reimbursementSubmitted;
	}

	public void setReimbursementSubmitted(Timestamp reimbursementSubmitted) {
		this.reimbursementSubmitted = reimbursementSubmitted;
	}

	public Timestamp getReimbursementResolved() {
		return reimbursementResolved;
	}

	public void setReimbursementResolved(Timestamp reimbursementResolved) {
		this.reimbursementResolved = reimbursementResolved;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	public int getReimbursementAuthorID() {
		return reimbursementAuthorID;
	}

	public void setReimbursementAuthorID(int reimbursementAuthorID) {
		this.reimbursementAuthorID = reimbursementAuthorID;
	}

	public int getReimbursementResolverID() {
		return reimbursementResolverID;
	}

	public void setReimbursementResolverID(int reimbursementResolverID) {
		this.reimbursementResolverID = reimbursementResolverID;
	}

	public int getReimbursementStatusID() {
		return reimbursementStatusID;
	}

	public void setReimbursementStatusID(int reimbursementStatusID) {
		this.reimbursementStatusID = reimbursementStatusID;
	}

	public int getReimbursementTypeID() {
		return reimbursementTypeID;
	}

	public void setReimbursementTypeID(int reimbursementTypeID) {
		this.reimbursementTypeID = reimbursementTypeID;
	}

	public String getReimbursementReceipt() {
		return reimbursementReceipt;
	}

	public void setReimbursementReceipt(String reimbursementReceipt) {
		this.reimbursementReceipt = reimbursementReceipt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbursementAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbursementAuthorID;
		result = prime * result + ((reimbursementDescription == null) ? 0 : reimbursementDescription.hashCode());
		result = prime * result + reimbursementID;
		result = prime * result + ((reimbursementReceipt == null) ? 0 : reimbursementReceipt.hashCode());
		result = prime * result + ((reimbursementResolved == null) ? 0 : reimbursementResolved.hashCode());
		result = prime * result + reimbursementResolverID;
		result = prime * result + reimbursementStatusID;
		result = prime * result + ((reimbursementSubmitted == null) ? 0 : reimbursementSubmitted.hashCode());
		result = prime * result + reimbursementTypeID;
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(reimbursementAmount) != Double.doubleToLongBits(other.reimbursementAmount))
			return false;
		if (reimbursementAuthorID != other.reimbursementAuthorID)
			return false;
		if (reimbursementDescription == null) {
			if (other.reimbursementDescription != null)
				return false;
		} else if (!reimbursementDescription.equals(other.reimbursementDescription))
			return false;
		if (reimbursementID != other.reimbursementID)
			return false;
		if (reimbursementReceipt == null) {
			if (other.reimbursementReceipt != null)
				return false;
		} else if (!reimbursementReceipt.equals(other.reimbursementReceipt))
			return false;
		if (reimbursementResolved == null) {
			if (other.reimbursementResolved != null)
				return false;
		} else if (!reimbursementResolved.equals(other.reimbursementResolved))
			return false;
		if (reimbursementResolverID != other.reimbursementResolverID)
			return false;
		if (reimbursementStatusID != other.reimbursementStatusID)
			return false;
		if (reimbursementSubmitted == null) {
			if (other.reimbursementSubmitted != null)
				return false;
		} else if (!reimbursementSubmitted.equals(other.reimbursementSubmitted))
			return false;
		if (reimbursementTypeID != other.reimbursementTypeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", reimbursementAmount=" + reimbursementAmount
				+ ", reimbursementSubmitted=" + reimbursementSubmitted + ", reimbursementResolved="
				+ reimbursementResolved + ", reimbursementDescription=" + reimbursementDescription
				+ ", reimbursementAuthorID=" + reimbursementAuthorID + ", reimbursementResolverID="
				+ reimbursementResolverID + ", reimbursementStatusID=" + reimbursementStatusID
				+ ", reimbursementTypeID=" + reimbursementTypeID + ", reimbursementReceipt=" + reimbursementReceipt
				+ "]";
	}
	
	
	
	
}