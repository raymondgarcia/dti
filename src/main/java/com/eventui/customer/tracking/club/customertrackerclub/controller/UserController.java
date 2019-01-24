/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.controller;


import com.eventui.customer.tracking.club.customertrackerclub.exceptions.NotFoundException;
import com.eventui.customer.tracking.club.customertrackerclub.model.UserDto;
import com.eventui.customer.tracking.club.customertrackerclub.service.IGenericService;
import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author raymondgarcia
 */
@RestController
@RequestMapping("/api/users")
@PreAuthorize("hasRole('ROLE_USER')")
public class UserController {
    
    @Autowired
    @Qualifier(value = "userService")
    IGenericService<UserDto> userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public Collection<UserDto> listCustomer() {
        System.out.println("enter person" +userService.findAll());
        return Optional.ofNullable(userService.findAll())
                .orElseThrow(() ->new NotFoundException("No found"));
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserDto getCustomer(@Valid @NotNull @PathVariable("id") final int id) {
        return Optional.ofNullable(userService.findOne(id))
                .orElseThrow(() ->new NotFoundException("No found"));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserDto createCustomer(@NotNull @RequestBody final UserDto userDto) {
        return userService.create(userDto);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserDto updateCustomer(@Valid @NotNull @PathVariable("id") final int id,
            @Valid @NotNull @RequestBody final UserDto userDto) {
        return userService.update(userDto);
    }
    
}
