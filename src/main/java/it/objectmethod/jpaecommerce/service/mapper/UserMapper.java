package it.objectmethod.jpaecommerce.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.jpaecommerce.entity.Login;
import it.objectmethod.jpaecommerce.service.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, Login> {

	@Override
	UserDTO toDto(Login entity);

	@Override
	@Mapping(target = "password", ignore = true)
	Login toEntity(UserDTO dto);

}
