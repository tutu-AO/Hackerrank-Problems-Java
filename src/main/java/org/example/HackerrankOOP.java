package org.example;
import java.util.*;
public class HackerrankOOP {
    public static void main(String[] args){
        //Java Inheritance I
        /**Using inheritance, one class can acquire the properties of others*/
        Bird bird = new Bird();
        bird.walk(); /**u walk method is in the parent class Animal*/
        bird.fly();
        bird.sing();

        //Java Inheritance II
        /**
         * Write the following code in your editor below:
         *     A class named Arithmetic with a method named add that takes
         *     integers as parameters and returns an integer denoting their sum.
         *     A class named Adder that inherits from a superclass named Arithmetic.
         * Your classes should not be public
         * .*/
        // Create a new Adder object
        Adder a = new Adder();
        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());
        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");

        //Java Abstract Class
        /**A Java abstract class is a class that can't be instantiated.
         * That means you cannot create new instances of an abstract class.
         * It works as a base for subclasses. You have to create another class that extends the abstract class.
         * Then you can create an instance of the new class. */
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        MyBook new_novel = new MyBook();
        new_novel.setTitle(title);
        System.out.println("The title is: "+new_novel.getTitle());
        sc.close();

        //Java Interface
        /**A Java interface can only contain method signatures and fields.
         * The interface can be used to achieve polymorphism.
         * polymorphism means having many forms.
         * polymorphism allows you to define one interface and have multiple implementations
         * Compile-time polymorphism -> method overloading
         * Runtime polymorphism -> method overriding
         *
         * Concrete classes implements the methods in the interface
         * Task:
         * You need to write a class called MyCalculator which implements the interface.
         * divisorSum function just takes an integer as input and return the sum of all its divisors.
         * For example divisors of 6 are 1, 2, 3 and 6, so divisor_sum should return 12*/
        MyCalculator my_calculator = new MyCalculator();
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        System.out.print(my_calculator.divisor_sum(n) + "\n");
        sc1.close();

        //Java Method Ovverriding
        /**When a subclass inherits from a superclass, it also inherits its methods;
         * however, it can also override the superclass methods (as well as declare and implement new ones).
         *
         * Note: When overriding a method, you should precede it with the @Override annotation.
         * The parameter(s) and return type of an overridden method must be exactly the same as
         * those of the method inherited from the supertype.
         *
         * Task:
         * Complete the code in your editor by writing an overridden getNumberOfTeamMembers
         * method that prints the same statement as the superclass' getNumberOfTeamMembers
         * method, except that it replaces n with 11 (the number of players on a Soccer team). */
        Sports c1 = new Sports();
        Soccer c2 = new Soccer();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();

        //Java Method Ovverriding 2(Super Keyword)
        /**When a method in a subclass overrides a method in superclass,
         * it is still possible to call the overridden method using super keyword.
         * If you write super.func() to call the function func(), it will call the
         * method that was defined in the superclass.*/
        MotorCycle M=new MotorCycle();

        //Java Instanceof keyword
        /**The Java instanceof operator is used to test if the object or instance is an instanceof the specified type.*/
        ArrayList mylist = new ArrayList();
        Scanner sc2 = new Scanner(System.in);
        int t = sc2.nextInt();
        for(int i=0; i<t; i++){
            String s=sc2.next();
            if(s.equals("Student"))mylist.add(new Student());
            if(s.equals("Rockstar"))mylist.add(new Rockstar());
            if(s.equals("Hacker"))mylist.add(new Hacker());
        }
        System.out.println(count(mylist));
        sc2.close();

        //Java Iterator
        /**Java Iterator class can help you to iterate through every element in a collection.*/
        ArrayList mylist1 = new ArrayList();
        Scanner sc3 = new Scanner(System.in);
        int n3 = sc3.nextInt();
        int m = sc3.nextInt();
        for(int i = 0;i<n3;i++){
            mylist1.add(sc3.nextInt());
        }

        mylist1.add("###");
        for(int i=0;i<m;i++){
            mylist1.add(sc3.next());
        }

        Iterator it=func(mylist1);
        while(it.hasNext()){
            Object element = it.next();
            System.out.println((String)element);
        }


    }
    /**ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented*/
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
    static String count(ArrayList mylist){
        int a = 0,b = 0,c = 0;
        for(int i = 0; i < mylist.size(); i++){
            Object element=mylist.get(i);
            if(element instanceof Student)
                a++;
            if(element instanceof Rockstar)
                b++;
            if(element instanceof Hacker)
                c++;
        }
        String ret = Integer.toString(a)+" "+ Integer.toString(b)+" "+ Integer.toString(c);
        return ret;
    }
    static Iterator func(ArrayList mylist){
        Iterator it=mylist.iterator();
        while(it.hasNext()){
            Object element = it.next();
            if(element instanceof String)//Hints: use instanceof operator
                break;
        }
        return it;

    }
}
class Student{} //this student is for Java Instanceof keyword problem
class Rockstar{}
class Hacker{}
class Animal{
    void walk(){ System.out.println("I am walking"); }
}
class Bird extends Animal
{
    void fly() { System.out.println("I am flying"); }
    void sing(){ System.out.println("I am singing"); }
}
class Arithmetic{
    public int add(int a, int b){ return (a+b); }
}
class Adder extends Arithmetic{}
abstract class Book{
    String title;
    abstract void setTitle(String s); /** should be implemented in child class */
    String getTitle(){ return title; }
}
class MyBook extends Book{
    void setTitle(String s){ this.title = s; } /** method from the abstract */
}
interface AdvancedArithmetic{
    int divisor_sum(int n);
}
class MyCalculator implements AdvancedArithmetic{
    public int divisor_sum(int n){
        int sum = 0;
        for(int i = 1; i<=n; i++){ if(n % i == 0){ sum += i; } }
        return sum;
    }
}
class Sports{
    String getName(){ return "Generic Sports"; }
    void getNumberOfTeamMembers(){ System.out.println( "Each team has n players in " + getName() ); }
}
class Soccer extends Sports{
    @Override
    String getName(){ return "Soccer Class"; }
    // Write your overridden getNumberOfTeamMembers method here
    @Override
    void getNumberOfTeamMembers(){ System.out.println( "Each team has 11 players in " + getName() ); }

}
class BiCycle{ String define_me(){ return "a vehicle with pedals.";} }
class MotorCycle extends BiCycle{
    String define_me(){ return "a cycle with an engine."; }
    MotorCycle(){
        System.out.println("Hello I am a motorcycle, I am "+ define_me());
        String temp=super.define_me(); //Fix this line
        System.out.println("My ancestor is a cycle who is "+ temp );
    }
}



