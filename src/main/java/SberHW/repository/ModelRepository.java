package SberHW.repository;

import SberHW.entities.ModelAuto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelRepository extends CrudRepository<ModelAuto, Long>    {
    List<ModelAuto> findByNameIgnoreCase(String name);
}
