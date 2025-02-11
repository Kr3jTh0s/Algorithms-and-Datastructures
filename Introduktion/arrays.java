import java.util.Random;

class arrays{
    /* clock with a !(~0,24) chance for error *
    public static void clock(){
        long n = 100;
        double a = 0;
        for (int i = 0; i < 1000; i++){
            long n0 = System.nanoTime();
            long n1 = System.nanoTime();
            System.out.println(" resolution " + (n1 - n0) + " nanoseconds");
            if ((n1 - n0) == n)
                a ++;
        }
        System.out.println(" -chance for error: " + a/1000 + " or " + a + "/1000 ");
    }
    //*/
    /* testing clock speed for accessing array *
    public static void clockTest(){
        int[] given = {0,1,2,3,4,5,6,7,8,9};
        int sum = 0;

        long n = 200;
        double a = 0;

        for (int i = 0; i < 10; i++){
            long t0 = System.nanoTime();
            sum += given[i];
            long t1 = System.nanoTime();
            System.out.println(" one operation in " + (t1 - t0) + " ns");
            if ((t1 - t0) != n)
                a ++;
        }
        System.out.println(" -chance for error: " + a/10 + " or " + a + "/10 ");
    }
    //*/
    /* testing clock speed for accessing random elements of array *
    public static void clockTestRndm(){
        int[] given = {0,1,2,3,4,5,6,7,8,9};

        Random rnd = new Random();

        int sum = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < 1000; i++){
            sum += given[rnd.nextInt(10)];
        }
        long t1 = System.nanoTime();
        System.out.println(" one read operation in " + (t1 - t0)/1000 + " nanoseconds");
    }
    //*/
    /* ye */
    public static int run(int[] array, int[] indx){
        int sum = 0;
        for(int i = 0; i < indx.length; i++){
            sum += array[indx[i]];
        }
        return sum;
    }

    public static long bench(int n, int loop){
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = i;
        }

        Random rnd = new Random();

        int[] indx = new int[loop];
        for(int i = 0; i < loop; i++){
            indx[i] = rnd.nextInt(n);
        }
        

        long t0 = System.nanoTime();
        run(array, indx);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    private static long search(int n, int loop){
        Random rnd = new Random();

        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = rnd.nextInt(n*2);
        }

        int[] keys = new int[loop];
        for(int k = 0; k < loop; k++){
            keys[k] = rnd.nextInt(n*2);
        }

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

    private static long duplicates(int n, int loop){
        Random rnd = new Random();

        int[] array_a = new int[n];
        for(int i = 0; i < n; i++){
            array_a[i] = rnd.nextInt(n*2);
        }

        int[] array_b = new int[n];
        for(int i = 0; i < n; i++){
            array_b[i] = rnd.nextInt(n*2);
        }

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

    public static void main(String[] args) {
        // Test 1
        /* *
        for(int i = 0; i < 10; i++){
            long t = bench(1000, 1000);
            System.out.println(" access: " + t + " ns");
        }
        //*/

        // Test 2
        /* *
        int n = 1000;
        int loop = 1000;
        int k = 10;

        long min = Long.MAX_VALUE;
        long max = 0;
        long total = 0;

        bench(n, 1000000);

        for(int i = 0; i < k; i++){
            long t = bench(n, loop);
            if (t > max) max = t;
            if (t < min) min = t;
            total += t;
        }

        System.out.println(" avg: " + ((double) total)/loop/k);
        System.out.println(" min: " + ((double) min)/loop);
        System.out.println(" max: " + ((double) max)/loop);
        //*/

        // Test 3
        /* */
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800};

        // JIT warmup
        bench(10000, 1000000);

        int loop = 1000;
        int k = 1000;

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = bench(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + min + " ns");
        }
        //*/

        // Test 4
        /* *
        int[] sizes = {100, 200, 400, 800, 1600, 3200};

        // JIT warmup
        bench(1000, 1000000);

        int loop = 1000;
        int k = 100;

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = search(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double) min)/loop + " ns");
        }
        //*/

        // Test 5
        /* *
        int[] sizes = {100, 200, 400, 800, 1600, 3200};

        // JIT warmup
        bench(1000, 1000000);

        int loop = 100;
        int k = 10;

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = duplicates(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double) min)/loop + " ns");
        }
        //*/

    }
}