package Spring.project.Emp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import Spring.project.Emp.model.Employee;

public interface Service {
	List<Employee>getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
