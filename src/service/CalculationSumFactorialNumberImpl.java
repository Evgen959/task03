package service;

import service.interfeces.CalculationSumFactorialNumber;

import java.math.BigInteger;

// This class calculates the Catalan number. Since the Java class Math does not have a method for calculating the Catalan number, to save time, the implementation of the methods was taken from the Internet.

public class CalculationSumFactorialNumberImpl implements CalculationSumFactorialNumber {

    // Method for calculating factorial
    private BigInteger factorial(int n) {
        // Variable declaration. The variable type is BigInteger since result can be very large.
        BigInteger result = BigInteger.ONE;
        // Цикл
        for (int i = 2; i <= n; i++) {
            // The valueOf method converts an int or long number to a BigInteger.
            // The multiply method multiplies two BigInteger objects, a result object and a BigInteger.valueOf(i) object.
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Method for calculating the Sum Factorial Number
    @Override
    public BigInteger sumFactorialNumber(int n) {
        // I declare the variable d for code clarity.
        BigInteger d = factorial(n);
        // Declare and initialize the sum variable
        BigInteger sum = BigInteger.ZERO;
        // Cycle
        while (d.compareTo(BigInteger.ZERO) > 0){
            // .mod(BigInteger.TEN) - BigInteger class method returns the remainder of division by ten
            BigInteger a = d.mod(BigInteger.TEN);
            // add(a) - the method adds the remainder of the division of the variable d to the sum variable
            sum = sum.add(a);
            // .divide(BigInteger.TEN) - BigInteger class method returns the result of division by ten without a remainder
            d = d.divide(BigInteger.TEN);
        }
        return sum;
    }
}
