package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServerController {

    @Autowired
    public ServerDAO dao;


    //API ENDPOINT USATI COME TEST
    @GetMapping(path = "/all")
    public @ResponseBody
    List<Light> getAllUsers() {

        List<Light> light = dao.getAll();
        return light;
    }
    //-----------------------------------------------------------------


    //API ENDPOINT USATI DALL'APPLICAZIONE MOBILE
    @RequestMapping(path = "/Check", method = RequestMethod.GET)
    @ResponseBody
    public Integer checkLight() {

        int foundId = dao.check();

        return foundId;
    }

    @RequestMapping(path = "/Set", method = RequestMethod.GET)
    @ResponseBody
    public void setLight() {

        dao.set();

    }

}