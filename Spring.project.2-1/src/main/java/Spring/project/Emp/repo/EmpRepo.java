package Spring.project.Emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Spring.project.Emp.model.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}
