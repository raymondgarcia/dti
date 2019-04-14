/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;


import com.eventui.customer.tracking.club.customertrackerclub.dao.UserRepository;
import com.eventui.customer.tracking.club.customertrackerclub.entity.User;
import com.eventui.customer.tracking.club.customertrackerclub.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author raymondgarcia
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository dao;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
        User user = dao.findByUsername(username).get();
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRol());
        return buildUserForAuthentication(user, authorities);
    }
    
     private UserDetails toUserDetails(User userObject) {
        return org.springframework.security.core.userdetails.User.withUsername(userObject.getUsername())
                   .password(new BCryptPasswordEncoder().encode(userObject.getPassword()))
                   .roles(userObject.getRol().toString()).build();
    }

    private UserDetails buildUserForAuthentication(User user,
            List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), 
                new BCryptPasswordEncoder().encode(user.getPassword()),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Roles userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        setAuths.add(new SimpleGrantedAuthority("ROLE_"+userRoles.toString()));
        List<GrantedAuthority> result = new ArrayList<>(setAuths);
        return result;
    }
}
