package br.letscode.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.letscode.ecommerce.service.ProductsRestService;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductsRestController {
  @Autowired
  ProductsRestService productsService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<String>> findAll(){
    return ResponseEntity.ok(productsService.findAll());
  }
}
