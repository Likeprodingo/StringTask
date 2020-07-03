package reader;

import exception.CustomException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomDataReader {
    private static final String FILE_PATH = "src/main/resources/data.txt";

    public String consoleTextRead() throws CustomException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            System.out.println("to stop write - exit");
            while (true) {
                line = reader.readLine();
                if (line.equals("exit")) {
                    break;
                }
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new CustomException("Wrong console input", e);
        }
        return stringBuilder.toString();
    }

    public String fileTextRead(String pathToFile) throws CustomException {
        StringBuilder result = new StringBuilder("");
        String line;
        if (pathToFile.equals("")) {
            pathToFile = FILE_PATH;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            throw new CustomException("Wrong file input", e);
        }
        return result.toString();
    }
}
