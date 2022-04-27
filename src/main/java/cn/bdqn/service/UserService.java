package cn.bdqn.service;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    PageBean<User> findUserByName(String queryname, Integer currPageNo, Integer pageSize);

    void add(User user);

    void delete(Integer id);

    User findUserById(Integer id);

    void update(User user);
}
