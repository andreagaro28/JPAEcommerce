package it.objectmethod.jpaecommerce.service.mapper;

import org.mapstruct.Mapper;

import it.objectmethod.jpaecommerce.entity.CartDetail;
import it.objectmethod.jpaecommerce.service.dto.CartDetailDTO;

@Mapper(componentModel = "spring")
public interface CartDetailMapper extends EntityMapper<CartDetailDTO, CartDetail> {

	@Override
	CartDetailDTO toDto(CartDetail entity);

	@Override
	CartDetail toEntity(CartDetailDTO dto);
}
