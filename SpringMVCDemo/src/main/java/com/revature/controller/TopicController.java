package com.revature.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.revature.model.Topic;
@Controller
@RequestMapping(value="/topic")
public class TopicController {
    
    private List<Topic> topicList = new ArrayList<Topic>();
    
    @ResponseBody // tells Spring to skip ViewResolver
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public ResponseEntity<List<Topic>> getAll() {
        this.topicList.add(new Topic("Biology"));
        return new ResponseEntity<>(this.topicList, HttpStatus.OK);
    }
}