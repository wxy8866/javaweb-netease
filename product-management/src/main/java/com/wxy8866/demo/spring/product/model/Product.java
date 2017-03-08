package com.wxy8866.demo.spring.product.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable
{
    private static final long serialVersionUID = 3374639755006102632L;
    private String name;
    private BigDecimal price;
    private String description;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
