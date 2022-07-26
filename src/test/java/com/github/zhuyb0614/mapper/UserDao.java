package com.github.zhuyb0614.mapper;

import com.github.zhuyb0614.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    @Select("select * from user where id= #{id}")
    User findById(Integer id);

}