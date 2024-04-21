package com.analiseCredito.service;

import com.analiseCredito.domain.Proposta;
import com.analiseCredito.service.strategy.CalculoPonto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnaliseCreditoService {



    private List<CalculoPonto> calculoPontoList;

    public void analisar(Proposta proposta){
       int pontuacao = calculoPontoList.stream().mapToInt(impl -> impl.calcular(proposta)).sum();
    }


}
