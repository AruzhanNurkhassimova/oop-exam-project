package System;
 
import java.io.*;

/**
 * Singleton storage class responsible for saving and loading
 * university data using Java serialization.
 */
public class Database {
    private static Database instance;
    private String filePath = "university_data.ser";
 
    private Database() {}

    /**
     * Returns the single Database instance.
     *
     * @return database singleton instance
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
 
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves university data to a file using serialization.
     *
     * @param university university object to save
     */
    public void saveData(University university) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(university);
        } catch (IOException e) {
            throw new RuntimeException("Cannot save data: " + e.getMessage(), e);
        }
    }

    /**
     * Loads university data from a file.
     * If file does not exist, returns a new empty University object.
     *
     * @return loaded university data
     */
    public University loadData() {
        File file = new File(filePath);
        if (!file.exists()) {
            return new University();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (University) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Cannot load data: " + e.getMessage(), e);
        }
    }
}
