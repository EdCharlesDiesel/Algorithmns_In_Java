/**
 * 
 */

import java.util.Arrays;

/**
 * 
 */
public class Knuth_Morris_Pratt {

	/**

	 */
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	//}

	// O(n + m) time | O(m) space
	public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
		int[] pattern = buildPattern(substring);
		return doesMatch(string, substring, pattern);
	}

	public static int[] buildPattern(String substring) {
		int[] pattern = new int[substring.length()];
		Arrays.fill(pattern, -1);
		int j = 0;
		int i = 1;
		while (i < substring.length()) {
			if (substring.charAt(i) == substring.charAt(j)) {
				pattern[i] = j;
				i++;
				j++;
			} else if (j > 0) {
				j = pattern[j - 1] + 1;
			} else {
				i++;
			}
		}
		return pattern;
	}

	public static boolean doesMatch(String string, String substring, int[] pattern) {
		int i = 0;
		int j = 0;
		while (i + substring.length() - j <= string.length()) {
			if (string.charAt(i) == substring.charAt(j)) {
				if (j == substring.length() - 1)
					return true;
				i++;
				j++;
			} else if (j > 0) {
				j = pattern[j - 1] + 1;
			} else {
				i++;
			}
		}
		return false;
	}
}
