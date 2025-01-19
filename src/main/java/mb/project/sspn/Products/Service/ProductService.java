package mb.project.sspn.Products.Service;

import mb.project.sspn.Products.Model.Product;
import mb.project.sspn.Products.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addNew(Product product) {
        if (product.getName() == null || product.getName().isEmpty())
            throw new IllegalStateException("Por favor insira um nome valido para o produto.");
        if (product.getDescription() == null || product.getDescription().isEmpty())
            throw new IllegalStateException("Por favor insira uma descrição valida para o produto.");
        if (product.getValue() <= 0)
            throw new IllegalStateException("O valor do produto deve ser maior que zero.");
        if (product.getQuantity() <= 0)
            throw new IllegalStateException("A quantidade do produto deve ser maior que zero.");

        repository.addNew(product);
    }

    public List<Product> getProducts() {
        return repository.getProducts();
    }

    public void updateProduct(Product product) {
        if (!repository.exist(product.getProductId()))
            throw new IllegalStateException("ID do produto não encontrada");
        if (repository.validate(product))
            repository.updateProduct(product);
    }


    public void deleteProduct(int  id) {
        if (!repository.exist(id))
            throw new IllegalStateException("ID do produto não encontrada");
        repository.deleteProduct(id);
    }

}
