
package SberHW.repository;

import SberHW.entities.Modification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModificationRepository extends JpaRepository<Modification, Long> {
    List<Modification> findByNameIgnoreCase(String name);

    List<Modification> findByNameIgnoreCaseAndPeriodBeginAndPeriodEnd(String name, int periodBegin, int periodEnd);

    List<Modification> findByNameIgnoreCaseAndPeriodBegin(String name, int periodBegin);

    List<Modification> findByNameIgnoreCaseAndPeriodEnd(String name, int periodEnd);


}

