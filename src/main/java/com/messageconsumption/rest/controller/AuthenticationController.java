package com.messageconsumption.rest.controller;

import com.messageconsumption.Constants;
import com.messageconsumption.rest.request.LoginUserDTO;
import com.messageconsumption.rest.response.APIResponse;
import com.messageconsumption.service.CommonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Seema
 */
@RestController
@RequestMapping(Constants.BASE_PUBLIC_API_URL)
public class AuthenticationController {

    private final CommonService commonService;

    @Autowired
    public AuthenticationController(CommonService commonService) {
        this.commonService = commonService;
    }

    /**
     * @param loginUser : loginUser
     * @return : token
     * @apiNote :validate username and password after that return token
     */
    @PostMapping("/generate-token")
    @ApiOperation(value = "Generate Token")
    public APIResponse<String> register(@Valid @RequestBody LoginUserDTO loginUser, HttpServletResponse response) {
        return commonService.generateToken(loginUser, response);

    }


}
