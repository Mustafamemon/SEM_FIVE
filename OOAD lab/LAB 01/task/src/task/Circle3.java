package task;
//--------------------------------Question 3----------------------//
//Super Class
public class Circle3 {
	private double radius ;
	
	public Circle3() {
		// TODO Auto-generated constructor stub
		radius = 2.0;
	}

	public double getRadius() {
		return radius;
	}
	public double getArea() {
		return radius*radius*Math.PI;
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + " Area=" +  getArea() + "]";
	}

}

