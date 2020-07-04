package service.impl;

import exception.CustomException;
import service.TextEditElement;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTextEditElement implements TextEditElement {

    private static final String SENTENCE_FORMAT = "\\b(\\w{%d})(\\w)(\\w*)";
    private static final String REPLACE_RULE = "$1%s$3";
    private static final String CORRECT_FORMAT = "(\\w*%s)(%s)(\\w*)";
    private static final String WORD_REPLACE_RULE = "\\b()(\\w{%d})()\\b";
    private static final String SPACE_CLEAR_RULE = "[ \\t\\n\\r]+";
    private static final String TEXT_CLEAR_RULE = "[^a-zA-Zа-яА-Я \\-]";
    private static final String WORD_DELETE_RULE = "()(\\b[%s]\\w{%d}\\s?\\b)()";
    private static final String CONSONANTS = "йцкгшщзхфвпрлджчсмтбqwrtpsdfghjkzxcvbnmЙЦКНГШЗЩХФВПРЛДЖЧСМТБQWRTPSDFGHJKLZXCVBNM";

    @Override
    public String replaceChar(String text, int index, char symbol) throws CustomException {
        if (text == null || text.length() == 0 || index <=0) {
            throw new CustomException("wrong text");
        }
        Pattern pattern = Pattern.compile(String.format(SENTENCE_FORMAT, index-1));
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(String.format(REPLACE_RULE, symbol));
    }

    @Override
    public String replaceAll(String text, char condition, char replace, char insert) throws CustomException {
        if (text == null || text.length() == 0) {
            throw new CustomException("wrong text");
        }
        Pattern pattern = Pattern.compile(String.format(CORRECT_FORMAT, condition, replace));
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(String.format(REPLACE_RULE, insert));
    }

    @Override
    public String replaceWord(String text, int length, String insert) throws CustomException {
        if (text == null || text.length() == 0) {
            throw new CustomException("wrong text");
        }
        Pattern pattern = Pattern.compile(String.format(WORD_REPLACE_RULE, length));
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(String.format(REPLACE_RULE, insert));
    }

    @Override
    public String clearText(String text) throws CustomException {
        if (text == null || text.length() == 0) {
            throw new CustomException("wrong text");
        }
        String result = text.replaceAll(TEXT_CLEAR_RULE, "");
        result = result.replaceAll(SPACE_CLEAR_RULE, " ");
        return result;
    }

    @Override
    public String deleteCustomWords(String text, int length) throws CustomException {
        if (text == null || text.length() == 0 || length <= 0) {
            throw new CustomException("wrong text");
        }
        return text.replaceAll(String.format(WORD_DELETE_RULE, CONSONANTS, length - 1), "");
    }

}
