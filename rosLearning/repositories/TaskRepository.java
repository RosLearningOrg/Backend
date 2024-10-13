package com.ytrewq.rosLearning.repositories;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Task;
import java.util.Set;

public interface TaskRepository {

    Set<Task> getAllCourseTasks(int id);

}
