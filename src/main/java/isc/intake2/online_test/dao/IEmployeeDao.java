package isc.intake2.online_test.dao;

import java.util.List;
 
import isc.intake2.online_test.entities.Employee;
 
public interface IEmployeeDao {
 
    Employee findById(int id);
 
    void saveEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
     
    List<Employee> findAllEmployees();
 
    Employee findEmployeeBySsn(String ssn);
 
}

