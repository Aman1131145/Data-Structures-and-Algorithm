package OOPs1.fraction;

public class fractionUse {

    public static void temp() {
		fraction f1 = new fraction(20,30);
		f1.print();
		// 2/3
		
		f1.setNumerator(12);
		// 4/1
		int d = f1.getDenominator();
		System.out.println(d);
		f1.print();
		
		f1.setNumerator(10);
		int i = 47;
		try {
			f1.setDenominator(0);
			i++;
		}catch(ZeroDenominatorException e) {
			System.out.println("Hey don't input 0 as denominator");
		}finally{
			System.out.println("Finally Block Printed");
		}
		System.out.println(i);
		
		fraction f2 = new fraction(3,4);
		f1.add(f2);
		f1.print();
		// f1 => 13/12
		f2.print();
		// f2 => 3/4
		
		fraction f3 = new fraction(4,5);
		f3.multiply(f2);
		f3.print();
		// f3 => 3/5
		f2.print();
		// f2 => 3/4

		fraction f4 = fraction.add(f1, f3);
		f1.print();
		f3.print();
		f4.print();
	}
	public static void main(String[] args) {
		temp();
	}
}
