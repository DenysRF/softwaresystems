package ss.week4;

public class Exponent implements Function, Integrandable {

	private int n;
	
	public Exponent (int exponent) {
		n = exponent;
	}
	
	@Override
	public double apply(double x) {
		return Math.pow(x, n);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Exponent(n-1), new Constant(n));
	}
	
	@Override
	public Function integrand() {
		return new LinearProduct(new Exponent(n+1), new Constant(1.0/(n+1))); 
	}
	
	public String toString() {
		return "(x^" + n + ")";
	}

}
