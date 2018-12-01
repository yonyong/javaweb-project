package cn.lianwei.yonyong.utils;

import java.util.Date;

public class IdUtil {
	public static int getID() {
		Date date=new Date();
		int mon=date.getMonth();
		int day=date.getDay();
		int hour=date.getHours();
		int min=date.getMinutes();
		int sec=date.getSeconds();
		int time=date.getTimezoneOffset();
		System.out.println(day);
		System.out.println(hour);
		System.out.println(min);
		System.out.println(sec);
		System.out.println(time);
		time=sec+min*60+hour*60*60+day*60*60*24+mon*60*60*30;
		System.out.println("ID值："+time+"...");
		return time;
	}
}
