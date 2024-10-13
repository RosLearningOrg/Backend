package com.ytrewq.rosLearning.Repositories.Impl;

import com.ytrewq.rosLearning.Entities.Result;
import com.ytrewq.rosLearning.Repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ResultRepositoryImpl extends BaseRepository<Result, Integer> {
    public ResultRepositoryImpl() {
        super(Result.class);
    }
}
