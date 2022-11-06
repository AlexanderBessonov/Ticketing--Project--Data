package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> listAllTasks() ;

    void save (TaskDTO dto);

   void update(TaskDTO dto);

    void delete (Long id);

   TaskDTO findById(Long id);
   int totalNonCompletedTasks(String projectCode);
    int totalCompletedTasks (String projectCode);
}
