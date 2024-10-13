package com.ytrewq.rosLearning.repositories.Impl;
import com.ytrewq.rosLearning.Entities.Result;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import org.springframework.stereotype.Repository;
@Repository
public class ResultRepositoryImpl extends BaseRepository<Result,Integer> {
    public ResultRepositoryImpl() {
        super(Result.class);
    }
}
