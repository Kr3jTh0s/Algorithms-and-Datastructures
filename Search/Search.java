import java.util.Random;

public class Search {
    
    // Unsorted search
    /* */
    public static boolean unsorted_srch(int[] array, int key){
        for(int index = 0; index < array.length; index++)
            if(array[index] == key) return true;
        
        return false;
    }
    //*/

    /* */
    private static long searchUnsorted(int n, int loop){
        Random rnd = new Random();

        int[] array = new int[n];
        for(int i = 0; i < n; i++) array[i] = rnd.nextInt(n*2);

        int[] keys = new int[loop];
        for(int k = 0; k < loop; k++) keys[k] = rnd.nextInt(n*2);

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++){
            int key = keys[i];
            unsorted_srch(array, key);
        }
        long t1 = System.nanoTime();
        return (t1 - t0);
    }
    //*/

    // Sorted search
    /* */
    public static boolean sorted_srch(int[] array, int key){
        for(int index = 0; index < array.length; index++){
            if(array[index] >= key) return true;
        }
        
        return false;
    }
    //*/

    /* */
    public static int[] sort_array(int n, Random rnd){
        int[] array = new int[n];
        int nxt = 0;
        for(int i = 0; i < n; i++){
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt; 
        }
        return array;
    }
    //*/

    /* */
    private static long searchSorted(int n, int loop){
        Random rnd = new Random();

        int[] array = sort_array(n, rnd);

        int[] keys = new int[loop];
        for(int k = 0; k < loop; k++) keys[k] = rnd.nextInt(n*10);

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++){
            int key = keys[i];
            sorted_srch(array, key);
        }
        long t1 = System.nanoTime();
        return (t1 - t0);
    }
    //*/

    // Binary search
    /* */
    public static boolean binary_srch(int[] array, int key){
        int first = 0;
        int last = array.length - 1;

        while(true){
            int index = (first + last)/2;

            if(array[index] == key) return true;
            
            if(array[index] < key && index < last){
                first = index + 1;
                continue;
            }

            else if(array[index] > key && index > first){
                last = index - 1;
                continue;
            }

            else return false;
        }
    }
    //*/

    /* */
    private static long searchBinary(int n, int loop){
        Random rnd = new Random();

        int[] array = sort_array(n, rnd);

        int[] keys = new int[loop];
        for(int k = 0; k < loop; k++) keys[k] = rnd.nextInt(n*10);

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++){
            int key = keys[i];
            binary_srch(array, key);
        }
        long t1 = System.nanoTime();
        return (t1 - t0);
    }
    //*/

    public static void main(String[] args) {
        
        // Test 1
        /* *
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 254000, 512000, 1024000};

        int loop = 1000;
        int k = 10;

        // JIT warmup
        searchUnsorted(10000, 1000000);

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = searchUnsorted(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        System.out.println("-----------------------------");
        //*/

        // Test 2
        /* *
        //int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 254000, 512000, 1024000};

        //int loop = 1000;
        //int k = 10;

        // JIT warmup
        searchSorted(10000, 1000000);

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = searchSorted(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        System.out.println("-----------------------------");
        //*/

        // Test 3
        /* */
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 254000, 512000, 1024000};

        int loop = 1000;
        int k = 10;

        // JIT warmup
        searchBinary(10000, 1000000);

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = searchBinary(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        //*/

        // Test ?
        /* *
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25400, 51200};
        int[] loops = {1000, 1000, 1000, 1000, 10, 10, 10, 1, 1, 1};

        int indx = 0;
        int loop = loops[indx];
        int k = 10;

        // JIT warmup
        duplicates(1000, 1000);

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = duplicates(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
            loop = loops[indx++];
        }
        //*/
    }
}
