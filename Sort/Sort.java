import java.util.Random;

public class Sort {

    // Selection sort
    /* */
    public static void selection_sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int candidate = i;
            for(int j = i + 1; j < array.length; j++)
                if(array[j] < array[candidate]) candidate = j;
            if(!(candidate == i)) swap(array, candidate, i);
        }
    }
    //*/
    
    /* */
    private static long selectionSort(int n, int loop){
        Random rnd = new Random();

        int[][] array = new int[loop][n];
        for(int i = 0; i < loop; i++) 
            for(int j = 0; j < n; j++)
                array[i][j] = rnd.nextInt(n*10);
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++)
            selection_sort(array[i]);
        long t1 = System.nanoTime();
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        return (t1 - t0);
    }
    //*/

    // Insertion sort
    /* */
    public static void insertion_sort(int[] array){
        for(int i = 0; i < array.length; i++)
            for(int j = i; j > 0 && array[j] < array[j - 1]; j--)
                swap(array, j, j - 1);  
    }
    //*/

    /* */
    public static void swap(int[] array, int j, int i){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    //*/
    
    public static void reverse(int[] array, int n){
        int[] sub = new int[n];
        int j = n;
        for(int i = 0; i < n; i++) sub[--j] = array[i];
        for(int i = 0; i < n; i++) array[i] = sub[i];
    }

    /* */
    private static long insertionSort(int n, int loop){
        Random rnd = new Random();

        int[][] array = new int[loop][n];
        for(int i = 0; i < loop; i++) 
            for(int j = 0; j < n; j++)
                array[i][j] = rnd.nextInt(n*10);
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/
        
        for(int i = 0; i < loop; i++) quick_sort(array[i]);
        for(int i = 0; i < loop; i++) reverse(array[i], n);
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++)
            insertion_sort(array[i]);
        long t1 = System.nanoTime();
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        return (t1 - t0);
    }
    //*/

    // Merge sort
    /* */
    public static void merge_sort(int[] array){
        if(array.length == 0) return;
        int[] sub = new int[array.length];
        merge_sort(array, sub, 0, array.length - 1);
    }
    //*/

    /* */
    private static void merge_sort(int[] array, int[] sub, int low, int high){
        if(low != high){
            int mid = low + (high - low)/2;
            merge_sort(array, sub, low, mid);
            merge_sort(array, sub, mid+1, high);
            merge(array, sub, low, mid, high);
        }
    }
    //*/

    /* */
    private static void merge(int[] array, int[] sub, int low, int mid, int high){
        for(int i = low; i <= high; i++) sub[i] = array[i];

        int i = low;
        int j = mid + 1;

        for(int k = low; k <= high; k++){
            if(i > mid) array[k] = sub[j++];
            else if(j > high) array[k] = sub[i++];
            else if(sub[i] < sub[j]) array[k] = sub[i++];
            else array[k] = sub[j++];
        }
    }
    //*/

    /* */
    private static long mergeSort(int n, int loop){
        Random rnd = new Random();

        int[][] array = new int[loop][n];
        for(int i = 0; i < loop; i++) 
            for(int j = 0; j < n; j++)
                array[i][j] = rnd.nextInt(n*10);
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++)
            merge_sort(array[i]);
        long t1 = System.nanoTime();
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        return (t1 - t0);
    }
    //*/

    // Quick sort
    /* */
    public static void quick_sort(int[] array){
        if(array.length == 0) return;
        quick_sort(array, 0, array.length - 1);
    }
    //*/

    /* */
    private static void quick_sort(int[] array, int low, int high){
        if(low < high){
            int pi = partition(array, low, high);

            quick_sort(array, low, pi - 1);
            quick_sort(array, pi+1, high);
        }
    }
    //*/

    /* */
    private static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int j = (low - 1);

        for (int i = low; i <= high - 1; i++)
            if (array[i] < pivot) swap(array, i, ++j);
            
        swap(array, j + 1, high);
        return (j + 1);
    }
    //*/

    /* */
    private static long quickSort(int n, int loop){
        Random rnd = new Random();

        int[][] array = new int[loop][n];
        for(int i = 0; i < loop; i++) 
            for(int j = 0; j < n; j++)
                array[i][j] = rnd.nextInt(n*10);
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++)
            quick_sort(array[i]);
        long t1 = System.nanoTime();
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        return (t1 - t0);
    }
    //*/

    public static void main(String[] args) {

        // Test
        /* *
        System.out.println();
        long t = insertionSort(10, 5);
        System.out.println(t);
        //*/

        // Selection sort
        /* *
        int[] sizes = {10, 20, 40, 80, 160, 320, 640, 1280, 2540, 5120};
        int[] loops = {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 100, 100};

        int indx = 0;
        int k = 10;

        // JIT warmup
        selectionSort(2000, 2000);

        for(int n : sizes){
            int loop = loops[indx];
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = selectionSort(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
            indx++;
        }
        System.out.println("-----------------------------");
        //*/

        // Insertion sort
        /* */
        int[] sizes = {10, 20, 40, 80, 160, 320, 640, 1280, 2540, 5120};
        int[] loops = {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 100, 100};

        int indx = 0;
        int k = 10;

        // JIT warmup
        insertionSort(2000, 2000);

        for(int n : sizes){
            int loop = loops[indx];
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = insertionSort(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
            indx++;
        }
        //System.out.println("-----------------------------");
        //*/

        // Merge sort
        /* *
        int[] sizes = {10, 20, 40, 80, 160, 320, 640, 1280, 2540, 5120};
        
        int loop = 1000;
        int k = 10;

        // JIT warmup
        mergeSort(2000, 2000);

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = mergeSort(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        System.out.println("-----------------------------");
        //*/

        // Quick sort
        /* *
        int[] sizes = {10, 20, 40, 80, 160, 320, 640, 1280, 2540, 5120};
        
        int loop = 1000;
        int k = 10;

        // JIT warmup
        quickSort(2000, 2000);

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = quickSort(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        //System.out.println("-----------------------------");
        //*/
    }
}
