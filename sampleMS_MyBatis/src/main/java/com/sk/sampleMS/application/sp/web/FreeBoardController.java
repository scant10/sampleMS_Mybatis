package com.sk.sampleMS.application.sp.web;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.sk.sampleMS.domain.sample.model.*;
import com.sk.sampleMS.domain.sample.service.*;

@RestController
public class FreeBoardController {

    @Autowired
    FreeBoardService freeBoardService;
    
       
    @RequestMapping(value = "/FreeBoard", method = RequestMethod.GET)
    public ResponseEntity<?> ListAll(ModelAndView mav, Errors errors)throws Exception {
           
         return new ResponseEntity(freeBoardService.getFreeBoardAll(), HttpStatus.OK);
    }
    
      
    @RequestMapping(value = "/FreeBoard", method = RequestMethod.POST)
    public ResponseEntity<?> register(@ModelAttribute("formModel") FreeBoard freeBoard, ModelAndView mav) {
              
            System.out.println("controller dto check::" + freeBoard.toString() );
            freeBoardService.save(freeBoard);
            return new ResponseEntity(null, HttpStatus.OK);
         
    }

}
