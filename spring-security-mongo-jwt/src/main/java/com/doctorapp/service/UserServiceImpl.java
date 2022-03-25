package com.doctorapp.service;

import com.doctorapp.model.AppUser;
import com.doctorapp.model.Roles;
import com.doctorapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

// The interface is an inbuilt one with a single method
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // get the user from the repository
        AppUser appUser = userRepository.findByUsername(username);
        // if user is not available throw usernotfoundexception
        if(appUser==null)
            throw new UsernameNotFoundException("Username not found");

        // create a list authorities object to provide roles for the user
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(Roles.USER.getRoleName()));
        authorities.add(new SimpleGrantedAuthority(Roles.ADMIN.getRoleName()));

        // Else create the (inbuilt) user object using the appuser;
        // UserDetails iis the interface and the user the class that implements it
        // so write as UserDetails user = new User
//        User user = new User(appUser.getUsername(),appUser.getPassword(),authorities);
        UserDetails user = new User(appUser.getUsername(),appUser.getPassword(),authorities);
        System.out.println("appUser = " + appUser);
        System.out.println("user = " + user);
        return user;
    }
    public void addUser(AppUser user){
       // save it to db using repository
        userRepository.save(user);

    }
}
