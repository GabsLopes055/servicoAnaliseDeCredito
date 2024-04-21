package com.analiseCredito.service.strategy.Impl;

import com.analiseCredito.domain.Proposta;
import com.analiseCredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RendaMaiorQueValorSolicitado implements CalculoPonto {


    @Override
    public int calcular(Proposta proposta) {
        return rendaMaiorQueSolicitado(proposta) ? 0 : 100;
    }

    private boolean rendaMaiorQueSolicitado(Proposta proposta) {
        return proposta.getValorSolicitado() > 5000;
    }
}
