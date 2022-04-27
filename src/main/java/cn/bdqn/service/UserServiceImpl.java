package cn.bdqn.service;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public PageBean<User> findUserByName(String queryname, Integer currPageNo, Integer pageSize) {
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setTotalCount(userMapper.getTotalCount());
        pageBean.setPageSize(pageSize);
        pageBean.setCurrPageNo(currPageNo);
        pageBean.setTotalPageCount(pageBean.getTotalCount()%pageSize==0?pageBean.getTotalCount()/pageSize:pageBean.getTotalCount()/pageSize+1);
        pageBean.setLists(userMapper.findUserByName(queryname,currPageNo,pageSize));


        System.out.println("这是Service输出总条数测试:"+pageBean.getTotalCount());
        System.out.println("这是Service输出页大小测试:"+pageBean.getPageSize());
        System.out.println("这是Service输出当前页测试:"+pageBean.getCurrPageNo());
        System.out.println("这是Service输出总页数测试:"+pageBean.getTotalPageCount());
        System.out.println("下面是Service输出用户List测试!!!!!!!");
        for (User user:pageBean.getLists()) {

            System.out.println(user.getUsername());
        }
        return pageBean;
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


}
