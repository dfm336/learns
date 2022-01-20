package com.dfm.app.listener;

/**
 * @Author:代奉明
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();

        person.registerListener(new PersonListener() {
            @Override
            public void doEat(Event event) {
                Person person1 = event.getPerson();
                System.out.println(person1);
                System.out.println("person1 = " + person1+"正在吃放呢");
            }

            @Override
            public void doSleep(Event event) {
                Person p = event.getPerson();
                System.out.println("p = " +p+"正在睡觉！");
            }
        });

        person.eat();
        System.out.println(person);
    }
}
