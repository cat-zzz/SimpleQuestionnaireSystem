package cn.edu.syu.controller;

import cn.edu.syu.po.User;
import cn.edu.syu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 根据id查询用户详情
	 */
	@RequestMapping("/findUserById")
	public String findUserById(Integer id,Model model) {
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "user";
	}
	@RequestMapping("/addUser.action")
	public String addUserJump(User user){
		return "/addUser.jsp";
	}
	/**
	 * 注册用户
	 */
	@RequestMapping("/addUser")
	public String addUser(User user,Model model,HttpSession session){
		String tips="注册失败，已存在该用户名！";
		//调用service处理User
		int nums=userService.addUser(user);
		if (nums>0){		//注册成功
			user=userService.findUserByName(user.getUserName());
			tips="用户："+user.getUserName()+" 注册成功";
			model.addAttribute("user",user);
			session.setAttribute("USER",user);
			return "main";
		}else{
			model.addAttribute("tips",tips);
			return "forward:addUser.jsp";
		}
	}
	@RequestMapping("addUserJump")
	public String addUserJump(){
		return "/addUser.jsp";
	}
	/**
	 * 用户登录
	 */
	@RequestMapping("/login")
	public String loginUser(User user, HttpSession session, HttpServletRequest request,Model model){
		ModelAndView mv=new ModelAndView();
		User user1=userService.loginUser(user.getUserName(),user.getUserPwd());
		String loginDefeatTips="";
		String checkCode=request.getParameter("check_code");
		String savedCode= (String) request.getSession().getAttribute("check_code");
		if (user1==null){	//未查到用户
			loginDefeatTips="用户名或密码错误";
			model.addAttribute("loginDefeatTips",loginDefeatTips);
			return "forward:login.jsp";
		} else if (!checkCode.equals(savedCode)){	//验证码错误
			loginDefeatTips="验证码错误";
			model.addAttribute("loginDefeatTips",loginDefeatTips);
			return "forward:login.jsp";
		} else{	//登录成功
			session.setAttribute("USER",user1);
			return "main";
		}
	}
	/**
	 * 跳转修改个人信息页面
	 */
	@RequestMapping("/updateUserJump")
	public String updateUserJump(User user){
		return "updateUser";
	}

	/**
	 *
	 */
	@RequestMapping("/questionnaire/updateUserJump")
	public String updateUserJumpFromQuest(User user){
		return "updateUser";
	}
	/**
	 * 修改个人信息
	 */
	@RequestMapping("/updateUser")
	public String updateUser(String userPwd,String userBirthday,HttpSession session,Model model){
		//TODO
		User user= (User) session.getAttribute("USER");
		System.out.println(user);
		user.setUserPwd(userPwd);
		user.setUserBirthday(userBirthday);
		userService.updateUser(user.getUserName(),user.getUserPwd(),user.getUserBirthday());
		model.addAttribute("user",user);
		return "main";
	}
}
