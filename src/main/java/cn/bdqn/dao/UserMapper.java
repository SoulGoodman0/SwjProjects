package cn.bdqn.dao;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where username like CONCAT('%',#{queryname},'%') limit #{currPageNo},#{pageSize}")
    List<User> findUserByName(@Param(value = "queryname") String queryname,@Param(value = "currPageNo") Integer currPageNo,@Param(value = "pageSize") Integer pageSize);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void add(User user);

    @Delete("delete from user where id=#{id}")
    void delete(Integer id);

    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void update(User user);

    @Select("select count(1) from user")
    int getTotalCount();
}
