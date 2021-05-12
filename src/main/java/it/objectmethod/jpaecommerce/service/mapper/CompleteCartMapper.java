package it.objectmethod.jpaecommerce.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.jpaecommerce.entity.Cart;
import it.objectmethod.jpaecommerce.service.dto.CompleteCartDTO;

@Mapper(componentModel = "spring")
public interface CompleteCartMapper extends EntityMapper<CompleteCartDTO, Cart> {

	@Override
	@Mapping(source = "id", target = "cartId")
	CompleteCartDTO toDto(Cart entity);

	@Override
	Cart toEntity(CompleteCartDTO dto);
}
