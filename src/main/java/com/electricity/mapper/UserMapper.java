package com.electricity.mapper;

import com.electricity.dto.UserDTO;
import org.springframework.security.core.userdetails.User;

//@Mapper(componentModel = "spring")
public interface UserMapper extends GeneralMapper<UserDTO, User> {

}
