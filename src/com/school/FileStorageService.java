package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Simple file storage service for lists of Storable objects.
 */
public class FileStorageService {

    /**
     * Save a list of Storable items to a file (one toDataString() per line).
     *
     * @param items    list of items implementing Storable
     * @param filename output file path (relative to project root)
     */
    public void saveData(List<? extends Storable> items, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Storable s : items) {
                pw.println(s.toDataString());
            }
            System.out.println("Saved " + items.size() + " records to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving data to " + filename + ": " + e.getMessage());
            // For debugging you might uncomment:
            // e.printStackTrace();
        }
    }
}
