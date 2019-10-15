package app;

class Utils {

    static String concatenateWords(String firstWord, String secondWord) {
        if (isWordIsLatin(firstWord) & isWordIsLatin(secondWord)) {
            return firstWord + secondWord;
        } else {
            throw new IllegalArgumentException("Слова не заданы (null) или заданны некорректно - только символы: a-zA-Z");
        }
    }

    static long computeFactorial(int number) {
        int result = 1;
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Задано отрицательное число");
            }
        } catch (IllegalArgumentException e){
            result = -1;
            e.printStackTrace();
        }

        if (number == 0) {
            return 1;
        }
        if (number == 1) {
            return 1;
        }
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }


    private static boolean isWordExist(String word) {
        boolean wordExist = false;
        if (word != null) {
            wordExist = true;
        }
        return wordExist;
    }

    private static boolean isWordIsLatin(String word) {
        boolean result = false;
        if (isWordExist(word)) {
            if (word.isEmpty()) {
                return true;
            } else {
                result = word.matches("^[a-zA-Z]+$");
            }
        }
        return result;
    }

}
