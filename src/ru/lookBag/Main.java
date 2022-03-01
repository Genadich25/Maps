package ru.lookBag;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        List<String> strings = new ArrayList(List.of("кот", "дом", "кот", "окно", "солнце", "окно", "кот"));
        printOddNumbers(nums);
        printEvenNumbersNoDouble(nums);
        printUniqueString(strings);
        printCountDoubleInList(strings);
    }

    public static void printOddNumbers(List<Integer> nums) {
        List<Integer> oddNumbers = new ArrayList();

        for (int i = 0; i < nums.size(); ++i) {
            if ((Integer) nums.get(i) % 2 == 1) {
                oddNumbers.add((Integer) nums.get(i));
            }
        }

        if (!oddNumbers.isEmpty()) {
            System.out.println("Все нечетные числа в списке:");
            Iterator var4 = oddNumbers.iterator();

            while (var4.hasNext()) {
                Integer oddNumber = (Integer) var4.next();
                System.out.print(oddNumber + " ");
            }

            System.out.println();
            System.out.println();
        } else {
            System.out.println("В списке нет нечетных чисел!");
            System.out.println();
        }

    }

    public static void printEvenNumbersNoDouble(List<Integer> nums) {
        List<Integer> evenNumbers = new ArrayList();
        Iterator var2 = nums.iterator();

        Integer evenNumber;
        while (var2.hasNext()) {
            evenNumber = (Integer) var2.next();
            if (evenNumber % 2 == 0 && !evenNumbers.contains(evenNumber)) {
                evenNumbers.add(evenNumber);
            }
        }

        if (!evenNumbers.isEmpty()) {
            System.out.println("Все четные числа в списке без повторений:");
            var2 = evenNumbers.iterator();

            while (var2.hasNext()) {
                evenNumber = (Integer) var2.next();
                System.out.print(evenNumber + " ");
            }

            System.out.println();
            System.out.println();
        } else {
            System.out.println("В списке нет четных чисел!");
            System.out.println();
        }

    }

    public static void printUniqueString(List<String> strings) {
        List<String> uniqueStrings = new ArrayList();

        int i;
        for (i = 0; i < strings.size(); ++i) {
            if (!uniqueStrings.contains(strings.get(i))) {
                uniqueStrings.add((String) strings.get(i));
            }
        }

        if (!uniqueStrings.isEmpty()) {
            System.out.println("Все уникальные строки в списке:");

            for (i = 0; i < uniqueStrings.size(); ++i) {
                PrintStream var10000 = System.out;
                Object var10001 = uniqueStrings.get(i);
                var10000.print((String) var10001 + " ");
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
                PrintStream var10000 = System.out;
                String var10001 = (String) strings.get(i);
                var10000.println(var10001 + " повторяется " + count + " раза");
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
