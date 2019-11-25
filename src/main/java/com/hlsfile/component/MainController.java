package com.hlsfile.component;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**   
 * @ClassName:  MainController   
 * @Description:TODO(页面跳转控制类)   
 * @author: hucheng 
 * @date:   2019年10月31日 下午4:16:34       
 * @Copyright: 2019 www.xxxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于xxxxxxxxx传阅，禁止外泄以及用于其他的商业目
*/  
@Controller
public class MainController {
    
	/**   
	 * @Title: goLoginHtml   
	 * @Description: TODO(跳转登录页)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@GetMapping(value = "/")
	public String goLoginHtml() {return "login";}
	
	/**   
	 * @Title: goIndexHtml   
	 * @Description: TODO(跳转首页)   
	 * @param: @param username
	 * @param: @param password
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@RequestMapping(value = "/index")
	public String goIndexHtml(@RequestParam("username")String username,@RequestParam("password")String password ) {
		if (username.equals("root")&password.equals("123")) {
			return "index";
		}
		return "redirect:/";
	}
	
	/**   
	 * @Title: goWelcomeHtml   
	 * @Description: TODO(跳转欢迎页)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@GetMapping(value = "/welcome")
	public String goWelcomeHtml() {return "welcome";}
	
	/**   
	 * @Title: goMemberList   
	 * @Description: TODO(跳转会员列表页)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@GetMapping(value = "/member_list")
	public String goMemberList() {return "member/member-list";}
	
	
	/**   
	 * @Title: goLogout   
	 * @Description: TODO(退出跳回登录页)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@GetMapping(value = "/logout")
	public String goLogout() {return "login";}
	
	
	
}
