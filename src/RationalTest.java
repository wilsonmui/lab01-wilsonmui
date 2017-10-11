import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
    
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }
    
    //test lcm
    @Test
    public void test_lcm_m6_3(){
        assertEquals(6,Rational.lcm(-6,3));
    }
 
    @Test
    public void test_lcm_6_m3(){
        assertEquals(6,Rational.lcm(6,-3));
    }
    
    @Test
    public void test_lcm_3_7(){
        assertEquals(21,Rational.lcm(3,7));
    }
    
    //test plus
    @Test
    public void test_plus_r20_25_and_r25_20(){
        Rational r_20_25 = new Rational(20,25);
        Rational r_25_20 = new Rational(25,20);
        assertEquals("41/20", r_25_20.plus(r_20_25).toString());
    }
    
    @Test
    public void test_plus_r3_7_and_r13_4(){
        Rational r_3_7 = new Rational(3,7);
        Rational r_13_4 = new Rational(13,4);
        assertEquals("103/28", r_3_7.plus(r_13_4).toString());
    }
    
    @Test
    public void test_plus_r0_1_and_r24_6(){
        Rational r_0_1 = new Rational(0,1);
        Rational r_24_6 = new Rational(24,6);
        assertEquals("4", r_0_1.plus(r_24_6).toString());
    }
    
    @Test
    public void test_plus_m3_1_r5_m7(){
        Rational r_m3_1 = new Rational(-3,1);
        Rational r5_m7 = new Rational(5,-7);
        assertEquals("-26/7", r_m3_1.plus(r5_m7).toString());
    }
    
    //test sum of 2 radicals
    @Test
    public void test_sum_r20_25_and_r25_20(){
        Rational r_20_25 = new Rational(20,25);
        Rational r_25_20 = new Rational(25,20);
        assertEquals("41/20", (Rational.sum(r_20_25, r_25_20)).toString());
    }
    
    @Test
    public void test_sum_r0_1_and_r24_6(){
        Rational r_0_1 = new Rational(0,1);
        Rational r_24_6 = new Rational(24,6);
        assertEquals("4", (Rational.sum(r_0_1, r_24_6)).toString());
    }
    
    @Test
    public void test_sum_m3_1_r5_m7(){
        Rational r_m3_1 = new Rational(-3,1);
        Rational r5_m7 = new Rational(5,-7);
        assertEquals("-26/7", (Rational.sum(r_m3_1,r5_m7)).toString());
    }
   
    //test minus
    @Test
    public void test_minus_r20_25_and_r25_20(){
        Rational r_20_25 = new Rational(20,25);
        Rational r_25_20 = new Rational(25,20);
        assertEquals("9/20", r_25_20.minus(r_20_25).toString());
    }
    
    @Test
    public void test_minus_r3_7_and_r13_4(){
        Rational r_3_7 = new Rational(3,7);
        Rational r_13_4 = new Rational(13,4);
        assertEquals("-79/28", r_3_7.minus(r_13_4).toString());
    }
    
    @Test
    public void test_minus_r0_1_and_r24_6(){
        Rational r_0_1 = new Rational(0,1);
        Rational r_24_6 = new Rational(24,6);
        assertEquals("-4", r_0_1.minus(r_24_6).toString());
    }
    
    @Test
    public void test_minus_m3_1_r5_m7(){
        Rational r_m3_1 = new Rational(-3,1);
        Rational r5_m7 = new Rational(5,-7);
        assertEquals("-16/7", r_m3_1.minus(r5_m7).toString());
    }
    
    //test subtract
    @Test
    public void test_sub_r20_25_and_r25_20(){
        Rational r_20_25 = new Rational(20,25);
        Rational r_25_20 = new Rational(25,20);
        assertEquals("9/20", (Rational.difference(r_25_20, r_20_25)).toString());
    }
    
    @Test
    public void test_sub_r3_7_and_r13_4(){
        Rational r_3_7 = new Rational(3,7);
        Rational r_13_4 = new Rational(13,4);
        assertEquals("-79/28", (Rational.difference(r_3_7,r_13_4)).toString());
    }
    
    @Test
    public void test_sub_r0_1_and_r24_6(){
        Rational r_0_1 = new Rational(0,1);
        Rational r_24_6 = new Rational(24,6);
        assertEquals("-4", (Rational.difference(r_0_1,r_24_6)).toString());
    }
    
    @Test
    public void test_sub_m3_1_r5_m7(){
        Rational r_m3_1 = new Rational(-3,1);
        Rational r5_m7 = new Rational(5,-7);
        assertEquals("-16/7", (Rational.difference(r_m3_1, r5_m7)).toString());
    }
    
    //test recip
    @Test(expected = IllegalArgumentException.class)
    public void test_recip_0_1(){
        Rational r_0_1 = new Rational(0,1);
        Rational rattt = r_0_1.reciprocalOf();
    }
    
    @Test
    public void test_recip_m3_1(){
        Rational r_m3_1 = new Rational(-3,1);
        assertEquals("-1/3", (r_m3_1.reciprocalOf()).toString());
    }
    
    @Test
    public void test_recip_13_4(){
        Rational r_13_4 = new Rational(13,4);
        assertEquals("4/13", (r_13_4.reciprocalOf()).toString());
    }
    
    //test divided by
    
    @Test
    public void test_div_r3_7_and_r13_4(){
        Rational r_3_7 = new Rational(3,7);
        Rational r_13_4 = new Rational(13,4);
        assertEquals("12/91", (r_3_7.dividedBy(r_13_4)).toString());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_div_r0_1_and_r24_6(){
        Rational r_0_1 = new Rational(0,1);
        Rational r_24_6 = new Rational(24,6);
        Rational rattt = r_24_6.dividedBy(r_0_1);
    }
    
    @Test
    public void test_div_m3_1_r5_m7(){
        Rational r_m3_1 = new Rational(-3,1);
        Rational r5_m7 = new Rational(5,-7);
        assertEquals("21/5", (r_m3_1.dividedBy(r5_m7)).toString());
    }
    
    //test quotient
    @Test
    public void test_q_r3_7_and_r13_4(){
        Rational r_3_7 = new Rational(3,7);
        Rational r_13_4 = new Rational(13,4);
        assertEquals("12/91", (Rational.quotient(r_3_7,r_13_4)).toString());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_q_r0_1_and_r24_6(){
        Rational r_0_1 = new Rational(0,1);
        Rational r_24_6 = new Rational(24,6);
        Rational rattt = Rational.quotient(r_24_6, r_0_1);
    }
    
    @Test
    public void test_q_m3_1_r5_m7(){
        Rational r_m3_1 = new Rational(-3,1);
        Rational r5_m7 = new Rational(5,-7);
        assertEquals("21/5", (Rational.quotient(r_m3_1,r5_m7)).toString());
    }
    
    
    
    
    
    
    
    
    
    
    
}
