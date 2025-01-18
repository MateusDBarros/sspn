package mb.project.sspn.Products.Model;

public class Product {
    private int productId;
    private String name;
    private String description;
    private double value;
    private int quantity;

    public Product() {
    }

    public Product(int productId, String name, String description, double value, int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.value = value;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public double getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
