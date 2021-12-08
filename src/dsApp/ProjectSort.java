package dsApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectSort {

	private static Integer score(String s1, String s2) {
		String smlStr = "";
		String bigStr = "";
		int cnt = 0;
		if (s1.length() > s2.length()) {
			smlStr = s2.toLowerCase();
			bigStr = s1.toLowerCase();
		} else {
			smlStr = s1.toLowerCase();
			bigStr = s2.toLowerCase();
		}
		for (int i = 0; i < smlStr.length(); i++) {
			if (smlStr.charAt(i) == bigStr.charAt(i)) {
				cnt++;
			}
		}
		return cnt;
	}

	private static ArrayList<String> sentenceToArray(String sent) {
		ArrayList<String> result = new ArrayList<>();
		int curIndex = 0;
		result.add("");
		for(char c: sent.toCharArray()) {
			if(c != ' ') {
				result.set(curIndex, result.get(curIndex)+c);
			} else { 
				curIndex++;
				result.add("");
			}
			
		}
		return result;
	}
	private static int scoreOfSentence(String a, String sent) {
		ArrayList<String> o2Words = sentenceToArray(sent);
		int result = 0;
		for(String s: o2Words) {
			result += score(a, s);
		}
		return result;
	}
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
