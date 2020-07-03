package service.impl;

import exception.CustomException;
import service.TextEditElement;

public class RegularTextEditElement implements TextEditElement {
    @Override
    public String replaceChar(String text, int index, char symbol) throws CustomException {
        return null;
    }//TODO

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
    } //TODO

}
