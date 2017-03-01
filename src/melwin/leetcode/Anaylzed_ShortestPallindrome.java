package melwin.leetcode;

// ||STRING|| ||PALLINDROME|| ||KMP||
// ||

public class Anaylzed_ShortestPallindrome {

	// source : https://github.com/IDeserve/learn/blob/master/ShortestPalindrome.java
	
	public  static String shortestPalindrome(String s)
	{
		String rev_s = new StringBuilder(s).reverse().toString();
		//use special character to avoid overlap
		String l = s + "#" + rev_s; 
		
		int[] p = new int[l.length()];
		
		//build KMP table.
		//i -> suffix boundary
		//j -> prefix boundary
		for(int i=1; i<l.length(); i++)
		{
			//update prefix boundary to previous match position
			int j = p[i-1];
			
			//move to the last prefix boundary match
			while(j>0 && l.charAt(i)!=l.charAt(j))
				j = p[j-1];
			
			//if prefix boundary matches suffix boundary,
			//increase prefix length 
			if(l.charAt(i) == l.charAt(j)) p[i] = j + 1;
		}
		
		return rev_s.substring(0, s.length() - p[l.length() - 1]) + s;
	}
	
	
	public static void main(String[] args) {
	}

}
