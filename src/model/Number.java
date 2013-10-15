package model;

public class Number {

    private long numerator;
    private long denominator;

    public Number(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public Number(long numerator) {
        this(numerator, 1);
    }

    public Number(double number) {
        numerator=(long)number;
        denominator=1;
        while(numerator!=number*denominator){
            denominator*=denominator*10;
            numerator*=(long)(number*denominator);
        }
        reduce();
    }

    public Number(Number number) {
        this(number.numerator, number.denominator);
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    private void reduce(){
        int[] primeNumbers = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
        for (int i : primeNumbers) {
            while(this.numerator%primeNumbers[i]==0&&this.denominator%primeNumbers[i]==0){
                this.numerator/=primeNumbers[i];
                this.denominator/=primeNumbers[i];
            }
        }
    }
    
    public boolean equals(Object object){
        if(object==null)return false;
        if(object instanceof Number)return equals((Number)object);
        return false;
    }
    
    private boolean equals(Number number){
        return(numerator==number.numerator&&denominator==number.denominator);
    }

    public Number addition(Number fraction1, Number fraction2) {
        return new Number(fraction1.numerator * fraction2.denominator
                + fraction1.denominator * fraction2.numerator,
                fraction1.denominator * fraction2.denominator);
    }

    public Number subtract(Number fraction1, Number fraction2) {
        return new Number(fraction1.numerator * fraction2.denominator
                - fraction1.denominator * fraction2.numerator,
                fraction1.denominator * fraction2.denominator);
    }

    public Number multiplication(Number fraction1, Number fraction2) {
        return new Number(fraction1.numerator*fraction2.denominator,
                fraction1.denominator*fraction2.numerator);
    }
}