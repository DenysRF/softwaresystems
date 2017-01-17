package ss.week4;

public class Constant implements Function, Integrandable {

	private double f;
	
	public Constant (double c) {
		f = c;
	}

	
	@Override
	public double apply(double x) {
		return f;
	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}
	
	@Override
	public Function integrand() {
		return new LinearProduct(new Exponent(1), new Constant(f));
	}

	public String toString() {
		return "(" + f + ")";
	}
}
