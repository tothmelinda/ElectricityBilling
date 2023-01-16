package com.electricity.service;

import com.electricity.dto.UserDTO;
import com.electricity.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO add(UserDTO userDTO);

    void deleteById(Long id);

    UserDTO update(Long id, UserDTO newUserDTO);

    User findByEmail(String email);
}
