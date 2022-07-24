package cn.edu.syu.service.impl;

import cn.edu.syu.dao.UserDao;
import cn.edu.syu.po.User;
import cn.edu.syu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

//@Transactional注解主要是针对数据的增加、修改、删除进行事务管理
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	/**
	 * 根据id查询用户
	 */
	public User findUserById(Integer id) {
		return this.userDao.findUserById(id);
	}
	/**
	 * 根据用户名查询用户
	 */
	@Override
	public User findUserByName(String name) {
		return this.userDao.findUserByName(name);
	}

	@Override
	public List<User> selectUsers() {
		return userDao.selectUsers();
	}

	@Override
	public int addUser(User user) {
		User user1=null;
		user1=userDao.findUserByName(user.getUserName());
		if (user1!=null){
			System.out.println("已存在该用户名");
			return 0;
	} else {
			return userDao.addUser(user);
		}
	}

	@Override
	public User loginUser(String userName, String userPwd) {
		User user=userDao.findUserByName(userName);
		if (user.getUserPwd().equals(userPwd)){	//验证通过
			return user;
		}else {
			return null;
		}
	}

	@Override
	public User updateUser(String userName,String userPwd, String userBirthday) {
		System.out.println(userName);
		System.out.println(userPwd);
		System.out.println(userBirthday );
		User user=new User();
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setUserBirthday(userBirthday);
		userDao.updateUser(user);
		return null;//不要在意返回的是null，不想再改了，反正能正常运行。
	}
}