package com.tuanz.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LamdaList {


    public static void main(String[] args) {

        List<Person> aList = new ArrayList();
        Person p01 = new Person("AAA","12");
        Person p02 = new Person("BBB","11");
        Person p03 = new Person("CCC","12");
        Person p04 = new Person("AAA","11");
        Person p05 = new Person("EEE","12");
        aList.add(p01);
        aList.add(p02);
        aList.add(p03);
        aList.add(p04);
        aList.add(p05);
        List<Person> list1 = aList.stream().filter(item -> item.getName().equals("AAA")).collect(Collectors.toList());
        int count = aList.stream().filter(item -> item.getName().equals("AAA")).collect(Collectors.toList()).size();
        System.out.println("countName= " + list1.size());
        System.out.println("countName= " + count);
        List<Person> list2 = aList.stream().filter(item -> item.getSex().equals("12")).collect(Collectors.toList());
        System.out.println("countAge= " + list2.size());

    }
}

class Person{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String name;
    private String sex;

    public Person(String name,String sex){
        this.name=name;
        this.sex=sex;
    }
}
