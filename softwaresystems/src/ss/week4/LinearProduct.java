package ss.week4;

public class LinearProduct extends Product implements Function, Integrandable {

	private Constant c;
	private Function g;
	
	public LinearProduct(Function g, Constant c) {
		super(g, c);
		this.g = g;
		this.c = c;
	}

	@Override
	public double apply(double x) {
		return g.apply(x) * c.apply(x);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(g.derivative(), c);
	}
	
	@Override
	public Function integrand() {
		if (g instanceof Integrandable) {
		return new LinearProduct(((Integrandable)g).integrand(), c);
		} else {
			return null;
		}
	}
	
	public String toString() {
		return g + " * " + c;
	}
	
}
