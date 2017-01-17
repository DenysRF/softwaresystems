package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.Rectangle;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
	private Rectangle rectangle;
	
	@Before
	public void setUp() {
		rectangle = new Rectangle(10,20);
	}
	
	@Test
	public void testLength() {
		assertEquals (10, rectangle.length());
	}
	
	@Test
	public void testWidth() {
		assertEquals (20, rectangle.width());
	}
	
	@Test
	public void testArea() {
		assertEquals (200, rectangle.area());
	}
	
	@Test
	public void testPerimeter() {
		assertEquals (60, rectangle.perimeter());
	}
}
