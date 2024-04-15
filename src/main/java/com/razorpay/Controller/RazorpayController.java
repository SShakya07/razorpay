package com.razorpay.Controller;

import com.razorpay.Order;
import com.razorpay.Payload.OrderDetails;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class RazorpayController {
    //http://localhost:8080/api/order
@PostMapping
    public String createOreder(@RequestBody OrderDetails orderDetails) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient("rzp_test_HhYWoZVfCku18i", "WloWDYvpRg6JtZnBPxqDnGEX");

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount",orderDetails.getAmount());
        orderRequest.put("currency",orderDetails.getCurrency());
        orderRequest.put("receipt", UUID.randomUUID().toString());
        JSONObject notes = new JSONObject();
        notes.put(orderDetails.getNoteSubject(),orderDetails.getNoteContent());
       // notes.put("notes_key_1","Tea, Earl Grey, Hot");
        orderRequest.put("notes",notes);

        Order order = razorpay.orders.create(orderRequest);

        return order.get("id").toString();
    }
}
