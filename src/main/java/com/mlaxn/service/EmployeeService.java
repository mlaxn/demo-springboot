package com.mlaxn.service;



import com.mlaxn.model.ModelClass;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class EmployeeService {
    Hashtable<Integer,ModelClass> employees = new Hashtable<>();
    private static final String template = "Hello Employee, %s !";		//template to format the strings out put

    public EmployeeService() {
        ModelClass e1 = new ModelClass(1,"Madan","Infosys Manager");
        ModelClass e2 = new ModelClass(2," Goli","Infosys Tech Lead");
        employees.put(e1.getEid(), e1);
        employees.put(e2.getEid(), e2);

    }
    public void createEmployee(int id, String name, String post) {

        ModelClass e = new ModelClass(id,name,post);
        employees.put(e.getEid(),e);

    }

    public ModelClass getEmployee(int eid) {
        if (employees.containsKey(eid))
            return employees.get(eid);
        else
            System.out.println("Employee Not Found");
        return null;

    }
    public Hashtable<Integer, ModelClass> getAll(){

        return employees;
    }

    public void deleteEmployee(int eid) {
        if (employees.containsKey(eid)) {
            employees.remove(eid);
            System.out.println("Deledted Employee Id: " + eid);
        }
        else
            System.out.println("Employee Id: "+ eid + " not Found");
    }

    public String greetEmployee(int eid ) {
        String greet_name= null;
        if (employees.containsKey(eid))
            greet_name = employees.get(eid).getName();
        return String.format(template, greet_name);

        // return "Hello Employee " + greet_name + "!";
    }

}
