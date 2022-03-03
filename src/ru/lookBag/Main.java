package ru.lookBag;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList(List.of(1, 1, 4, 3, 4, 2, 5, 5, 6, 7));
        List<String> strings = new ArrayList(List.of("кот", "дом", "кот", "окно", "солнце", "окно", "кот"));
        printOddNumbers(nums);
        printEvenNumbersNoDouble(nums);
        printUniqueString(strings);
        printCountDoubleInList(strings);
    }

    public static void printOddNumbers(List<Integer> nums) {
        List<Integer> oddNumbers = new ArrayList();

        for (int i = 0; i < nums.size(); ++i) {
            if ( nums.get(i) % 2 == 1) {
                oddNumbers.add(nums.get(i));
            }
        }
        if (!oddNumbers.isEmpty()) {
            System.out.println("Все нечетные числа в списке:");
            for (int i = 0; i < oddNumbers.size(); ++i) {
                System.out.print(oddNumbers.get(i) + " ");
            }
            System.out.println();
            System.out.println();
        } else {
            System.out.println("В списке нет нечетных чисел!");
            System.out.println();
        }

    }

    public static void printEvenNumbersNoDouble(List<Integer> nums) {
        Set<Integer> evenNumbers = new TreeSet<>();
        for (int i = 0; i < nums.size(); ++i) {
            if (nums.get(i) % 2 == 0 && !evenNumbers.contains(nums.get(i))) {
                evenNumbers.add(nums.get(i));
            }
        }

        if (!evenNumbers.isEmpty()) {
            System.out.println("Все четные числа в списке в порядке возрастания:");
            String evenNumber = evenNumbers.toString();
            evenNumber = evenNumber.replace("[","");
            evenNumber = evenNumber.replace("]","");
            evenNumber = evenNumber.replace(",","");
            System.out.print(evenNumber);
            System.out.println();
            System.out.println();
        } else {
            System.out.println("В списке нет четных чисел!");
            System.out.println();
        }

    }

    public static void printUniqueString(List<String> strings) {
        List<String> uniqueStrings = new ArrayList();

        for (int i = 0; i < strings.size(); ++i) {
            if (!uniqueStrings.contains(strings.get(i))) {
                uniqueStrings.add(strings.get(i));
            }
        }

        if (!uniqueStrings.isEmpty()) {
            System.out.println("Все уникальные строки в списке:");
            for (int i = 0; i < uniqueStrings.size(); ++i) {
                System.out.print(uniqueStrings.get(i) + " ");
            }

            System.out.println();
            System.out.println();
        } else {
            System.out.println("В списке все элементы имееют повторения!");
            System.out.println();
        }

    }

    public static void printCountDoubleInList(List<String> strings) {
        int globalCount = 0;
        int count = 0;
        List<String> copyStrings = new ArrayList(strings);

        for (int i = 0; i < strings.size(); ++i) {
            for (int j = 0; j < strings.size(); ++j) {
                if (copyStrings.contains(strings.get(i))) {
                    copyStrings.remove(strings.get(i));
                    ++count;
                }
            }

            if (count > 1) {
                System.out.println(strings.get(i) + " повторяется " + count + " раза");
                ++globalCount;
            }

            count = 0;
        }

        if (globalCount <= 0) {
            System.out.println("В списке нет повторений!");
            System.out.println();
            System.out.println();
        } else {
            System.out.println("В списке всего " + globalCount + " повторения");
            System.out.println();
        }
    }
}
