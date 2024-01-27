package org.example.repository;

import com.example.pojo.OperateLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OperateLogRepository extends CrudRepository<OperateLog, Integer> {
}
