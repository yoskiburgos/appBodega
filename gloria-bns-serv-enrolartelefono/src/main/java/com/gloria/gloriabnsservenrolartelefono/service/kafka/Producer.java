package com.gloria.gloriabnsservenrolartelefono.service.kafka;

import com.gloria.gloriabnsservenrolartelefono.constant.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Producer {
    
    @Autowired
    private KafkaTemplate <String, String> kafkaTemplate;

    public void publicarMensaje(String mensaje){
        log.info("[KAFKA] - PRODUCER: [publicar-mensaje]");
        log.info(mensaje);
        this.kafkaTemplate.send(Constantes.KAFKA_TOPIC, mensaje);
    }
}
