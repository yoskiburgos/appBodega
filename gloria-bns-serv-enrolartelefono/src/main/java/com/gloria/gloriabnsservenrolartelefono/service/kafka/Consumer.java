package com.gloria.gloriabnsservenrolartelefono.service.kafka;

import com.gloria.gloriabnsservenrolartelefono.constant.Constantes;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Consumer {
    
    @KafkaListener(topics = Constantes.KAFKA_TOPIC, groupId = Constantes.KAFKA_CONSUMER_GROUP_ID)
    public void consumirMesanje(String mensaje){
        log.info("[KAFKA] - CONSUMER: [consumir-mensaje]");
        log.info(mensaje);
    }
}
