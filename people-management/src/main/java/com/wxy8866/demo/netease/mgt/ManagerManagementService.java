package com.wxy8866.demo.netease.mgt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ManagerManagementService implements Management<ManagerDTO>
{

    public List<EmployeeDTO> getAllMyEmployee(Long managerID)
    {
        System.out.println("Method getAllMyEmploye() in EmployeeManagementService called");
        return new ArrayList<EmployeeDTO>();
    }

    @Override
    public void create(ManagerDTO manager)
    {
        System.out.println("Method create() in ManagerManagementService called");

    }

    @Override
    public void delete(Integer managerId)
    {
        System.out.println("Method delete() in ManagerManagementService called");

    }

    @Override
    public void update(ManagerDTO manager) throws Exception
    {
        System.out.println("Method update() in ManagerManagementServicecalled");
        throw new Exception("Throw exception manually");
    }

    @Override
    public ManagerDTO getById(Integer id)
    {
        System.out.println("Method getById() in ManagerManagementService called");
        return new ManagerDTO();
    }

}
