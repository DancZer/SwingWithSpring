package employees.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select new employees.backend.EmployeeDto(e.id, e.name, e.email) from Employee e")
    List<EmployeeDto> findAllDto();
}
