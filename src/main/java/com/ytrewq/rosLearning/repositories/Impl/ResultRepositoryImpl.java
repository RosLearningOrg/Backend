package com.ytrewq.rosLearning.repositories.Impl;
import com.ytrewq.rosLearning.entities.Result;
import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ResultRepositoryImpl extends BaseRepository<Result,Integer> {
    public ResultRepositoryImpl() {
        super(Result.class);
    }
}
