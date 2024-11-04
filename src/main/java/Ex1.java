public class Ex1 {
    /**
     * @param args the command line arguments
     */
    public static boolean isSorted(int[] array) {
        if (array.length < 2) {
            return true;
        }

        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                ascending = false;
            }
            if (array[i] > array[i - 1]) {
                descending = false;
            }
        }

        return ascending || descending;
    }
    public static void main(String[] args) {
        // TODO code application logic here

        //ex1
        int[] array1 = {1, 3, 7, 10};
        int[] array2 = {9, 5, 3, 1};
        int[] array3 = {10, 9, 3, 12};

        System.out.println(isSorted(array1));
        System.out.println(isSorted(array2));
        System.out.println(isSorted(array3));

    }
   }
