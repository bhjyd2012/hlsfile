package com.hlsfile.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @ClassName:  ErrorPageController   
 * @Description:TODO(错误页提示)   
 * @author: hucheng 
 * @date:   2019年8月9日 下午3:32:37       
 * @Copyright: 2019 www.xxxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于xxxxxxxxx传阅，禁止外泄以及用于其他的商业目
*/  
@Controller
public class ErrorPageController {
		@RequestMapping("401")
		public String get401page() {
			return "errorpage/401";
		}
	  @RequestMapping("403")
		public String get403page() {
			return "errorpage/403";
		}
	  @RequestMapping("404")
		public String get404page() {
			return "errorpage/404";
		}
	  @RequestMapping("500")
		public String get500page() {
			return "errorpage/500";
		}
}
