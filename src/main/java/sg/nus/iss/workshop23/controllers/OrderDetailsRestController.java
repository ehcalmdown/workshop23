package sg.nus.iss.workshop23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.iss.workshop23.models.OrderDetails;
import sg.nus.iss.workshop23.services.OrderDetailsService;

@RestController
@RequestMapping(path = "/order/total", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderDetailsRestController {

    @Autowired
    private OrderDetailsService odSvc;

    @GetMapping(path = "{orderId}")
    public ResponseEntity<String> getOrderDetailsWithDiscountedPrice(@PathVariable Integer orderId) {
        OrderDetails ord = odSvc.getDiscountedOrderDetails(orderId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ord.toJSON().toString());
    }
}
