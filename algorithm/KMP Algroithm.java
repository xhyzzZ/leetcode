// KMP Algroithm

// JAVA program for implementation of KMP pattern 
// searching algorithm 

class KMP_String_Matching { 

	public static void main(String args[]) { 
		String txt = "ABABDABACDABABCABAB"; 
		String pat = "ABABCABAB"; 
		new KMP_String_Matching().KMPSearch(pat, txt); 
	} 

	public void KMPSearch(String pattern, String txt) { 
		int M = pattern.length(); 
		int N = txt.length(); 

		// create lps[] that will hold the longest 
		// prefix suffix values for pattern 
		int[] lps = new int[M]; 
		int j = 0; // index for pat[] 

		// Preprocess the pattern (calculate lps[] 
		// array) 
		lps = computeLPSArray(pattern); 

		int i = 0; // index for txt[] 
		while (i < N) { 
			if (pattern.charAt(j) == txt.charAt(i)) { 
				j++; 
				i++; 
			} 
			if (j == M) { 
				System.out.println("Found pattern " + "at index " + (i - j)); 
				j = lps[j - 1]; 
			} else if (i < N && pattern.charAt(j) != txt.charAt(i)) {
				// mismatch after j matches 
				// Do not match lps[0..lps[j-1]] characters, 
				// they will match anyway 
				if (j != 0) 
					j = lps[j - 1]; 
				else
					i = i + 1; 
			}
		}
	} 

	private int[] computeLPSArray(String pattern) { 
		int len = pattern.length();
		int[] res = new int[len];
		
		int j = 0; 
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = res[j - 1];
			}
			
			if (pattern.charAt(j) == pattern.charAt(i)) {
				j++;
			}
			res[i] = j;
		}
		return res;
	}
} 
