package edu.fatec.praticaTDD.salaryCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SalaryCalculatorTest {

    private static final double DELTA = 0.0001;

    @Test
    public void desenvolvedorAboveOrEqual3000() {
        Employee e = new Employee("Dev", "a@b.com", 3000.0, Role.DESENVOLVEDOR);
        SalaryCalculator calc = new SalaryCalculator();
        assertEquals(2400.0, calc.calculateNetSalary(e), DELTA);
    }

    @Test
    public void desenvolvedorBelow3000() {
        Employee e = new Employee("Dev", "a@b.com", 2999.99, Role.DESENVOLVEDOR);
        SalaryCalculator calc = new SalaryCalculator();
        assertEquals(2699.991, calc.calculateNetSalary(e), DELTA);
    }

    @Test
    public void dbaAboveOrEqual2000() {
        Employee e = new Employee("DBA", "a@b.com", 2000.0, Role.DBA);
        SalaryCalculator calc = new SalaryCalculator();
        assertEquals(1500.0, calc.calculateNetSalary(e), DELTA);
    }

    @Test
    public void dbaBelow2000() {
        Employee e = new Employee("DBA", "a@b.com", 1999.99, Role.DBA);
        SalaryCalculator calc = new SalaryCalculator();
        assertEquals(1699.9915, calc.calculateNetSalary(e), DELTA);
    }

    @Test
    public void testadorAboveOrEqual2000() {
        Employee e = new Employee("Test", "a@b.com", 2000.0, Role.TESTADOR);
        SalaryCalculator calc = new SalaryCalculator();
        assertEquals(1500.0, calc.calculateNetSalary(e), DELTA);
    }

    @Test
    public void testadorBelow2000() {
        Employee e = new Employee("Test", "a@b.com", 1500.0, Role.TESTADOR);
        SalaryCalculator calc = new SalaryCalculator();
        assertEquals(1275.0, calc.calculateNetSalary(e), DELTA);
    }

    @Test
    public void gerenteAboveOrEqual5000() {
        Employee e = new Employee("Gerente", "a@b.com", 5000.0, Role.GERENTE);
        SalaryCalculator calc = new SalaryCalculator();
        assertEquals(3500.0, calc.calculateNetSalary(e), DELTA);
    }

    @Test
    public void gerenteBelow5000() {
        Employee e = new Employee("Gerente", "a@b.com", 4999.99, Role.GERENTE);
        SalaryCalculator calc = new SalaryCalculator();
        assertEquals(3999.992, calc.calculateNetSalary(e), DELTA);
    }

}
