package app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class UtilsTest {

    /**
     * Tests for concatenateWords() method
     */

    @Parameterized.Parameters(name = "Тест {index}: firstWord = {0}, secondWord = {1}, expected = {2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"Hello", "world", "Helloworld"},
                {"", "world", "world"},
                {"Hello", "", "Hello"},
                {"", "", ""},
        });
    }

    private String firstWord;
    private String secondWord;
    private String expected;

    public UtilsTest(String firstWord, String secondWord, String expected) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
        this.expected = expected;
    }

    @Test
    public void testWithParameters() {
        Assert.assertEquals(expected, Utils.concatenateWords(firstWord, secondWord));
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

}