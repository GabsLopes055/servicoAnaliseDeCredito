package com.analiseCredito.listener;

import com.analiseCredito.domain.Proposta;
import com.analiseCredito.service.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.stereotype.Component;
import java.io.UnsupportedEncodingException;

@Component
public class AnalisarPropostaListener {

    private final AnaliseCreditoService analiseCreditoService;

    AnalisarPropostaListener(AnaliseCreditoService analiseCreditoService) {
        this.analiseCreditoService = analiseCreditoService;
    }


    @RabbitListener(queues = "${rabbitmq.queue.analisar.proposta}")
    public void analizarProposta(Proposta proposta){

        System.out.println(proposta);

        analiseCreditoService.analisar(proposta);
    }
}
