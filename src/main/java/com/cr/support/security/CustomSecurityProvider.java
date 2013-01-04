package com.cr.support.security;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description 自定义安全Provider
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public class CustomSecurityProvider implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		Security.addProvider(new BouncyCastleProvider());

	}

}
