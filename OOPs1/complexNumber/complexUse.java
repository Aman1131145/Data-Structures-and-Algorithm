package OOPs1.complexNumber;

public class complexUse {
	public static void main(String[] args) {
		complex c1 = new complex(2, 3);
		c1.print();
		
		c1.setReal(10);
		c1.setImaginary(30);
		c1.print();
		
		complex c2 = new complex(1,5);
		c1.add(c2);
		c1.print();
		c2.print();
		
		complex c3 = new complex(3,2);
		c3.multiply(c2);
		c3.print();
		c2.print();
		
		complex c4 = complex.add(c1, c3);
		c1.print();
		c3.print();
		c4.print();
		
		complex c5 = c1.conjugate();
		c5.print();
	}
}