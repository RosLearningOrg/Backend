package com.ytrewq.rosLearning.service.mongo;

import com.ytrewq.rosLearning.entity.mongo.Task;
import com.ytrewq.rosLearning.repository.mongo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}

