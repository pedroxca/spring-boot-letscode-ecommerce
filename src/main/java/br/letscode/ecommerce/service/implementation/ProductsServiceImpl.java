package br.letscode.ecommerce.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.letscode.ecommerce.clients.ProductsRestClient;
import br.letscode.ecommerce.service.ProductsRestService;

@Service
public class ProductsServiceImpl implements ProductsRestService {
  @Autowired
  ProductsRestClient productsRestClient;
  @Override
  public List<String> findAll() {
    return productsRestClient.findAll();
  }
}
