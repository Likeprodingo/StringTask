package service.impl;

import exception.CustomException;
import service.TextEditElement;

import java.util.ArrayList;

public class CharTextEditElement implements TextEditElement {

    private static final String LETTERS = "qwertyuiopasdfghjkzxcvbnmQWERTYUIOPASDFGHJKLZXCVBN ёйцукенгшщзхъфывапролджэячсмитьбюMЙЦУКЕНГШЩЗХЪЁФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    private static final String CONSONANTS = "йцкгшщзхфвпрлджчсмтбqwrtpsdfghjkzxcvbnmЙЦКНГШЗЩХФВПРЛДЖЧСМТБQWRTPSDFGHJKLZXCVBNM";
    private static final char SPACE = ' ';

    @Override
    public String replaceChar(String text, int index, char symbol) throws CustomException {
        int count = 0;
        if (text == null || text.length() == 0) {
            throw new CustomException("text is empty");
        }
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            count++;
            if (textArray[i] == SPACE) {
                count = 0;
                continue;
            }
            if (count == index) {
                textArray[i] = symbol;
            }
        }
        return new String(textArray);
    }

    @Override
    public String replaceAll(String text, char condition, char replace, char insert) throws CustomException {
        int count = 0;
        if (text == null || text.length() == 0) {
            throw new CustomException("text is empty");
        }
        char[] textArray = text.toCharArray();
        for (int i = 1; i < textArray.length; i++) {
            if (textArray[i - 1] == condition && textArray[i] == replace) {
                textArray[i] = insert;
            }
        }
        return new String(textArray);
    }

    @Override
    public String replaceWord(String text, int length, String insert) throws CustomException {
        if (text == null || text.length() == 0) {
            throw new CustomException("text is empty");
        }
        char[] textArray = text.toCharArray();
        StringBuilder word = new StringBuilder("");
        int count = 0;
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < text.length(); i++) {
            if (textArray[i] == SPACE) {
                word.append(SPACE);
                words.add(count == length ? insert + SPACE: word.toString());
                count = 0;
                word = new StringBuilder("");
                continue;
            }
            word.append(textArray[i]);
            count++;
            if(i==text.length()-1){
                words.add(count == length ? insert : word.toString());
            }
        }
        StringBuilder result = new StringBuilder("");
        for (String w : words) {
            result.append(w);
        }
        return result.toString();
    }

    @Override
    public String clearText(String text) throws CustomException {
        if (text == null || text.length() == 0) {
            throw new CustomException("text is empty");
        }
        char[] textArray = text.toCharArray();
        char[] letters = LETTERS.toCharArray();
        main:
        for (int i = 0; i < textArray.length; i++) {
            for (char letter : letters) {
                if (textArray[i] == letter) {
                    continue main;
                }
            }
            textArray[i] = SPACE;
        }
        return new String(textArray);
    }

    @Override
    public String deleteCustomWords(String text, int length) throws CustomException {
        if (text == null || text.length() == 0) {
            throw new CustomException("text is empty");
        }
        char firstLetter = SPACE;
        int count = 0;
        char[] textArray = text.toCharArray();
        char[] consonants = CONSONANTS.toCharArray();
        StringBuilder result = new StringBuilder("");
        main:
        for (int i = 0; i < textArray.length; i++) {
            if (count == 0) {
                firstLetter = textArray[i];
            }
            if (textArray[i] == SPACE || i==textArray.length-1) {
                if(count == length){
                    for (char consonant : consonants) {
                        if (firstLetter == consonant) {
                            count = 0;
                            continue main;
                        }
                    }
                }
                for (int j = i - count; j <= i; j++) {
                    result.append(textArray[j]);
                }
                count = 0;
                continue;
            }
            count++;
        }
        return result.toString();
    }
}
