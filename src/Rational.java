/** A class to represent a rational number
    with a numerator and denominator

    @author P. Conrad for CS56 F16

    */

public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }
    
    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    public Rational(int num, int denom) {
	if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
        
    this.num = num;
    this.denom = denom;
        
    //reduce
	if (num != 0) {
	    int gcd = Rational.gcd(num,denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
    }

    public String toString() {
    //fix - sign in denom
    if (denom < 0){
        denom = denom*-1;
        num = num*-1;
    }
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
    }

    
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
    
    
    //return lcm
    public static int lcm(int a, int b){
        return Math.abs(Math.abs(a*b)/ gcd(a,b));
    }

    //returns sum of this number plus r
    public Rational plus(Rational r){
        int tLcm = lcm(this.denom, r.denom);
        
        //adding step (create 2 new Rationals)
        int s1num = (tLcm/this.denom)*this.num;
        int s2num = (tLcm/r.denom)*r.num;
        /*
        Rational tSum = new Rational( (s1num+s2num), tLcm );
        
        this.num = tSum.getNumerator();
        this.denom = tSum.getDenominator();
        */
        return new Rational( (s1num+s2num), tLcm );
    }
  
    //return addition of two Rationals (create new Rational to deal with reducing)
    public static Rational sum (Rational a, Rational b){
        Rational sumR = a.plus(b);
        return sumR;
    }

    //return this number minus r
    public Rational minus(Rational r){
        Rational neg_1 = new Rational(-1,1);
        Rational neg_r = r.times(neg_1);
        Rational Rminus = this.plus(neg_r);
        
        return Rminus;
    }

    //returns a-b
    public static Rational difference(Rational a, Rational b){
        Rational diffR = a.minus(b);
        return diffR;
    }
    

    //returns reciprocal (swap numerator and denominator). If numerator if zero, throws an instance of java.lang.ArithmeticException
    public Rational reciprocalOf(){
        int tempNum = this.denom;
        int tempDen = this.num;
        
        if (tempNum == 0)
            throw new ArithmeticException();
        return new Rational(tempNum, tempDen);
    }

    //returns this number divided by r
    public Rational dividedBy(Rational r){
        if(r.num==0)
            throw new IllegalArgumentException("denom cannot be zero");
        
        Rational thisR = new Rational(this.num, this.denom);
        Rational recipR = r.reciprocalOf();
        Rational divR = product(thisR,recipR);
        
        return divR;
    }

    //returns a divided by b
    public static Rational quotient(Rational a, Rational b){
        Rational q = a.dividedBy(b);
        return q;
    }
    
   
    
    
}
