package unlar.lsi.helloworld.api.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unlar.lsi.helloworld.models.Person;
import unlar.lsi.helloworld.service.PersonService;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@XSlf4j
@RequiredArgsConstructor
public class PersonRest {

    private final PersonService personService;


    public PersonRest(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/peoples")
    public ResponseEntity<List<Person>> findAll() {

        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping(value = "/person")
    public ResponseEntity create(@Valid @RequestBody Person entity) {
        return ResponseEntity.ok(personService.save(entity));
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> findById(Long id) {
        Optional<Person> person = personService.findById(id);
        if (!person.isPresent()) {

            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(person.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody Person entity) {
        if (!personService.findById(id).isPresent()) {

            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(personService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!personService.findById(id).isPresent()) {

            ResponseEntity.badRequest().build();
        }

        personService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
