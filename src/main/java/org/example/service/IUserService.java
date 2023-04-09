package org.example.service;

import org.example.exceptions.GenericException;
import org.example.model.dtos.UserDto;

public interface IUserService {
    public String registerUser(UserDto dto) throws GenericException;
}
