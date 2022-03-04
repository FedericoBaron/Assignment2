import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class pa2cop4520p1v2 {

    public static AtomicInteger currentIndex = new AtomicInteger(0);
    public static boolean isPartyOver = false;
    public static int currentGuest;
    public static int numGuests;
    public static boolean hasCake = true;
    public static int numCupcakesEaten = 0;
    public static ReentrantLock lock = new ReentrantLock();
    
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("How many guests do you want to invite?");
        numGuests = kb.nextInt();
        long timeStart = System.currentTimeMillis();
        currentGuest = ((int)(Math.random() * numGuests));

        ExecutorService service = Executors.newFixedThreadPool(numGuests);
        for(int i = 0; i < numGuests; i++){
            service.submit(new AddGuest());
        }
        
        service.shutdown();

        try{service.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);

        } catch(Throwable e) {
            System.out.println(e);
        }
        
        kb.close();
        System.out.println("Party is over. Thank you for coming!");
        long timeEnd = System.currentTimeMillis();
        System.out.println("Execution time: " + ((timeEnd - timeStart)/1000) + "s");
    }

    static class AddGuest extends pa2cop4520p1v2 implements Runnable {

        public void run(){
            int n = currentIndex.getAndIncrement();
            boolean isCounter = false;
            int count = 0;
            boolean hasHadCupcake = false;

            if(n == 0){
                isCounter = true;
            }

            while(!isPartyOver){
                // enter labyrinth
                lock.lock();
                if(currentGuest == n){
                    if(isCounter){
                        if(hasCake == false){
                            count++;
                            
                            //request new cupcake
                            hasCake = true;
                            
                            // check if all guests have entered labyrinth
                            if(count == numGuests - 1){
                                isPartyOver = true;
                            }
                        }
                    }
                    else if(!hasHadCupcake && hasCake == true){
                        // eat cupcake
                        hasCake = false;

                        // guest ate cupcake
                        hasHadCupcake = true;
                    }

                    // Minotaur selects a new random guest to join the labyrinth
                    currentGuest = ((int)(Math.random() * numGuests));
                }
                lock.unlock();
            }
        }
    }
}
