package oop_bookmart;

public class Faculty extends Member{

	public double memberFee = 9.99;
	
	Faculty(int memberID, String memberFName, String memberMidIni, String memberLName,
			String memberEmail, String memberPasswd)
	{
		super(memberID, memberFName, memberMidIni, memberLName, memberEmail, memberPasswd);
		super.setMemberFee(memberFee);
	}
	
	//Override toString method
	@Override
	public String toString()
	{

		return "Faculty Information\n" + 
				"Member ID: " + getMemberID() + "\n" +
				"First name: " + getMemberFName() + "\n" +
				"Middle Initial : " + getMemberMidIni() + "\n" +
				"Last Name: " + getMemberLName() + "\n" +
				"Email address: " + getMemberEmail() + "\n" +
				"Monthly fee: " + memberFee + "\n";
	}
	
	
	

}
