package melwin.codinginterview.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Chapter 10 	: 	Sorting and Searching
 * Question 2	:	GroupAnagrams
 * 
 * TAGS : ||NEW_TECHNIQUE|| ||ANAGRAM|| ||CRACKING||
 */

public class GroupAnagrams {

	private static HashMap<String, ArrayList<String>> table;
	
	private static void putToTable(){
		for(String s : input){
			char[] array = s.toCharArray();
			Arrays.sort(array);
			String sorted = new String(array);
			if(table.get(sorted)==null){
				table.put(sorted,new ArrayList<String>());
			}
			table.get(sorted).add(s);
		}
	}
	
	private static void printTable(){
		Iterator i = table.entrySet().iterator();
		while(i.hasNext()){
			 Map.Entry pair = (Map.Entry)i.next();
			 System.out.println(pair.getKey()+"\t"+pair.getValue().toString());
		}
	}
	
	private static ArrayList<String> input;
	
	public static void main(String[] args) {
		table = new HashMap<>();
		input = new ArrayList<>();
		input.add("eat");
		input.add("tea");
		input.add("tan");
		input.add("ate");
		input.add("nat");
		input.add("bat");
		
		putToTable();
		printTable();
	}

}
