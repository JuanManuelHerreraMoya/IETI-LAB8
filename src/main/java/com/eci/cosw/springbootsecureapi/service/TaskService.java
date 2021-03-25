package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    Task findTaskById( String id ) throws Exception;

    void createTask( Task task );

    void deletTaskById(String id) throws Exception;
}
