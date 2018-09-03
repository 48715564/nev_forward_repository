package io.daocloud.java.nevforwardrepository.service;

import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import io.daocloud.java.nevforwardrepository.entity.ForwardLocalRecord;
import io.daocloud.java.nevforwardrepository.repository.ForwardLocalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class ForwardLocalRecordService {
    @Autowired
    ForwardLocalRecordRepository forwardLocalRecordRepository;
    @Autowired
    KeyGenerator keyGenerator;
    @Transactional
    public void batchSave(List<ForwardLocalRecord> forwardLocalRecords){
        for(ForwardLocalRecord forwardLocalRecord:forwardLocalRecords){
            forwardLocalRecord.setId(keyGenerator.generateKey().longValue());
            forwardLocalRecordRepository.save(forwardLocalRecord);
        }
    }
}
