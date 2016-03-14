package oop_bookmart;

public abstract class Member {
	
	private int memberID;
	private String memberFName;
	private String memberMidIni;
	private String memberLName;
	private String memberEmail;
	private String memberPasswd;
	private double memberFee;
	private boolean isAdmin;
	private boolean isStudent;
	private boolean isFaculty;
	private String memberPaypalID;
	
	/*
	public Member()
	{
		memberID = 500;
		memberFName = "Member1";
		memberMidIni = "n";
		memberLName = "None";
		memberEmail = "member1@bookmart.com";
		memberPasswd = "memPass1";
		memberFee = 0.0;
		
	}
	*/
	
	public Member(int memberID, String memberFName, String memberMidIni,
			String memberLName, String memberEmail, String memberPasswd,
			boolean isStudent, boolean isFaculty, String memberPaypalID)
	{
		this.memberID = memberID;
		this.memberFName = memberFName;
		this.memberMidIni = memberMidIni;
		this.memberLName = memberLName;
		this.memberEmail = memberEmail;
		this.memberPasswd = memberPasswd;
		this.isAdmin = false;
		this.isStudent = isStudent;
		this.isFaculty = isFaculty;
		this.memberPaypalID = memberPaypalID;
	}
	
	//Set member ID
	public void setMemberID(int memberID) { this.memberID = memberID; }
	
	//Set member first name
	public void setMemberFName(String memberFName) { this.memberFName = memberFName; }
	
	//Set member middle initial
	public void setMemberMidIni(String memberMidIni) { this.memberMidIni = memberMidIni; }
	
	//Set member last name
	public void setMemberLName(String memberLName) { this.memberLName = memberLName; }
	
	//Set member email address
	public void setMemberEmail(String memberEmail) { this.memberEmail = memberEmail; }
	
	//Set member password
	public void setMemberPasswd(String memberPasswd) { this.memberPasswd = memberPasswd; }
	
	//Set member's monthly fee
	public void setMemberFee(double memberFee) { this.memberFee = memberFee; }
	
	//Set member's status of student
	public void setIsStudent(boolean isStudent) { this.isStudent = isStudent; }
	
	//Set member's status of faculty
	public void setIsFaculty(boolean isFaculty) { this.isStudent = isFaculty; }
	
	//Set paypal ID
	public void setPaypalID(String memberPaypalID) { this.memberPaypalID = memberPaypalID; }
	
	
	//Get member ID
	public int getMemberID() { return memberID; }
	
	//Get member first name
	public String getMemberFName() { return memberFName; }
	
	//Get member middle initial
	public String getMemberMidIni() { return memberMidIni; }
	
	//Get member last name
	public String getMemberLName() { return memberLName; }
	
	//Get member email address
	public String getMemberEmail() { return memberEmail; }
	
	//Get member password
	public String getMemberPasswd() { return memberPasswd; }
	
	//Get member fee
	public double getMemberFee() { return memberFee; }
	
	//Get isAdmin value
	public boolean getIsAdmin() { return isAdmin; }
	
	//Get member status
	public boolean getIsStudent() { return isStudent; }
	
	public boolean getIsFaculty() { return isFaculty; }
	
	//Get paypal ID
	public String getPaypalID() { return memberPaypalID; }
	
	//Override toString
	@Override
	public String toString()
	{
		return "User Information\n" + 
				"Member ID: " + memberID + "\n" +
				"First name: " + memberFName + "\n" +
				"Middle Initial : " + memberMidIni + "\n" +
				"Last Name: " + memberLName + "\n" +
				"Email address: " + memberEmail + "\n" +
				"Monthly fee: " + memberFee + "\n" +
				"Member is student: " + isStudent + "\n" +
				"Member is faculty: " + isFaculty;
		
	}
}
