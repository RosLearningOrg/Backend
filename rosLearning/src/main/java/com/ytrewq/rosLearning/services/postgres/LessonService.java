package com.ytrewq.rosLearning.services.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    private com.ytrewq.rosLearning.repositories.postgres.LessonRepository lessonRepository;
}
