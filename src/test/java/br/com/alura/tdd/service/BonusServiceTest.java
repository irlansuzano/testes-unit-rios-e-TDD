package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto() {
        BonusService bonusService = new BonusService();

        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(new Funcionario("irlan", LocalDate.now(), new BigDecimal("25000"))));

        //ou com try, onde podemos validar a mensagem
//        try {
//            bonusService.calcularBonus(new Funcionario("irlan", LocalDate.now(), new BigDecimal("25000")));
//            fail("não retornou a exceção");
//        } catch (IllegalArgumentException e) {
//            assertEquals("Funcionário com salário maior do que 10 mil não pode receber bonus!", e.getMessage());
//        }

    }

    @Test
    void bonusDeveriaSerDezPctSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("irlan", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusValorDezMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("irlan", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}