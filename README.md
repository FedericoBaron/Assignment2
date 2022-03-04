# Assignment 2

## Program 1: Minotaur’s Birthday Party (50 points)

The Minotaur invited N guests to his birthday party. When the guests arrived, he made the following announcement.

The guests may enter his labyrinth, one at a time and only when he invites them to do so. At the end of the labyrinth, the Minotaur placed a birthday cupcake on a plate. When a guest finds a way out of the labyrinth, he or she may decide to eat the birthday cupcake or leave it. If the cupcake is eaten by the previous guest, the next guest will find the cupcake plate empty and may request another cupcake by asking the Minotaur’s servants. When the servants bring a new cupcake the guest may decide to eat it or leave it on the plate.

The Minotaur’s only request for each guest is to not talk to the other guests about her or his visit to the labyrinth after the game has started. The guests are allowed to come up with a strategy prior to the beginning of the game. There are many birthday cupcakes, so the Minotaur may pick the same guests multiple times and ask them to enter the labyrinth. Before the party is over, the Minotaur wants to know if all of his guests have had the chance to enter his labyrinth. To do so, the guests must announce that they have all visited the labyrinth at least once.

Now the guests must come up with a strategy to let the Minotaur know that every guest entered the Minotaur’s labyrinth. It is known that there is already a birthday cupcake left at the labyrinth’s exit at the start of the game. How would the guests do this and not disappoint his generous and a bit temperamental host?

Create a program to simulate the winning strategy (protocol) where each guest is represented by one running thread. In your program you can choose a concrete number for N or ask the user to specify N at the start.

### Strategy:

For the first program, in which we have the cupcake at the end of the labyrinth, I decided to use locks to create ensure that only one guest enters the room at a time. There will be a counter which is the first guest (thread) and this person will check if there is a cupcake or not. If there is no cupcake we will increase the counter and request another cupcake. The guests will enter the room when the minotaur picks their number and once in the room we will check if we already had a cupcake. If we haven't yet had a cupcake, and there's a cupcake already there, we will eat a cupcake. The counter will be the only one allowed to request a cupcake, all the other guests can only eat a cupcake, and only if they haven't had one already.

### Correctness, Efficiency and Evaluation:

Correctness is ensured by using the counter to count how many guests have definitely visited the maze by looking at whether there's a cupcake or not. I also ensured correctness by testing the program and seeing that all the guests do get in the maze and that the counter is accurate. 

The efficiency of the program is roughly N^2, N being the number of guests, since the counter will on average only be able to check once every N turns. 

The program using locks was able bring the runtime down to 15 seconds from around 3 minutes when simply using Atomics and no locks. I used a ReentrantLock in order to ensure that the variables weren't accessed by many threads at the same time. 

### How to run

To run the program download pa2cop4520p1v2.java and in your terminal CD into the directory that file resides in. Once there, write "javac pa2cop4520p1v2.java", followed by "java pa2cop4520p1v2". After that, the program will start running and will ask you how many guests are attending the Minatour's party. Input an integer, and the program will run accounting for that number of guests. The output will be written into the terminal and it will print "Party is over. Thank you for coming!" as well as the execution time. 

## Program 2: Minotaur’s Crystal Vase (50 points)

The Minotaur decided to show his favorite crystal vase to his guests in a dedicated showroom with a single door. He did not want many guests to gather around the vase and accidentally break it. For this reason, he would allow only one guest at a time into the showroom. He asked his guests to choose from one of three possible strategies for viewing the Minotaur’s favorite crystal vase:

1) Any guest could stop by and check whether the showroom’s door is open at any time and try to enter the room. While this would allow the guests to roam around the castle and enjoy the party, this strategy may also cause large crowds of eager guests to gather around the door. A particular guest wanting to see the vase would also have no guarantee that she or he will be able to do so and when.

2) The Minotaur’s second strategy allowed the guests to place a sign on the door indicating when the showroom is available. The sign would read “AVAILABLE” or “BUSY.” Every guest is responsible to set the sign to “BUSY” when entering the showroom and back to “AVAILABLE” upon exit. That way guests would not bother trying to go to the showroom if it is not available.

3) The third strategy would allow the quests to line in a queue. Every guest exiting the room was responsible to notify the guest standing in front of the queue that the showroom is available. Guests were allowed to queue multiple times.

Which of these three strategies should the guests choose? Please discuss the advantages and disadvantages.

Implement the strategy/protocol of your choice where each guest is represented by 1 running thread. You can choose a concrete number for the number of guests or ask the user to specify it at the start.

### Strategy

For the second program, in which we are going to see the Minotaur's vase, we are using the third strategy of using a queue. I selected this strategy as it would allow the guests to line up and get their turn in a fair way. The first strategy of just letting the guests check if the room is available would probably make some guests frustrated as there's a chance they won't get to see the vase for a while. With the second strategy of having a "busy" or "available" sign is a little better than the first strategy as guests will know that the room is busy or available but it still might lead to some guests not getting to see the vase for a while if they happen to get unlucky and the room gets occupied before they get a chance to enter every time. The third approach of using the queue means guests will have to wait for their turn in a queue which is time consuming, but the benefit of knowing everyone will get their turn if they wait is more fair than that of the other approaches. 

### Correctness, Efficiency, and Evaluation

The correctness of the program is ensured by using the queue to make sure that the guests enter if they're in front of the queue and by using an AtomicBoolean that checks if the room is available. 

The efficiency of this program is roughly O(N), N being the number of guests since we just join a queue and go through it. However, the way the program is implemented is to run for x amount of seconds, x being the length of the party. So the program will always run for x amount of time. 

The program is using a ArrayBlockingQueue is very efficient since this queue has a fixed size N, with N being the number of guests so that it never overflows but also doesn't need to adjust its size.

### How to run

To run the program download pa2cop4520p2.java and in your terminal CD into the directory that file resides in. Once there, write "javac pa2cop4520p2.java", followed by "java pa2cop4520p2". After that, the program will start running and will ask you "How many guests are in the party?" and then "How many seconds will the party last?". After you input the responses for these 2 questions, the program will print "Party started!". Once the party starts, it will run for the amount of seconds you specified, letting the guests line up to see the vase. Once the party is over, the program will print "Party is over. Thank you for coming!".


