package service;

import exception.CustomException;

public interface TextEditElement {
    String replaceChar(String text, int index, char symbol) throws CustomException;

    String replaceAll(String text, char condition, char replace, char insert) throws CustomException;

    String replaceWord(String text, int length, String insert) throws CustomException;

    String clearText(String text) throws CustomException;

    String deleteCustomWords(String text, int length) throws CustomException;
}
