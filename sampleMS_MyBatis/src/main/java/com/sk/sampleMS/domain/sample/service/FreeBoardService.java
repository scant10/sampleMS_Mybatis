package com.sk.sampleMS.domain.sample.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.sk.sampleMS.domain.sample.model.*;
import com.sk.sampleMS.domain.sample.repository.*;

@Service
public class FreeBoardService {

        
    @Autowired
    private FreeBoardRepository freeBoardRepository;

    public List<FreeBoard> getFreeBoardAll(){
        return freeBoardRepository.selectFreeBoardAll();
    }
    
    public void save(FreeBoard freeboard){
        freeBoardRepository.registBoard(freeboard);
    }
}
