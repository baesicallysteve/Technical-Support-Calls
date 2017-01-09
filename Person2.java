/**
02.
* <p>Title: CSC 230 Project 3: Technical Support Calls</p>
03.
*
04.
* <p>Description:This program is a hash table that adds People who have technical support call
* 	whenever they use a call, it gets deducted. It implements a hash table and two different hashing functions
* 	</p>
05.
*
06.
* <p>Due 20 December 2016 11:59 pm</p>
07.
*
08.
* @author Steven Turner (Steven.Turner867@students.ncc.edu)
09.
*/
public class Person2 implements Person {
	//Two strings to hold the first and last name, one int to hold the amount of calls
	private String mfname;
	private String mlname;
	private int mcalls;
	
	//Default constructor, not important
	public Person2(){
		mfname = "FirstName";
		mlname = "LastName";
		mcalls = 5;
	}
	//Takes a String parameter. Splits it by the Space and makes the first name the first part and the last name the second part
	public Person2(String firstname, String lastname){
		mfname = firstname;
		mlname = lastname;
		mcalls = 5;
	}
	//Checks to see if calls have reached 0 
	@Override
	public boolean hasCalls() {
		return mcalls != 0;
	}
	//By adding a call, you are really subtracting how many calls you have left
	@Override
	public void addCalls() {
		mcalls--;
	}
	//Creates a hash code that is based on the String classes hash code for the first and last name.
	@Override
	public int hashCode(){
		int hash = 0;
		hash = mfname.hashCode() + mlname.hashCode();
		//Sometimes that hash code is a negative number, so this makes it positive
		if(hash < 0){
			hash = hash * -1;
		}
		return hash;
	}
	
	//Classic toString method
	@Override
	public String toString(){
		String str = "";
		str += mfname + " "+ mlname;
		str += " has " + mcalls + " remaining";
		return str;
	}
	
	
}
