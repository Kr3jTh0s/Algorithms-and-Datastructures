import java.util.Random;

class ListTesting{

    // ------ Linked lists -------
    /* */
    public static long appendLinked(int n, int loop){
        LinkedList a = new LinkedList(n);
        LinkedList b = new LinkedList(loop);
        long t0 = System.nanoTime();
        //a.append(b);
        b.append(a);
        long t1 = System.nanoTime();
        return (t1 - t0);
    }
    //*/

    /* */
    private static long linkedBench(int n, int loop){
        /* */
        long t = 0;
        for(int i = 0; i < loop; i++) 
            t += appendLinked(n, loop);
        return (t);
        //*/
    }
    //*/

    // ----------- Array ------------
    /* *
    public static int[] appendArray(int[] a, int[] b){
        int[] appended = new int[a.length + b.length];
        for(int i = 0; i < a.length; i++) appended[i] = a[i];
        for(int i = 0; i < b.length; i++) appended[a.length + i] = b[i];
        a = appended;
        return a;
    }
    //*/

    /* */
    public static int[] createArray(int[] arr){
        for(int i = 0; i < arr.length; i++) arr[i] = i;
        return arr;
    }
    //*/

    /* */
    public static long appendArray(int n, int loop){
        int[] a = new int[n];
        a = createArray(a);
        int[] b = new int[loop];
        b = createArray(b);

        /* */
        long t0 = System.nanoTime();
        int[] appended = new int[a.length + b.length];
        for(int i = 0; i < a.length; i++) appended[i] = a[i];
        for(int i = 0; i < b.length; i++) appended[a.length + i] = b[i];
        a = appended;
        long t1 = System.nanoTime();
        //*/

        /* *
        long t0 = System.nanoTime();
        int[] appended = new int[a.length + b.length];
        for(int i = 0; i < b.length; i++) appended[i] = b[i];
        for(int i = 0; i < a.length; i++) appended[b.length + i] = a[i];
        b = appended;
        long t1 = System.nanoTime();
        //*/

        return (t1 - t0);
    }
    //*/

    /* */
    private static long arrayBench(int n, int loop){
        /* */
        long t = 0;
        for(int i = 0; i < loop; i++) 
            t += appendArray(n, loop);
        return (t);
        //*/

        /* *
        Random rnd = new Random();

        int[][] a = new int[loop][n];
        int[][] b = new int[loop][loop];

        for(int i = 0; i < loop; i++){
            for(int j = 0; j < n; j++) a[i][j] = rnd.nextInt(n*10);
            for(int j = 0; j < loop; j++) b[i][j] = rnd.nextInt(n*10);
        }

        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(" a: " + (i + 1) + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(a[i][j] + ", ");
            System.out.println();
            System.out.print(" b: " + (i + 1) + " | ");
            for(int j = 0; j < loop; j++)
                System.out.print(b[i][j] + ", ");
        }
        //*/
        /* *
        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++)
            a[i] = appendArray(a[i], b[i]);
            //b[i] = appendArray(b[i], a[i]);
        long t1 = System.nanoTime();
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(" a: " + (i + 1) + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(a[i][j] + ", ");
            System.out.println();
            System.out.print(" b: " + (i + 1) + " | ");
            for(int j = 0; j < loop + n; j++)
                System.out.print(b[i][j] + ", ");
        }
        //*/

        //return (t1 - t0);
    }
    //*/

    // ----------- Stack ------------
    /* *
    public static DynamicStack appendDynStack(DynamicStack a, StaticStack b){
        int[] sta = b.stack;
        for(int i = 0; i < b.top; i++) a.push(sta[i]);
        return a;
    }
    //*/

    /* *
    public static StaticStack appendStaStack(DynamicStack a, StaticStack b){
        int[] dyn = a.stack;
        for(int i = 0; i < a.top; i++) b.push(dyn[i]);
        return b;
    }
    //*/

    /* *
    public static DynamicStack createDynamic(DynamicStack a, int n, Random rnd){
        a = new DynamicStack();
        for(int i = 0; i < n; i++) a.push(rnd.nextInt(n*10));
        return a;
    }
    //*/

    /* *
    public static StaticStack createStatic(StaticStack b, int loop, int n, Random rnd){
        b = new StaticStack(loop + n);
        for(int i = 0; i < loop; i++) b.push(rnd.nextInt(loop*10));
        return b;
    }
    //*/

    /* */
    public static long appendArrayStack(int n, int loop){
        DynamicStack a = new DynamicStack();
        for(int i = 0; i < n; i++) a.push(i);
        StaticStack b = new StaticStack(loop + n);
        for(int i = 0; i < loop; i++) b.push(i);

        /* */
        long t0 = System.nanoTime();
        for(int i = 0; i < b.top; i++) a.push(b.stack[i]);
        long t1 = System.nanoTime();
        //*/

        /* *
        long t0 = System.nanoTime();
        for(int i = 0; i < a.top; i++) b.push(a.stack[i]);
        long t1 = System.nanoTime();
        //*/

        return (t1 - t0);
    }
    //*/

