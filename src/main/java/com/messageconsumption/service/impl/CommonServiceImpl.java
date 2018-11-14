package com.messageconsumption.service.impl;

import com.messageconsumption.db.model.User;
import com.messageconsumption.rest.request.LoginUserDTO;
import com.messageconsumption.rest.response.APIResponse;
import com.messageconsumption.rest.security.JwtTokenUtil;
import com.messageconsumption.rest.security.token.AuthenticationToken;
import com.messageconsumption.service.CommonService;
import com.messageconsumption.service.UserService;
import com.messageconsumption.util.Permission;
import com.messageconsumption.util.Roles;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * @author Seema
 */
@Service
public class CommonServiceImpl implements CommonService {
    private static final Logger LOGGER = LogManager.getLogger(CommonServiceImpl.class);

    private JwtTokenUtil jwtTokenUtil;
    private BCryptPasswordEncoder encoder;
    private UserService userService;

    @Autowired
    public CommonServiceImpl(JwtTokenUtil jwtTokenUtil, BCryptPasswordEncoder encoder,
                             UserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.encoder = encoder;
        this.userService = userService;
    }

    @Override
    public APIResponse<String> generateToken(LoginUserDTO userDTO, HttpServletResponse response) {
        AuthenticationToken authToken;
        APIResponse<String> apiResponse = new APIResponse<>();
        String token = "";

        try {
            token = jwtTokenUtil.generateToken(userDTO);

        } catch(Exception e) {
            LOGGER.error("Username and password check time exception occur {}", e);
        }
        if(StringUtils.isNotBlank(token)) {
            apiResponse.setCode(HttpStatus.OK.value());
            apiResponse.setDesc(HttpStatus.OK.getReasonPhrase());
            response.setStatus(HttpStatus.OK.value());
            authToken = new AuthenticationToken();
            authToken.setToken(token);
            token = authToken.getToken();
            apiResponse.setPayload(token);

        } else {
            apiResponse.setCode(HttpStatus.UNAUTHORIZED.value());
            apiResponse.setDesc(HttpStatus.UNAUTHORIZED.getReasonPhrase());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            apiResponse.setPayload("Username and Password is invalid");
        }
        return apiResponse;
    }


    @Override
    public APIResponse<String> register(LoginUserDTO loginUserDTO, HttpServletResponse response) {
        APIResponse<String> apiResponse = new APIResponse<>();
        try {
            User user = new User();

            user.setFirstName(loginUserDTO.getFirstName());
            user.setLastName(loginUserDTO.getLastName());
            user.setEmail(loginUserDTO.getEmail());
            user.setPassword(encoder.encode(loginUserDTO.getPassword()));
            List<String> permissionList = Stream.of(Permission.values()).map(Enum::name).collect(Collectors.toList());
            user.setPermission(permissionList);
            user.setRole(String.valueOf(Roles.ADMINISTRATOR));
            if(!userService.isPresent("email", user.getEmail())) {
                userService.save(user);
                apiResponse.setCode(HttpStatus.OK.value());
                apiResponse.setDesc(HttpStatus.OK.getReasonPhrase());
                response.setStatus(HttpStatus.OK.value());
                apiResponse.setPayload("Account created Successfully......");

            } else {
                apiResponse.setCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setDesc(HttpStatus.BAD_REQUEST.getReasonPhrase());
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                apiResponse.setPayload("Account is already exist......");
            }
        } catch(Exception e) {
            LOGGER.error("Error when user register time {}", e.getMessage());
        }
        return apiResponse;
    }
}
