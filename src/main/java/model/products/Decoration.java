package model.products;

public class Decoration extends Product{

    public enum Material{
        WOOD,
        Plastic
    }
    private Material material;

    public Decoration(double price, Material material) {
        super(price);
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Decoration: Strock ID: " + super.getId() + ", material: " + this.material + ",price:" + " " + this.getPrice() + " €";
    }
}
