package com.analiseCredito.listener;

import com.analiseCredito.domain.Proposta;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class AnalisarPropostaListener {


    @RabbitListener(queues = "${rabbitmq.queue.analisar.proposta}")
    public void analizarProposta(Proposta proposta) throws MessageConversionException, UnsupportedEncodingException {
        System.out.println("RECEBI A PROPOSTA");
        System.out.println("***********");
        System.out.println(proposta);
    }

}
