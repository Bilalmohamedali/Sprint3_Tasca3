package repository;

import model.FlowerShop;

import java.io.*;

public class TextFileRepository implements Repository{
    @Override
    public void saveFlowerShop(FlowerShop flowerShop, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(flowerShop.toString());

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public FlowerShop loadFlowerShop(String filePath){
        FlowerShop flowerShop = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream (fileInputStream);
            flowerShop = (FlowerShop) objectInputStream.readObject();
            objectInputStream.close();
        }catch (ClassNotFoundException | IOException e){
            throw new RuntimeException(e);
        }
        return flowerShop;
    }
}
