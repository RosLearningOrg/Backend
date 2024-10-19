package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends BaseRepo<Task> {
//    Optional<Task> findTaskByTitle(String title);
//
//    @Query("SELECT t FROM Course c JOIN c.themes th JOIN th.tasks t WHERE c.id = %:course_id% AND th.id = %:theme_id%")
//    Task[] getAllCourseTasks(@Param("course_id") int course_id, @Param("theme_id") int theme_id);
}
