package ss.week2;

public class Rectangle {
    private int length;
    private int width;
    private int area;
    private int perimeter;


    //@ private invariant length >= 0;
    //@ private invariant width >= 0;
    /**
     * Create a new Rectangle with the specified length and width.
     */
    /*@
		requires theLength >= 0 && theWidth >= 0;
		ensures length() == theLength;
		ensures width() == theWidth;
     */
    public Rectangle(int theLength, int theWidth) {
    	assert theLength >= 0;
    	assert theWidth >= 0;
    	
    	length = theLength;
    	width = theWidth;
    	assert length() == theLength;
    	assert width() == theWidth;
	
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ ensures \result >= 0;
    /*@ pure */ public int length() {
    	assert length >= 0;
    	return length;
    	
    }

    /**
     * The width of this Rectangle.
     */
    //@ ensures \result >= 0;
    /*@ pure */ public int width() {
    	assert width >= 0;
    	return width;
    	
    	
    }

    /**
     * The area of this Rectangle.
     */
    //@ ensures \result >= 0;
    //@ ensures \result == length() * width();
    public int area() {
    	
    	assert length() >= 0;
    	assert width() >= 0;
    	assert area >= 0;
    	assert length * width == length() * width();
    	
    	area = length * width;
    	return area;
    	
    	
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ ensures \result >= 0;
    //@ ensures \result == 2*length() + 2*width();
    public int perimeter() {
    	
    	assert length() >= 0;
    	assert width() >= 0;
    	assert perimeter >= 0;
    	assert 2*(length + width) == 2*length() + 2*width();
    	
    	perimeter = 2*(length + width);
    	return perimeter;
    	
    	
    }
}