    /* */
    private static long stackBench(int n, int loop){
        /* */
        long t = 0;
        for(int i = 0; i < loop; i++) 
            t += appendArrayStack(n, loop);
        return (t);
        //*/

        /* *
        Random rnd = new Random();

        DynamicStack[] a = new DynamicStack[loop];
        StaticStack[] b = new StaticStack[loop];

        for(int i = 0; i < loop; i++){
            a[i] = createDynamic(a[i], n, rnd);
            b[i] = createStatic(b[i], loop, n, rnd);
        }

        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(" a: " + (i + 1) + " | ");

            int[] aStack = a[i].stack;
            for(int j = 0; j < n; j++) 
                System.out.print(aStack[j] + ", ");

            System.out.println();
            System.out.print(" b: " + (i + 1) + " | ");

            int[] bStack = b[i].stack;
            for(int j = 0; j < loop; j++)
                System.out.print(bStack[j] + ", ");
        }
        //*/
        /* *
        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++)
            a[i] = appendDynStack(a[i], b[i]);
        long t1 = System.nanoTime();
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(" a: " + (i + 1) + " | ");

            int[] aStack = a[i].stack;
            for(int j = 0; j < n; j++) 
                System.out.print(aStack[j] + ", ");

            System.out.println();
            System.out.print(" b: " + (i + 1) + " | ");

            int[] bStack = b[i].stack;
            for(int j = 0; j < loop + n; j++)
                System.out.print(bStack[j] + ", ");
        }
        //*/

        //return (t1 - t0);
    }
    //*/

    // ------- Linked stack ---------
    /* */
    public static LinkedStack createStack(LinkedStack s, int size){
        for(int i = 0; i < size; i++) s.push(i);
        return s;
    }
    //*/

    /* */
    public static long appendLinkedStack(int n, int loop){
        LinkedStack a = new LinkedStack();
        a = createStack(a, n);
        LinkedStack b = new LinkedStack();
        b = createStack(b, loop);

        long t0 = System.nanoTime();
        //a.append(b);
        b.append(a);
        long t1 = System.nanoTime();

        return (t1 - t0);
    }
    //*/

    /* */
    private static long linkedStackBench(int n, int loop){
        /* */
        long t = 0;
        for(int i = 0; i < loop; i++) 
            t += appendLinkedStack(n, loop);
        return (t);
        //*/

        /* *
        Random rnd = new Random();

        LinkedStack[] a = new LinkedStack[loop];
        LinkedStack[] b = new LinkedStack[loop];

        for(int i = 0; i < loop; i++){
            a[i] = createStack(a[i], n, rnd);
            b[i] = createStack(b[i], loop, rnd);
        }

        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(" a: " + (i + 1) + " | ");
            System.out.print(a[i]);

            System.out.println();
            System.out.print(" b: " + (i + 1) + " | ");
            System.out.print(b[i]);
        }
        //*/
        /* *
        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++)
            a[i].append(b[i]);
        long t1 = System.nanoTime();
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(" a: " + (i + 1) + " | ");
            System.out.print(a[i]);

            System.out.println();
            System.out.print(" b: " + (i + 1) + " | ");
            System.out.print(b[i]);
        }
        //*/

        //return (t1 - t0);
    }
    //*/

    
    public static void main(String[] args){

        // Test
        /* *
        System.out.println();
        long t = linkedBench(10, 5);
        System.out.println(t);
        //*/

        // Linked list -------
        /* */
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25400, 51200};
        
        int loop = 1000;
        int k = 10;

        // JIT warmup
        linkedBench(10000, 10000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = linkedBench(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        System.out.println("-----------------------------");
        //*/

        // Array ---------
        /* */
        //int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25400, 51200};
        
        //int loop = 1000;
        //int k = 10;

        // JIT warmup
        arrayBench(10000, 10000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = arrayBench(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        System.out.println("-----------------------------");
        //*/

        // Stack ---------
        /* */
        //int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25400, 51200};
    
        //int loop = 1000;
        //int k = 10;

        // JIT warmup
        stackBench(10000, 10000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = stackBench(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        System.out.println("-----------------------------");
        //*/

        // Linked stack ---------
        /* */
        //int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25400, 51200};
        
        //int loop = 1000;
        //int k = 10;

        // JIT warmup
        linkedStackBench(10000, 10000);
         
        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = linkedStackBench(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        //*/

        /* *
        Random rnd = new Random();

        LinkedList list = new LinkedList(2);
        System.out.println(list);
        
        list.add(4);
        System.out.println(list);

        int length = list.length();
        System.out.println(length);
        
        for(int i = 0; i < 10; i++) list.add(rnd.nextInt(10));
        list.add(7);
        System.out.println(list);
        
        length = list.length();
        System.out.println(length);
        
        boolean found = list.find(7);
        System.out.println(found);
        
        if(found){
            list.remove(7);
            System.out.println(list);
        }
        list.remove(4);
        System.out.println(list);
        
        LinkedList list2 = new LinkedList(2);
        for(int i = 0; i < 5; i++) list2.add(rnd.nextInt(10) + 10);
        System.out.println(list2);
        
        list.append(list2);
        System.out.println(list);
        //*/
    }
}
