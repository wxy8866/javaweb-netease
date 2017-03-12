package com.wxy8866.demo.netease.mgt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMgt
{

    public static void main(String[] args) throws Exception
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Management<EmployeeDTO> management = context.getBean(EmployeeManagementService.class);
        management.getById(1);
        management.create(new EmployeeDTO());
        EmployeeDTO employee = management.getById(1);
        employee.setFirstName("XingYi");
        employee.setLastName("Wei");
        management.update(employee);
        management.delete(1);
        Management<ManagerDTO> management2 = context.getBean(ManagerManagementService.class);
        management2.create(new ManagerDTO());
        ManagerDTO manager = management2.getById(2);
        try
        {
            management2.update(manager);
        } catch (Exception e)
        {
        }
        management2.delete(2);
        ((ConfigurableApplicationContext) context).close();
    }
}
