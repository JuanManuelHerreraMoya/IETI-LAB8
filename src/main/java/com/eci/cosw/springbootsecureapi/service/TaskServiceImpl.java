package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.ListTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    ListTask listaTask;

    public TaskServiceImpl(){

    }


    @Override
    public List<Task> getTasks() {
        return listaTask.findAll();
    }

    @Override
    public Task findTaskById(String id) throws Exception {
        Task temp = null ;
        return listaTask.findById(id);
    }


    @Override
    public void createTask(Task task) {
        listaTask.createTask(task);
    }

    @Override
    public void deletTaskById(String id) throws Exception {
        listaTask.deletById(id);
    }


}