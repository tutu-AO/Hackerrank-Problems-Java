package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HackerrankBigDecimal {
    public static void main(String[] args){
        //Hackerrank BigNumber Questions
        //1. Java BigDecimal
        /**
         * Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!
         * Given an array, s, of n real number strings, sort them in descending order — but wait, there's more!
         * Each number must be printed in the exact same format as it was read from stdin, meaning that .1 is
         * printed as .1, and 0.1 is printed as 0.1. If two numbers represent numerically equivalent values (e.g.,.1 = 0.1),
         * then they must be listed in the same order as they were received as input).
         *
         * Complete the code in the unlocked section of the editor below. You must rearrange array's elements
         * according to the instructions above.
         * Input Format
         *
         * The first line consists of a single integer,n, denoting the number of integer strings.
         * Each line i of the n subsequent lines contains a real number denoting the value of s.*/
        Scanner s1 = new Scanner(System.in);
        int n1 = s1.nextInt();
        String[] arr = new String[n1];
        for (int i = 0; i < n1; i++){
            arr[i] = s1.next();
        }
        //Your code here
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                BigDecimal a = new BigDecimal(o1);
                BigDecimal b = new BigDecimal(o2);
                return b.compareTo(a);
            }
        };
        Arrays.sort(arr, 0, n1, customComparator);

        for(int i = 0; i < n1; i++){
            System.out.println(arr[i]);
        }

        //2. Java Primality Test
        /**
         * A prime number is a natural number greater than 1 whose only positive divisors are 1 and itself.
         * For example, the first six prime numbers are 2, 3, 5, 7, 11, and 13.
         * Given a large integer, n, use the Java BigInteger class' isProbablePrime method to determine
         * and print whether it's prime or not prime.
         *
         * Input Format:
         * A single line containing an integer,n(the number to be checked).
         *
         * Output Format:
         * If n is a prime number, print prime; otherwise, print not prime.*/
        Scanner s2 = new Scanner(System.in);
        BigInteger knownPrime = new BigInteger(s2.next());
        int certainty = 1;

        boolean isPrime = knownPrime.isProbablePrime(certainty);
        if(isPrime){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }

        //3. Java BigInteger
        /**
         * In this problem, you have to add and multiply huge numbers!
         * These numbers are so big that you can't contain them in any ordinary data types like a long integer.
         * Use the power of Java's BigInteger class and solve this problem.
         *
         * Input Format:
         * There will be two lines containing two numbers, a and b.
         *
         * Output Format:
         * Output two lines. The first line should contain a + b, and the second line should contain a x b.
         * Don't print any leading zeros.*/
        Scanner s3 = new Scanner(System.in);
        BigInteger a = s3.nextBigInteger();
        BigInteger b = s3.nextBigInteger();

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
