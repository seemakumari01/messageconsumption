package com.messageconsumption.rest.controller;

import com.messageconsumption.Constants;
import com.messageconsumption.rest.request.LoginUserDTO;
import com.messageconsumption.rest.response.APIResponse;
import com.messageconsumption.service.CommonService;
import io.swagger.annotations.ApiOperation;
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
public class UserController {
    private CommonService commonService;

    public UserController(CommonService commonService) {
        this.commonService = commonService;
    }

    /**
     * @param loginUserDTO : LoginUserDTO class object
     */
    @PostMapping(value = "/register")
    @ApiOperation(value = "User Registration")
    public APIResponse<String> register(@Valid @RequestBody LoginUserDTO loginUserDTO, HttpServletResponse response) {
        return commonService.register(loginUserDTO, response);
    }
}
