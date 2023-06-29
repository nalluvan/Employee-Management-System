package Spring.project.Emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import Spring.project.Emp.model.Employee;
import Spring.project.Emp.repo.EmpRepo;
@org.springframework.stereotype.Service
public class ServiceIMPl implements Service {
	@Autowired
	public EmpRepo empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.empRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = empRepo.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.empRepo.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.empRepo.findAll(pageable);
	}

}
