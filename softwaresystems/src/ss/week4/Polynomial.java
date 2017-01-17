package ss.week4;

public class Polynomial implements Function, Integrandable {

	public LinearProduct[] polynomials;
	
	public Polynomial(double[] array) {
		polynomials = new LinearProduct[array.length];
		for (int i = 0; i < array.length; i++) {
			polynomials[i] = new LinearProduct(new Exponent(i), new Constant(array[i]));
		}
	}
	
	@Override
	public double apply(double x) {
		double result = 0.0;
		for (int i = 0; i < polynomials.length; i++) {
			result += polynomials[i].apply(x);
			
		}
		
		return result;

	}

	@Override
	public Function derivative() {
		Function sum = null;
		for (int i = 0; i < polynomials.length - 1; i++) {
			sum = new Sum(sum, polynomials[i].derivative());
			}
		return sum;
	}
	
	@Override
	public Function integrand() {
		Function sum = null;
		for (int i = 0; i < polynomials.length; i++) {
			sum = new Sum(sum, polynomials[i].integrand());
			}
		return sum;
		
	}
	
	public String toString() {
		return "f(x) = a(n)*x^n + a(n-1)*x*(n-1) + ... + a1*x + a0";
	}

}
