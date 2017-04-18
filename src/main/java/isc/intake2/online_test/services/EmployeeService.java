package isc.intake2.online_test.services;

import java.util.List;
 
import isc.intake2.online_test.entities.Employee;
 
public interface EmployeeService {
 
    Employee findById(int id);
     
    void saveEmployee(Employee employee);
     
    void updateEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
 
    List<Employee> findAllEmployees(); 
     
    Employee findEmployeeBySsn(String ssn);
 
    boolean isEmployeeSsnUnique(Integer id, String ssn);
     
}