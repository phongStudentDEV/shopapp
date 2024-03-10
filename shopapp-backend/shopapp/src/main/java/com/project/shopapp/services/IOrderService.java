package com.project.shopapp.services;

import com.project.shopapp.dtos.OrderDTO;
import com.project.shopapp.responses.OrderResponse;

import java.util.List;

public interface IOrderService {
    OrderResponse createCategory(OrderDTO orderDTO);

    OrderResponse getCategoryById(Long id);

    List<OrderResponse> getAllCategories();

    OrderResponse updateCategory(Long id, OrderDTO orderDTO);

    void deleteCategory(Long id);
}
