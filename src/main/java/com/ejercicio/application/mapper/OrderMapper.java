package com.ejercicio.application.mapper;

import com.ejercicio.application.dto.OrderDTO;
import com.ejercicio.domain.model.Order;
import com.ejercicio.domain.model.OrderType;

/**
 * Mapper para Order
 * DRY: Lógica de conversión centralizada
 */
public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        if (order == null) {
            return null;
        }
        return OrderDTO.builder()
                .id(order.getId())
                .total(order.getTotal())
                .orderType(order.getOrderType().name())
                .build();
    }

    public static Order toEntity(OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        return Order.builder()
                .id(dto.getId())
                .total(dto.getTotal())
                .orderType(OrderType.valueOf(dto.getOrderType()))
                .build();
    }
}
