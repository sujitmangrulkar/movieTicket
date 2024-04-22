package com.bookmyshow.api.service;

import com.bookmyshow.api.payloads.UserDto;

import java.util.UUID;

public interface UserService
{
    UserDto register(UserDto userDto);
    String login(String email,String password);
    UserDto updateProfile(UserDto userDto, String userId);

}
