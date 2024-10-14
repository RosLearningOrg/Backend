package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    Optional<Task> findTaskByTitle(String title);

    @Query("SELECT t FROM Course c JOIN c.themes th JOIN th.tasks t WHERE c.id = %:course_id% AND th.id = %:theme_id%")
    Task[] getAllCourseTasks(@Param("course_id") int course_id, @Param("theme_id") int theme_id);


}
