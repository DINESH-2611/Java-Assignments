package Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateRemoverHashSet {
    public static <T> List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        List<Integer> result = new ArrayList<>(set);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbersWithDuplicates = new ArrayList<>();
        numbersWithDuplicates.add(5);
        numbersWithDuplicates.add(2);
        numbersWithDuplicates.add(7);
        numbersWithDuplicates.add(2);
        numbersWithDuplicates.add(5);
        numbersWithDuplicates.add(9);
        numbersWithDuplicates.add(7);

        System.out.println("List with duplicates: " + numbersWithDuplicates);

        List<Integer> numbersWithoutDuplicates = removeDuplicates(numbersWithDuplicates);

        System.out.println("List without duplicates: " + numbersWithoutDuplicates);
    }
}
