package com.messageconsumption.rest.security.token;


import com.google.common.collect.Lists;
import com.messageconsumption.Constants;
import com.messageconsumption.exceptions.BaseException;
import com.messageconsumption.rest.security.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Seema
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LogManager.getLogger(JwtAuthenticationFilter.class);

    @Qualifier("userService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    /**
     * @param req   : HttpServletRequest
     * @param res   : HttpServletResponse
     * @param chain : FilterChain
     * @throws IOException      : IOException
     * @throws ServletException : ServletException
     * @implNote : This method is use to filter each request after that check header in token is valid
     */
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String header = req.getHeader(Constants.AUTHORIZATION_HEADER);

        if(header != null && header.startsWith(Constants.TOKEN_PREFIX)) {
            String username = null;
            String authToken = header.replace(Constants.TOKEN_PREFIX, "");
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            } catch(IllegalArgumentException e) {
                LOGGER.error("an error occurred during getting username from token", e);
            } catch(ExpiredJwtException e) {
                LOGGER.warn("the token is expired and not valid anymore", e);
            } catch(SignatureException e) {
                LOGGER.error("Authentication Failed. Username or Password not valid.", e);
            }
            checkApiWithToken(username, authToken, req, res);
        }
        chain.doFilter(req, res);
    }

    /**
     * @param username  : UserName
     * @param authToken : Authentication Token
     * @param req       : Request
     * @param res       : Response
     * @throws IOException : Input Output Exception
     * @implNote : Check API with Token
     */
    private void checkApiWithToken(String username, String authToken, HttpServletRequest req, HttpServletResponse res) throws IOException {

        if((username != null) && (SecurityContextHolder.getContext().getAuthentication() == null)) {

            SecuredAccessToken securedAccessToken = jwtTokenUtil.getDecodedToken(authToken);

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if(jwtTokenUtil.validateToken(authToken, userDetails)) {

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, Lists.newArrayList(new SimpleGrantedAuthority("ROLE_ADMIN")));
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));

                LOGGER.info("authenticated user '{}' setting security context", username);

                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }

    }

}