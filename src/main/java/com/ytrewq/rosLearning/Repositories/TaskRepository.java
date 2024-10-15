package com.ytrewq.rosLearning.Repositories;


import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    Set<Task> getAllCourseTasks(int id);
    <S extends Task> S save (S entity);

}
