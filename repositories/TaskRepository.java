package com.ytrewq.rosLearning.repositories;

import com.ytrewq.rosLearning.Entities.Task;
import java.util.Set;

public interface TaskRepository {

    Set<Task> getAllCourseTasks(int course_id,int theme_id);

}
