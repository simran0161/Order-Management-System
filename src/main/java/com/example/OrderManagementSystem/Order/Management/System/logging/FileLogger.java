package com.example.OrderManagementSystem.Order.Management.System.logging;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

@Component
public class FileLogger {
    private static final Path file_path= Paths.get("order_log.txt");

    public synchronized  void log(String message){
        try(BufferedWriter writer = Files.newBufferedWriter(
                file_path,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )){
            writer.write(message);
            writer.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
