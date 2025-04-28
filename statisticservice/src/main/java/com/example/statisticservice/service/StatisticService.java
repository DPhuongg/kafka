package com.example.statisticservice.service;


import com.example.statisticservice.entity.Statistic;
import com.example.statisticservice.repository.StatisticRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StatisticRepo statisticRepo;

    @RetryableTopic(attempts = "5", dltTopicSuffix = ".DLT", backoff = @Backoff(delay = 2000, multiplier = 2))
    @KafkaListener(id = "statisticGroup", topics = "statistic")
    public void listen(Statistic statistic) {
        logger.info("Received" + statistic.getMessage());
        throw new RuntimeException();
//        statisticRepo.save(statistic);
    }

    @KafkaListener(id = "dltGroup", topics = "statistic.DLT")
    public void listenDLT(Statistic statistic) {
        logger.info("Received statistic.DTL " + statistic.getMessage());
    }
}
