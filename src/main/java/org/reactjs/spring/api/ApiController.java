package org.reactjs.spring.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mashhur on 3/22/17.
 */

@RequestMapping(value = "/api")
@RestController
public class ApiController {

    @RequestMapping(method = RequestMethod.GET)
    String index() {
        return "Welcome to Spring-React API Controller!";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    List<User> getUsers() {
        ArrayList<User> userList = new ArrayList<>();
        User mstt = new User(1, "mashhur1", "mstt", "no idea who he is!");
        User sttm = new User(2, "mashhur2", "sttm", "no idea who he is too!");
        userList.add(mstt);
        userList.add(sttm);
        return userList;
    }

    @RequestMapping(value = "/getUniqueKey")
    @ResponseBody
    String generateKey() {
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
