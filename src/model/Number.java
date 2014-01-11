package model;

import java.text.DecimalFormat;

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
        numerator = (long) number;
        denominator = 1;
        while (numerator != number * denominator) {
            denominator *= denominator * 10;
            numerator *= (long) (number * denominator);
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

    private void reduce() {
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        for (int i : primeNumbers) {
            while (this.numerator % i == 0 && this.denominator % i == 0) {
                this.numerator /= i;
                this.denominator /= i;
            }
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof Number) {
            return equals((Number) object);
        }
        return false;
    }

    private boolean equals(Number number) {
        return (numerator == number.numerator && denominator == number.denominator);
    }

    public Number multiply(Number number) {
        return new Number(numerator * number.numerator, denominator * number.denominator);
    }

    @Override
    public String toString() {
        DecimalFormat df=new DecimalFormat("0.00");
        return df.format((double)getNumerator()/(double)getDenominator())+"";
    }
}
