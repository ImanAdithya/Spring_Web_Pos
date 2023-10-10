package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    ItemService service;

    //xxx-formurl
    @PostMapping
    public ResponseUtil saveCustomer(ItemDTO dto){
        service.saveItem (dto);
        return new ResponseUtil ("OK","ITEM Added Success",dto);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteCustomer(String id){
        service.deleteItem (id);
        return new ResponseUtil ("OK","ITEM Deleted Success",id);
    }

    @GetMapping
    public ResponseUtil getAllCustomer(){
        List<ItemDTO> allItems = service.getAllItem ();
        return new ResponseUtil ("OK","ITEM Loaded Success",allItems);
    }

    @GetMapping(params = {"id"})
    public ResponseUtil findCustomer(String id){
        service.findItem (id);
        return new ResponseUtil ("OK","ITEM Deleted Success",id);
    }

    //json ywanne
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody ItemDTO c){
        service.updateItem (c);
        return new ResponseUtil ("OK","ITEM Updated Success",c);
    }
}
