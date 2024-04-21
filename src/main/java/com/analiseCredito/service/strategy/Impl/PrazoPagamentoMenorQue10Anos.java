package com.analiseCredito.service.strategy.Impl;

import com.analiseCredito.domain.Proposta;
import com.analiseCredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

@Component
public class PrazoPagamentoMenorQue10Anos implements CalculoPonto {
    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }
}
