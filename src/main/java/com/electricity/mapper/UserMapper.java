package com.electricity.mapper;

import com.electricity.dto.UserDTO;
import com.electricity.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GeneralMapper<UserDTO, User> {

}
