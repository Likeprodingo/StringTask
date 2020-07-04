package service.impl;

import exception.CustomException;
import service.TextEditElement;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringTextEditElement implements TextEditElement {

    private static final String CONSONANTS = "йцкгшщзхфвпрлджчсмтбqwrtpsdfghjkzxcvbnmЙЦКНГШЗЩХФВПРЛДЖЧСМТБQWRTPSDFGHJKLZXCVBNM";
    private static final String SPACE = " ";
    private static final String NOT_LETTERS = "[^[a-zA-Zа-яА-Я]]";

    @Override
    public String replaceChar(String text, int index, char symbol) throws CustomException {
        int startPosition = 0;
        if (text == null || text.length() == 0) {
            throw new CustomException("wrong text");
        }
        String[] words = text.split(SPACE);
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (index > 0 && index <= words[i].length()) {
                words[i] = words[i].substring(startPosition, index - 1) + symbol + words[i].substring(index);
            }
        }
        result = String.join(" ", words);
        return result;
    }

    @Override
    public String replaceAll(String text, char condition, char replace, char insert) throws CustomException {
        if (text == null || text.length() == 0) {
            throw new CustomException("wrong text");
        }
        String[] words = text.split(SPACE);
        String result = "";
        int conditionIndex;
        for (int i = 0; i < words.length; i++) {
            conditionIndex = words[i].indexOf(condition);
            if (conditionIndex != -1 &&
                    conditionIndex < (words[i].length() - 1) &&
                    words[i].charAt(conditionIndex + 1) == replace)
                words[i] = words[i].replace(words[i].charAt(conditionIndex + 1), insert);
        }
        result = String.join(" ", words);
        return result;
    }

    @Override
    public String replaceWord(String text, int length, String insert) throws CustomException {
        if (text == null || text.length() == 0 || insert == null) {
            throw new CustomException("wrong text");
        }
        String[] words = text.split(SPACE);
        String result = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == length) {
                words[i] = insert;
            }
        }
        result = String.join(" ", words);
        return result;
    }

    @Override
    public String clearText(String text) throws CustomException {
        if (text == null || text.length() == 0) {
            throw new CustomException("wrong text");
        }
        String result;
        result = text.replaceAll(NOT_LETTERS, " ");
        return result;
    }

    @Override
    public String deleteCustomWords(String text, int length) throws CustomException {
        int startPosition = 0;
        if (text == null || text.length() == 0) {
            throw new CustomException("wrong text");
        }
        StringBuilder result = new StringBuilder();
        String[] words = text.split(SPACE);
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != length || CONSONANTS.indexOf(words[i].charAt(startPosition)) == -1) {
                result.append(words[i]);
                result.append(" ");
            }
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}
