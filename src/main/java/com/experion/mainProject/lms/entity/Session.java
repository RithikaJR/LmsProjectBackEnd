package com.experion.mainProject.lms.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="session")
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private  Long sessionId;

    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "trainer_name")
    private String trainerName;

    @Column(name = "session_description")
    private String sessionDescription;

    @Column(name = "session_start_time")
    private String sessionStartTime;

    @Column(name = "session_end_time")
    private String sessionEndTime;

    @Column(name = "session_date")
    private Date sessionDate;

    @Column(name = "session_cost")
    private BigDecimal sessionCost;




}
