package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class HackerrankStrings {

    static String getSmallLarge(String s, int k){
        String smallest = s.substring(0, k);
        String largest = "";

        for(int i = 0; i < s.length() - k; i++){
            String S = s.substring(i, i+k);
            if(smallest.compareTo(S) > 0){
                smallest = S;
            }

            if(largest.compareTo(S) < 0){
                largest = S;
            }
        }
        return smallest + "\n" + largest;
    }
    static boolean isAnagram(String str4, String str44){
        if(str4.length() != str44.length()){
            return false;
        }

        int res = 0;
        for(int i = 0; i < str4.length(); i++){
            res ^= str4.charAt(i);
            res ^= str44.charAt(i);
        }
        return res == 0;
    }

    public static void main(String[] args) {
        //Hackerrank Java Strings Questions
        //1. Java String Introduction
        /**
         * The elements of a String are called characters.
         * The number of characters in a String is called the length,
         * and it can be retrieved with the String.length() method.
         *
         * Given two strings of lowercase English letters, A and B perform the following operations:
         *     Sum the lengths of A and B.
         *     Determine if A is lexicographically larger than B (i.e.: does B come before A in the dictionary?).
         *     Capitalize the first letter in A and B and print them on a single line, separated by a space.
         *
         * Input Format:
         * The first line contains a string A.
         * The second line contains another string B.
         * The strings are comprised of only lowercase English letters.
         *
         * Ex:
         * If String A is "hello" and B is "java".
         * A has a length of 5, and B has a length of 4; the sum of their lengths is 9.
         * When sorted alphabetically/lexicographically, "hello" precedes "java"; therefore, A is not greater than B
         * and the answer is No.
         * When you capitalize the first letter of both A and B and then print them separated by a space, you get "Hello Java".
         * */
        Scanner s = new Scanner(System.in);
        String A = s.nextLine();
        String B = s.nextLine();

        System.out.println((A.length() + B.length()));
        if (A.compareTo(B) <= 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        System.out.println(
                Character.toUpperCase(A.charAt(0)) + A.substring(1) + " " +
                        Character.toUpperCase(B.charAt(0)) + B.substring(1)
        );

        //2. Java Substring
        /**
         * Given a string, s, and two indices, start and end, print a substring consisting
         * of all characters in the inclusive range from start to end-1. You'll find the
         * String class' substring method helpful in completing this challenge.
         *
         * Input Format
         *
         * The first line contains a single string denoting s.
         * The second line contains two space-separated integers denoting the respective values of start and end.
         * */
        Scanner s1 = new Scanner(System.in);
        String str = s1.next();
        int start = s1.nextInt();
        int end = s1.nextInt();
        System.out.println(str.substring(start, end));

        //3. Java Substring Comparisons
        /**
         * Given a string, s, and an integer, k, complete the function so that
         * it finds the lexicographically smallest and largest substrings of length k.
         *
         * Function Description:
         * Complete the getSmallestAndLargest function in the editor below.
         * getSmallestAndLargest has the following parameters:
         *     string s: a string
         *     int k: the length of the substrings to find
         * Returns:
         *     string: the string ' + "\n" + ' where and are the two substrings
         *
         * Input Format:
         * The first line contains a string denoting
         * The second line contains an integer denoting.
         * */
        Scanner s2 = new Scanner(System.in);
        String S = s2.next();
        int n = s2.nextInt();
        System.out.println(getSmallLarge(S, n));

        //4. Java String Reverse
        /**
         * A palindrome is a word, phrase, number, or other sequence of characters which reads the same
         * backward or forward
         *
         * Given a string A, print Yes if it is a palindrome, print No otherwise*/
        Scanner s3 = new Scanner(System.in);
        String p = s3.next();
        int len = p.length();
        StringBuffer reversed = new StringBuffer(len);
        for (int i = (len - 1); i >= 0; i--) {
            reversed.append(p.charAt(i));
        }
        if (p.equals(reversed)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        //5. Java Anagrams
        /**
         * Two strings,a and b, are called anagrams if they contain all the same
         * characters in the same frequencies. For this challenge, the test is
         * not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac,
         * TCA, aTC, and CtA.
         *
         * Function Description
         * Complete the isAnagram function in the editor.
         * isAnagram has the following parameters:
         *     string a: the first string
         *     string b: the second string
         * Returns
         *     boolean: If and are case-insensitive anagrams, return true. Otherwise, return false.
         *
         * Input Format
         * The first line contains a string
         * The second line contains a string .*/
        Scanner s4 = new Scanner(System.in);
        String str4 = s4.next();
        String str44 = s4.next();
        System.out.println(isAnagram(str4, str44));

        //6. Java String Tokens
        /**
         *Given a string,s, matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens.
         * We define a token to be one or more consecutive English alphabetic letters. Then, print the number
         * of tokens, followed by each token on a new line.
         *
         * Note: You may find the String.split method helpful in completing this challenge.
         * Input Format:
         * A single string s.
         *
         * Output Format
         *
         * On the first line, print an integer,n, denoting the number of tokens in string s(they do not need to be unique).
         * Next, print each of the n tokens on a new line in the same order as they appear in input string s.
         * */
        Scanner s5 = new Scanner(System.in);
        String str5 = s5.nextLine();

        String[] tokens = str5.split("[^a-zA-Z]");
        System.out.println(tokens.length);
        /*
        for(int i = 0; i < tokens.length; i++){
            System.out.println(strArray[i]);
        }*/
        for (String token : tokens) {
            System.out.println(token);
        }

        //7. Pattern Syntax Checker
        /**
         * Using Regex, we can easily match or search for patterns in a text.
         * Before searching for a pattern, we have to specify one using some well-defined syntax.
         * In this problem, you are given a pattern. You have to check whether the syntax of the
         * given pattern is valid.
         *
         * Note: In this problem, a regex is only valid if you can compile it using the
         * Pattern.compile method.
         *
         * Input Format:
         * The first line of input contains an integer N, denoting the number of test cases.
         * The next lines contain a string of any printable characters representing the pattern of a regex.
         *
         * Output Format:
         * For each test case, print Valid if the syntax of the given pattern is correct.
         * Otherwise, print Invalid. Do not print the quotes.
         * */
        Scanner s6 = new Scanner(System.in);
        int rN = s6.nextInt();
        /*
        for(int i = 0; i < rN; i++){
            String regex = s6.nextLine();
            try{
                Pattern.compile(regex);
                System.out.println("Valid");
            }catch (PatternSyntaxException e){
                System.out.println("Invalid");
            }
        }*/
        while (rN-- > 0) {
            String regex = s6.nextLine();
            try {
                Pattern.compile(regex);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
        }

        //8. Java Regex
        /**
         * Write a class called MyRegex which will contain a string pattern. You need to write a regular
         * expression and assign it to the pattern such that it can be used to validate an IP address.
         * Use the following definition of an IP address:
         *
         * IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
         * Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3
         *
         * Some valid IP address:
         * 000.12.12.034
         * 121.234.12.12
         * 23.45.12.56
         *
         * Some invalid IP address:
         * 000.12.234.23.23
         * 666.666.23.23
         * .213.123.23.32
         * 23.45.22.32.
         * I.Am.not.an.ip
         * */
        Scanner s7 = new Scanner(System.in);
        while (s7.hasNext()){
            String IP = s7.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

        //9. Java Regex 2 - Duplicate Words
        /**
         * In this challenge, we use regular expressions (RegEx) to remove instances of words that are repeated
         * more than once, but retain the first occurrence of any case-insensitive repeated word. For example,
         * the words love and to are repeated in the sentence I love Love to To tO code. Can you complete the
         * code in the editor so it will turn I love Love to To tO code into I love to code?
         *
         * To solve this challenge, complete the following three lines:
         *     Write a RegEx that will match any repeated word.
         *     Complete the second compile argument so that the compiled RegEx is case-insensitive.
         *     Write the two necessary arguments for replaceAll such that each repeated word is
         *     replaced with the very first instance the word found in the sentence. It must be the
         *     exact first occurrence of the word, as the expected output is case-sensitive.
         *
         * Note: This challenge uses a custom checker; you will fail the challenge if you modify
         * anything other than the three locations that the comments direct you to complete.
         * To restore the editor's original stub code, create a new buffer by clicking on the
         * branch icon in the top left of the editor.
         *
         * Input Format:
         * The following input is handled for you the given stub code:
         * The first line contains an integer,n, denoting the number of sentences.
         * Each of the subsequent lines contains a single sentence consisting of
         * English alphabetic letters and whitespace characters.*/
        Scanner s8 = new Scanner(System.in);
        int N = s8.nextInt();
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern pReg = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        while (N-- > 0){
            String str8 = s8.nextLine();
            Matcher m = pReg.matcher(str8);
            while (m.find()){
                str8 = str8.replaceAll(m.group(), m.group(1));
            }
            System.out.println(str8);
        }

        //10. Valid Username Regular Expression
        /**
         * You are updating the username policy on your company's internal networking platform.
         * According to the policy, a username is considered valid if all the following constraints are satisfied:
         *     The username consists of 8 to 30 characters inclusive. If the username consists of less than 8 or greater than
         *     30 characters, then it is an invalid username.
         *     The username can only contain alphanumeric characters and underscores (_).
         *     Alphanumeric characters describe the character set consisting of lowercase characters [a-z] uppercase characters
         *     [A-Z], and digits [0-9].
         *     The first character of the username must be an alphabetic character, i.e., either lowercase character
         *     [a-z] or uppercase character [A-Z].
         *
         * Update the value of regularExpression field in the UsernameValidator class so that the regular expression
         * only matches with valid usernames.
         *
         * Input Format
         * The first line of input contains an integer n, describing the total number of usernames.
         * Each of the next lines contains a string describing the username. The locked stub code
         * reads the inputs and validates the username.*/
        Scanner s9 = new Scanner(System.in);
        int userInt = s9.nextInt();
        while(userInt-- != 0){
            String username = s9.next();
            if(username.matches(UsernameValidator.pattern)){
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }
        }

        //11. Tag Content Extractor
        /**
         * In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag
         * like <tag>contents</tag>. Note that the corresponding end tag starts with a /.
         * Given a string of text in a tag-based language, parse this text and retrieve the
         * contents enclosed within sequences of well-organized tags meeting the following criterion:
         *
         *     The name of the start and end tags must be same. The HTML code <h1>Hello World</h2> is not valid,
         *     because the text starts with an h1 tag and ends with a non-matching h2 tag.
         *     Tags can be nested, but content between nested tags is considered not valid. For example,
         *     in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.
         *     Tags can consist of any printable characters.
         *
         * Input Format:
         * The first line of input contains a single integer,N(the number of lines).
         * The N subsequent lines each contain a line of text.
         * */
        Scanner s10 = new Scanner(System.in);
        int nT = s10.nextInt();
        Pattern tp = Pattern.compile("<(.+)>([^<>]+)<\\/\\1>");
        while (nT-- != 0){
            String str10 = s10.nextLine();
            Matcher m = tp.matcher(str10);
            boolean invalid = true;
            while (m.find()){
                System.out.println(m.group(2));
                invalid = false;
            }

            if(invalid){
                System.out.println("None");
            }
        }
    }
}
class MyRegex{
    String pattern = "^(([0-1]?[0-9]?[0-9]?|2[0-4][0-9]|25[0-5])\\.){3}([0-1]?[0-9]?[0-9]?|2[0-4][0-9]|25[0-5]){1}$";
}
class UsernameValidator{
    public static final String pattern = "^[a-zA-Z][\\w]{7,29}$";
}
