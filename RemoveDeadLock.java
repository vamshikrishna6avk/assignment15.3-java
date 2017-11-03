package synchronizedLock;//created package as synchronizedLock
/**
 *Synchronization is the solution to prevents race conditions from happening.
 * The synchronized keyword places a lock on an important object or piece of code 
    to make sure that only one thread at a time will have access.
 **/


public class RemoveDeadLock {//created class as RemoveDeadLock
    //classes are the basics of opps(object oriented programming)
	static class First_Thread implements Runnable {//implementing Runnable

		public void run() { //Here public is a access modifier which defines who can access this method
			//void is used to define return type of the method,void means method wont return any value
			
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + "locked on Integer class");//system is used to return code
		           //out is a static member
		         	//Println is used to print text  and gives output 
				synchronized (String.class) {
					System.out.println(Thread.currentThread().getName() + "locked on String class");//system is used to return code
			           //out is a static member
		         	//Println is used to print text  and gives output 
				}
			}
		}
	}
	/*
	 * In second method , we are passing the Integer and string classes but in same order 
	 */

	static class Second_Thread implements Runnable {

		public void run() { //Here public is a access modifier which defines who can access this metho
			//void is used to define return type of the method,void means method wont return any value
		
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + "locked on Integer class");//system is used to return code
		           //out is a static member
	         	//Println is used to print text  and gives output 
				synchronized (String.class) {
					System.out.println(Thread.currentThread().getName() + "locked on Integer class");//system is used to return code
			           //out is a static member
		         	//Println is used to print text  and gives output 
				}
			}
		}

	}

	/**
	 * here we create the main method then create the two thread for calling the
	 * method run
	 */
	public static void main(String[] args) { //Here public is a access modifier which defines who can access this method
		//Here static a keyword which identifies class related thing
		//void is used to define return type of the method,void means method wont return any value
		//main is name of method
		//declares method String[]
		//String[]args means arguments will be passed into main method and says that main() as a parameter
		Thread t1=new Thread(new First_Thread());//created new threads
		Thread t2= new Thread(new Second_Thread());
		t1.setName("First thread ");//naming two threads 
		t2.setName("Second thread");
		t1.start();//starts
		t2.start();
		
	}



} 