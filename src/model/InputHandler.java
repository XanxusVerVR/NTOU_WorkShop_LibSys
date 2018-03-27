package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

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

    public Queue<String> getCommandByFile() {
        String content = readFile();
        Queue<String> commandList = getQueueByString(content);
        return commandList;
    }

    private String readFile() {
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
        return sb.toString();
    }

    //名子怪怪的
    private Queue<String> getQueueByString(String str) {
        Queue<String> queue = new LinkedList<String>();
        final String[] splittedStr = str.split("\n");
        for (String s : splittedStr) {
            if (!s.equals("")) {
                queue.add(s);
            }
        }
        return queue;
    }
}
