package dsApp;
public class ProjectSort {

	public static void sortIncreasing(int[] a, int n)
	{
		for (int index = 0; index < n - 1; index++)
		{
			int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
			swap(a, index, indexOfNextSmallest);
		}
	}
	
	private static int getIndexOfSmallest(int[] a, int first, int last)
	{
		int min = a[first];
		int indexOfMin = first;
		for(int index = first + 1; index <= last; index++)
		{
			if(a[index] < min)
			{
				min = a[index];
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}
	
	public static void sortDecreasing(int[] a, int n)
	{
		for (int index = 0; index < n - 1; index++)
		{
			int indexOfNextLargest = getIndexOfLargest(a, index, n - 1);
			swap(a, index, indexOfNextLargest);
		}	
	}
	
	private static int getIndexOfLargest(int[] a, int first, int last)
	{
		int max = a[first];
		int indexOfMin = first;
		for(int index = first + 1; index <= last; index++)
		{
			if(a[index] > max)
			{
				max = a[index];
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}
	
	
	private static void swap(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void swap(String[] a, int i, int j)
	{
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static <T extends Comparable<? super T>> int alphabetical(String[] a, int first, int last)
	{
		String min = a[first];
		int indexOfMin = first;
		String longest = "";
		
		for(int index = first + 1; index <= last; index++)
		{
			if(a[index].length() > min.length())
			{
				longest = a[index];
			}
			else {
				longest = min;
			}
			
			if(a[index].charAt(0) < min.charAt(0))
			{
				min = a[index];
				indexOfMin = index;
			}
			else if(a[index].charAt(0) == min.charAt(0)) 
			{
				boolean flag = true;
				for(int i = 0; i < longest.length(); i++) {
					if(a[index].charAt(i) < min.charAt(i))
					{
						min = a[index];
						indexOfMin = index;
						flag = false;
					}
				}
			}
		}
		return indexOfMin;
	}
	
	public static void sortAlphabet(String[] a, int n)
	{
		for (int index = 0; index < n - 1; index++)
		{
			int indexOfNextSmallest = alphabetical(a, index, n - 1);
			swap(a, index, indexOfNextSmallest);
		}
	}
	
	public static String[] searchFunc(String a, String[] s) {
		
		String[] f = new String[s.length];
		int j = 0;
		
		for(int i = 0; i < s.length; i++) {
			if(s[i].contains(a)) {
				f[j] = s[i];
				j++;
			}
		}
		
		String[] l = new String[j];
		
		for(int i = 0; i < s.length; i++) {
			if(f[i] != null) {
				l[i] = f[i];
			}
		}
		
		return l;
	}

}
