package com.bi.account.hexagonal.infrastructure.adapters.security;

import com.bi.account.hexagonal.infrastructure.adapters.service.IuserService;
import com.bi.account.hexagonal.infrastructure.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
public class InfoAdditionalToken implements TokenEnhancer {


    private final IuserService iuserService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication){
        Map<String,Object> info = new HashMap<String,Object>();
        UserEntity userEntity = iuserService.loadByUsername(authentication.getName());
        info.put("name", userEntity.getName());
        info.put("lastName", userEntity.getLastName());
        info.put("email", userEntity.getEmail());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
