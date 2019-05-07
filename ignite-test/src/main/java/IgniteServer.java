import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nikhilkumar on 05/02/2017.
 */
public class IgniteServer {
	public static void main(String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("example-ignite.xml");

	}

	private static void run() {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner s = new Scanner(System.in);
		int num = (s.nextInt());
		List<char[]> ccNumbers = new ArrayList<char[]>(num);

		for (int i = 1; i <= num; i++) {
			ccNumbers.add(s.next().toCharArray());
		}

		for (char[] chars : ccNumbers) {
			int A = calculateSumEvenFromRight(chars);
			int B = calculateSumOddFromRight(chars);
			if ((A + B) % 10 == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	private static int calculateSumEvenFromRight(char[] chars) {
		int sum = 0;
		for (int i = chars.length; i > 0; i--) {
			if (i % 2 == 0) {
				sum = +Integer.valueOf(Character.toString((chars[i - 1])));
			}
		}
		return sum;
	}

	private static int calculateSumOddFromRight(char[] chars) {
		int sum = 0;
		for (int i = chars.length; i > 0; i--) {
			if (i % 2 != 0) {
				int temp = Integer.valueOf(Character.toString((chars[i - 1]))) * 2;
//				System.out.println(chars[i-1] );
//				System.out.println(temp);
//				System.out.println(temp/10 + temp%10);
				sum = +(temp / 10 + temp % 10);
			}
		}
		return sum;
	}

}
