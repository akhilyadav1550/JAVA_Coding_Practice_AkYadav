package org.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

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

		Object[] array = Arrays.stream(findDup).collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet()
				.stream()
				.filter(e -> e.getValue() > 1)
				.map(e -> e.getKey())
				.toArray();

		String[] findDuplicateResult = Arrays.stream(array).map(i -> i.toString()).toArray(String[]::new);

		System.out.println(Arrays.toString(findDuplicateResult));

	}
}