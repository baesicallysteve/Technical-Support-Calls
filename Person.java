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
public interface Person {
	//All of these classes will be implemented in both Person1 and Person2
	public boolean hasCalls();
	public void addCalls();
	public int hashCode();
	public String toString();
}
