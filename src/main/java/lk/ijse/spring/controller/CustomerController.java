package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    //xxx-formurl
    @PostMapping
    public ResponseUtil saveCustomer(CustomerDTO dto){
        service.saveCustomer (dto);
        return new ResponseUtil ("OK","Customer Added Success",dto);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteCustomer(String id){
       service.deleteCustomer (id);
        return new ResponseUtil ("OK","Customer Deleted Success",id);
    }

    @GetMapping
    public ResponseUtil getAllCustomer(){
        List<CustomerDTO> allCustomer = service.getAllCustomer ();
        return new ResponseUtil ("OK","Customer Loaded Success",allCustomer);
    }

    @GetMapping(params = {"id"})
    public ResponseUtil findCustomer(String id){
         service.findCustomer(id);
        return new ResponseUtil ("OK","Customer Deleted Success",id);
    }

    //json ywanne
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO c){
       service.updateCustomer (c);
        return new ResponseUtil ("OK","Customer Updated Success",c);
    }
}
