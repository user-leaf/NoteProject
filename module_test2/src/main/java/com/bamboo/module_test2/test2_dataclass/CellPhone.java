package com.bamboo.module_test2.test2_dataclass;

public class CellPhone {
    private String brand;
    private double price;

    public CellPhone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CellPhone) {
            CellPhone other = (CellPhone) o;
            return other.brand.equals(brand) && other.price == price;
        }
        return false;
    }

//    @Override
//    public int hashCode() {
//        return (int) (brand.hashCode() + price);
//    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
