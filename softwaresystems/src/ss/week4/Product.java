package ss.week4;

public class Product implements Function {

	private Function g;
	private Function h;
	
	public Product (Function g, Function h) {
		this.g = g;
		this.h = h;
		
	}
	
	@Override
	public double apply(double x) {
		return g.apply(x) * h.apply(x);
	}

	@Override
	public Function derivative() {
		return new Sum((new Product(g.derivative(), h)), 
				(new Product(h.derivative(), g))) ;
	}
	
	public String toString() {
		return g + "*" + h;
	}

}
