#include <stdio.h>
#include <unistd.h> 
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

/* The Collatz conjecture concerns what happens when we take any
	positive integer n and apply the following algorithm:
	n={n / 2 , if n is even
	3 * n + 1 , if n is odd

	The conjecture states that when this algorithm is continually applied,
	all positive integers will eventually reach 1. For example, if n = 35, the
	sequence is
	35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1

	Write a C program using the fork() system call that generates this
	sequence in the child process. The starting number will be provided
	from the command line. For example, if 8 is passed as a parameter on
	the command line, the child process will output 8, 4, 2, 1. Because the
	parent and child processes have their own copies of the data, it will be
	necessary for the child to output the sequence. Have the parent invoke
	the wait() call to wait for the child process to complete before exiting
	the program. Perform necessary error checking to ensure that a positive
	integer is passed on the command line.
	
	https://github.com/LC-CUNY/Programming_HW0/blob/master/Programming%20hw.pdf */

// set up function for calculation
void collatzSeq(int num)
{
     // print the number user input with tabbed spacing
          printf("\t %d", num);

     // greater than 1 because they eventually have to reach 1
     while (num > 1)
     {
          // n / 2 , if n is even
          if (num % 2 == 0)
          {
               num = num / 2;
          }
          else
          {
               // 3 * n + 1 , if n is odd
               num = 3 * num + 1;
          }

          // print the number again until it reaches 1
          printf("\t %d", num);
     }
}

int main()
{
     // declare user input
     int num;
     // declare process id
     int pid;

     do
     {
          // get input number from user to pass to collatz
          printf("\n Enter a number greater than zero: ");
          // accept next user input as num
          scanf("%d", &num);

     } while (num <= 0); // conditional that checks for greater than zero

     // process id is initialized to fork()
     pid = fork();

     // check if process id fork is less than zero to catch failure
     if (pid < 0)
     {
          printf("\n Fork process failed to execute.");
          // exit program
          exit(1);
     }

     // check if process id fork is zero (which is what makes it a parent process)
     if (pid == 0)
     {
          // now created a child process
          printf("...child process number %d started...\n", getpid() );

          // begin collatz sequence calculation
          collatzSeq(num);

          // completed sequence
          printf("\nChild process is done.\n");
     }
     else
     {
          // if process id fork is not equal to zero, then it is busy and must wait
          printf("Parent process is busy waiting on child process to complete...\n");

          // invoke the wait function for the process id to wait for child to finish
          wait(NULL);

          printf("Parent process is done.\n");
     }

     return 0;
}