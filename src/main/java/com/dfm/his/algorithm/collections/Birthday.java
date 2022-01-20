package com.dfm.his.algorithm.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 测试数据：
 *             
 *             6
Avril 3 2
Candy 4 5
Tim 3 2
Sufia 4 5
Lagrange 4 5
Bill 3 2
 * @author Administrator
 *
 */
public class Birthday {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		List<Student> studetnList = new ArrayList<Student>();
		for(int i=0;i<num;i++) {
			String name = input.next();
			int month = input.nextInt();
			int day = input.nextInt();
			Student student = new Student(name, month, day);
			studetnList.add(student);
		}
		for (Student student : studetnList) {
			System.out.println(student);
		}
		Collections.sort(studetnList,new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int result = 0;
				int flag = (o1.getMonth()*10+o1.getDay()) - (o2.getMonth()*10+o2.getDay());
				if( flag != 0) {
					result = (flag > 0) ? 1 : -1; // >0升序， <0 降序
				}else {//说明flag == 0 则 出生日期相同
					flag = o1.getName().length() - o2.getName().length();
					if(flag != 0) {
						result = (flag > 0) ? 2 : -2;	
					}else {//说明 Name的长度相同
						flag = o1.getName().compareTo(o2.getName());
						if(flag != 0) {
							result = (flag > 0) ? 3 : -3;
						}
					}
				}
				return result;
			}
		});
		System.out.println("-----------排序后-----------------");
		for (Student student : studetnList) {
			System.out.println(student);
		}
		List<String> res = null;
		for(int i=0 ; i<studetnList.size();i++) {
			Student stu1 = studetnList.get(i);
			res = new ArrayList<String>();
			int count =0;
			for(int j=i+1;j<studetnList.size();j++) {
				Student stu2 = studetnList.get(j);
				int ans = (stu1.getMonth()*10+stu1.getDay())-(stu2.getMonth()*10+stu2.getDay());
				if(ans == 0) {//说明出生 月 日 相等
					if(count == 0)//防止第一个 多次加入
					{
						res.add(stu1.getName());
						count = -1;//修改后不会 再加入
					}
					res.add(stu2.getName());
					i = j;//由于已经排序，加快遍历。从最后一个相同日期的 下标开始 搜索
				}
			}
			if(res != null) {
				System.out.print(stu1.getMonth()+"-"+stu1.getDay()+" ");
				for (String string : res) {
					System.out.print(string+" ");
				}
			}
			System.out.println();
		}
	}
	
}
class Student{
	String name;
	int month;
	int day;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", month=" + month + ", day=" + day + "]";
	}
	public Student(String name, int month, int day) {
		super();
		this.name = name;
		this.month = month;
		this.day = day;
	}
	
}