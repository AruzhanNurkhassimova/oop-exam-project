package System;
 
import java.io.*;
 
public class Database {
    private static Database instance;
    private String filePath = "university_data.ser";
 
    private Database() {}
 
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
 
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
 
    public void saveData(University university) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(university);
        } catch (IOException e) {
            throw new RuntimeException("Cannot save data: " + e.getMessage(), e);
        }
    }
 
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
