package app;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class UtilsTest {

    /**
     * Tests for concatenateWords() method
     */

    @Test
    public void isBothWordsExist() {
        String firstWord = "Hello";
        String secondWord = "world";
        String expected = firstWord + secondWord;
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(expected, actual);
    }

    //    One or both words "null"
    @Test(expected = IllegalArgumentException.class)
    public void isFirstWordNull() {
        String secondWord = "world";
        String actual = Utils.concatenateWords(null, secondWord);
        Assert.assertEquals(secondWord, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSecondWordNull() {
        String firstWord = "world";
        String actual = Utils.concatenateWords(firstWord, null);
        Assert.assertEquals(firstWord, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isBothWordsNull() {
        String expected = "-1";
        String actual = Utils.concatenateWords(null, null);
        Assert.assertEquals(expected, actual);
    }

    //    One or both words is "empty"
    @Test
    public void isFirstEmptyWord() {
        String firstWord = "";
        String secondWord = "world";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(secondWord, actual);
    }

    @Test
    public void isSecondEmptyWord() {
        String firstWord = "Hello";
        String secondWord = "";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(firstWord, actual);
    }

    @Test
    public void isBothWordsEmpty() {
        String firstWord = "";
        String secondWord = "";
        String expected = "";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(expected, actual);
    }

    //    One or both words is "not Latin words" it's a string
    @Test(expected = IllegalArgumentException.class)
    public void isFirstWordNotLatinWord() {
        String firstWord = "Hello test";
        String secondWord = "world";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(secondWord, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSecondWordNotLatinWord() {
        String firstWord = "Hello";
        String secondWord = "new world";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(firstWord, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isBothWordsNotLatinWord() {
        String firstWord = "Hello world";
        String secondWord = " Newworld";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(secondWord, actual);
    }

    //  One or both words is "not Latin words" added not latin characters: space, tab, 0-9, ...
    @Test(expected = IllegalArgumentException.class)
    public void isFirstWordNotLatinWord2() {
        String firstWord = "Hello ";
        String secondWord = "world";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(secondWord, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isFirstWordNotLatinWord3() {
        String firstWord = "He4llo";
        String secondWord = "world";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(secondWord, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSecondWordNotLatinWord2() {
        String firstWord = "Hello";
        String secondWord = " world";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(firstWord, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSecondWordNotLatinWord3() {
        String firstWord = "Hello";
        String secondWord = "w7r!d";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(firstWord, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isBothWordsNotLatinWord2() {
        String firstWord = "He110 w0r1d";
        String secondWord = " New3wor!d";
        String actual = Utils.concatenateWords(firstWord, secondWord);
        Assert.assertEquals(secondWord, actual);
    }

    /**
     * Tests for computeFactorial() method
     */
//      <0-> exc, 0->1 , 1->1, n ->n!
//    @Test(expected = IllegalArgumentException.class)
//    public void isNumberNegative(){
//        long actual = Utils.computeFactorial(-3);
//        Assert.assertEquals(1,actual);
//    }
    @Test
    public void isNumberNegative() {
        long actual = Utils.computeFactorial(-3);
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void isNumberZero() {
        long actual = Utils.computeFactorial(0);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void isNumberOne() {
        long actual = Utils.computeFactorial(1);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void isNumber5() {
        long actual = Utils.computeFactorial(5);
        Assert.assertEquals(120, actual);
    }

    @Test
    public void testComputeFactorial() {
        long actual = Utils.computeFactorial(6);
        Assert.assertEquals(720, actual);
    }


    @Ignore
    @Test(timeout = 1)
    public void testFactorialWithTimeout() {
        int rndNumber = (int) (Math.random() * 10) + 7;
        long actual = Utils.computeFactorial(rndNumber);
        Assert.assertEquals(720, actual);
    }


}