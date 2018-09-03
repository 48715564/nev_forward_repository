package io.daocloud.java.nevforwardrepository.config;

import com.sun.javafx.binding.StringFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    }

    private static final String CREATE_TABLE_SQL = "CREATE TABLE `t_forward_local_record_%s` (\n" +
            "  `id` bigint(20) NOT NULL,\n" +
            "  `error` varchar(1000) DEFAULT NULL,\n" +
            "  `vin` varchar(20) DEFAULT NULL,\n" +
            "  `is_answer` bit(1) DEFAULT NULL,\n" +
            "  `package_time` datetime DEFAULT NULL,\n" +
            "  `raw` varchar(2500) DEFAULT NULL,\n" +
            "  `send_time` datetime DEFAULT NULL,\n" +
            "  `platform_vin` varchar(255) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  KEY `t_forward_local_record_vin_index` (`vin`),\n" +
            "  KEY `t_forward_local_record_is_answer_index` (`is_answer`),\n" +
            "  KEY `t_forward_local_record_package_time_index` (`package_time`),\n" +
            "  KEY `t_forward_local_record_send_time_index` (`send_time`)\n" +
            ") ";
    public static void main(String[] args) {
        System.out.println(String.format(CREATE_TABLE_SQL,"2019"));
    }
}