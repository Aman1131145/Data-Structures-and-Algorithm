package OOPs1.polynomialClass;

import OOPs1.dynamicArray.DynamicArray;

public class Polynomial {

    DynamicArray coefficients;
    private int deg;
    private int coeff[];
    
    public Polynomial(){
        coeff = new int[10];
        deg = -1;
    }

    private void reconstruct(){
        int temp[] = coeff;
        coeff = new int[coeff.length * 2];
        for(int i = 0; i < temp.length; i++){
            coeff[i] = temp[i];
            System.out.println(coeff);
        }
    }

    public void setCoefficient(int deg, int coeff){
		for(int i = 0; i <= 100; i++){
            if(i>this.coeff.length){
                reconstruct();
            }
            this.coeff[i] = i;
        }
        System.out.println(coeff);
        // if(coeff >= this.coeff.length){
		// 	reconstruct();
		// }else{
		// 	this.deg = deg;
        // 	this.coeff[deg] = coeff;
		// }
    }

    public int getCoefficient(int deg){
        return coeff[deg];
    }

    public int degree(){
        return coeff[deg];
    }

    public void print(){
        for(int i = 0; i <= this.coeff.length; i++){
            if(coeff[i] == 0){
				continue;
			}if(coeff[deg] == 0){
				System.out.println(coeff[i] + "x^" + " + ");
			}else{
				System.out.print(coeff[i] + "x^" + coeff[deg] + " + " );
			}
        }
		System.out.println();
    }

    public void add(Polynomial p){
        int p1 = this.coeff.length;
        int p2 = p.coeff.length;
        int maximum = Math.max(p1,p2);
        for(int i = 0; i <= maximum; i++){
            this.coeff[i] = this.coeff[i] + p.coeff[i];
			if(i > this.coeff.length){
				reconstruct();
			}
        }
    }

    // public void subtract(Polynomial p){}

    // public void multiply(Polynomial p){}
 
    // public int evaluate(int x){

    // }

    // public static Polynomial add(Polynomial p1, Polynomial p2){

    // }
    
//     public class Polynomial {
// 	    private int[] coeffa;
// 	    private int degree;
	    
	    
// 	    public Polynomial(){
// 	        coeffa = new int[5];
// 	        degree = -1;
// 	    }

		
// 		/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
// 		 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
// 		 *  is already present in the polynomial then previous coefficient is replaced by
// 		 *  new coefficient value passed as function argument
// 		*/
// 		public void setCoefficient(int degree, int coeff){
// 	        if (degree >= coeffa.length){
// 	            restructure(degree);
// 	        }
	        
// 	        coeffa[degree] = coeff;
	        
// 	        if (degree >= this.degree){
// 	            this.degree = degree;
// 	        }
			
// 		}
		
// 		// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
// 		public void print(){
// 			for(int i = 0; i<coeffa.length; i++){
// 	            if (coeffa[i]!=0){
// 	                System.out.print(coeffa[i] + "x" + i + " "); //check format of printing.
// 	            }
// 	        }
// 		}

		
// 		// Adds two polynomials and returns a new polynomial which has result
// 		public Polynomial add(Polynomial p){
	        
// 	        Polynomial x = new Polynomial();
	        
// 	        int i = 0;
// 	        int j = 0;
// 	        int k = 0;
	        
// 	        while(i<p.coeffa.length && j<this.coeffa.length){
// 	            x.setCoefficient(k, p.coeffa[i] + this.coeffa[j]);
// 	            k++;
// 	            i++;
// 	            j++;
// 	        }
	        
// 	        while (i<p.coeffa.length){
// 	            x.setCoefficient(k, p.coeffa[i]);
// 	            i++;
// 	            k++;
// 	        }
	        
// 	        while (j<this.coeffa.length){
// 	            x.setCoefficient(k, this.coeffa[j]);
// 	            j++;
// 	            k++;
// 	        }
	        
// 	        return x;
	        
// 		}
		
// 		// Subtracts two polynomials and returns a new polynomial which has result
// 		public Polynomial subtract(Polynomial p){
// 	        Polynomial x = new Polynomial();
	        
// 	        int i = 0;
// 	        int j = 0;
// 	        int k = 0;
	        
// 	        while(i<p.coeffa.length && j<this.coeffa.length){
// 	            x.setCoefficient(k, p.coeffa[i] - this.coeffa[j]);
// 	            k++;
// 	            i++;
// 	            j++;
// 	        }
	        
// 	        while (i<p.coeffa.length){
// 	            x.setCoefficient(k, p.coeffa[i]);
// 	            i++;
// 	            k++;
// 	        }
	        
// 	        while (j<this.coeffa.length){
// 	            x.setCoefficient(k, -this.coeffa[j]);
// 	            j++;
// 	            k++;
// 	        }
	        
// 	        return x;
				
// 		}
		
// 		// Multiply two polynomials and returns a new polynomial which has result
// 		public Polynomial multiply(Polynomial p){
	        
// 	        Polynomial x = new Polynomial();
	        
// 	        for(int i = 0; i<p.coeffa.length;i++){
// 	            for(int j = 0; j<this.coeffa.length; j++){
// 	                if (i+j<=x.degree){
// 	                    x.setCoefficient(i+j, x.coeffa[i+j] + p.coeffa[i] * this.coeffa[j]);
	                    
// 	                }
	                
// 	                else{
// 	                    x.setCoefficient(i+j, p.coeffa[i] * this.coeffa[j]);
// 	                }
// 	            }
// 	        }
	        
// 	        return x;
	        
	        
// 			//return p;
// 		}
	    
// 	    private void restructure(int degree){
// 	        int[] temp = coeffa;
// 	        coeffa = new int[degree+1];
// 	        for(int i = 0; i<temp.length; i++){
// 	            coeffa[i] = temp[i];
// 	        }
// 	    }
}
