package algorithm;

import org.junit.Test;

/**
 * 1�ﰳ�� ���� �߿� ���� ���ڸ� ã�� ����
 * ����ÿ��� ���� ���Ŀ��� ���Ǿ� �� �� �ִ�.
 * @author Administrator
 * 
 */
public class ScaleTest {

	// 13�� ����� �������� �ʴ´�.
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
