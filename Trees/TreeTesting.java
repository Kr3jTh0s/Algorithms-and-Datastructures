import java.util.Random;

public class TreeTesting{

    // ------- Ordered Recursive Add ---------
    /* *
    public static long btBench1(int n){
        BinaryTree b = new BinaryTree();
        b.add(n/2);
        for(int i = 0; i < n; i++) b.add(i);

        long t0 = System.nanoTime();
        b.add(n);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    private static long binaryTreeBench1(int n, int loop){
        long t = 0;
        for(int i = 0; i < loop; i++) 
            t += btBench1(n);
        return (t);
    }
    //*/

    // ------- Random Recursive Add ---------
    /* *
    public static long btBench2(int n, Random rnd){
        BinaryTree b = new BinaryTree();
        for(int i = 0; i < n; i++) b.add(rnd.nextInt(n*2));
        int r = rnd.nextInt(n*2);

        long t0 = System.nanoTime();
        b.add(r);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    private static long binaryTreeBench2(int n, int loop){
        Random rnd = new Random();
        long t = 0;
        for(int i = 0; i < loop; i++) 
            t += btBench2(n, rnd);
        return (t);
    }
    //*/

    // ------- Ordered Iterative Add ---------
    /* *
    public static long btBench3(int n){
        BinaryTree b = new BinaryTree();
        b.addon(n/2);
        for(int i = 0; i < n; i++) b.addon(i);

        long t0 = System.nanoTime();
        b.addon(n);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    private static long binaryTreeBench3(int n, int loop){
        long t = 0;
        for(int i = 0; i < loop; i++) 
            t += btBench3(n);
        return (t);
    }
    //*/

    // ------- Random Iterative Add ---------
    /* *
    public static long btBench4(int n, Random rnd){
        BinaryTree b = new BinaryTree();
        for(int i = 0; i < n; i++) b.addon(rnd.nextInt(n*2));
        int r = rnd.nextInt(n*2);

        long t0 = System.nanoTime();
        b.addon(r);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }

    private static long binaryTreeBench4(int n, int loop){
        Random rnd = new Random();
        long t = 0;
        for(int i = 0; i < loop; i++) 
            t += btBench4(n, rnd);
        return (t);
    }
    //*/

    // ------- Lookup Method ---------
    /* */
    private static long binaryTreeBench5(int n, int loop){
        Random rnd = new Random();
        BinaryTree b = new BinaryTree();
        for(int i = 0; i < n; i++) b.addon(rnd.nextInt(n*2));
        
        int[] keys = new int[loop];
        for(int k = 0; k < loop; k++) keys[k] = rnd.nextInt(n*2);

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++){ 
            int key = keys[i];
            b.lookup(key);
        }
        long t1 = System.nanoTime();
        
        return (t1 - t0);
    }
    //*/


    public static void main(String[] args){
        /* *
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        for(int i = 0; i < 11; i++) tree.add(i);
        tree.printTree();
        System.out.println(tree.lookup(0));
        System.out.println(tree.lookup(10));
        System.out.println(tree.lookup(5));
        System.out.println(tree.lookup(11));

        BinaryTree trad = new BinaryTree();
        trad.addon(5);
        for(int i = 0; i < 11; i++) trad.addon(i);
        trad.printTree();
        System.out.println(trad.lookup(0));
        System.out.println(trad.lookup(10));
        System.out.println(trad.lookup(5));
        System.out.println(trad.lookup(11));
        //*/

        int[] sizes = {10, 20, 40, 80, 160, 320, 640, 1280, 2540, 5120};
        
        int loop = 1000;
        int k = 10;
        
        // ------- Ordered Recursive Add ---------
        /* *
        // JIT warmup
        binaryTreeBench1(1000, 1000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = binaryTreeBench1(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        System.out.println("-----------------------------");
        //*/

        // ------- Random Recursive Add ---------
        /* *
        loop = 1000;
        // JIT warmup
        binaryTreeBench2(1000, 1000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = binaryTreeBench2(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        System.out.println("-----------------------------");
        //*/

        // ------- Ordered Iterative Add ---------
        /* *
        loop = 100;
        // JIT warmup
        binaryTreeBench3(1000, 1000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = binaryTreeBench3(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        System.out.println("-----------------------------");
        //*/

        // ------- Random Iterative Add ---------
        /* *
        loop = 1000;
        // JIT warmup
        binaryTreeBench4(1000, 1000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = binaryTreeBench4(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        //*/

        // ------- Lookup ---------
        /* */
        // JIT warmup
        binaryTreeBench5(10000, 1000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = binaryTreeBench5(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        //*/
    }
}
