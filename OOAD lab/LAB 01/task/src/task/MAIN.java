package task;

public class MAIN {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------------Question No 1--------------");
		Circle c1 = new Circle();
	    System.out.println("The circle has radius of "  + c1.getRadius() + " and area of " + c1.getArea());
	    Circle c2 = new Circle(2.0);
	    System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.getArea());
	    System.out.println("------------Question No 2-------------");
	    Employee e1= new Employee(173795,"Mustafa","Manga",12500);
	    System.out.println(e1);
	    System.out.println("------------Question No 3--------------");
	    System.out.println("------------Super Class--------------");
	    Circle3 c3 = new Circle3();
	    System.out.println(c3);
	    System.out.println("------------Sub Class--------------");
	    Cylinder cy1= new Cylinder();
	    System.out.println(cy1);
	    System.out.println("------------Question No 4--------------");
	    System.out.println("Animal Sound : ");
	    goat g = new goat();
	    cats c =new cats();
	    System.out.println(g.getAnimalSound());
	    System.out.println(c.getAnimalSound());
	    System.out.println("------------Question No 5--------------");
	    System.out.println("-----------OverLoading-----------------");
	    Number n = new Number();
	    System.out.println("Adding Two Number " + n.addingNumber(1, 2));
	    System.out.println("Adding Three Number " + n.addingNumber(1, 2,3));
	    System.out.println("-----------OverRidding-----------------");
	    DerivedNumber dn = new DerivedNumber();
	    System.out.println("Adding Two Number " + dn.addingNumber(5, 2));
	    System.out.println("Adding Three Number " + dn.addingNumber(1, 5,3));

	}

}
