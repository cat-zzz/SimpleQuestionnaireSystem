package cn.edu.syu.dao;

import cn.edu.syu.po.User;

import java.util.List;

public interface UserDao {
    //添加用户
    int addUser(User user);
    //根据id查找用户
    User findUserById(Integer id);
    User findUserByName(String userName);
    //查询所有用户
    List<User> selectUsers();
    //更新用户信息
    int updateUser(User user);
}
