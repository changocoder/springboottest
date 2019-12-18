package unlar.lsi.helloworld.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unlar.lsi.helloworld.models.Person;
import unlar.lsi.helloworld.repository.IPersonaRepository;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PersonService {

    private final IPersonaRepository personaRepository;


    public PersonService(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Person> findAll(){

        return  personaRepository.findAll();
    }

    public  Person save(Person entity) {
        return personaRepository.save(entity);
    }



    public Optional<Person> findById(Long entity) {
        return personaRepository.findById(entity);
    }

    public void deleteById(Long entity) {
        personaRepository.deleteById(entity);
    }
}
