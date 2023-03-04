package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.modelo.enums.Desempenho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {

    ReajusteService reajusteService;
    Funcionario funcionario;

    @BeforeEach //antes de cada método, chame esse
    public void inicializar(){
        reajusteService = new ReajusteService();
        funcionario = new Funcionario("irlan", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void reajusteTresPctADesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteQuinzePctBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteVintePctOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}