package com.analiseCredito.service.strategy.Impl;

import com.analiseCredito.domain.Proposta;
import com.analiseCredito.service.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Order(1)
public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        if (nomeNegativado()) {
            return 100;
        } else throw new RuntimeException("Usuário negativado");
    }

    private boolean nomeNegativado() {
        return new Random().nextBoolean();
    }

}
