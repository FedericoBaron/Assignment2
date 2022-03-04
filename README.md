# Assignment2
COP4520 Assignment 2

## Program 1:

### Strategy:

For the first program, in which we have the cupcake at the end of the labyrinth, I decided to use locks to create ensure that only one guest enters the room at a time. There will be a counter which is the first guest (thread) and this person will check if there is a cupcake or not. If there is no cupcake we will increase the counter and request another cupcake. The guests will enter the room when the minotaur picks their number and once in the room we will check if we already had a cupcake. If we haven't yet had a cupcake, and there's a cupcake already there, we will eat a cupcake. The counter will be the only one allowed to request a cupcake, all the other guests can only eat a cupcake, and only if they haven't had one already.

### Correctness, Efficiency and Evaluation:

### How to run

To run the program download pa2cop4520p1v2.java and in your terminal CD into the directory that file resides in. Once there, write "javac pa2cop4520p1v2.java", followed by "java pa2cop4520p1v2". After that, the program will start running and will ask you how many guests are attending the Minatour's party. Input an integer, and the program will run accounting for that number of guests. The output will be written into the terminal and it will print "Party is over. Thank you for coming!" as well as the execution time. 

Program 2: 

### Strategy

For the second program, in which we are going to see the Minotaur's vase, we are using the third strategy of using a queue. I selected this strategy as it would allow the guests to line up and get their turn in a fair way. The first strategy of just letting the guests check if the room is available would probably make some guests frustrated as there's a chance they won't get to see the vase for a while. With the second strategy of having a "busy" or "available" sign is a little better than the first strategy as guests will know that the room is busy or available but it still might lead to some guests not getting to see the vase for a while if they happen to get unlucky and the room gets occupied before they get a chance to enter every time. The third approach of using the queue means guests will have to wait for their turn in a queue which is time consuming, but the benefit of knowing everyone will get their turn if they wait is more fair than that of the other approaches. 

### Correctness, Efficiency, and Evaluation

### How to run

To run the program download pa2cop4520p2.java and in your terminal CD into the directory that file resides in. Once there, write "javac pa2cop4520p2.java", followed by "java pa2cop4520p2". After that, the program will start running and will ask you "How many guests are in the party?" and then "How many seconds will the party last?". After you input the responses for these 2 questions, the program will print "Party started!". Once the party starts, it will run for the amount of seconds you specified, letting the guests line up to see the vase. Once the party is over, the program will print "Party is over. Thank you for coming!".


