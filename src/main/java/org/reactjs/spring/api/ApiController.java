package org.reactjs.spring.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mashhur on 3/22/17.
 */

@RestController
public class ApiController {

    @RequestMapping("/api")
    @ResponseBody
    String home() {
        return "Welcome to MovieGram!";
    }

    @RequestMapping("/api/getUniqueKey")
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

    @RequestMapping("/api/users")
    @ResponseBody
    List<User> getUsers() {
        ArrayList<User> userList = new ArrayList<>();
        User mstt = new User("mashhur", "stt", "no idea who he is!");
        userList.add(mstt);

        return userList;
    }

}
