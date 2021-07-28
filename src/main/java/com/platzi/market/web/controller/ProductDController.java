package com.platzi.market.web.controller;

import com.platzi.market.domain.ProductDto;
import com.platzi.market.domain.service.ProductDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductDController {

    @Autowired
    private ProductDService productDService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAll() {

        return new ResponseEntity<>(productDService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductD(@PathVariable("id") int productId) {
        return productDService.getProductD(productId)
                .map(productDTO -> new ResponseEntity<>(productDTO,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/categoryD/{categoryId}")
    public ResponseEntity<List<ProductDto>> getByCategoryD(@PathVariable("categoryId") int categoryId) {
        return productDService.getByCategoryD(categoryId)
                .map(productDTOS -> new ResponseEntity<>(productDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productD) {
        return new ResponseEntity<>(productDService.save(productD), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productDId) {
        return productDService.delete(productDId)? new ResponseEntity(HttpStatus.OK):new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
