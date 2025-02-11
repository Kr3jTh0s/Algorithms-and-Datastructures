public class QueueTest {

    // ------- Linked Queue ---------
    /* */
    public static long queueBench(int n, int h){
        Queue<Integer> q = new LinkedQueue<Integer>();
        for(int i = 0; i < n; i++) q.enqueue(i);

        long t0 = System.nanoTime();
        //for(int i = 0; i < n; i++) q.enqueue(i);
        //for(int i = 0; i < n; i++) q.dequeue();
        q.dequeue();
        long t1 = System.nanoTime();

        //System.out.print(" q: " + (h + 1) + " | ");
        //System.out.println(q);

        return (t1 - t0);
    }
    //*/

    /* */
    private static long linkedQueueBench(int n, int loop){
        /* */
        long t = 0;
        for(int i = 0; i < loop; i++) 
            t += queueBench(n, i);
        return (t);
        //*/
    }
    //*/

    
    public static void main(String[] args){

        // Test
        /* *
        System.out.println();
        long t = linkedQueueBench(10, 5);
        System.out.println(t);
        //*/

        // Linked Queue -------
        /* */
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25400, 51200};
        
        int loop = 1000;
        int k = 10;

        // JIT warmup
        linkedQueueBench(10000, 10000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = linkedQueueBench(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        //System.out.println("-----------------------------");
        //*/
    }
}
