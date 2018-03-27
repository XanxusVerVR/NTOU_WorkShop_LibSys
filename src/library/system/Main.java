package library.system;

import controller.CommandHandler;
import java.util.Queue;
import model.InputHandler;

public class Main {

    public static void main(String[] args) {
        String path = "";
        path = "" + InputHandler.class.getClassLoader().getResource("");
        path = path.substring(6) + "sampleInput";
        InputHandler inputHandler = new InputHandler("/Users/xanxus/Desktop/NTOU_WorkShop_LibSys/build/classes/sampleInput");
        Queue<String> commandList = inputHandler.getCommandByFile();
        CommandHandler commandHandler = new CommandHandler(commandList);
        commandHandler.runBehaviorByCommand();
    }
}
