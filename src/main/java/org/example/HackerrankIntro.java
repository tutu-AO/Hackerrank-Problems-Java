package org.example;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class HackerrankIntro {

    //12. Java Date and Time
    /**
     * The Calendar class is an abstract class that provides methods for converting between a specific
     * instant in time and a set of calendar fields such as YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on,
     * and for manipulating the calendar fields, such as getting the date of the next week.
     *
     * You are given a date. You just need to write the method, getDay,
     * which returns the day on that date. To simplify your task, we
     * have provided a portion of the code in the editor.
     *
     * Example:
     * month=8
     * day=14
     * year=2017
     *
     * The method should return MONDAY as the day on that date. */
    public static String findDay(int month, int day, int year) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.YEAR, year);

        String res = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
        return res;
    }

    public static void main(String[] args) {
        // Hackerrank Introduction to Java Questions
        //1. Welcome to Java
        /**
         * Welcome to the world of Java! In this challenge, we practice printing to stdout.
         * You must print two lines of output:
         *     Print Hello, World. on the first line.
         *     Print Hello, Java. on the second line.
         */
        System.out.println("Hello, World");
        System.out.println("Hello, Java");

        //2. Java Stdin and Stdout I
        /**
         * Most HackerRank challenges require you to read input from stdin (standard input) and
         * write output to stdout (standard output).One popular way to read input from stdin is
         * by using the Scanner class and specifying the Input Stream as System.in.
         *
         * Task:
         * In this challenge, you must read 3 integers from stdin and then print them to stdout.
         * Each integer must be printed on a new line. To make the problem a little easier, a
         * portion of the code is provided for you in the editore below.
         *
         * input:
         * 42
         * 100
         * 125
         *
         * output:
         * 42
         * 100
         * 125
         * */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        //3. Java If-Else
        /**
         * In this challenge, we test your knowledge of using if-else conditional statements to automate decision-making processes.
         * Task: Given an integer, n, perform the following conditional actions:
         *      If is odd, print Weird
         *      If is even and in the inclusive range of to print Not Weird
         *      If is even and in the inclusive range of to, print Weird
         *      If is even and greater than , print Not Weird
         * Complete the stub code provided in your editor to print whether or not is weird.
         * */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N % 2 == 1){
            System.out.println("Weird");
        } else if (N % 2 == 0 && (N >= 2 && N <= 5)) {
            System.out.println("Not Weird");
        } else if (N % 2 == 0 && (N >= 6 && N <= 20)) {
            System.out.println("Weird");
        } else if (N % 2 == 0 && N > 20) {
            System.out.println("Not Weird");
        }

        //4. Java Stdin and Stdout II
        /**
         * In this challenge, you must read an integer, a double, and a String from stdin,
         * then print the values according to the instructions in the Output Format section below.
         * Input Format
         * There are three lines of input:
         *
         *     The first line contains an integer.
         *     The second line contains a double.
         *     The third line contains a String.
         *     */
        Scanner s = new Scanner(System.in);
        int aInt = s.nextInt();
        Double bDouble = s.nextDouble();
        s.nextLine();
        String cStr = s.nextLine();

        System.out.println("Integer: " + aInt);
        System.out.println("Double: " + bDouble);
        System.out.println("String: " + cStr);

        //5. Java Output Formatting
        /**
         * Java's System.out.printf function can be used to print formatted output.
         * The purpose of this exercise is to test your understanding of formatting output using printf.
         * Input Format:
         * Every line of input will contain a String followed by an integer.
         * Each String will have a maximum of
         * alphabetic characters, and each integer will be in the inclusive range from 0 to 999 .
         * */
        Scanner s1 = new Scanner(System.in);
        System.out.println("===========================================================");
        for(int i = 0; i < 3; i++){
            String str = s1.next();
            int digits = s1.nextInt();
            System.out.printf("%-14s %03d %n", str, digits);
        }
        System.out.println("===========================================================");

        //6. Java Loops I
        /**
         * In this challenge, we're going to use loops to help us do some simple math.
         * Task:
         * Given an integer, N, print its first 10 multiples. Each multiple N x i(where 1 <= i <= 10)
         * should be printed on a new line in the form: N x i = result.
         *
         * */
        Scanner s2 = new Scanner(System.in);
        int m = s2.nextInt();
        for(int i = 1; i < 11; i++){
            System.out.println(m+" x "+i+" = "+ (m*i));
        }

        //7. Java Loop II
        Scanner scc = new Scanner(System.in);
        int t = scc.nextInt();
        for(int i = 0; i < t; i++){
            int ax = scc.nextInt();
            int bx = scc.nextInt();
            int nx = scc.nextInt();

            int acc = 0;
            for(int j = 0; j < nx; j++){
                acc += Math.pow(2, j) * bx;
                System.out.print((ax + acc) + " ");
            }
            System.out.println();
        }

        //8. Java Datatypes
        /**
         * Java has 8 primitive data types; char, boolean, byte, short, int, long, float, and double.
         * For this exercise, we'll work with the primitives used to hold integer values (byte, short, int, and long):
         *     A byte is an 8-bit signed integer.
         *     A short is a 16-bit signed integer.
         *     An int is a 32-bit signed integer.
         *     A long is a 64-bit signed integer.
         * Given an input integer, you must determine which primitive data types are capable of properly storing that input.
         *  The first line contains an integer, T denoting the number of test cases.
         *  Each test case, T comprises a single line with an integer, n which can be arbitrarily large or small.
         *  */
        Scanner in = new Scanner(System.in);
        int ii = in.nextInt();
        for(int i = 0; i < ii; i++){
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127){
                    System.out.println("* byte");
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                }else if(x>=-32768 && x<=32767){
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                }else if(x>=-Math.pow(2, 31) && x<=Math.pow(2, 31)-1){
                    System.out.println("* int");
                    System.out.println("* long");
                }else if(x>=-Math.pow(2, 63) && x<=Math.pow(2, 63)-1){
                    System.out.println("* long");
                }
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }

        //9. Java End-of-file
        /**
         * The challenge here is to read lines of input until you reach EOF, then number and print all lines of content.
         * Hint: Java's Scanner.hasNext() method is helpful for this problem.
         * Input Format:
         * Read some unknown
         * lines of input from stdin(System.in) until you reach EOF; each line of input contains a non-empty String.
         *
         * */
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        while (scanner.hasNext()){
            System.out.println(count +" "+scanner.nextLine());
            count++;
        }
        scanner.close();

        //10. Java Static Initializer Block
        /**
         * Static initialization blocks are executed when the class is loaded, and
         * you can initialize static variables in those blocks. It's time to test your
         * knowledge of Static initialization blocks. You are given a class Solution with a main method.
         * Complete the given code so that it outputs the area of a parallelogram with breadth and height.
         * You should read the variables from the standard input.
         *
         * If B <= 0 or H <= 0, the output should be "java.lang.Exception: Breadth and height must be positive" without quotes.
         * */
        Scanner sp = new Scanner(System.in);
        int B = sp.nextInt();
        int H = sp.nextInt();
        if(B <= 0 || H <= 0){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }else{
            System.out.println(B * H);
        }

        //11. Java Int to String
        /**
         * You are given an integer n, you have to convert it into a string.
         * Please complete the partially completed code in the editor.
         * If your code successfully converts into a string the code
         * will print "Good job". Otherwise it will print "Wrong answer".
         *
         * n can range between -100 to 100 inclusive.
         * */
        Scanner sx = new Scanner(System.in);
        int p = sx.nextInt();
        String str = Integer.toString(p);
        if (p == Integer.parseInt(str)) {
            System.out.println("Good job");
        } else {
            System.out.println("Wrong answer.");
        }

        //12. Java Date and Time
        /**calling the method findDay*/
        String res = findDay(8, 14, 2017);
        System.out.println(res); // prints MONDAY

        //13. Java Currency Formatter
        /**
         * Given a double-precision number, payment, denoting an amount of money,
         * use the NumberFormat class' getCurrencyInstance method to convert
         * payment into the US, Indian, Chinese, and French currency formats.
         * Then print the formatted values as follows:
         *
         * US: formattedPayment
         * India: formattedPayment
         * China: formattedPayment
         * France: formattedPayment
         *
         * where formattedPayment is payment formatted according to the appropriate Locale's currency.
         *
         * Note: India does not have a built-in Locale, so you must construct one where the language is en (i.e., English).
         * */
        Scanner curScan = new Scanner(System.in);
        double payment = curScan.nextInt();

        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }

}



