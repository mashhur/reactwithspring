package org.reactjs.spring.api;

import org.reactjs.spring.api.entity.User;
import org.reactjs.spring.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by mashhur on 3/22/17.
 */

@RequestMapping(value = "/api")
@RestController
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "Welcome to Spring-React API Controller!";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> getUsers() {

        // For pagination : userRepository.findAll(new PageRequest(1, 20)
        return userRepository.findAll();
    }

    @RequestMapping(value = "/getUniqueKey")
    @ResponseBody
    protected String generateKey() {
        String strRet = "";
        try {
            // generate globally unique key (considering host name)
            String host = InetAddress.getLocalHost().getHostName() + UUID.randomUUID().toString();
            String sKey = UUID.nameUUIDFromBytes(host.getBytes()).toString();
            strRet = host + "-"+ sKey;
        } catch (Exception ex){
            // in case of exception, generate an unique value (guaranteed only in one VM)
            strRet = UUID.randomUUID().toString();
        }

        return strRet;
    }

}
