package app;

public class Main {

    public static void main(String[] args) {

        String firstString = "Hello";
        String secondString = "World";

        System.out.println(Utils.concatenateWords(firstString, ""));
        System.out.println(Utils.concatenateWords("", secondString));
        System.out.println(Utils.concatenateWords("", ""));
        System.out.println(Utils.concatenateWords(firstString, secondString));

        System.out.println(Utils.computeFactorial(-1));
        System.out.println(Utils.computeFactorial(0));
        System.out.println(Utils.computeFactorial(1));
        System.out.println(Utils.computeFactorial(5));
        System.out.println(Utils.computeFactorial(10));

    }
}
