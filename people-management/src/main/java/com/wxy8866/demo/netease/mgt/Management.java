package com.wxy8866.demo.netease.mgt;

public interface Management<E>
{
    public void create(E entity) throws Exception;

    public void delete(Integer id) throws Exception;

    public void update(E entity) throws Exception;

    public E getById(Integer id) throws Exception;
}
