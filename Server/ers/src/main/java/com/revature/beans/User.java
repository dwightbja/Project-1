package com.revature.beans;

public class User {
	private int ersUserID;
	private String ersUserName;
	private String ersPassword;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userRole;
	private int userRoleID;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int ersUserID, int userRoleID, String ersUserName, String userFirstName, String userLastName) {
		this.ersUserID = ersUserID;
		this.ersUserName = ersUserName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userRoleID = userRoleID;
	}


	public User(int ersUserID, String ersUserName, String ersPassword, String userFirstName, String userLastName,
			String userEmail, String userRole, int userRoleID) {
		super();
		this.ersUserID = ersUserID;
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRole = userRole;
		this.userRoleID = userRoleID;
	}
     
	public User(String ersUserName, String ersPassword, int ersUserID) {
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.ersUserID = ersUserID;
	}

	public int getErsUserID() {
		return ersUserID;
	}


	public void setErsUserID(int ersUserID) {
		this.ersUserID = ersUserID;
	}


	public String getErsUserName() {
		return ersUserName;
	}


	public void setErsUserName(String ersUserName) {
		this.ersUserName = ersUserName;
	}


	public String getErsPassword() {
		return ersPassword;
	}


	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public int getUserRoleID() {
		return userRoleID;
	}


	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersPassword == null) ? 0 : ersPassword.hashCode());
		result = prime * result + ersUserID;
		result = prime * result + ((ersUserName == null) ? 0 : ersUserName.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + userRoleID;
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
		User other = (User) obj;
		if (ersPassword == null) {
			if (other.ersPassword != null)
				return false;
		} else if (!ersPassword.equals(other.ersPassword))
			return false;
		if (ersUserID != other.ersUserID)
			return false;
		if (ersUserName == null) {
			if (other.ersUserName != null)
				return false;
		} else if (!ersUserName.equals(other.ersUserName))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (userRoleID != other.userRoleID)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [ersUserID=" + ersUserID + ", ersUserName=" + ersUserName + ", ersPassword=" + ersPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRole=" + userRole + ", userRoleID=" + userRoleID + "]";
	}
	
	
	
	
	

}