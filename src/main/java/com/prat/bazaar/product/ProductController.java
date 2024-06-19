package com.prat.bazaar.product;

import com.prat.bazaar.model.Product;
import com.prat.bazaar.service.ProductService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {


    @Autowired
    ProductService productService;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/allProducts")
    @ApiResponse(description = "API to fetch all Products")
    public List<Product> getAllProducts() {

        log.info("Getting All Products!!");
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    @ApiResponse(description = "API to fetch product based on Id")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/search/{keyword}")
    @ApiResponse(description = "API to Search a certain product based on search text")
    public List<Product> searchProductByKeyword(@PathVariable String keyword) {
        log.info("Searching Product by Keyword: " + keyword);
        return productService.geProductDetailsBySearchKeyword(keyword);
    }

    @PostMapping("/product")
    @ApiResponse(description = "API to create new Products")
    public Boolean createProducts(@RequestBody List<Product> products) {
        log.info("Creating Products: " + products);
        return productService.createNewProducts(products);
    }

    @PutMapping("/product")
    @ApiResponse(description = "API to update an existing Products")
    public Boolean updateProduct(@RequestBody Product product) {
        log.info("Updating Product: " + product);
        return productService.updateExistingProduct(product);
    }

}
