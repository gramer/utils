package guava;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Objects;

public class AvodingNullTest {
	
	@Test
	@SuppressWarnings("unchecked")
	public void testAvoidNull_nullCase() {
		List<String> nullArg = null;
		List<String> checkedArgs = Objects.firstNonNull(nullArg, Collections.EMPTY_LIST);
		
		assertThat(checkedArgs, is(Collections.EMPTY_LIST));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testAvoidNull_notNullCase() {
		List<String> notNullArg = Arrays.asList("aa");
		List<String> checkedArgs = Objects.firstNonNull(notNullArg, Collections.EMPTY_LIST);
		
		assertThat(checkedArgs, is(notNullArg));
	}
	

}
