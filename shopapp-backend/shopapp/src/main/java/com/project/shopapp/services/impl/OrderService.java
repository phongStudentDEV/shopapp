package com.project.shopapp.services.impl;

import com.project.shopapp.dtos.OrderDTO;
import com.project.shopapp.responses.OrderResponse;
import com.project.shopapp.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    @Override
    public OrderResponse createCategory(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderResponse getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<OrderResponse> getAllCategories() {
        return null;
    }

    @Override
    public OrderResponse updateCategory(Long id, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
