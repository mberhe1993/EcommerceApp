package com.example.productservice.DTO;


import java.math.BigDecimal;

public class ProductDTO {

    private  String productnumber;
    private String  name;
    private String supplierPhone;
    private BigDecimal price;
    private String description;
    private String supplierName;

    //getters
    public String getproductnumber(){return productnumber;}
    public String getName(){return name;}
    public String getsupplierPhone(){return supplierPhone;}
    public BigDecimal getprice(){return price;}
    public String getdescription(){return description;}
    public String getsupplierName(){return supplierName;}

    //setters
    public void setproductnumber(String productnumber){this.productnumber = productnumber;}
    public void setName(String name){this.name = name;}
    public void setsupplierPhone(String supplierPhone){this.supplierPhone = supplierPhone;}
    public void setprice(BigDecimal price){this.price = price;}
    public void setdescription(String description){this.description = description;}
    public void setsupplierName(String supplierName){this.supplierName = supplierName;}

}
