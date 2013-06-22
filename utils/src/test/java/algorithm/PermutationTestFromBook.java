package algorithm;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * 주어진 문자열에서 모든 수열을 구하시오.
 * 
 * @author Administrator
 *
 */

public class PermutationTestFromBook {
	
	private List<String> findPermutations(String s) {
		if (s == null) {
			return null;
		}
		
		List<String> permutations = Lists.newArrayList(); 
		if (s.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		char first = s.charAt(0);
		String remainder = s.substring(1);
		List<String> words = findPermutations(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String result = insertChartAt(word, first, j);
				permutations.add(result);
			}
		}
		
		return permutations;
	}

	private String insertChartAt(String word, char first, int j) {
		String start = word.substring(0, j);
		String end = word.substring(j);

		return start + first + end;
	}
	
	@Test
	public void testN3() {
		List<String> result = findPermutations("abc");
		System.out.println(result);
		assertThat(result.size(), is(6));
	}
}
