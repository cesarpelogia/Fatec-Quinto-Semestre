package edu.fatec.praticaTDD.salaryCalculator;

public class SalaryCalculator {

    public double calculateNetSalary(Employee e){
        double base = e.getBaseSalary();
        Role r = e.getRole();
        double discount = switch (r) {
            case DESENVOLVEDOR -> (base >= 3000.0) ? 0.20 : 0.10;
            case DBA, TESTADOR -> (base >= 2000.0) ? 0.25 : 0.15;
            case GERENTE -> (base >= 5000.0) ? 0.30 : 0.20;
            default -> 0.0;
        };
        return base * (1.0 - discount);
    }
}
