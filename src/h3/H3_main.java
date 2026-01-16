package h3;

import java.util.Arrays;

public class H3_main {
    public static void main(String[] args) {
		int[] arr = mergeSort(new int[]{3,2,1,4,0,12,7,13,9,11,12,99,100,1000});
		for(int x : arr) {
			System.out.println(x);
		}
	}
    
    public static int[] mergeSort(int[] array) {
    	if(array.length<=1) {
    		return array;
    	}else {
			int half = (array.length)/2;
			int[] left = mergeSort(Arrays.copyOfRange(array, 0, half));
			int[] right = mergeSort(Arrays.copyOfRange(array, half, array.length));
			int l = 0;
			int r = 0;
			int[] ergArray = new int[array.length];
			while(l + r < array.length) {
				if(r >= right.length || (l < left.length && left[l] <= right[r])) {
					ergArray[l+r] = left[l];
					l++;
				}else {
					ergArray[l+r] = right[r];
					r++;
				}
			}
			return ergArray;
		}
    }
}
