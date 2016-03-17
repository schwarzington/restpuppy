package com.restpuppy.main.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restpuppy.puppy.Puppy;

@Controller
public class RESTPuppy {
    @RequestMapping(path = "/getAllPuppies", method = RequestMethod.GET)
    public @ResponseBody ArrayList<Puppy> getAllPuppies(Model model) {
        return null;
    }
}
