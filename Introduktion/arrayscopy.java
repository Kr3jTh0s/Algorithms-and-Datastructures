import java.util.Random;

class arrayscopy{

    /* *
    public static long rndAccess(int n, int loop){
        int[] array = new int[n];
        for(int i = 0; i < n; i++) array[i] = i;

        Random rnd = new Random();

        int[] indx = new int[loop];
        for(int i = 0; i < loop; i++) indx[i] = rnd.nextInt(n);
        
        int sum = 0;
        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++) sum += array[indx[i]];
        long t1 = System.nanoTime();

        return (t1 - t0);
    }
    //*/

    /* *
    private static long search(int n, int loop){
        Random rnd = new Random();

        int[] array = new int[n];
        for(int i = 0; i < n; i++) array[i] = rnd.nextInt(n*2);

        int[] keys = new int[loop];
        for(int k = 0; k < loop; k++) keys[k] = rnd.nextInt(n*2);

        int sum = 0;
        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++){
            int key = keys[i];
            for(int j = 0; j < n; j++){
                if(key == array[j]){
                    sum++;
                    break;
                }
            }
        }
        long t1 = System.nanoTime();
        return (t1 - t0);
    }
    //*/

    /* *
    private static long duplicates(int n, int loop){
        Random rnd = new Random();

        int[] array_a = new int[n];
        for(int i = 0; i < n; i++) array_a[i] = rnd.nextInt(n*2);

        int[] array_b = new int[n];
        for(int i = 0; i < n; i++) array_b[i] = rnd.nextInt(n*2);

        int sum = 0;
        long t0 = System.nanoTime();
        for(int k = 0; k < loop; k++){
            for(int i = 0; i < n; i++){
                int key = array_a[i];
                for(int j = 0; j < n; j++){
                    if(key == array_b[j]){
                        sum++;
                        break;
                    }
                }
            }
        }
        long t1 = System.nanoTime();
        return (t1 - t0);
    }
    //*/
    public static void main(String[] args) {
        // Test 1
        /* *
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25400, 51200};

        int loop = 1000;
        int k = 10;

        // JIT warmup
        //for(int i = 0; i < 10; i++)
            rndAccess(100000, 1000000);

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = rndAccess(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        //*/

        // Test 2
        /* *
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25400, 51200};

        int loop = 1000;
        int k = 10;

        // JIT warmup
        search(10000, 1000000);

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = search(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        //*/

        // Test 3
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