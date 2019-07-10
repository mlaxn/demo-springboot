package com.mlaxn.controller;

import java.util.Hashtable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mlaxn.service.EmployeeService;
import com.mlaxn.model.ModelClass;


@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    EmployeeService es;

    @GetMapping("/all")
    public Hashtable <Integer,ModelClass> getAllEmployee(){
        return es.getAll();

    }

    //@RequestMapping("get/{eid}")

    @GetMapping("get/{eid}")
    public ModelClass getEmployee(@PathVariable("eid") int eid)
    {
        return es.getEmployee(eid);

    }

    //@RequestMapping("create/{eid}/{name}/{post}")

    @PostMapping("add/{eid}/{name}/{post}")
    public void createEmployee (@PathVariable("eid")int id,
                                @PathVariable("name") String name,
                                @PathVariable("post") String post)
    {
        es.createEmployee(id, name, post);
    }

    @DeleteMapping("/delete/{eid}")
    public void deleteEmployee(@PathVariable("eid") int eid)
    {
        es.deleteEmployee(eid);

    }

    @GetMapping("/greet/{eid}")
    public String greet_msg(@RequestParam(value="eid", defaultValue="2") int eid)
    {
        return es.greetEmployee(eid);
    }


}
