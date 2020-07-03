package service.impl;

import exception.CustomException;
import service.TextEditElement;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringTextEditElement implements TextEditElement {

    private static final String SPACE = " ";

    @Override
    public String replaceChar(String text, int index, char symbol) throws CustomException {
        int startPosition = 0;
        if (text == null || text.length() == 0) {
            throw new CustomException("wrong text");
        }
        String[] words = text.split(SPACE);
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (index > 0 && index < words[i].length()) {
                words[i] = words[i].substring(startPosition, index - 1) + symbol + words[i].substring(index);
            }
        }
        result = String.join(" ", words);
        return result;
    }

    @Override
    public String replaceAll(String text, char condition, char replace, char insert) throws CustomException {
        return null;
    }//TODO

    @Override
    public String replaceWord(String text, int length, String insert) throws CustomException {
        return null;
    }//TODO

    @Override
    public String clearText(String text) throws CustomException {
        return null;
    }//TODO

    @Override
    public String deleteCustomWords(String text, int length) throws CustomException {
        return null;
    }//TODO
}
