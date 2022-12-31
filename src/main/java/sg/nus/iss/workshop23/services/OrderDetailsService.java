package sg.nus.iss.workshop23.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.workshop23.models.OrderDetails;
import sg.nus.iss.workshop23.repositories.OrderRepository;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderRepository odSvc;

    public OrderDetails getDiscountedOrderDetails(Integer orderId) {
        return odSvc.getDiscountedOrderDetails(orderId);
    }
}
