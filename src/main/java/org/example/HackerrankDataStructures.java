package org.example;

import java.util.*;

public class HackerrankDataStructures {
    public static void main(String[] args){

        //Java 1D Array
        /**An array is a simple data structure used to store a collection of data in a contiguous block of memory.
         * Each element in the collection is accessed using an index, and the elements are easy to find because
         * they're stored sequentially in memory. */
        Scanner s1 = new Scanner(System.in);
        int n1 = s1.nextInt();
        int[] arr = new int[n1];
        for(int i = 0; i < n1; i++){
            int num = s1.nextInt();
            arr[i] = num;
        }
        s1.close();
        for(int a:arr){
            System.out.println(a);
        }

        //Java Subarray
        /**A subarray of an n-element array is an array composed from a contiguous block of the original array's elements.
         * For example, if array=[1,2,3], then the subarrays are [1], [2], [3], [1,2], [2,3], and [1,2,3].
         * Something like [1,3] would not be a subarray as it's not a contiguous subsection of the original array.
         *
         * The sum of an array is the total sum of its elements.
         *         An array's sum is negative if the total sum of its elements is negative.
         *         An array's sum is positive if the total sum of its elements is positive.
         * Given an array of n integers, find and print its number of negative subarrays on a new line.
         * */
        Scanner s2 = new Scanner(System.in);
        int n2 = s2.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i < n2; i++){
            arr2[i] = s2.nextInt();
        }


        int acc = 0;
        for(int i = 0; i < n2; i++){
            int sum = 0;
            for(int j = i; j < n2; j++){
                sum += arr2[j]; //
                if(sum < 0){
                    acc += 1; //9
                }
            }
        }
        System.out.println(acc);
        s2.close();

        //Java Arraylist
        /**
         * Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature.
         * Try to solve this problem using Arraylist. You are given n lines. In each line there are zero or more integers.
         * You need to answer a few queries where you need to tell the number located in yth position of xth line.
         *
         * The first line has an integer n. In each of the next n lines there will be an integer d denoting number
         * of integers on that line and then there will be d space-separated integers. In the next line there
         * will be an integer q denoting number of queries. Each query will consist of two integers x and y.
         * */
        Scanner s3 = new Scanner(System.in);
        int n3 = s3.nextInt();

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < n3; i++){
            int n = s3.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                list.add(s3.nextInt());
            }
            //[[41, 77, 74, 22, 44], [12], [37, 34, 36, 52], [], [20, 22, 33]]
            lists.add(list);
        }

        int q = s3.nextInt();
        for(int i = 0; i < q; i++){
            int x = s3.nextInt(); //5
            int y = s3.nextInt(); //5
            ArrayList<Integer> arr3 = lists.get(x-1); //[20, 22, 33]
            if(y <= arr3.size()){
                System.out.println(arr3.get(y-1));
            }else{
                System.out.println("ERROR!");
            }
        }

        s3.close();


        //Java 1D Array (Part2) - Done
        Scanner s4 = new Scanner(System.in);
        int q4 = s4.nextInt();
        while (q4-- > 0) {
            int n = s4.nextInt();
            int leap = s4.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = s4.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        s4.close();

        // Java List - Done
        Scanner s5 = new Scanner(System.in);
        int n5 = s5.nextInt();
        List<Integer> aList = new ArrayList<>();
        for(int i = 0; i < n5; i++){
            aList.add(s5.nextInt());
        }

        int q5 = s5.nextInt();
        while (q5-- != 0){
            String str5 = s5.next();
            switch (str5){
                case "Insert":
                    int index5 = s5.nextInt();
                    int value5 = s5.nextInt();
                    aList.add(index5, value5);
                    break;
                case "Delete":
                    int index55 = s5.nextInt();
                    aList.remove(index55);
                    break;
                default:
                    break;
            }
        }
        for(int e:aList){
            System.out.print(e + " ");
        }

        // Java Map - Done
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            hm.put(name, phone);
            in.nextLine();
        }

        while(in.hasNext())
        {
            String s=in.nextLine();
            if(hm.containsKey(s)){
                System.out.println(s +"="+hm.get(s));
            }else{
                System.out.println("Not found");
            }
        }
        in.close();

        // Java Stack - Done
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();
            Stack<Character> stack = new Stack<>();
            boolean b = true;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == '{' || input.charAt(i) == '(' || input.charAt(i) == '['){
                    stack.add(input.charAt(i));
                }else{
                    if(stack.isEmpty()){
                        b = false;
                        break;
                    }else{
                        char val = stack.pop();
                        if((input.charAt(i) == '}' && val != '{') ||
                                (input.charAt(i) == ')' && val != '(')||(input.charAt(i) == ']' && val != '[')){
                            b = false;
                            break;
                        }
                    }
                }
            }
            if(b == true && stack.isEmpty()){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }
        /* another way of implementing balanced brackets
        while(true){
            int oriLen = input.length();

            input = input.replace("[]", "");
            input = input.replace("{}", "");
            input = input.replace("()", "");

            int curLen = input.length();
            if(curLen == oriLen){
                break;
            }
        }
        if(input.length() == 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }*/

        //Java Hashset - Done
        Scanner s6 = new Scanner(System.in);
        int n6 = s6.nextInt();
        HashSet<String> hs6 = new HashSet<>();
        for(int i = 0; i < n6; i++){
            String name6 = s6.nextLine();
            hs6.add(name6);
            System.out.println(hs6.size());
        }
        s6.close();

        //Java Generics - Done
        Integer[] iArr = {1, 2, 3};
        String[] sArr = {"Hello", "World"};

        printArray(iArr);
        printArray(sArr);

