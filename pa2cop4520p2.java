import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class pa2cop4520p2{

    public static final AtomicBoolean isRoomAvailable = new AtomicBoolean(true);
    public static ArrayBlockingQueue<Integer> queue;
    public static AtomicInteger currentIndex = new AtomicInteger(0);
    public static int numSeconds;
    public static long timeStart;
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("How many guests are in the party?");
        int numGuests = kb.nextInt();
        queue = new ArrayBlockingQueue<Integer>(numGuests);
        System.out.println("How many seconds will the party last?");
        numSeconds = kb.nextInt();
        System.out.println("Party started!");
        timeStart = System.currentTimeMillis();

        ExecutorService service = Executors.newFixedThreadPool(numGuests);
        for(int i = 0; i < numGuests; i++){
            service.submit(new JoinQueue());
        }

        while(System.currentTimeMillis() < timeStart + (numSeconds * 1000)){

        }

        service.shutdown();
        kb.close();
        System.out.println("Party is over. Thank you for coming!");
    }

    static class JoinQueue extends pa2cop4520p2 implements Runnable {

        public void run(){
            int num = currentIndex.getAndIncrement();
            boolean isInRoom = false;
            boolean isInQueue = false;

            while(System.currentTimeMillis() < timeStart + (numSeconds * 1000)){

                // if we are in the room, leave 
                if(isInRoom){
                    isInRoom = false;
                    isRoomAvailable.set(true);
                }
                // if we are not in the queue, join it 
                else if(isInQueue == false){
                    queue.add(num);
                    isInQueue = true;
                }
                // if room is available and we're up next, join queue 
                else if(isRoomAvailable.get() && queue.peek() == num){
                    isRoomAvailable.set(false);
                    isInRoom = true;
                    isInQueue = false;
                    queue.remove();
                }
            }
        }
    }

}
