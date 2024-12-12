package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SortingPractice06Oct24 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }

        System.out.println(Arrays.toString(arr));

        int[] qsHP = Arrays.copyOf(arr, arr.length);

        quickSortHighPivot(qsHP, 0, qsHP.length - 1);
        System.out.println(Arrays.toString(qsHP));

        int[] qsLP = Arrays.copyOf(arr, arr.length);

        quickSortLowPivot(qsLP, 0, qsLP.length - 1);
        System.out.println(Arrays.toString(qsLP));

        int[] qsRP = Arrays.copyOf(arr, arr.length);
        quickSortRandomPivot(qsRP, 0, qsRP.length - 1);
        System.out.println(Arrays.toString(qsRP));

        int[] ms = Arrays.copyOf(arr, arr.length);
        mergeSort(ms, 0, ms.length - 1);
        System.out.println(Arrays.toString(ms));

        int[] is = Arrays.copyOf(arr, arr.length);
        insertionSort(is);
    }

    public static void insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swap(nums, j - 1, j);
                j--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int low = left , high = mid + 1, k = 0;

        while (low <= mid && high <= right) {
            if (nums[low] <= nums[high]) {
                temp[k++] = nums[low++];
            } else {
                temp[k++] = nums[high++];
            }
        }

        while (low <= mid) {
            temp[k++] = nums[low++];
        }

        while (high <= right) {
            temp[k++] = nums[high++];
        }

        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    public static void quickSortRandomPivot(int[] nums, int left, int right) {
        if (left < right) {
            int pIndex = partitionRP(nums, left, right);
            quickSortRandomPivot(nums, left, pIndex - 1);
            quickSortRandomPivot(nums, pIndex + 1, right);
        }
    }

    public static int partitionRP(int[] nums, int left, int right) {
        getPivot(nums, left, right);
        int pivot = nums[right];

        int i = left - 1;

        for (int j = left; j <= right; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, (i + 1), right);
        return (i + 1);
    }

    public static void getPivot(int[] nums, int left, int right) {
        Random random = new Random();
        int pivot = random.nextInt(right - left) + left;
        int temp = nums[pivot];
        nums[pivot] = nums[right];
        nums[right] = temp;
    }

    public static void quickSortLowPivot(int[] nums, int left, int right) {
        if (left < right) {
            int pIndex = partitionLP(nums, left, right);
            quickSortLowPivot(nums, left, pIndex - 1);
            quickSortLowPivot(nums, pIndex + 1, right);
        }
    }

    public static int partitionLP(int[] nums, int left, int right) {
        int pivot = nums[left];

        int low = left, high = right;

        while (low < high) {
            while (low <= right - 1 && nums[low] <= pivot) {
                low++;
            }
            while (high >= left + 1 && nums[high] > pivot) {
                high--;
            }

            if (low < high) {
                swap(nums, low, high);
            }
        }
        swap(nums, left, high);
        return high;
    }

    public static void quickSortHighPivot(int[] nums, int low, int high) {
        if (low < high) {
            int pIndex = partitionHP(nums, low, high);
            quickSortHighPivot(nums, low, pIndex - 1);
            quickSortHighPivot(nums, pIndex + 1, high);
        }
    }

    public static int partitionHP(int[] nums, int low, int high) {
        int i = low - 1;
        int pivot = nums[high];

        for (int j = low; j <= high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return (i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
