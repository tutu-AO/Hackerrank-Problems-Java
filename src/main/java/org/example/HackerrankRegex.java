package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerrankRegex {
    public static void main(String[] args){
        //Matching anything but a newline
        Tester test1 = new Tester();
        test1.check("(([^\\s+]{3})\\.){3}([^\\s+]{3}){1}");

        //Matching whitespace & non-whitespace characters
        /**Match the pattern XXxXXxXX where x denotes whitespace characters
         * and X denotes non-whitespace characters*/
        Tester2 test2 = new Tester2();
        test2.checker("(\\S{2}\\s{1}){2}\\S{2}");

        //Matching word & non-word characters
        /**TASK: you have a test string S. Match the xxxXxxxxxxxxxxXxxx
         * Here x denotes any word character and X denotes any non-word character*/
        Tester2 test3 = new Tester2();
        test3.checker("^\\w+\\W+\\w+\\W+\\w{3}");

        //Match Start & End
        /**Task: Match the pattern Xxxxx. Here, x denotes a word character,
         * and X denotes a digit. S must start with a digit X and end with
         * . symbol. S should be 6 characters long only*/
        Tester2 test4 = new Tester2();
        test4.checker("^\\d{1}\\w{0,4}\\.$");

        //Matching digits & non-digits characters
        /**Task: You have a test string S. Match the pattern xxXxxXxxxx
         * Here x denotes a digit character and X denotes non-digit character*/
        Tester2 test5 = new Tester2();
        test5.checker("(\\d{2}\\D){2}\\d{4}");


    }
}
 class Tester{
    public void check(String pattern){
        Scanner sc = new Scanner(System.in);
        String testString = sc.nextLine();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(testString);

        boolean match = m.matches();
        System.out.format("%s", match);
        sc.close();

        /**
         * test strings:
         * 1123.456.abc.def - expect false
         * 123.125.528.256 - expect true*/
    }

 }
 class Tester2{
    public void checker(String regex){
        Scanner sc = new Scanner(System.in);
        String testString = sc.nextLine();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(testString);
        System.out.println(m.find());

        sc.close();

    }
 }


