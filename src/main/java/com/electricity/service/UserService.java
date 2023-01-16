package com.electricity.service;

import com.electricity.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO add(UserDTO userDTO);

    void deleteById(Long id);

    UserDTO update(Long id, UserDTO newUserDTO);

    UserDTO findByEmail(String email);
}
