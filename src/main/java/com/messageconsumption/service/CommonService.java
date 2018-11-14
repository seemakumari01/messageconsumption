package com.messageconsumption.service;

import com.messageconsumption.rest.request.LoginUserDTO;
import com.messageconsumption.rest.response.APIResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Seema
 */
public interface CommonService {
    /**
     * @param userDTO : userDTO class object
     * @return : APIResponse class object
     * @implNote : check credential if true then return token
     */
    APIResponse<String> generateToken(LoginUserDTO userDTO, HttpServletResponse response);

    /**
     * @param loginUserDTO : user
     * @return : APIResponse class object
     * @implNote only admin register
     */
    APIResponse<String> register(LoginUserDTO loginUserDTO, HttpServletResponse response);
}
