package edu.fatec.praticaTDD.personEmail;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<String> isValidToInclude(Person person){
        
        List<String> errors = new ArrayList<>();

        if(person == null){
            errors.add("Person is null");
            return errors;
        }

        String name = person.getName();
        if(name == null || name.trim().isEmpty()){
            errors.add("Nome deve ter pelo menos duas partes e conter apenas letras");
        } else {
            String[] parts = name.trim().split("\\s+");
            if(parts.length < 2){
                errors.add("Nome deve ter pelo menos duas partes e conter apenas letras");
            } else {
                for(String part: parts){
                    if(!part.matches("[A-Za-zÀ-ÖØ-öø-ÿ]+")){
                        errors.add("Nome deve ter pelo menos duas partes e conter apenas letras");
                        break;
                    }
                }
            }
        }

        int age = person.getAge();
        if(age < 1 || age > 200){
            errors.add("Idade deve estar entre 1 e 200");
        }

        // pelo menos um email
        List<Email> emails = person.getEmails();
        if(emails == null || emails.isEmpty()){
            errors.add("Pelo menos um email é obrigatório");
        } else {
            for(Email e: emails){
                String en = e.getName();
                if(en == null || !en.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")){
                    errors.add("Email '" + en + "' é inválido");
                }
            }
        }

        return errors;
    }
}
