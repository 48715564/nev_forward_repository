package io.daocloud.java.nevforwardrepository;

import com.google.common.collect.Queues;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author bo.zhou
 */
@EntityScan(basePackageClasses = {NevForWardRepositoryApplication.class, Jsr310JpaConverters.class})
@SpringBootApplication
@Slf4j
@EnableScheduling
public class NevForWardRepositoryApplication{

    public static void main(String[] args) {
        SpringApplication.run(NevForWardRepositoryApplication.class, args);
    }

    @Scheduled(initialDelay = 3000, fixedDelay = 1000)
    @SneakyThrows
    public void createTable() {
        //判断表是否存在
        log.info("create_table:{}", "");
    }
}
