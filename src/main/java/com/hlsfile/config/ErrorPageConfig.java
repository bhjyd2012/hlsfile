package com.hlsfile.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**   
 * @ClassName:  ErrorPageConfig   
 * @Description:TODO(ErrorPageRegistrar配置错误页)   
 * @author: hucheng 
 * @date:   2019年8月9日 下午3:33:19       
 * @Copyright: 2019 www.xxxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于xxxxxxxxx传阅，禁止外泄以及用于其他的商业目
*/  
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar{

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/400");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401");
        ErrorPage error403Page =  new ErrorPage(HttpStatus.FORBIDDEN,"/403");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
        registry.addErrorPages(error400Page,error401Page,error403Page,error404Page,error500Page);
	}
		
}
