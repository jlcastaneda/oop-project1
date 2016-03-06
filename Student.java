package oop_bookmart;

public class Student extends Member{
	
	public double memberFee = 7.99;
	
	Student(int memberID, String memberFName, String memberMidIni, String memberLName,
			String memberEmail, String memberPasswd)
	{
		super(memberID, memberFName, memberMidIni, memberLName, memberEmail, memberPasswd);
		super.setMemberFee(memberFee);
	}
	
	//Override toString method
	@Override
	public String toString()
	{

		return "Student Information\n" + 
				"Member ID: " + getMemberID() + "\n" +
				"First name: " + getMemberFName() + "\n" +
				"Middle Initial : " + getMemberMidIni() + "\n" +
				"Last Name: " + getMemberLName() + "\n" +
				"Email address: " + getMemberEmail() + "\n" +
				"Monthly fee: " + memberFee + "\n";
	}
	
	

}
