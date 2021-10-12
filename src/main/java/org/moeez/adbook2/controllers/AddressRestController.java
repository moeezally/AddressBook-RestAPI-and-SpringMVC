package org.moeez.adbook2.controllers;

import org.moeez.adbook2.models.address;
import org.moeez.adbook2.services.dashboardLoaderService;
import org.moeez.adbook2.services.addressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AddressRestController {

    @Autowired
    private dashboardLoaderService DashboardService;
    @Autowired
    private addressBookService AddressBookService;

    @GetMapping (path = "/address/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<address> getAllAddresses(){
        return DashboardService.LoadDashboard();
    }


    @GetMapping (path = "/address/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public address getAddressById(@PathVariable("id") int id){
        return AddressBookService.GetAddressById(id);
    }


    @DeleteMapping(path="/address/{id}")
    public ResponseEntity<Boolean> DeleteAddressById(@PathVariable("id") int id){
        boolean deleted=AddressBookService.deleteAddressById(id);

        if(deleted){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(false,HttpStatus.NOT_MODIFIED);
        }

    }


    @PostMapping(path = "/address/")
    public ResponseEntity<Boolean> AddAddress(@RequestBody address address){
        boolean added=AddressBookService.insertAddress(address);

        if(added){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(false,HttpStatus.NOT_MODIFIED);
        }

    }


    @PutMapping(path = "/address/{id}")
    public ResponseEntity<Boolean> UpdateAddressById(@PathVariable("id") int id, @RequestBody address updateAddress){
        address fetched=AddressBookService.GetAddressById(id);
        System.out.println(updateAddress);
        if (updateAddress.getName()==null||updateAddress.getName().isEmpty()){
            updateAddress.setName(fetched.getName());
        }
        if (updateAddress.getCity()==null||updateAddress.getCity().isEmpty() ){
            updateAddress.setCity(fetched.getCity());
        }
        if (updateAddress.getId()==0){
            updateAddress.setId(fetched.getId());
        }
        if (updateAddress.getCountry()==null||updateAddress.getCountry().isEmpty()){
            updateAddress.setCountry(fetched.getCountry());
        }
        if (updateAddress.getGender()==null||updateAddress.getGender().isEmpty()){
            updateAddress.setGender(fetched.getGender());
        }
        System.out.println(updateAddress);

        boolean updated=AddressBookService.updateAddress(updateAddress);

        if(updated)
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }



}
