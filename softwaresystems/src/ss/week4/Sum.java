package ss.week4;

public class Sum implements Function, Integrandable {
	
	private Function g;
	private Function h;
	
	public Sum (Function g, Function h) {
		this.g = g;
		this.h = h;
		
	}
	
	@Override
	public double apply(double x) {
		return g.apply(x) + h.apply(x);
	}

	@Override
	public Function derivative() {
		return new Sum(g.derivative(), h.derivative());

	}
	@Override
	public Function integrand() {
		if (g instanceof Integrandable && h instanceof Integrandable) {
			return new Sum(((Integrandable)g).integrand(), ((Integrandable)h).integrand());
		} else {
			return null;
		}

	}
	
	public String toString() {
		return g + "+" + h;
	}

}
