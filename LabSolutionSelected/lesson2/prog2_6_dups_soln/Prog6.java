package prog2_6_dups_soln;

import java.util.Arrays;

public class Prog6 {
	public static String[] removeDups2(String[] arr) {
		if(arr==null  || arr.length == 0 || arr.length == 1){ 
			return arr;
		} else {
			int pos = 0;
			String[] retArr = new String[arr.length];
			for(String s : arr) {
				if(!belongsTo(retArr, s)) {
					retArr[pos++] = s;
				}
			}
			String[] retval = new String[pos];
			System.arraycopy(retArr, 0, retval, 0, pos);
			return retval;
		}
	}
	/** Returns true if s belongs to a */
	private static boolean belongsTo(String[] a, String s) {
		for(String t : a) {
			if(s.equals(t)) return true;
		}
		return false;
	}
	public static String[] removeDups(String[] arr) {
		if(arr==null  || arr.length == 0 || arr.length == 1){ 
			return arr;
		}
		else {
			int len = arr.length;
			StringBuilder nodups = new StringBuilder(arr[0]);
			for(int i = 1; i < len; ++i) {
				boolean dupFound = false;
				for(int j = 0; j < i; ++j)                                                                                                                                  {
					if(arr[j].equals(arr[i])) {
						dupFound = true;
						break;
					}
				}
				if(!dupFound) {
					nodups.append("," + arr[i]);
				}
			}
			String[] noDupsArray = nodups.toString().split(",");
			return noDupsArray;
			
		}
		

	}
	
	public static void main(String[] args) {
		String[] arr = {"horse", "boy", "horse", "boy", "boy"};
		String[] result = removeDups(arr);
		System.out.println(Arrays.toString(result));
	}

}
