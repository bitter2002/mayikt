package com.mayikt.entity;

public class EmEntity {
    private String name;
    private String address;
    /*
    * 员工属于哪个部门
    * */
    private DeptEntity deptEntity;

    public DeptEntity getDeptEntity() {
        return deptEntity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeptEntity(DeptEntity deptEntity) {
        this.deptEntity = deptEntity;
    }

    @Override
    public String toString() {
        return "EmEntity{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", deptEntity=" + deptEntity +
                '}';
    }
}
