package com.messageconsumption.util;

import com.messageconsumption.Constants;
import com.messageconsumption.exceptions.InvalidTokenException;
import com.messageconsumption.rest.security.token.Token;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author Seema
 */
public final class SecurityUtil {

    private static BasicTextEncryptor encryptor = new BasicTextEncryptor();

    static {
        encryptor.setPassword(Constants.SIGNING_KEY);
    }

    public static <T extends Token> String encodeToken(T accessToken) {

        try {
            return encryptor.encrypt(JSONUtil.toJson(accessToken));
        } catch(Exception e) {
            throw new InvalidTokenException(e.getMessage(), e);
        }
    }

    public static <T extends Token> T decodeToken(String token, Class<T> clazz) {
        try {
            return JSONUtil.loadJson(encryptor.decrypt(token), clazz);
        } catch(Exception e) {
            throw new InvalidTokenException(e.getMessage(), e);
        }
    }

}