package cn.edu.syu.service;

import cn.edu.syu.po.User;

import java.util.List;

public interface UserService {
    //根据id查询用户
    User findUserById(Integer id);
    //根据用户名查询用户
    User findUserByName(String name);
    //查询所有用户
    List<User> selectUsers();
    //添加用户
    int addUser(User user);
    //用户登录
    User loginUser(String userName,String userPwd);
    //

    User updateUser(String userName, String userPwd, String userBirthday);
}
