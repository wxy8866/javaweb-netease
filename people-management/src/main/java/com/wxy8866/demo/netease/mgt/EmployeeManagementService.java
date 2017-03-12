package com.wxy8866.demo.netease.mgt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManagementService implements Management<EmployeeDTO>
{
    @Override
    public EmployeeDTO getById(Integer employeeId)
    {
        System.out.println("Method getById() in EmployeeManagementService called");
        return new EmployeeDTO();
    }

    public List<EmployeeDTO> getAllEmployee()
    {
        System.out.println("Method getAllEmployee() in EmployeeManagementService called");
        return new ArrayList<EmployeeDTO>();
    }

    @Override
    public void create(EmployeeDTO employee)
    {
        System.out.println("Method create() in EmployeeManagementService called");
    }
    @Override
    public void delete(Integer employeeId)
    {
        System.out.println("Method delete() in EmployeeManagementService called");
    }
    @Override
    public void update(EmployeeDTO employee)
    {
        System.out.println("Method update() in EmployeeManagementServicecalled");
    }
}
