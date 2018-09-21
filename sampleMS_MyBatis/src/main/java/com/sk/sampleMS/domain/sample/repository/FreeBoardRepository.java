package com.sk.sampleMS.domain.sample.repository;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.sk.sampleMS.domain.sample.model.*;



@Repository
public class FreeBoardRepository {
    private static final String MAPPER_NAME_SPACE="sample.mapper.freeBoard.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<FreeBoard> selectFreeBoardAll(){
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectFreeBoardAll");
    }
    
    public void registBoard(FreeBoard freeBoard){
        sqlSessionTemplate.insert(MAPPER_NAME_SPACE+ "insertBoard", freeBoard);
    }
}
