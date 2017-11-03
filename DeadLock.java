package synchronizedLock;//created pacakge as synchronizedLock
/**deadlock occurs when multiple threads needs the same locks but obtain them in different order**/
/**
 *Synchronization is the solution to prevents race conditions from happening.
 * The synchronized keyword places a lock on an important object or piece of code 
    to make sure that only one thread at a time will have access.
 **/

public class DeadLock {//created class as DeadLock
    //classes are the basics of opps(object oriented programming
	
	// Creates first method and extends runnable interface
	// t1 tries to lock resource1 then resource2  
	static class First_Thread implements Runnable { //first thread implementing runnable
		

		public void run() // Run method 
		 //Here public is a access modifier which defines who can access this method //Here public is a access modifier which defines who can access this method
		//void is used to define return type of the method,void means method wont return any value
		        {
			synchronized (Integer.class) { // Passing Integer class in a synchronized method
				System.out.println(Thread.currentThread().getName()+ " locked on integer class" );//system is used to return code
		           //out is a static member
		         	//Println is used to print text  and gives output 
				synchronized (String.class) {// Passing string class in a synchronized method
					System.out.println(Thread.currentThread().getName()+ "locked on string class");
				}
			}
			}
		}
	
	/*
	 * In second method , we are passing the Integer and string classes but in reverse order.
	 * That's why Creates method and extends runnable interface
	 * This will arise a deadlock. 
	 */

	// t2 tries to lock resource2 then resource1  
	static class Second_Thread implements Runnable {//second thread implementing runnable

		public void run() { //Here public is a access modifier which defines who can access this metho
			//void is used to define return type of the method,void means method wont return any value
			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName()+ " locked on string class");//system is used to return code
		           //out is a static member
		         	//Println is used to print text  and gives output 
				synchronized (Integer.class) {
					System.out.println(Thread.currentThread().getName()+ "locked on integer class");//system is used to return code
			           //out is a static member
			         	//Println is used to print text  and gives output 
				}
			}
		}

	}

	public static void main(String[] args) { //Creating main method 
		 //Here public is a access modifier which defines who can access this method
		//Here static a keyword which identifies class related thing
		//void is used to define return type of the method,void means method wont return any value
		//main is name of method
		//declares method String[]
		//String[]args means arguments will be passed into main method and says that main() as a parameter
		// Creating threads x
		Thread t1=new Thread(new First_Thread());
		Thread t2= new Thread(new Second_Thread());
		
		//Initializing thread with string arguments 
		t1.setName("First thread ");
		t2.setName("Second thread");
		// Starting Both threads
		t1.start();
		t2.start();
		
		
	
	
	
	}

}