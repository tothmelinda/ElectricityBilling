package com.electricity.service.impl;

import com.electricity.dto.UserDTO;
import com.electricity.entity.User;
import com.electricity.exception.ServiceException;
import com.electricity.mapper.UserMapper;
import com.electricity.repository.UserRepository;
import com.electricity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User with id %d not found", id)));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO add( UserDTO userDTO) {
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ServiceException("notFound", "Not Found(fromService)", "user", new Object[]{id}));
        userRepository.delete(user);
    }

    @Override
    public UserDTO update(Long id, UserDTO newUserDTO) {
        User oldUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User with id %d not found", id)));

        oldUser.setFirstName(newUserDTO.getFirstName());
        oldUser.setLastName(newUserDTO.getLastName());
        oldUser.setEmail(newUserDTO.getEmail());
        oldUser.setPassword(newUserDTO.getPassword());
        oldUser.setPhoneNumber(newUserDTO.getPhoneNumber());
        oldUser.setImage(newUserDTO.getImage());

        userRepository.save(oldUser);

        return userMapper.toDTO(oldUser);
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException(String.format("User with id %d not found", email)));;
        return userMapper.toDTO(user);
    }
}
