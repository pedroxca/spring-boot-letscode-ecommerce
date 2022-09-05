package br.letscode.ecommerce.controller.api.v1;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.letscode.ecommerce.models.Message;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = "/home", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiHomeController {
  @Operation(description = "This is the api home", summary = "This is the api home", responses = @ApiResponse(responseCode = "200", description = "Api home"))
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Message> home() {
    return ResponseEntity.ok(new Message("Hello, this is the API home!"));
  }
}
