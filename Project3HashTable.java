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

public class Project3HashTable {
	private Person[] mbucket; //Person Array to hold hashcodes 
	double msize; //Double number to hold size of the Hash Table
	int mbucketsize; // Size of the bucket 
	public Project3HashTable(){
		 mbucket = new Person[11]; //Creates a new Person array size 11.
		 msize = 0.0;
		 mbucketsize = mbucket.length;
	}
	
	//This method returns load factor in a double number.
	public double loadFactor(){
		return msize/mbucketsize;
	}
	//This method searches for a given person and returns that person if they are found
	//If they aren't found, it returns null.
	public Person search(Person p){
		boolean PersonFound = false;
		int hash = p.hashCode() % (mbucket.length-1); //Compresses the hash code.
		int counter = hash; //Creeates a disposable variable that holds hash value.
		while((PersonFound == false) && counter < mbucketsize){ //While the person isn't found and the counter is less than the bucketsize 
		if(mbucket[counter] == null){ //If the bucket you are looking in is null, increment
			counter++;
		}
		else if(mbucket[counter].hashCode() == p.hashCode()) //If Person's hash code is equal to the one you are searching for change PersonFound to true
			PersonFound = true;
		counter++;
		}
		//If Person found is true, change hash to the number at the counter, print the system error message and return p.
		if(PersonFound == true){
			hash = counter;
			System.err.println("Person found at bucket " + hash + " with a bucket size of "+ msize);
			return p;
		}
		else{
		return null;
		}
	}
	
	public void addtoSize(){
		msize++;
	}
	
	//Put puts a Person into the hash table.
	public void put(Person p){
		int personhash = p.hashCode();
		int hash = personhash % (mbucketsize-1); //Compresses hashcode
		if(p.hasCalls() == true){ //If the person has a has calls
			p.addCalls();//Add a new call
			if (loadFactor() < 0.5){ //If loadfactor isn't above thresh hold 
				while(mbucket[hash] != null){ //While mbucket isn't null, keep on incrementing
					hash++;
				}
				mbucket[hash] = p; //Add the person to the hash table
				addtoSize(); //Increment size.
			}
			//Above thresh hold
			else{
				Person[] tempbucket = new Person[mbucketsize * 2]; //Create a temporary bucket twice the size of the original bucket
				for(int i = 0; i < mbucketsize; i++){
					tempbucket[i] = mbucket[i];//Add every value to the new bucket 
				}
				mbucket = new Person[tempbucket.length]; //Double the size of bucket
				mbucketsize = mbucket.length;
				msize = 0.0; //Put the size of the bucket back to 0.
				for(int i = 0; i < mbucketsize; i++){
					if(tempbucket[i] != null){ //for every item in the temp bucket that isn't null
						//Rehash the value and put it back in the original bucket
					hash = tempbucket[i].hashCode() % (mbucketsize-1);
					mbucket[hash] = tempbucket[i];
					addtoSize();
					}
				}
				hash = p.hashCode() % (mbucketsize -1);//Compress the data.
				//Add it to the bucket array
				while(mbucket[hash] != null){
					hash++;
				}
				mbucket[hash] = p;
				msize++;
			}
		}
		//Print the person
		System.out.println(p.toString());
	}

	public int bucketLength(){
		return mbucket.length;
	}
}
