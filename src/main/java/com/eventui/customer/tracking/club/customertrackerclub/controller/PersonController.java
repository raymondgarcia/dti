package com.eventui.customer.tracking.club.customertrackerclub.controller;



import com.eventui.customer.tracking.club.customertrackerclub.exceptions.NotFoundException;
import com.eventui.customer.tracking.club.customertrackerclub.model.PersonDto;
import com.eventui.customer.tracking.club.customertrackerclub.service.IGenericService;
import java.util.Collection;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/customers")
@PreAuthorize("hasRole('ROLE_USER')")
public class PersonController {

    @Autowired
    @Qualifier(value = "personService")
    IGenericService<PersonDto> personService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<PersonDto> listCustomer() {
        return Optional.ofNullable(personService.findAll())
                .orElseThrow(() ->new NotFoundException("No found"));
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public PersonDto getCustomer(@Valid @NotNull @PathVariable("id") final String id) {
        return Optional.ofNullable(personService.findOne(id))
                .orElseThrow(() ->new NotFoundException("No found"));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public PersonDto createCustomer(@NotNull @RequestBody final PersonDto personDto) {
        return personService.create(personDto);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public PersonDto updateCustomer(@Valid @NotNull @PathVariable("id") final String id,
            @Valid @NotNull @RequestBody final PersonDto personDto) {
        return personService.update(personDto);
    }

}
