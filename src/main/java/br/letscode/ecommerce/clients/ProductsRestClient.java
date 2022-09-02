package br.letscode.ecommerce.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "FinanceiroRestClient",
 url = "https://dummyjson.com")
public interface ProductsRestClient {
  @RequestMapping(path = "/products/categories", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  public List<String> findAll();
}
