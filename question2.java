import java.util.Scanner;
public class question2 {
	
//	Write a multithreaded program that outputs prime numbers. This
//	program should work as follows: The user will run the program and
//	will enter a number on the command line. The program will then create
//	a separate thread that outputs all the prime numbers less than or equal
//	to the number entered by the user. (You can use Java or C)
	
	//https://github.com/LC-CUNY/Programming_HW0/blob/master/Programming%20hw.pdf
	
	
	
	 public static void main(String[] args) {
		 
		 //Creates scanner and asks for a Number input then sets that input to int n.
	      Scanner scanner = new Scanner(System.in);
	      System.out.println("Enter the value of n:");
	      int n = scanner.nextInt();
	      scanner.close();
	      
	      
	      
	      //here it creates a threads, myThread1 will calculate the first half myThread2 will calculate the second half on prime numbers
	      ExecutorThread myThread1 = new ExecutorThread(n, 1, n/2);
	      ExecutorThread myThread2 = new ExecutorThread(n, n/2, n);
		 
	      //Threads are started
	      myThread1.start();
	      myThread2.start();
		 
		  }
	 
	 public static class ExecutorThread extends Thread {
		 
		 //creating the parameters for the thread. 
		  int Plimit =0;
		  int Max;
		  int posInitial;
		  int posFinal;
		  
		  
		  //sets parameters
		  public ExecutorThread (int Max, int posInitial, int posFinal) {
			  
			  Plimit = Max;
			  this.Max = Max;
			  this.posInitial = posInitial;
			  this.posFinal = posFinal;
		  
		  }
		  
		  public void run() {
			  String primeNumbers = "";
			  
			  
			  //here it calculates the prime numbers for which individual thread.
			  for (int i = posInitial; i < posFinal; i++)  	   
		      { 		 		  
		         int counter=0; 		  
		         for(int num =i; num>=1; num--)
		         {
			    if(i%num==0)
			    	{
			    	counter = counter + 1;
			    	}
		         }
		         if (counter ==2)
			 		{
		        	 //Appended the Prime number to the String
		        	 primeNumbers = primeNumbers + i + " ";
			 		}	
		         }
			  System.out.println("Prime numbers from 1 to n are :");
		      System.out.println(primeNumbers);
		  }
	      	
	 }

}
