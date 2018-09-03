package io.daocloud.java.nevforwardrepository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_forward_local_record")
public class ForwardLocalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "package_time", columnDefinition = "DATETIME")
    private LocalDateTime packageTime;

    @Column(name = "send_time", columnDefinition = "DATETIME")
    private LocalDateTime sendTime;

    @Column(name = "vin")
    private String vin;

    @Column(name = "raw")
    private String raw;

    @Column(name = "error")
    private String error;

    @Column(name = "is_answer")
    private Boolean isAnswer;

    @Column(name = "platform_vin")
    private String platformVin;

    @Override
    public String toString() {
        return "ForwardLocalRecord{" +
                "id=" + id +
                ", packageTime=" + packageTime +
                ", sendTime=" + sendTime +
                ", vin='" + vin + '\'' +
                ", raw='" + raw + '\'' +
                ", error='" + error + '\'' +
                ", isAnswer=" + isAnswer +
                ", platformVin='" + platformVin + '\'' +
                '}';
    }
}
