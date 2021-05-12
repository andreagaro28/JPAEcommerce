package it.objectmethod.jpaecommerce.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.jpaecommerce.entity.Order;
import it.objectmethod.jpaecommerce.service.dto.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {

	@Override
	@Mapping(source = "user.userName", target = "userName")
	@Mapping(source = "user.id", target = "userId")
	OrderDTO toDto(Order entity);

	@Override
	Order toEntity(OrderDTO dto);
}
