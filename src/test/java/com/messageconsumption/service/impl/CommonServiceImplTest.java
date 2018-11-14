package com.messageconsumption.service.impl;

import com.messageconsumption.rest.request.LoginUserDTO;
import com.messageconsumption.rest.security.JwtTokenUtil;
import com.messageconsumption.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class CommonServiceImplTest {

    private CommonServiceImpl commonService;
    private JwtTokenUtil jwtTokenUtil;
    private UserService userService;
    private BCryptPasswordEncoder encoder;


    @Before
    public void setUp() throws Exception {
        jwtTokenUtil = mock(JwtTokenUtil.class);
        userService = mock(UserService.class);
        encoder = mock(BCryptPasswordEncoder.class);
        commonService = spy(new CommonServiceImpl(jwtTokenUtil, encoder, userService));


    }

    @Test
    public void generateToken() throws Exception {
        LoginUserDTO loginUserDTO = mock(LoginUserDTO.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        commonService.generateToken(loginUserDTO, httpServletResponse);
        verify(commonService).generateToken(loginUserDTO, httpServletResponse);
    }

    @Test
    public void register() throws Exception {

    }


}