package edu.fatec.praticaTDD.personEmail;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PersonDAOTest {

    @Test
    public void validPersonShouldHaveNoErrors() {
        Person p = new Person("Joao Silva", 30);
        p.addEmail(new Email("joao@example.com"));
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(p);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void nameMustHaveAtLeastTwoParts() {
        Person p = new Person("SingleName", 30);
        p.addEmail(new Email("a@b.c"));
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(p);
        assertEquals(1, errors.size());
        assertTrue(errors.get(0).contains("Nome"));
    }

    @Test
    public void nameMustContainOnlyLetters() {
        Person p = new Person("Joao 123", 30);
        p.addEmail(new Email("a@b.c"));
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(p);
        assertEquals(1, errors.size());
        assertTrue(errors.get(0).contains("Nome"));
    }

    @Test
    public void ageOutOfRange() {
        Person p = new Person("Joao Silva", 0);
        p.addEmail(new Email("a@b.c"));
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(p);
        assertTrue(errors.contains("Idade deve estar entre 1 e 200"));
    }

    @Test
    public void mustHaveAtLeastOneEmail() {
        Person p = new Person("Joao Silva", 25);
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(p);
        assertTrue(errors.contains("Pelo menos um email é obrigatório"));
    }

    @Test
    public void invalidEmailFormat() {
        Person p = new Person("Joao Silva", 25);
        p.addEmail(new Email("bad-email"));
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(p);
        assertEquals(1, errors.size());
        assertTrue(errors.get(0).contains("é inválido"));
    }

}
