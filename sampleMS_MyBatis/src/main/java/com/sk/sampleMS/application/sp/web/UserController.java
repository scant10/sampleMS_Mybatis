package com.sk.sampleMS.application.sp.web;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.sk.sampleMS.application.sp.web.Exception.*;
import com.sk.sampleMS.domain.sample.model.*;
import com.sk.sampleMS.domain.sample.service.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ResponseEntity<?> findUserInfoAll() throws Exception{
        return new ResponseEntity(userService.getUserInfoAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ResponseEntity<?> registUser(@Validated @RequestBody User user){
        System.out.println("controller vo check::" + user.toString() );
        userService.adduserInfo(user);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping("/search")
    public ResponseEntity<?> findUserListbyNames(@RequestParam("username") String userName){
        return new ResponseEntity(userService.findByUserNameLike(userName), HttpStatus.OK);
    }

    @RequestMapping("/{username}")
    public ResponseEntity<?> findByUserOne(@PathVariable("username") String userName){
        User user = userService.findByUserName(userName);
        if(user == null){
            throw new UserNotFoundException("user not found");
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }
}