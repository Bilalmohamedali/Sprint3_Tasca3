package repository;

import model.FlowerShop;

public interface Repository {
    void saveFlowerShop(FlowerShop flowerShop, String filePath);
        FlowerShop loadFlowerShop(String filePath);

}
