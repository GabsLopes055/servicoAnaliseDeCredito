package com.analiseCredito.service.strategy.Impl;

import com.analiseCredito.constantes.MensagemConstantes;
import com.analiseCredito.domain.Proposta;
import com.analiseCredito.exceptions.StrategyException;
import com.analiseCredito.service.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Order(2)
public class PontuacaoScoreImpl implements CalculoPonto {


    @Override
    public int calcular(Proposta proposta) {

        int score = score();

        if (score <= 200) {
            throw new StrategyException(String.format(MensagemConstantes.PONTUACAO_SERASA_BAIXA, proposta.getUsuario().getNome()));
        }
        else if (score <= 400) return 150;
        else if (score <= 600) return 180;
        else return 220;

    }

    private int score() {
        return new Random().nextInt(0, 1000);
    }
}
