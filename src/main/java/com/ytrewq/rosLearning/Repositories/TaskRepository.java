package com.ytrewq.rosLearning.Repositories;


import com.ytrewq.rosLearning.Entities.Task;

import java.util.Set;

public interface TaskRepository {

    Set<Task> getAllCourseTasks(int id);

}
