package dsApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectSort {

	public static void sortIncreasing(int[] a, int n) {
		for (int index = 0; index < n - 1; index++) {
			int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
			swap(a, index, indexOfNextSmallest);
		}
	}

	private static int getIndexOfSmallest(int[] a, int first, int last) {
		int min = a[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++) {
			if (a[index] < min) {
				min = a[index];
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}

	public static void sortDecreasing(int[] a, int n) {
		for (int index = 0; index < n - 1; index++) {
			int indexOfNextLargest = getIndexOfLargest(a, index, n - 1);
			swap(a, index, indexOfNextLargest);
		}
	}

	private static int getIndexOfLargest(int[] a, int first, int last) {
		int max = a[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++) {
			if (a[index] > max) {
				max = a[index];
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static <T extends Comparable<? super T>> int alphabetical(String[] a, int first, int last) {
		String min = a[first];
		int indexOfMin = first;
		String longest = "";

		for (int index = first + 1; index <= last; index++) {
			if (a[index].length() > min.length()) {
				longest = a[index];
			} else {
				longest = min;
			}

			if (a[index].charAt(0) < min.charAt(0)) {
				min = a[index];
				indexOfMin = index;
			} else if (a[index].charAt(0) == min.charAt(0)) {
				boolean flag = true;
				for (int i = 0; i < longest.length(); i++) {
					if (a[index].charAt(i) < min.charAt(i)) {
						min = a[index];
						indexOfMin = index;
						flag = false;
					}
				}
			}
		}
		return indexOfMin;
	}

	public static void sortAlphabet(String[] a, int n) {
		for (int index = 0; index < n - 1; index++) {
			int indexOfNextSmallest = alphabetical(a, index, n - 1);
			swap(a, index, indexOfNextSmallest);
		}
	}

//	public static ObservableList<String> searchFunc(String a, ObservableList<String> items) {
//		
//		ObservableList<String> n = FXCollections.observableArrayList();
//		
//		a = a.toLowerCase();
//		
//		for(String g : items) {
//			if(g.toLowerCase().contains(a)) {
//				n.add(g);
//			}
//		}
//		return n;
//	}

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
		ArrayList<String> result = new ArrayList();
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
	public static void searchFunc(String a, ObservableList<String> items) {
		Collections.sort(items, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				Integer _o1 = scoreOfSentence(a, o1);
				Integer _o2 = scoreOfSentence(a, o2);
				return Integer.valueOf(_o2.compareTo(_o1));
			}

		});
	}
}
