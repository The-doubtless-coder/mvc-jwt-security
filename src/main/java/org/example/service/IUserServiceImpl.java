package org.example.service;

import org.example.exceptions.GenericException;
import org.example.model.User;
import org.example.model.dtos.UserDto;
import org.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {
    private UserRepo userRepo;

    @Override
    public String registerUser(UserDto dto) throws GenericException {
        boolean isUserPresent = userRepo.findByEmail(dto.getEmail()).isPresent();
        if(isUserPresent){
            throw new GenericException("user's email is already in use");
        }
        User user = new User(dto.getName(), dto.getEmail()
                , dto.getPassword(), dto.getRoles());
        User saved = userRepo.save(user);
        return saved.getEmail();
    }
    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
