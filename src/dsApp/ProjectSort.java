package dsApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * 
 * @author Manyeuris Soriano
 *
 */
public class ProjectSort {
	/**
	 * 
	 * @param s1 - first string being compared to
	 * @param s2 - second string being compare to
	 * @return number of related characters based of position and char
	 */
	private static Integer score(String s1, String s2) {
		String smlStr = "";
		String bigStr = "";
		int cnt = 0;
		//determine which string is smaller
		if (s1.length() > s2.length()) {
			smlStr = s2.toLowerCase();
			bigStr = s1.toLowerCase();
		} else {
			smlStr = s1.toLowerCase();
			bigStr = s2.toLowerCase();
		}
		//add to the score based on whether the character is the same char and position
		for (int i = 0; i < smlStr.length(); i++) {
			if (smlStr.charAt(i) == bigStr.charAt(i)) {
				cnt++;
			}
		}
		// return the score
		return cnt;
	}
	/**
	 * 
	 * @param sent string that could be multiple words or not
	 * @return arrayList of each string in the sentence
	 */
	private static ArrayList<String> sentenceToArray(String sent) {
		// create an empty arrayList that will return the sentence into multiple strings
		ArrayList<String> result = new ArrayList<>();
		int curIndex = 0;
		result.add("");
		//add the char until you see a space at which start a new string in a new index
		for(char c: sent.toCharArray()) {
			if(c != ' ') {
				result.set(curIndex, result.get(curIndex)+c);
			} else { 
				curIndex++;
				result.add("");
			}
			
		}
		//retuen that arrayList
		return result;
	}
	/**
	 * 
	 * @param a the search word
	 * @param sent the sentances to search through
	 * @return
	 */
	private static int scoreOfSentence(String a, String sent) {
		
		ArrayList<String> o2Words = sentenceToArray(sent);
		int result = 0;
		for(String s: o2Words) {
			result += score(a, s);
		}
		return result;
	}
	/**
	 * 
	 * @param a the search item
	 * @param items the items to search through
	 */
	public static void searchFunc(String a, ObservableList<ShoppingItem> items) {
		Collections.sort(items, new Comparator<ShoppingItem>() {
			@Override
			public int compare(ShoppingItem o1, ShoppingItem o2) {
				// TODO Auto-generated method stub
				Integer _o1 = scoreOfSentence(a, o1.getName());
				Integer _o2 = scoreOfSentence(a, o2.getName());
				return Integer.valueOf(_o2.compareTo(_o1));
			}

		});
	}
}
