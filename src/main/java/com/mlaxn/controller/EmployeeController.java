package com.mlaxn.controller;

import com.mlaxn.model.ModelClass;
import com.mlaxn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;

//import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    EmployeeService es;

    //@RequestMapping("/all")
    //@RequestMapping(value = "/all", method = RequestMethod.POST)

    //
    //private static Logger logger = LogManager.getLogger(SpringBootRestMvc1Application.class);


    @GetMapping("/all")
    public Hashtable <Integer,ModelClass> getAllEmployee(){

//		logger.info("Starting Spring Boot application..");
//		System.out.println("get all Methods is called");
//		logger.debug("Debuging... !");
//		logger.error("Error... !");

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
