package com.wxy8866.demo.netease.mgt;

import java.util.List;

public class ManagerDTO
{
    private Integer           id;
    private String            firstName;
    private String            lastName;
    private List<EmployeeDTO> myEmployeeList;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public List<EmployeeDTO> getMyEmployeeList()
    {
        return myEmployeeList;
    }

    public void setMyEmployeeList(List<EmployeeDTO> myEmployeeList)
    {
        this.myEmployeeList = myEmployeeList;
    }

}
