package com.analiseCredito.service.strategy.Impl;

import com.analiseCredito.domain.Proposta;
import com.analiseCredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutroEmprestimoEmAndamento implements CalculoPonto {


    @Override
    public int calcular(Proposta proposta) {
        return outrosEmprestimosEmAndamento() ? 0 : 80;
    }

    private boolean outrosEmprestimosEmAndamento(){
        return new Random().nextBoolean();
    }
}