//        Java Comparator - Done
        Scanner s7 = new Scanner(System.in);
        int n7 = s7.nextInt();

        Player[] player = new Player[n7];
        Checker checker = new Checker();

        for(int i = 0; i < n7; i++){
            player[i] = new Player(s7.next(), s7.nextInt());
        }
        s7.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.println(player[i].name +" "+ player[i].score);
        }

        // Java Sort - Done
        Scanner s8 = new Scanner(System.in);
        int n8 = s8.nextInt();
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < n8; i++){
            int id = s8.nextInt();
            String name = s8.next();
            double cgpa = s8.nextDouble();
            Student student = new Student(id, name, cgpa);
            students.add(student);
        }
        s8.close();

        Comparator<Student> comparator = (s11, s12) -> {
            if(s11.getCgpa() != s12.getCgpa()){
                return Double.compare(s12.getCgpa(), s11.getCgpa());
            }else{
                return s11.getName().compareTo(s12.getName());
            }
        };

        Collections.sort(students, comparator);
        for(Student s: students){
            System.out.println(s.getName());
        }

        // Java Dequeue - Done
        Scanner s9 = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n9 = s9.nextInt();
        int m = s9.nextInt();

        int max = 0;
        for (int i = 0; i < n9; i++) {
            int num = s9.nextInt();
            deque.add(num);
            set.add(num);
            if(deque.size() > m){
                int val = deque.remove();
                if(!deque.contains(val)){
                    set.remove(val);
                }
            }

            if(set.size() > max){
                max = set.size();
            }
        }

        System.out.println(max);
        s9.close();

        // Java BitSet - Done
        Scanner s10 = new Scanner(System.in);
        int n10 = s10.nextInt();
        int m10 = s10.nextInt();

        BitSet b1 = new BitSet(n10);
        BitSet b2 = new BitSet(n10);

        for(int i = 0; i < m10; i++){
            String str = s10.next();
            int a = s10.nextInt();
            int b = s10.nextInt();
            switch(str){
                case "AND":
                    if(a == 1){ b1.and(b2); }else{ b2.and(b1); }
                    break;
                case "OR":
                    if(a == 1){ b1.or(b2); }else{ b2.or(b1); }
                    break;
                case "XOR":
                    if(a == 1){ b1.xor(b2); }else{ b2.xor(b1); }
                    break;
                case "FLIP":
                    if(a == 1){ b1.flip(b); }else{ b2.flip(b); }
                    break;
                case "SET":
                    if(a == 1){ b1.set(b); }else{ b2.set(b); }
                    break;
                default:
                    break;
            }
            System.out.println(b1.cardinality() +" "+b2.cardinality());
        }
        s10.close();

        // Java Priority Queue - Done
        Scanner scan = new Scanner(System.in);
        Priorities priorities = new Priorities();

        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<StudentP> studentsP = priorities.getStudents(events);

        if (studentsP.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (StudentP st: studentsP) {
                System.out.println(st.getName());
            }
        }
        scan.close();

    }
    //Generic method to print both string and int arrays
    public static <T> void printArray(T[] arr){
        for(T a : arr){
            System.out.println(a);
        }
    }

    //helper method for Java 1D Array (Part2)
    public static boolean canWin(int leap, int[] game, int i) {

        if(i < 0 || game[i] == 1){
            return false;
        }

        if(i + 1 >= game.length || i + leap >= game.length){
            return true;
        }
        game[i] = 1;

        return canWin(leap, game, i + 1) || canWin(leap, game, i + leap) || canWin(leap, game, i - 1);
    }
}
class Priorities{
    Comparator<StudentP> comparator = (StudentP s1, StudentP s2) -> {
        if(s1.getCgpa() != s2.getCgpa()){
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }else{
            return s1.getName().compareTo(s2.getName());
        }
    };

    public List<StudentP> getStudents(List<String> E){
        PriorityQueue<StudentP> studentQ = new PriorityQueue<>(comparator);
        for(String e : E){
            String[] tokens = e.split(" ");
            String event = tokens[0];
            switch(event){
                case "ENTER":
                    studentQ.add(new StudentP(
                            Integer.parseInt(tokens[3]), tokens[1], Double.parseDouble(tokens[2])
                    ));
                    break;
                case "SERVED":
                    studentQ.poll();
                    break;
                default:
                    break;
            }
        }

        int len = studentQ.size();
        List<StudentP> students = new ArrayList<>();
        while(len-- != 0){
            students.add(studentQ.remove());
        }
        return students;
    }
}

class StudentP{
    private int id;
    private String name;
    private double cgpa;

    public StudentP(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public double getCgpa(){ return cgpa; }

}

class Student{
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
}
class Player{
    int score;
    String name;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}
class Checker implements Comparator<Player>{
    @Override
    public int compare(Player p1, Player p2){
        if(p1.score != p2.score){
            return Integer.compare(p2.score, p1.score);
        }else{
            return p1.name.compareTo(p2.name);
        }
    }
}
