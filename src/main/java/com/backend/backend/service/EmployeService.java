package com.backend.backend.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.backend.backend.entity.Employee;
import com.backend.backend.repository.EmployeeRepository;

@Service
public class EmployeService {
    
  private final EmployeeRepository employeeRepository;

  public EmployeService(EmployeeRepository employeeRepository) {
      this.employeeRepository = employeeRepository;
  }

  public Employee postEmpoyee(Employee employee){
    return employeeRepository.save(employee);
  }

  public Employee updatEmployee(Long id ,Employee employeeDetails){
      Optional<Employee> optionalEmployee = employeeRepository.findById(id);
      if(optionalEmployee.isPresent()){
          Employee existingemployee =optionalEmployee.get();
          existingemployee.setName(employeeDetails.getName());
          existingemployee.setEmail(employeeDetails.getEmail());
          existingemployee.setDepartment(employeeDetails.getDepartment());
          existingemployee.setPhone(employeeDetails.getPhone());

        return employeeRepository.save(existingemployee);
      }else {
        throw new RuntimeException("Employee with id " + id + " not found.");
      }
  }

  public String deleteEmployee(Long id,Employee employee){
    Optional<Employee> optionemployee =employeeRepository.findById(id);
     if(optionemployee.isPresent()){
        employeeRepository.deleteById(id);
        return ("Employee with id " + id + " has been deleted");
     }else {
        throw new RuntimeException("Employee with id " + id + " not found.");
     }
  }

  public List<Employee> getEmployee(){
     List<Employee> optionalEmployee =employeeRepository.findAll();

     if (optionalEmployee.isEmpty()) {
      throw new RuntimeException("No employees found.");
     }
     return optionalEmployee;
  }
}
