import java.io.IOException;
import java.util.Scanner;

//	Write a multithreaded program that calculates various statistical values
//	for a list of numbers. This program will be passed a series of numbers on
//	the command line and will then create three separate worker threads.
//	One thread will determine the average of the numbers, the second
//	will determine the maximum value, and the third will determine the
//	minimum value. For example, suppose your program is passed the
//	integers
//	90 81 78 95 79 72 85
//	The program will report
//	The average value is 82
//	The minimum value is 72
//	The maximum value is 95
//	The variables representing the average, minimum, and maximum values
//	will be stored globally. The worker threads will set these values, and the
//	parent thread will output the values once the workers have exited. (We
//	could obviously expand this program by creating additional threads
//	that determine other statistical values, such as median and standard
//	deviation.) (You can use Java or C)
	
	//https://github.com/LC-CUNY/Programming_HW0/blob/master/Programming%20hw.pdf

public class question3 {
    public static void main(String[] args) 
    { 
        System.out.println("Enter numbers separated by a comma. Ex: 2, 433, 54, 665, 44, 2");   
        Scanner scanner = new Scanner(System.in);
        String numScanned = scanner.nextLine();
        //System.out.println(numScanned);

        parser(numScanned);
    } 

    public static void parser(String num){
        String[] numStrArray = num.split(",");
        int[] numArray = new int[numStrArray.length];

        for (int i = 0; i < numStrArray.length; i++ ) {
            numArray[i] = Integer.parseInt(numStrArray[i]);
        }
        

        System.out.println("Maximum: "+numMax(numArray));
        System.out.println("Minimum: "+numMin(numArray));
        System.out.println("Average: "+numMean(numArray));
    }

    public static int numMax(int numArr[]) {
        int max = numArr[0];
        for (int i = 0; i < numArr.length; i++ ) {
            if (numArr[i] > max) {
                max = numArr[i];
            }
        }
            return max;
    }

    public static int numMin(int numArr[]) {
        int min = numArr[0];
        for (int i = 0; i < numArr.length; i++ ) {
            if (numArr[i] < min) {
                min = numArr[i];
            }
        }
            return min;
    }

    public static int numMean(int numArr[]) {
        int sum = 0;
        for (int i = 0; i < numArr.length; i++ ) {
            sum += numArr[i];
        }

        return (sum/numArr.length);
    }

} 
