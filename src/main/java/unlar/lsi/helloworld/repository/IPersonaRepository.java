package unlar.lsi.helloworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unlar.lsi.helloworld.models.Person;

public interface IPersonaRepository extends JpaRepository<Person,Long> {
}
