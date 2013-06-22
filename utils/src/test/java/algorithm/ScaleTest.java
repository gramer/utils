package algorithm;

import org.junit.Test;

/**
 * 1억개의 정수 중에 없는 숫자를 찾는 문제
 * 응용시에는 숫자 정렬에도 사용되어 질 수 있다.
 * @author Administrator
 * 
 */
public class ScaleTest {

	// 13의 배수는 저장하지 않는다.
	private int[]  getNumbers() {
		int[] numbers = new int[100000];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 100000);
		}

		return numbers;
	}

	@Test
	public void findNumbers() {
		int[] numbers = getNumbers();
		byte[] bitVector = new byte[numbers.length / 8 + 1];

		for (int n : numbers) {
			bitVector[n / 8] |= 1 << (n % 8);
		}

		for (int i = 0; i < bitVector.length; i++) {
			for (int j = 0; j < 8; j++) {
				if ((bitVector[i] & (1 << j)) != 0) {
					System.out.println("existed value : " + (i * 8 + j));
				}
			}
		}
	}

}
