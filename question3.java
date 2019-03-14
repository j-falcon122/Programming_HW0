import java.io.IOException;
import java.util.Scanner;

//  Write a multithreaded program that calculates various statistical values
//  for a list of numbers. This program will be passed a series of numbers on
//  the command line and will then create three separate worker threads.
//  One thread will determine the average of the numbers, the second
//  will determine the maximum value, and the third will determine the
//  minimum value. For example, suppose your program is passed the
//  integers
//  90 81 78 95 79 72 85
//  The program will report
//  The average value is 82
//  The minimum value is 72
//  The maximum value is 95
//  The variables representing the average, minimum, and maximum values
//  will be stored globally. The worker threads will set these values, and the
//  parent thread will output the values once the workers have exited. (We
//  could obviously expand this program by creating additional threads
//  that determine other statistical values, such as median and standard
//  deviation.) (You can use Java or C)
    
    //https://github.com/LC-CUNY/Programming_HW0/blob/master/Programming%20hw.pdf

class NumMax extends Thread { // Create thread to find max
    int[] numArray;
    int max;

    public NumMax(int numArr[]) {
        this.numArray = numArr;
        this.max = this.numArray[0];
    }
    public void run() {
        for (int i = 0; i < this.numArray.length; i++ ) {
            if (this.numArray[i] > max) {
                max = this.numArray[i];
            }
        }
        System.out.println("Maximum: "+max);
    }
}
class NumMin extends Thread { // Create thread to find min
    int[] numArray;
    int min;

    public NumMin(int numArr[]) { 
        this.numArray = numArr;
        this.min = this.numArray[0];
    }

    public void run() {
        for (int i = 0; i < this.numArray.length; i++ ) {
            if (this.numArray[i] < min) {
                min = this.numArray[i];
            }
        }
        System.out.println("Minimum: "+min);
    }
}
class NumAvg extends Thread { // Create thread to find average
    int[] numArray;
    int avg;

    public NumAvg(int numArr[]) {
        this.numArray = numArr;
        this.avg = this.numArray[0];
    }

    public void run() {
        int sum = 0;
        for (int i = 0; i < this.numArray.length; i++ ) {
            sum += this.numArray[i];
        }
        avg = sum/this.numArray.length;
        System.out.println("Average: "+avg);
    }
}


public class question3 {

    public static void main(String args[]) { // Main method that will envoke the program
        System.out.println("Enter numbers separated by a comma. Ex: 2, 433, 54, 665, 44, 2"); // Prompt the user for input
        Scanner scanner = new Scanner(System.in);
        String numScanned = scanner.nextLine(); // Input from user
        scanner.close();

        int[] numArray = parser(numScanned); // Parse the string inputted from user into a int array

        NumMax thread_max = new NumMax(numArray); 
        NumMin thread_min = new NumMin(numArray);
        NumAvg thread_avg = new NumAvg(numArray);

        thread_max.start(); // Start max thread
        thread_min.start(); // Start min thread
        thread_avg.start(); // Start avg thread
   }


   public static int[] parser(String num){ // Convert inputted string into an int array
        String[] numStrArray = num.split(",");
        int[] numArray = new int[numStrArray.length];

        for (int i = 0; i < numStrArray.length; i++ ) {
            numArray[i] = Integer.parseInt(numStrArray[i].replaceAll("\\s+","")); // Parse String element - Remove whitespaces
        }
        return numArray;

    }
}
