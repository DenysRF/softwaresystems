package ss.week4;

public class MergeSort {
    private int[] list;
    private int[] temp;
    
    private int number;
    
    public void sort(int[] values) {
    	this.list = values;
    	number = values.length;
    	this.temp = new int[number];
    	mergesort(0, number - 1);
    	
    }
    
    private void mergesort (int low, int hi) {
    	if (low < hi) {
    		int middle = low + (hi - low) / 2;
    		mergesort(low, middle);
    		mergesort(middle + 1, hi);
    		merge(low, middle, hi);
    	}
    	
    }
    
    private void merge(int low, int middle, int hi) {
    	for (int i = low; i <= hi; i++) {
    		temp[i] = list[i];
    	}
    	
    int i = low;
    int j = middle + 1;
    int k = hi;
    while (i <= middle && j <= hi) {
    	if (temp[i] <= temp[j]) {
    		list[k] = temp[i];
    		i++;
    	} else {
    		list[k] = temp[j];
    		j++;
    	}
    	k++;
    }
    while (i <= middle) {
    	list[k] = temp[i];
    	k++;
    	i++;
    	}
    }
}
