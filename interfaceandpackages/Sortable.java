package interfaceandpackages;

import java.util.Arrays;
import java.util.Scanner;

public interface Sortable {
    void sort(int[] arr);
}

class BubbleSort implements Sortable {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort implements Sortable {
    @Override
    public void sort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    int partition(int a[], int start, int end) {
        int pivot = a[end];
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            if (a[j] < pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    void quick(int a[], int start, int end) {
        if (start < end) {
            int p = partition(a, start, end);
            quick(a, start, p - 1);
            quick(a, p + 1, end);
        }
    }
}

class MergeSort implements Sortable {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);

    }

    void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

class SortableStart {
    Scanner scanner = new Scanner(System.in);

    void init() {
        System.out.println("Enter the size of the array");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the arr[" + i + "] element in the array");
            arr[i] = scanner.nextInt();
        }
        sort(arr);
    }

    void sort(int[] arr) {
        System.out.println("1.Bubble sort\n2.Quick Sort\n3.Merge Sort\nEnter the choice");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Before Sorting");
                printArray(arr);
                new BubbleSort().sort(arr);
                System.out.println("After Sorting using Bubble sort");
                printArray(arr);
                break;
            case 2:
                System.out.println("Before Sorting");
                printArray(arr);
                new QuickSort().sort(arr);
                System.out.println("After Sorting using Quick Sort");
                printArray(arr);
                break;
            case 3:
                System.out.println("Before Sorting");
                printArray(arr);
                new MergeSort().sort(arr);
                System.out.println("After Sorting using Merge Sort");
                printArray(arr);
                break;
            default:
                System.out.println("\t\t\tInvalid choice ,Enter valid choice");
        }
    }

    void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}

class SortableDriver {
    public static void main(String[] args) {
        new SortableStart().init();
    }
}
