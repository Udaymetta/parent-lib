package com.greaterhill.order.controller;

import com.greaterhill.model.CommonResponseObject;
import com.greaterhill.order.model.OrderRequestDto;
import com.greaterhill.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<CommonResponseObject> createOrder(@RequestBody OrderRequestDto request){
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping({"", "/{orderNumber}"})
    public ResponseEntity<Object> getOrders(
            @PathVariable (required = false) String orderNumber){
        return ResponseEntity.ok(orderService.getOrders(orderNumber));
    }
}