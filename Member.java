package oop_bookmart;

public abstract class Member {
	
	private int memberID;
	private String memberFName;
	private String memberMidIni;
	private String memberLName;
	private String memberEmail;
	private String memberPasswd;
	private double memberFee;
	
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
			String memberLName, String memberEmail, String memberPasswd)
	{
		this.memberID = memberID;
		this.memberFName = memberFName;
		this.memberMidIni = memberMidIni;
		this.memberLName = memberLName;
		this.memberEmail = memberEmail;
		this.memberPasswd = memberPasswd;
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
				"Monthly fee: " + memberFee + "\n";
	}
}
