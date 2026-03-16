package org.code;

import org.code.entity.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {1, 20, 2, 3, 1, 2, 3, 2, 221, 20, 22, 999};

//        Map<Integer, Integer> results = new TreeMap<>();
//
//       for (int num : numbers)
//           results.put(num,results.getOrDefault(num,0)+1);
//
//       System.out.println(results.entrySet());
//
//
//       int totalDuplicates = 0;
//
//       for (Map.Entry<Integer,Integer> entries : results.entrySet()){
//           if (entries.getValue()>1)
//               System.out.println(entries.getKey() + " Appears - > " + entries.getValue()+" Times....");
//       }

//        int[] arr1 = {5, 3, 9, 1}; int[] arr2 = {8, 3, 2, 9, 7};
//
//        TreeSet<Integer> uniqueMap = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed())
//                .collect(Collectors.toCollection(TreeSet::new));
//
//        for (Integer i : uniqueMap) {
//            System.out.println(i);
//        }


//        String str = "Akhil Yadav";
//        String charString = str.chars()
//                .mapToObj(c -> String.valueOf((char) c))
//                .reduce("", (a, b) -> b + a);
//        System.out.println(charString);

        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "Gks");
//        Optional<String> reduceResult    = words.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
//        reduceResult.ifPresent(System.out::println);

//        String sResult = words.stream().max(Comparator.comparingInt(String::length)).orElse(null);


//        String sResult = words.stream().collect(Collectors.maxBy(Comparator.comparingInt(String::length))).orElse("");
//        System.out.println(sResult);


//        List<String> sentences = List.of("hello world", "java streams are powerful");
//
//        List<String> res = sentences.stream().flatMap(s -> Arrays.stream(s.split("\\s+"))).toList();
//        System.out.println(res);

        List<String> words2 = List.of("stream", "flatmap", "distinct");
        List<String> uniqueChars = words2.stream()
                .flatMap(w -> w.chars().mapToObj(c -> String.valueOf((char) c)))
                .distinct()
                .toList();
        System.out.println(uniqueChars);



        record Order(String id, List<String> itemIds) {

            public String getId() { return id; }
            public List<String> getItemIds() { return itemIds; }

        }

        List<Order> orders = List.of(
                new Order("O1", List.of("I1","I2")),
                new Order("O2", List.of("I3")),
                new Order("O3", List.of())
        );

        List<String> allItemIds = orders.stream()
                .flatMap(o -> o.itemIds().stream())
                        .toList();

        System.out.println("allItemIds: "+allItemIds);

        Map<String, List<String>> itemIdsByOrder = new HashMap<>();
        for (Order o : orders) {
            itemIdsByOrder.put(o.getId(), o.getItemIds());
        }

        System.out.println(itemIdsByOrder);


        List<String> input = Arrays.asList("apple", "banana", "cherry", "date", "grapefruit");
        String result = input.stream().max(Comparator.comparing(String::length)).orElse("NULL");
        System.out.println(result);



        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );

        double avgResult = persons.stream()
                .mapToInt(Person::age)
                .average()
                .orElse(0);
        System.out.println(avgResult);

        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> resList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .toList();
        System.out.println(resList);

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l2 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> intersection = l1.stream()
                .filter(l2::contains)
                .collect(Collectors.toList());

        System.out.println(intersection);


        List<Integer> checkDuplicates = Arrays.asList(1,2, 3, 2, 4, 1, 5, 6, 5);
        List<Integer> checkDuplicatesResult = checkDuplicates.stream().distinct().toList();
        System.out.println(checkDuplicatesResult);


//        List<Transaction> transactions = Arrays.asList(
//                new Transaction("2022-01-01", 100),
//                new Transaction("2022-01-01", 200),
//                new Transaction("2022-01-02", 300),
//                new Transaction("2022-01-02", 400),
//                new Transaction("2022-01-03", 500)
//        );
//
//        Map<String, Integer> transResult = transactions.stream()
//                .collect(Collectors.groupingBy(Transaction::getDate,
//                        Collectors.summingInt(Transaction::getAmount)));
//
//        System.out.println(transResult);

        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k=3;

        int resume = Arrays.stream(array)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .orElse(-1);
        System.out.println(resume);


        List<String> checkFreqInput = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> freqCheckResult = checkFreqInput.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqCheckResult);

        List<Integer> checkPartitions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> PartionedByResult = checkPartitions
                .stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        System.out.println("checkPartitions-Input :"+checkPartitions);
        List<Integer> evenNumbers = PartionedByResult.get(true);
        System.out.println("EvenNumbers: "+evenNumbers);
        List<Integer> oddNumbers = PartionedByResult.get(false);
        System.out.println("OddNumbers: "+oddNumbers);
        
//        checking From STS-git
    }
  }