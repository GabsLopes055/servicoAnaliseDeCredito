package com.analiseCredito.service;

import com.analiseCredito.domain.Proposta;
import com.analiseCredito.exceptions.StrategyException;
import com.analiseCredito.service.strategy.CalculoPonto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    @Autowired
    private NotificacaoRabbit notificacaoRabbit;

    @Autowired
    private List<CalculoPonto> calculoPontoList;

    @Value("${rabbitmq.propostaConcluida.exchange}")
    private String exchangePropostaConcluida;

    public void analisar(Proposta proposta) {

        try {
            int pontos = calculoPontoList.stream().mapToInt(impl -> impl.calcular(proposta)).sum();
            proposta.setAprovado(pontos > 350);
        } catch (StrategyException ex) {
            proposta.setAprovado(false);
            proposta.setDescricao(ex.getMessage());
        }

        notificacaoRabbit.notificar(exchangePropostaConcluida, proposta);
    }


}
