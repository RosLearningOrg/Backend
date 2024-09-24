package com.ytrewq.rosLearning.repository.mongo;

import com.ytrewq.rosLearning.entity.mongo.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
