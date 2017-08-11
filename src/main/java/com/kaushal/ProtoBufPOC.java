package com.kaushal;

import com.tutorial.protobuf.AddressProto;
import com.tutorial.protobuf.Employee1Proto;
import com.tutorial.protobuf.EmployeeProto;
import com.tutorial.protobuf.EmployeeProto.Employee;
import com.tutorial.protobuf.EmployeeProto.Department;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProtoBufPOC {

    private static void serialize(){
        Department department = EmployeeProto.Department.newBuilder().setDeptid(1).setDeptname("Engineering").setDeptCount(123).build();
        AddressProto.Address address = AddressProto.Address.newBuilder().setCity("Pune").setState("Maharashtra").build();
        Employee employee = EmployeeProto.Employee.newBuilder().
                setFirstname("Kaushal").
                setLastname("Mundada").
                setId(1).
                setGender(Employee.Gender.MALE).
                setSalary(3000).
                putFavPlaces("abc", AddressProto.Address.newBuilder().setCity("Jodhpur").setState("Rajasthan").build()).
                putFavPlaces("xyz", AddressProto.Address.newBuilder().setCity("Shrinagar").setState("J&K").build()).
                setAddress(address).
                setPhone(Employee.Phone.newBuilder().setPhoneNumber(987654321).setWhatsappEnabled(true).build()).
                setDept(department).build();
        try {
            // write data to file
            FileOutputStream output = new FileOutputStream("EmpInfo.ser");
            employee.writeTo(output);
            output.close();

            System.out.println("Serialized Size - " + employee.getSerializedSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserialize(){
        try {
            // read data from file
            Employee1Proto.Employee1 employee1 = Employee1Proto.Employee1.parseFrom(new FileInputStream("EmpInfo.ser"));
            System.out.println(employee1);
            System.out.println(employee1.getGender());
            System.out.println("FavPlace - abc \n" + employee1.getFavPlacesOrThrow("abc"));
            System.out.println("Phone Number - " + employee1.getPhone().getPhoneNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        serialize();
        deserialize();
    }

}
