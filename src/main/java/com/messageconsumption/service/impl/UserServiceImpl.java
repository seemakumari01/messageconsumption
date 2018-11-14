package com.messageconsumption.service.impl;


import com.google.common.collect.Lists;
import com.messageconsumption.Constants;
import com.messageconsumption.db.model.User;
import com.messageconsumption.db.repositories.UserRepository;
import com.messageconsumption.db.repositories.impl.BaseRepository;
import com.messageconsumption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * UserServiceImpl class
 *
 * @link AuthenticationController
 * @author Seema
 */
@Service(value = Constants.USER_SERVICE)
public class UserServiceImpl extends BaseRepository<User> implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * @param email : email
     * @return User class object
     * @implNote This method custom override Spring Security  UserDetailsService class
     */
    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("Invalid Email or Password");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority());
    }

    /**
     * @return ArrayList
     */
    private List<SimpleGrantedAuthority> getAuthority() {
        return Lists.newArrayList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
