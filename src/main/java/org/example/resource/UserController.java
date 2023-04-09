package org.example.controller;

import org.apache.commons.logging.Log;
import org.example.exceptions.GenericException;
import org.example.model.dtos.UserDto;
import org.example.response.GeneralResponse;
import org.example.service.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private IUserServiceImpl iUserService;
    private Log logger;
    @GetMapping
    public String rtn(){
        return "user";
    }

    @PostMapping("/registration")
    public ResponseEntity<GeneralResponse> registerUser(@RequestBody UserDto dto) {
        String userMail = null;
        try {
            userMail = iUserService.registerUser(dto);
        } catch (GenericException e) {
            logger.error("seems like the used email already exists");
            return ResponseEntity.ok(new GeneralResponse
                    (new Date(System.currentTimeMillis()),
                            HttpStatus.BAD_REQUEST, "email " +
                            "submitted belongs to another user in our system"));
        }
        logger.info("registration went on successfully!  user email::'"+userMail+"'");
        return ResponseEntity.ok(new GeneralResponse(new Date(System.currentTimeMillis()),
                HttpStatus.ACCEPTED, "successful registration of user with email::'" + userMail + "'"));
    }

    @Autowired
    public void setiUserService(IUserServiceImpl iUserService) {
        this.iUserService = iUserService;
    }

    @Autowired
    public void setLogger(Log logger) {
        this.logger = logger;
    }
}
