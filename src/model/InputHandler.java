package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputHandler {

    String filePath;
    BufferedReader br;

    public InputHandler(String filePath) {
        this.filePath = filePath;
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getInputByFile() {
        StringBuilder sb = new StringBuilder();
        try {

            String line;
            while ((line = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String contents = sb.toString();
        return contents;
    }
}
