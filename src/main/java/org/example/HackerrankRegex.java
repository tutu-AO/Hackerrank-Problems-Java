package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerrankRegex {
    public static void main(String[] args){
        //Matching anything but a newline
//        Tester test1 = new Tester();
//        test1.check("(([^\\s+]{3})\\.){3}([^\\s+]{3}){1}");

        //Matching whitespace & non-whitespace characters
        /**Match the pattern XXxXXxXX where x denotes whitespace characters
         * and X denotes non-whitespace characters*/
//        Tester2 test2 = new Tester2();
//        test2.checker("(\\S{2}\\s{1}){2}\\S{2}");

        //Matching word & non-word characters
        /**TASK: you have a test string S. Match the xxxXxxxxxxxxxxXxxx
         * Here x denotes any word character and X denotes any non-word character*/
//        Tester2 test3 = new Tester2();
//        test3.checker("^\\w+\\W+\\w+\\W+\\w{3}");

        //Match Start & End
        /**Task: Match the pattern Xxxxx. Here, x denotes a word character,
         * and X denotes a digit. S must start with a digit X and end with
         * . symbol. S should be 6 characters long only*/
//        Tester2 test4 = new Tester2();
//        test4.checker("^\\d{1}\\w{0,4}\\.$");

        //Matching digits & non-digits characters
        /**Task: You have a test string S. Match the pattern xxXxxXxxxx
         * Here x denotes a digit character and X denotes non-digit character*/
//        Tester2 test5 = new Tester2();
//        test5.checker("(\\d{2}\\D){2}\\d{4}");

        //Matching Specific Characters
        /**Task: Write a regex that will match S with following conditions:
         * S must be to lenght: 6
         * First character: 1, 2, or 3
         * Second character: 1, 2, or 0
         * Third character: x, s, or 0
         * Fourth character: 3, 0, A, or a
         * Fifth character: x, s, or u
         * Sixth character: . or ,
         * */
//        Tester2 test6 = new Tester2();
//        test6.checker("^[1-3][0-2][xs0][30Aa][xsu][.,]$");

        //Excluding Specific Characters
        /**Task:
         * Write a regex that will match S with the following conditions:
         * S must be of length 6
         * First character should not be a digit (1,2,3,4,5,6,7,8,9 or 0).
         * Second character should not be a lowercase vowel (a,e,i,o or u).
         * Third character should not be b, c, D or F.
         * Fourth character should not be a whitespace character ( \r, \n, \t, \f or <space> ).
         * Fifth character should not be a uppercase vowel (A,E,I,O or U).
         * Sixth character should not be a . or , symbol. */
//        Tester2 test7 = new Tester2();
//        test7.checker("^[^\\d][^aeiou][^bcDF][^\\s][^AEIOU][^.,]$");

        //Matching Character Ranges
        /**Task:
         * Write a RegEx that will match a string satisfying the following conditions:
         * The string's length is >= 5.
         * The first character must be a lowercase English alphabetic character.
         * The second character must be a positive digit. Note that we consider zero to be neither positive nor negative.
         * The third character must not be a lowercase English alphabetic character.
         * The fourth character must not be an uppercase English alphabetic character.
         * The fifth character must be an uppercase English alphabetic character.
         * */
//        Tester2 test8 = new Tester2();
//        test8.checker("^[a-z][1-9][^a-z][^A-Z][A-Z]");

        //Matching {x} Repetitions
        /**Task:
         * You have a test string S.
         * Your task is to write a regex that will match S using the following conditions:
         * S must be of length equal to 45.
         * The first 40 characters should consist of letters(both lowercase and uppercase), or of even digits.
         * The last 5 characters should consist of odd digits or whitespace characters.
         * */
//        Tester2 test9 = new Tester2();
//        test9.checker("^[A-Za-z02468]{40}[13579\\s]{5}$");

        //Matching {x, y} Repetitions
        /**
         * Task:
         * You have a test string S.
         * Your task is to write a regex that will match S using the following conditions:
         *
         * S should begin with or digits.
         * After that, S should have 3 or more letters (both lowercase and uppercase).
         * Then S should end with up to 3 .symbol(s). You can end with 0 to 3 .symbol(s), inclusively.
         * */
//        Tester2 test10 = new Tester2();
//        test10.checker("^\\d{1,2}[A-Za-z]{3,}\\.{0,3}$");

        //Matching Zero or More Repetitions
        /**
         * Task:
         * You have a test string .
         * Your task is to write a regex that will match S using the following conditions:
         *
         * S should begin with 2 or more digits.
         * After that, S should have 0 or more lowercase letters.
         * S should end with 0 or more uppercase letters
         * */
//        Tester2 test11 = new Tester2();
//        test11.checker("^\\d{2,}[a-z]*[A-Z]*$");

        //Matching one or more repetitions
        /**Task:
         * You have a test string S.
         * Your task is to write a regex that will match S using the following conditions:
         *
         * S should begin with 1 or more digits.
         * After that, S should have 1 or more uppercase letters.
         * S should end with 1 or more lowercase letters.
         * */
//        Tester2 test12 = new Tester2();
//        test12.checker("^\\d+[A-Z]+[a-z]+$");

        //Matching Ending Items
        /**
         * Task:
         * Write a RegEx to match a test string, S, under the following conditions:
         *
         * S should consist of only lowercase and uppercase letters (no numbers or symbols).
         * S should end in s.
         */
//        Tester2 test13 = new Tester2();
//        test13.checker("^[A-Za-z]*s$");

        //Matching word boundaries
        /**
         * Task:
         * You have a test String S.
         * Your task is to write a regex which will match word starting with vowel (a,e,i,o, u, A, E, I , O or U).
         * The matched word can be of any length. The matched word should consist of letters (lowercase and uppercase both) only.
         * The matched word must start and end with a word boundary.*/
//        Tester2 test14 = new Tester2();
//        test14.checker("\\b[aeiouAEIOU][A-Za-z]*\\b");

        //Capturing & Non-capturing Groups
        /**
         * Task:
         * You have a test String S.
         * Your task is to write a regex which will match S with the following condition:
         * S should have or more consecutive repetitions of ok.*/
//        Tester2 test15 = new Tester2();
//        test15.checker(".*(ok){3}.*");

        //Alternative Matching
        /**
         * Task:
         * Given a test string, s, write a RegEx that matches s under the following conditions:
         * s must start with Mr., Mrs., Ms., Dr. or Er..
         * The rest of the string must contain only one or more English alphabetic letters (upper and lowercase).*/
        Tester2 test16 = new Tester2();
        test16.checker("^(Mr\\.|Mrs\\.|Ms\\.|Dr\\.|Er\\.){1}[A-Za-z]+$");





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


