package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortingPractice17Sep24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(arr));

        int[] insertionSortArray = Arrays.copyOf(arr, arr.length);
        insertionSort(insertionSortArray);

//        sorting with pairs

//        Input:
//pairs = [(5, "apple"), (2, "banana"), (9, "cherry")]
//
//Output:
//[[(5, "apple"), (2, "banana"), (9, "cherry")],
// [(2, "banana"), (5, "apple"), (9, "cherry")],
// [(2, "banana"), (5, "apple"), (9, "cherry")]]

        List<Pair> pairs = new ArrayList<>();
        Pair p1 = new Pair(5, "apple");
        pairs.add(p1);
        Pair p2 = new Pair(2, "banana");
        pairs.add(p2);
        Pair p3 = new Pair(9, "cherry");
        pairs.add(p3);

        System.out.println(pairs);

        List<List<Pair>> sortedPairs = insertionSortpairs(pairs);

        System.out.println(sortedPairs);
    }

    public static List<List<Pair>> insertionSortpairs(List<Pair> pairs) {
        int n = pairs.size();
        System.out.println(n);
        List<List<Pair>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && pairs.get(j - 1).key > pairs.get(j).key) {
                Pair temp = pairs.get(j - 1);
                pairs.set(j - 1, pairs.get(j));
                pairs.set(j, temp);
                j--;
            }
            list.add(new ArrayList<>(pairs));
        }
        return list;
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            while(j > 0 && arr[j - 1] > arr[j]) {
                int temp= arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

class Pair {
    int key;
    String value;

    Pair (int key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String toString() {
        return "(" + key + " , " + value + ")";
    }
}
