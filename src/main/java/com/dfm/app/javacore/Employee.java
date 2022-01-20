package com.dfm.app.javacore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author:fengming.dai
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Cloneable{

    private String userName;

    private Integer salary;

    private Date hireDay;

    /**
     * 实现深拷贝
     * 给内部 对象引用（可变对象）重新 赋值。
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee clone = (Employee) super.clone();
        clone.hireDay = (Date) hireDay.clone();
        return clone;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //通过  getClass 获取 Class 对象
        Employee employee = new Employee("dfm",400,new Date());
        Class<? extends Employee> employeeClass = employee.getClass();
        System.out.println("employeeClass.getName() = " + employeeClass.getName());
        System.out.println("employee.getUserName() = " + employee.getUserName());

        //调用 静态方法 forName 获取  类名（或者接口名） 对应的 Class 对象
        Class<?> aClass = Class.forName("java.util.Date");
        System.out.println("aClass.getName() = " + aClass.getName());

        //通过  T.class 获取 Class 对象
        Class<Date> dateClass = Date.class;
        System.out.println("dateClass.getName() = " + dateClass.getName());
        System.out.println("Employee.class = " + Employee.class.getName());

        // == 判断是否 同一个 类型 Class
        boolean charge = employee.getClass() == Employee.class;
        System.out.println("charge = " + charge);

        if(charge){
            try {
                // 通过 Class.newInstance() 构造一个 Class类型的 实例，调动 无惨构造器
                Employee instance = employee.getClass().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
