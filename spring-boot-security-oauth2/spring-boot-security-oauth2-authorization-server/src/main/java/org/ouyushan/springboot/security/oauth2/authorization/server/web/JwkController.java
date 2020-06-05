package org.ouyushan.springboot.security.oauth2.authorization.server.web;

import com.nimbusds.jose.jwk.JWKSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/11 18:09
 */
@RestController
public class JwkController {

    @Autowired
    private JWKSet jwkSet;

    @GetMapping(value = "/oauth2/keys", produces = "application/json; charset=UTF-8")
    public String keys() {
        return this.jwkSet.toString();
    }
}
