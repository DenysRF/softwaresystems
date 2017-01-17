package ss.week4.test;

import org.junit.Before;
import org.junit.Test;

import ss.week4.Constant;
import ss.week4.LinearProduct;
import ss.week4.Polynomial;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {

		private static final double DELTA = 1e-15;
		private static final double CONSTANT_VALUE = Math.PI;
	    private Polynomial polynomial;

	    @Before
	    public void setUp() {
	    	polynomial = new Polynomial(new double[CONSTANT_VALUE]);
//	    	double[] array = new array[CONSTANT_VALUE];
//	    	polynomial = new Polynomial(array);
	    	
	    }

	    @Test
	    public void testApply() {
	        assertEquals(CONSTANT_VALUE * CONSTANT_VALUE, polynomial.apply(0), DELTA);
	        assertEquals(CONSTANT_VALUE * CONSTANT_VALUE, polynomial.apply(-1), DELTA);
	        assertEquals(CONSTANT_VALUE * CONSTANT_VALUE, polynomial.apply(1), DELTA);
	    }

	    @Test
	    public void testDerivative() {
	        assertTrue(polynomial.derivative() instanceof Polynomial);
	        assertEquals(0.0, polynomial.derivative().apply(0), DELTA);
	    }
	}
