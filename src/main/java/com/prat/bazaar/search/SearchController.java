package com.prat.bazaar.search;

import com.prat.bazaar.model.Product;
import com.prat.bazaar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.logging.Logger;

@RestController("/api/v1")
public class SearchController {


    @Autowired
    ProductService productService;

    private static final Logger log = Logger.getLogger(SearchController.class.getName());

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {

        log.info("Getting All Products!!");
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

}
