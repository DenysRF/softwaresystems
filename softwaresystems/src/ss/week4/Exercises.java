package ss.week4;

public class Exercises {
    public static int countNegativeNumbers(int[] arr) {
        // TODO: implement, see exercise P-4.1
    	int i = 0;
    	int count = 0;
    	while (i < arr.length) {
    		if (arr[i] < 0) {
        		count++;
    		}
    		i++;
   		}
    	return count;
    		
    	}
    	

    public static void reverseArray(int[] ints) {
        // TODO: implement, see exercise P-4.2
    	int low = 0;
    	int high = ints.length - 1;
    	int temp;
    	while (low < high) {
    		temp = ints[low];
    		ints[low] = ints[high];
    		ints[high] = temp;
    		
    		low++;
    		high--;
    	}

    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
