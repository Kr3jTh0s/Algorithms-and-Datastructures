public class HashTest {
    
    // ------- Linear Search ---------
    /* */
    public static long linZip(int loop, String key){
        Zip postal = new Zip("postnummer.csv");
        boolean found = false;

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++) 
            found = postal.linSearch(key);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    public static void linBench(int loop, int k, String key){
        // JIT warmup
        linZip(100000, key);
         
        long min = Long.MAX_VALUE;
        for(int i = 0; i < k; i++){
            long t = linZip(loop, key);
            if (t < min) min = t;
        }
        System.out.println(" " + ((double)min)/loop + " ns");
    }

    // ------- binary Search ---------
    /* */
    public static long binZip(int loop, String key){
        Zip postal = new Zip("postnummer.csv");
        boolean found = false;

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++) 
            found = postal.binSearch(key);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    public static void binBench(int loop, int k, String key){
        // JIT warmup
        binZip(100000, key);
         
        long min = Long.MAX_VALUE;
        for(int i = 0; i < k; i++){
            long t = binZip(loop, key);
            if (t < min) min = t;
        }
        System.out.println(" " + ((double)min)/loop + " ns");
    }

    // ------- Linear Search ---------
    /* */
    public static long linZip2(int loop, int key){
        Zip2 postal = new Zip2("postnummer.csv");
        boolean found = false;

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++) 
            found = postal.linSearch(key);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    public static void linBench2(int loop, int k, int key){
        // JIT warmup
        linZip2(100000, key);
         
        long min = Long.MAX_VALUE;
        for(int i = 0; i < k; i++){
            long t = linZip2(loop, key);
            if (t < min) min = t;
        }
        System.out.println(" " + ((double)min)/loop + " ns");
    }

    // ------- binary Search ---------
    /* */
    public static long binZip2(int loop, int key){
        Zip2 postal = new Zip2("postnummer.csv");
        boolean found = false;

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++) 
            found = postal.binSearch(key);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    public static void binBench2(int loop, int k, int key){
        // JIT warmup
        binZip2(100000, key);
         
        long min = Long.MAX_VALUE;
        for(int i = 0; i < k; i++){
            long t = binZip2(loop, key);
            if (t < min) min = t;
        }
        System.out.println(" " + ((double)min)/loop + " ns");
    }

    // ------- Lookup Search ---------
    /* */
    public static long lookupZip3(int loop, int key){
        Zip3 postal = new Zip3("postnummer.csv");
        boolean found = false;

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++) 
            found = postal.lookup(key);
        long t1 = System.nanoTime();

        //System.out.println(found);

        return (t1 - t0);
    }

    public static void lookupBench3(int loop, int k, int key){
        // JIT warmup
        //lookupZip3(1000000, key);
         
        long min = Long.MAX_VALUE;
        for(int i = 0; i < k; i++){
            long t = lookupZip3(loop, key);
            if (t < min) min = t;
        }
        System.out.println(" " + ((double)min)/loop + " ns");
    }

    // ------- Collisions ---------
    /* */
    public static long colZip3(int loop, int mod){
        Zip3 postal = new Zip3("postnummer.csv");

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++) 
            postal.collisions(mod);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    // ------- Lookup Search ---------
    /* */
    public static long lookupZip4(int loop, int key){
        Zip4 postal = new Zip4("postnummer.csv");
        boolean found = false;

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++) 
            found = postal.lookup(key);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    public static void lookupBench4(int loop, int k, int key){
        // JIT warmup
        lookupZip4(1000000, key);
         
        long min = Long.MAX_VALUE;
        for(int i = 0; i < k; i++){
            long t = lookupZip4(loop, key);
            if (t < min) min = t;
        }
        System.out.println(" " + ((double)min)/loop + " ns");
    }
    /* */

    // ------- Lookup Search ---------
    /* */
    public static long lookupZip5(int loop, int key){
        Zip5 postal = new Zip5("postnummer.csv");
        boolean found = false;

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++) 
            found = postal.lookup(key);
        long t1 = System.nanoTime();

        //System.out.println(found);

        return (t1 - t0);
    }

    public static void lookupBench5(int loop, int k, int key){
        // JIT warmup
        lookupZip5(1000000, key);
         
        long min = Long.MAX_VALUE;
        for(int i = 0; i < k; i++){
            long t = lookupZip5(loop, key);
            if (t < min) min = t;
        }
        System.out.println(" " + ((double)min)/loop + " ns");
    }
    /* */


    public static void main(String[] args) {        
        int loop = 10000;
        int k = 10;
        
        // ------- Linear Search ---------
        /* *
        linBench(loop, k, "111 15");
        System.out.println("LS Z1 111 15-----------------------------");
        linBench(loop, k, "984 99");
        System.out.println("LS Z1 984 99-----------------------------");
        // ------- binary Search ---------
        /* *
        binBench(loop, k, "111 15");
        System.out.println("BS Z1 111 15-----------------------------");
        binBench(loop, k, "984 99");
        System.out.println("BS Z1 984 99-----------------------------");
        /* */

        // ------- Linear Search ---------
        /* *
        linBench2(loop, k, 11115);
        System.out.println("LS Z2 11115-----------------------------");
        linBench2(loop, k, 98499);
        System.out.println("LS Z2 98499-----------------------------");
        // ------- binary Search ---------
        /* *
        binBench2(loop, k, 11115);
        System.out.println("BS Z2 11115-----------------------------");
        binBench2(loop, k, 98499);
        System.out.println("BS Z2 98499-----------------------------");
        /* */

        // ------- Lookup Search ---------
        /* *
        lookupBench3(loop, k, 11115);
        System.out.println("L1 Z3 11115-----------------------------");
        lookupBench3(loop, k, 98499);
        System.out.println("L1 Z3 98499-----------------------------");
        /* *
        lookupZip3(1000000, 54544);
        int[] keys = {11115, 19999, 21122, 45454, 45432, 82001, 98499};
        for(int n : keys){
            lookupBench3(loop, k, n);
        }
        /* */

        // ------- Collisions ---------
        /* */
        int[] mod = {10000, 20000, 12345, 17389, 13513, 13600, 14000};
        // JIT warmup
        //colZip3(1000000, 12345);
        for(int m : mod){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < 1; i++){
                long t = colZip3(1, m);
                if (t < min) min = t;
            }
            //System.out.println(m + " " + ((double)min)/loop + " ns");
        }
        /* */

        // ------- Lookup Search 2 ---------
        /* *
        lookupBench4(loop, k, 11115);
        System.out.println("L2 Z4 11115-----------------------------");
        lookupBench4(loop, k, 98499);
        System.out.println("L2 Z4 98499-----------------------------");
        /* */

        // ------- Lookup Search 3 ---------
        /* *
        lookupBench5(loop, k, 11115);
        System.out.println("L3 Z5 11115-----------------------------");
        lookupBench5(loop, k, 98499);
        System.out.println("L3 Z5 98499-----------------------------");
        /* */
    }
}
