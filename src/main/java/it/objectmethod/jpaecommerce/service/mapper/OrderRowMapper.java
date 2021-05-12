package it.objectmethod.jpaecommerce.service.mapper;

import org.mapstruct.Mapper;

import it.objectmethod.jpaecommerce.entity.OrderRow;
import it.objectmethod.jpaecommerce.service.dto.OrderRowDTO;

@Mapper(componentModel = "spring")
public interface OrderRowMapper extends EntityMapper<OrderRowDTO, OrderRow> {

	@Override
	OrderRowDTO toDto(OrderRow entity);

	@Override
	OrderRow toEntity(OrderRowDTO dto);
}
