package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.User;
import com.bookmyshow.api.exceptions.ResourceNotFoundException;
import com.bookmyshow.api.payloads.UserDto;
import com.bookmyshow.api.repository.UserRepository;
import com.bookmyshow.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDto register(UserDto userDto)
    {
        User user = this.modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = this.userRepository.save(user);
        return this.modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public String login(String email, String password)
    {
        Optional<User> user = this.userRepository.findByEmailAndPassword(email, password);

        if(user!=null)
        {
            return "Login Success";
        }
        else
        {
            return "Login Failed";
        }
    }

    @Override
    public UserDto updateProfile(UserDto userDto, String userId)
    {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

        user.setUserName(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User savedUser = this.userRepository.save(user);

        return this.modelMapper.map(savedUser,UserDto.class);
    }
}
