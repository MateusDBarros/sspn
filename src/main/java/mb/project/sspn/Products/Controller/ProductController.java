package mb.project.sspn.Products.Controller;

import mb.project.sspn.Products.Model.Product;
import mb.project.sspn.Products.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        service.addNew(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto adicionado com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = service.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @PutMapping("/{productId}")
    public  ResponseEntity<String> updateProduct(@RequestBody Product product, @PathVariable int id) {
        product.setProductId(id);
        service.updateProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado com sucesso");
    }

    @DeleteMapping("/{productId")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluido com sucesso.");
    }
}
