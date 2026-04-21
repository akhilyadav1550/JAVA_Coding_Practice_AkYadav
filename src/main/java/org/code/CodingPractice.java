package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodingPractice {

	public static void main(String[] args) {

		String input = "J";
		String str[] = { "Hello", "Akhil", "Jasmine" };

		for (String s : str) {
			if (s.startsWith(input))
				System.out.println(s);
		}
		System.out.println("---------");

		Arrays.stream(str).filter(i -> i.toLowerCase().startsWith(input.toLowerCase())).forEach(System.out::println);

		char inputChar = input.charAt(0);

		System.out.println("---------");

		for (String s : str) {
			if (s.length() > 0 && s.charAt(0) == inputChar)
				System.out.println("withoutBuiltInFunctions -> " + s);
		}

		for (String s : str) {
			if (s.length() > 0) {

				char strch = s.charAt(0);

				if (strch == inputChar || strch == inputChar + 32 || strch == inputChar - 32)
					System.out.println("Using caseSensitive -> " + s);

			}
		}

		System.out.println("-----------------");

		int arr[] = { 1, 2342, 23, 212, 123123, 343, 112 };
		int k = 2;

		Integer string = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(k - 1).findFirst()
				.orElse(-1);

		System.out.println(string);

		System.out.println("-----------------");

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : arr) {
			pq.add(num);
			if (pq.size() > k)
				pq.remove();
		}
		System.out.println(pq.peek());

		System.out.println("-----------------");

		String findDup[] = { "Akhil", "John", "Akhil", "Sam", "John" };

		HashSet<String> hashset = new HashSet<>();

		for (String s : findDup) {
			if (!hashset.add(s))
				System.out.println(s);
		}

		System.out.println("-----------------");
		hashset.clear();
//		System.out.println(hashset);

		List<String> finalAns = Arrays.stream(findDup).filter(i -> !hashset.add(i)).collect(Collectors.toList());
		System.out.println(finalAns);

		System.out.println("-----------------");

		Object[] array = Arrays.stream(findDup)
				.collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(Map.Entry::getKey).toArray();

		String[] findDuplicateResult = Arrays.stream(array).map(i -> i.toString()).toArray(String[]::new);

		System.out.println(Arrays.toString(findDuplicateResult));

		System.out.println("-----------------");

		Stream<String> stream = Stream.of("A", "B", "C", "D");
		System.out.println(stream.findAny().orElse("NA"));

		System.out.println("-----------------");

		String inputStr = "zcharacter is currency";

		inputStr.replace(" ", "").chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().forEach(i -> System.out.println(i.getKey() + "-> " + i.getValue()));

		System.out.println("-----------------");
		
		IntStream.iterate(2, n->n+2).limit(10).forEach(i->System.out.print(i+" "));
		System.out.println("-----------------");		
		IntStream.range(1, 21).filter(i->i%2==0).mapToObj(i->i+" ").forEach(System.out::print);
		System.out.println("-----------------");		
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int FinalSum = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(FinalSum);
		System.out.println("-----------------");
		
		List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
		List<String> upperCasedWords = strings.stream()
				.map(n->n.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(upperCasedWords);
		System.out.println("-----------------");
		
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
		double avgnumber = numbers1.stream().mapToDouble(i->i.doubleValue()).average().orElse(0.00);
		System.out.println(avgnumber);
		System.out.println("-----------------");

		List<String> toBeSorted = Arrays.asList("banannaaaa", "orange", "apple", "grape","Ak");
		toBeSorted.stream().sorted().forEach(i -> System.out.println(i + ", "));
		System.out.println("-----------------");
		String finalConcatenatedString = toBeSorted.stream().sorted().collect(Collectors.joining(","));
		System.out.println(finalConcatenatedString);
		System.out.println("-----------------");
		String maxWord = toBeSorted.stream().max((a,b)->a.length()-b.length()).orElse("NA");
		System.out.println(maxWord);
		System.out.println("-----------------");
		List<Integer> numbertofindMax = Arrays.asList(4, 2, 8, 6, 10);
		Integer secondMaxNumber = numbertofindMax.stream().sorted((n1,n2)->n2-n1).skip(1).findFirst().orElse(0);
		System.out.println(secondMaxNumber);
		System.out.println("-----------------");
		
		List<Integer> checkUniqNums = Arrays.asList(1, 2, 3, 4, 2, 5, 6, 3, 7, 8, 1);
		List<Integer> uniqueNumbers = checkUniqNums.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueNumbers);
		System.out.println("-----------------");
		
		toBeSorted.stream()
		.min(Comparator.comparing(String::length))
		.ifPresentOrElse(System.out::println, ()->System.out.print("NA"));
		System.out.println("-----------------");
		
		List<Integer> SquaresOfNumbers = numbertofindMax.stream().map(n->n*n).collect(Collectors.toList());
		System.out.println(SquaresOfNumbers);
		System.out.println("-----------------");
		
		List<String> wordsStartsWithA = toBeSorted.stream().filter(i->i.toLowerCase().startsWith("a")).collect(Collectors.toList());
		System.out.println(wordsStartsWithA);
		System.out.println("-----------------");
		
		Integer finalProductofNumbers = numbertofindMax.stream().reduce(1,(a,b)->a*b);
		System.out.println(finalProductofNumbers);
		System.out.println("-----------------");
		
		toBeSorted.stream()
		.collect(Collectors.collectingAndThen(Collectors.toList(), 
				list->{
					Collections.reverse(list);
					return list.stream();
		}))
		.collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("-----------------");
		
		List<String> finalReversed = IntStream.rangeClosed(1, toBeSorted.size())
		.mapToObj(i->toBeSorted.get(toBeSorted.size()-i))
		.map(i->new StringBuilder(i).reverse().toString())
		.collect(Collectors.toList());
		System.out.println(finalReversed);
		System.out.println("-----------------");
		
		String finalAns1 = toBeSorted.stream()
		.collect(Collectors.collectingAndThen(Collectors.toList(), list->{
			Collections.reverse(list);
			return list.stream();
		})).collect(Collectors.joining(", "));
		System.out.println(finalAns1);
		System.out.println("-----------------");
		
		List<Integer> listNumToCheck = Arrays.asList(1, 2, 3, 2, 4, 2, 5);
		int target = 2;
		int SecondOccurenceAns = IntStream.range(0,listNumToCheck.size())
		.filter(i->listNumToCheck.get(i).equals(target))
		.skip(1)
		.findFirst().orElse(0);
		System.out.println("SecondOccurence is at index: "+SecondOccurenceAns);
		System.out.println("-----------------");
		
		
			
		
		
		
		
		
		
		
	}
}