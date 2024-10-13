package com.ytrewq.rosLearning.repositories.Impl;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import com.ytrewq.rosLearning.repositories.CourseRepository;
import com.ytrewq.rosLearning.repositories.TaskRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class TaskRepositoryImpl extends BaseRepository<Task, Integer> implements TaskRepository {
    @Autowired
    EntityManager entityManager;

    public TaskRepositoryImpl() {
        super(Task.class);
    }

    @Override
    public Set<Task> getAllCourseTasks(int course_id) {
        String jpql = "SELECT t FROM Course c JOIN c.themes th JOIN th.tasks t WHERE c.id = :course_id";
        return new HashSet<>(entityManager.createQuery(jpql, Task.class)
                .setParameter("course_id", course_id)
                .getResultList());
    }
}
