package algorithm;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 주어진 문자열에서 모든 수열을 구하시오.
 * ㅊ
 * @author Administrator
 *
 */
public class PermutationTest {

	private List<String> findPermutations(List<String> permutations, char c) {
		List<String> result = Lists.newArrayList();

		for (String permutation : permutations) {
			int i = 0, limit = permutation.length(); 
			for (; i < limit; i++) {
				result.add(new StringBuffer(permutation).insert(i, c).toString());
			}
			result.add(new StringBuffer(permutation).append(c).toString());			
		}

		return result;
	}

	public List<String> findAllPermutations(String s) {
		if (s.length() == 1) {
			return Arrays.asList(s);
		}

		List<String> basicPermutations = basicPermutations(s);
		List<String> result = Lists.newArrayList();		
		
		for (int i = 2, limit = s.length(); i < limit; i++) {
			result.addAll(findPermutations(result, s.charAt(i)));
		}
		
		return result;
	}

	// 두 자리로 구할 수 있는 순열을 구한다. 
	private List<String> basicPermutations(String s) {
		List<String> result = Lists.newArrayList();
		result.add(s.charAt(0) + "" + s.charAt(1));
		result.add(s.charAt(1) + "" + s.charAt(0));
		
		return result;
	}
	
	public boolean verify(List<String> permutations) {
		Map<String, Integer> countMap = Maps.newHashMap();
		for (String string : permutations) {
			if (countMap.containsKey(string)) {
				countMap.put(string, countMap.get(string) + 1);
			} else {
				countMap.put(string, 1);				
			}
		}
		
		Map<String, Integer> filteredMap = Maps.filterValues(countMap, new Predicate<Integer>() {

			public boolean apply(Integer input) {
				return input > 1;
			}
		});
		
		return filteredMap.size() == 0;

	}
	
	@Test
	public void testPermutation() {
		assertThat(findAllPermutations("abc").size(), is(6));
	}
	
	@Test
	public void test_중복체크() {
		List<String> result = findAllPermutations("abc");
		assertThat(verify(result), is(true));
	}
	
}
