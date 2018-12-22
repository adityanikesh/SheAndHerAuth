package com.cvs.avocado.security;

import java.security.KeyPair;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter{

//	@Override
//	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//		accessToken.
//		return null;
//	}
	
	@Override
	public void setKeyPair(KeyPair keyPair) {
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                new ClassPathResource("tomcat-keystore.p12"), "changeit".toCharArray());
		this.setKeyPair(keyStoreKeyFactory.getKeyPair("tomcat"));
	}

}
