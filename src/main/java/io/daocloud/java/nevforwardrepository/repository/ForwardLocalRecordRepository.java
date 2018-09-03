package io.daocloud.java.nevforwardrepository.repository;
import io.daocloud.java.nevforwardrepository.entity.ForwardLocalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ForwardLocalRecordRepository extends JpaRepository<ForwardLocalRecord, Long> {
    List<ForwardLocalRecord> findAllBySendTimeBetweenAndVinAndPlatformVin(
            LocalDateTime from, LocalDateTime to, String vin, String platformVin);
}
