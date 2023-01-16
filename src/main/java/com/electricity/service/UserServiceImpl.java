package com.electricity.service;

import com.electricity.dto.UserDTO;
import com.electricity.entity.User;
import com.electricity.exception.ServiceException;
import com.electricity.mapper.UserMapper;
import com.electricity.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new ServiceException("notFound", "Not Found(fromService)", "user", new Object[]{id}));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO add(UserDTO userDTO) {
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
        User oldUser = userRepository.findById(id).get();
        if(userRepository.findById(id).isPresent()){
            newUserDTO.setId(id);
            oldUser.setId(newUserDTO.getId());
            oldUser.setName(newUserDTO.getName());
            oldUser.setEmail(newUserDTO.getEmail());
            oldUser.setPassword(newUserDTO.getPassword());
            oldUser.setPhoneNumber(newUserDTO.getPhoneNumber());
            oldUser.setImage(newUserDTO.getImage());
            userRepository.save(userMapper.toEntity(newUserDTO));
        }else throw new ServiceException("notFound", "Not Found(fromService)", "user", new Object[]{id});
        return newUserDTO;
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return userMapper.toDTO(user);
    }
}
