package com.eci.cosw.springbootsecureapi.model;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListTask {
    List<Task> listTask = new ArrayList();

    public List<Task> findAll(){
        return listTask;
    }

    public void createTask (Task task){
        listTask.add(task);
    }

    public void deletById (String id) throws Exception {
        for (int i = 0; i < listTask.size(); i++){
            if(listTask.get(i).getId().equals(id)){
                listTask.remove(i);
            }
        }
        throw new Exception("Not Found");
    }

    public Task findById(String id) throws Exception {
        for (int i = 0; i < listTask.size(); i++){
            if(listTask.get(i).getId().equals(id)){
                return listTask.get(i);
            }
        }
        throw new Exception("Not Found");
    }

}
