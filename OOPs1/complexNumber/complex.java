package OOPs1.complexNumber;

public class complex {

    private int real;
    private int imaginary;

    public complex(int real,int imaginary){
        this.imaginary = imaginary;
        this.real = real;
    }

    
    public int getImaginary(){
        return imaginary;
    }
    
    public int getReal(){
        return real;
    }
    
    public void setReal(int r){
        this.real = r;
    }
    
    public void setImaginary(int i){
        this.imaginary = i;
    }

    public void print(){
        if(imaginary<0){
            System.out.println(real + " " + imaginary + "i");
        }else{
            System.out.println(real + "+" + imaginary + "i");
        }
    }

    public void add(complex c2){
        this.real = this.real + c2.real;
        this.imaginary = this.imaginary + c2.imaginary;
    }

    public void multiply(complex c2){
        this.real = (this.real*c2.real) + (this.imaginary*c2.imaginary)*(-1);
        this.imaginary = (this.real*c2.imaginary)+(this.imaginary*c2.real);
    }

    public complex conjugate() {
        this.real = this.real*1;
        this.imaginary = this.imaginary*(-1);
        complex c = new complex(this.real,this.imaginary);
        return c;
    }
    
    public static complex add(complex c1, complex c3) {
        int newr = c1.real + c3.real;
        int newi = c1.imaginary + c3.imaginary;
        complex c = new complex(newr, newi);
        return c;
    }

}
