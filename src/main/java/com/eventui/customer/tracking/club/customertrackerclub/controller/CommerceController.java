/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.controller;


import com.eventui.customer.tracking.club.customertrackerclub.exceptions.NotFoundException;
import com.eventui.customer.tracking.club.customertrackerclub.model.CommerceDto;
import com.eventui.customer.tracking.club.customertrackerclub.service.IGenericService;
import io.swagger.annotations.Api;
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
@Api(basePath = "/api/commerce", value = "Configuration Controller", description = "Operations with Configurations", produces = "application/json", tags = {
        "Configuration" })
@RestController
@RequestMapping("/api/commerces")
@PreAuthorize("hasRole('ROLE_USER')")
public class CommerceController {
    
    @Autowired
    @Qualifier(value = "commerceService")
    IGenericService<CommerceDto> commerceService;
     
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<CommerceDto> listCommerce() {
        return Optional.ofNullable(commerceService.findAll())
                .orElseThrow(() ->new NotFoundException("No found"));
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommerceDto getCommerce(@Valid @NotNull @PathVariable("id") final String id) {
        return Optional.ofNullable(commerceService.findOne(id))
                .orElseThrow(() ->new NotFoundException("No found"));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public CommerceDto createCommerce(@Valid @NotNull @RequestBody final CommerceDto commerceDto) {
        return commerceService.create(commerceDto);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CommerceDto updateCommerce(@Valid @NotNull @PathVariable("id") final String id,
            @Valid @NotNull @RequestBody final CommerceDto commerceDto) {
        commerceDto.setId(id);
        return commerceService.update(commerceDto);
    }

    
}
