import exception.CustomException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.CharTextEditElement;
import service.impl.RegularTextEditElement;
import service.impl.StringTextEditElement;

import static org.testng.Assert.assertEquals;

public class TextEditTest {
    CharTextEditElement charTextEditElement = new CharTextEditElement();
    RegularTextEditElement regularTextEditElement = new RegularTextEditElement();
    StringTextEditElement stringTextEditElement = new StringTextEditElement();

    @DataProvider(name = "text_symbol_replace")
    public Object[] textSymbolReplaceData() {
        return new Object[][]{
                {"almata verona anna rize ri123", 5, 'P', "almaPa veroPa anna rize ri12P"},
                {"ala a ripe ri123", 3, 'P', "alP a riPe riP23"}
        };
    }

    @Test(dataProvider = "text_symbol_replace")
    public void charSymbolEditTest(String text, int index, char symbol, String expected) throws CustomException {
        assertEquals(charTextEditElement.replaceChar(text, index, symbol), expected);
    }
    @Test(dataProvider = "text_symbol_replace")
    public void regularSymbolEditTest(String text, int index, char symbol, String expected) throws CustomException {
        assertEquals(regularTextEditElement.replaceChar(text, index, symbol), expected);
    }
    @Test(dataProvider = "text_symbol_replace")
    public void stringSymbolEditTest(String text, int index, char symbol, String expected) throws CustomException {
        assertEquals(stringTextEditElement.replaceChar(text, index, symbol), expected);
    }

    @DataProvider(name = "text_all_replace")
    public Object[] textAllReplaceData() {
        return new Object[][]{
                {"mia dia ruia nai 1wae asrima", 'i','a','H',"miH diH ruiH nai 1wae asrima"},
                {"atna rudementa ratna", 't','a','H',"atna rudementH ratna"},
        };
    }
    @Test(dataProvider = "text_all_replace")
    public void charAllEditTest(String text, char condition, char replace, char insert, String expected) throws CustomException {
        assertEquals(charTextEditElement.replaceAll(text, condition, replace, insert), expected);
    }
    @Test(dataProvider = "text_all_replace")
    public void regularAllEditTest(String text, char condition, char replace, char insert, String expected) throws CustomException {
        assertEquals(regularTextEditElement.replaceAll(text, condition, replace, insert), expected);
    }
    @Test(dataProvider = "text_all_replace")
    public void stringAllEditTest(String text, char condition, char replace, char insert, String expected) throws CustomException {
        assertEquals(stringTextEditElement.replaceAll(text, condition, replace, insert), expected);
    }

    @DataProvider(name = "text_word_replace")
    public Object[] textWordReplaceData() {
        return new Object[][]{
                {"mia dia ruia nai 1wae asrima", 4,"HOLA","mia dia HOLA nai HOLA asrima"},
                {"valenta atnas rudementa ratna", 5 ,"HOLA","valenta HOLA rudementa HOLA"},
        };
    }
    @Test(dataProvider = "text_word_replace")
    public void charWordEditTest(String text, int length, String insert, String expected) throws CustomException {
        assertEquals(charTextEditElement.replaceWord(text, length, insert), expected);
    }
    @Test(dataProvider = "text_word_replace")
    public void stringWordEditTest(String text, int length, String insert, String expected) throws CustomException {
        assertEquals(stringTextEditElement.replaceWord(text, length, insert), expected);
    }
    @Test(dataProvider = "text_word_replace")
    public void regularWordEditTest(String text, int length, String insert, String expected) throws CustomException {
        assertEquals(regularTextEditElement.replaceWord(text, length, insert), expected);
    }

    @DataProvider(name = "text_word_remove")
    public Object[] textWordRemoveData() {
        return new Object[][]{
                {"mia ruai awae asrima", 4,"mia awae asrima"},
        };
    }
    @Test(dataProvider = "text_word_remove")
    public void charWordRemoveTest(String text, int length,  String expected) throws CustomException {
        assertEquals(charTextEditElement.deleteCustomWords(text, length), expected);
    }
    @Test(dataProvider = "text_word_remove")
    public void stringWordRemoveTest(String text, int length,  String expected) throws CustomException {
        assertEquals(stringTextEditElement.deleteCustomWords(text, length), expected);
    }
    @Test(dataProvider = "text_word_remove")
    public void regularWordRemoveTest(String text, int length,  String expected) throws CustomException {
        assertEquals(regularTextEditElement.deleteCustomWords(text, length), expected);
    }

    @DataProvider(name = "text_regular_clear")
    public Object[] textRegularClearData() {
        return new Object[][]{
                {"m123a ruai a-ae 123/afarima","ma ruai a-ae afarima"},
        };
    }
    @Test(dataProvider = "text_clear")
    public void charClearTest(String text, String expected) throws CustomException {
        assertEquals(charTextEditElement.clearText(text), expected);
    }
    @Test(dataProvider = "text_clear")
    public void stringClearTest(String text, String expected) throws CustomException {
        assertEquals(stringTextEditElement.clearText(text), expected);
    }
    @DataProvider(name = "text_clear")
    public Object[] textClearData() {
        return new Object[][]{
                {"m123a ruai a-ae 123/afarima","m   a ruai a ae     afarima"},
        };
    }
    @Test(dataProvider = "text_regular_clear")
    public void regularClearTest(String text, String expected) throws CustomException {
        assertEquals(regularTextEditElement.clearText(text), expected);
    }
}
