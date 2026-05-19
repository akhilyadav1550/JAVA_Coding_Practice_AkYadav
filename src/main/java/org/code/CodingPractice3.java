package org.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodingPractice3 {

	public static void main(String args[]) {
		
//		Set<Character> set = new HashSet<>();
//		
//		String str = "programming";
////		str.chars().mapToObj(c->(char)c)
////		.collect(Collectors.groupingBy(
////				Function.identity(),
////				Collectors.counting())).entrySet().stream().filter(v -> v.getValue() > 1).forEach(r->System.out.print(r.getKey()));
//		
//		
//		List<Character> finalAns = str.chars().mapToObj(c->(char)c)
//		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
//		.filter(v->v.getValue()>1)
//		.map(t ->t.getKey()).collect(Collectors.toList());
// 
//		System.out.println(finalAns);
		
		
		String s = "abcabcbb";

		Set<Character> StringSet = new HashSet<>();

		int left = 0, max = 0;
		for (int right = 0; right < s.length(); right++) {
			while (StringSet.contains(s.charAt(right))) {
				StringSet.remove(s.charAt(left++));
			}
			StringSet.add(s.charAt(right));
			max = Math.max(max, right - left + 1);
		}
		System.out.println("Max substring length is " + max);
		
		

		int[] arr1 = { 1, 2, 2, 3, 4 };
		int[] arr2 = { 2, 2, 3, 5 };
		
		
		Set<Integer> firstSet = Arrays.stream(arr1).boxed().collect(Collectors.toSet());		
		String collectCommonResult = Arrays.stream(arr2).boxed().filter(c->firstSet.contains(c))
		.map(String::valueOf)
		.collect(Collectors.joining(",","{","}"));
		
		System.out.println(collectCommonResult);
		
		
		String makereverse = "JAAava is powerful";
		String reverseResult = Arrays
				.stream(makereverse.split(" "))
				.reduce((a,b)->b+" "+a)
				.map(String::toUpperCase)
				.orElse("NA");
		System.out.println(reverseResult);
		
		Map<Character, Long> charFrequencycount = makereverse.chars().mapToObj(c -> (char) c)
				.filter(c -> c != ' ')
				.map(c -> Character.toLowerCase(c))
				.collect(Collectors.groupingBy(Function.identity(),
						Collectors.counting()));
		
		System.out.print(charFrequencycount);
		
	}
}