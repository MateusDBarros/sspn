package mb.project.sspn.Products.Repository;

import mb.project.sspn.Products.Model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbc;


    public ProductRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void addNew(Product product) {
        String sql = "INSERT INTO Products (name, description, value, quantity) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, product.getName(), product.getDescription(), product.getValue(), product.getQuantity());
    }

    public List<Product> getProducts() {
        String sql = "SELECT * FROM Products";
        return jdbc.query(sql, (rs, rowNum) ->
                new Product(
                        rs.getInt("productId"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("value"),
                        rs.getInt("quantity")
                )
        );
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE SET name = ?, description = ?, value = ?, quantity = ? WHERE productId = ?";
        jdbc.update(sql, product.getName(), product.getDescription(), product.getValue(), product.getQuantity(), product.getProductId());
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM Products WHERE productId = ?";
        jdbc.update(sql, id);
    }

    public Boolean validate(Product product) {
        if (product.getName() == null || product.getName().isEmpty())
            throw new IllegalStateException("Por favor insira um nome valido para o produto.");
        if (product.getDescription() == null || product.getDescription().isEmpty())
            throw new IllegalStateException("Por favor insira uma descrição valida para o produto.");
        if (product.getValue() <= 0)
            throw new IllegalStateException("O valor do produto deve ser maior que zero.");
        if (product.getQuantity() <= 0)
            throw new IllegalStateException("A quantidade do produto deve ser maior que zero.");

        return true;
    }

    public boolean exist(int id) {
        String sql = "SELECT COUNT (*) FROM Products WHERE productId = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
