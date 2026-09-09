package logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private String fileName;
    private BufferedWriter writer;

    private Logger() {
        // Private constructor to prevent instantiation
        // Initialize the log file
        setFileName("default.log");
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String fileName) {
        // close current log file if open
        close();
        // Create new log file with the given filename
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            this.fileName = fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String message) {
        //write message to log file
        try {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        //close log file
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
