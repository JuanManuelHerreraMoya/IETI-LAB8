package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.service.TaskService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping( "/api" )
public class TaskController {

    @Autowired
    TaskService ts;

    @RequestMapping(path = "/newTask", method = RequestMethod.POST)
    public ResponseEntity<?> nreTask(@RequestBody Task task){
        try {
            ts.createTask(task);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, null);
        }
    }


    @RequestMapping(path = "/delet/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?>  delteTask(@PathVariable(name = "id") String id) {
        try {
            ts.deletTaskById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/tasks", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTasks(){
        try{
            return new ResponseEntity<>(ts.getTasks(),HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

