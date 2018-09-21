package com.sk.sampleMS.domain.sample.repository;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.sk.sampleMS.domain.sample.model.*;


@Repository
public class UserRepository {
    private static final String MAPPER_NAME_SPACE="sample.mapper.userMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<User> getUserInfoAll(){
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectUserInfoAll");
    }

    public void adduserInfo(User user){
        sqlSessionTemplate.insert(MAPPER_NAME_SPACE+ "addUserInfo", user);
    }

    public List<User> findByUserNameLike(String userName){
        Map<String,Object> params = new HashMap();
        params.put("userName", userName);

        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "findByUserNameLike", params);
    }

    public User findByUserName(String userName){
        Map<String,Object> params = new HashMap();
        params.put("userName", userName);

        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "findByUserName", params);
    }

    public List<User> findByForeach(Map<String, Object> paramMap){
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "foreachUserList", paramMap);
    }


}
