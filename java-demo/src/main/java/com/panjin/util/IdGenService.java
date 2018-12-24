package com.panjin.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class IdGenService {

	//计数器
	private int counter = 0;
	// 编号
	private char[] initId = {'0'};
	// 随机数据类
	private Random r;
	
	private static int rand_limit = 64*64*64*64;
	private static int count_limit = 64*64*64;
	private int ipJump = 1;
	
	// 32进制代号
	private static char datas[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D',
			'E','F','G','H','I','J','K','L','M','N','O' ,'P','Q','R','S','T','U','V','W',
			'X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s'
			,'t','u','v','w','x','y','z','A','B'};
	
	private static long mask = (1 << 6) - 1;
	
	private Object _syn = new Object();
	
	public IdGenService() {
		// --------确认基点
		int ipInt = 0;
		InetAddress addr = null;
		try {
			addr = java.net.InetAddress.getLocalHost();
			ipInt = addr.hashCode();
			ipJump = Math.abs(ipInt % 64) + 1;
		} catch (UnknownHostException e) {
			
		}
		long seed = System.currentTimeMillis() + ipInt;
		// 生成jvm编号
		r = new Random(seed);
		initId[0] = datas[r.nextInt(22) + 10];
	}
	
	/**
	 * 生成ID
	 * @return
	 */
	private String make() {
		return _make();
	}

	private String _make() {
		char[] str = new char[]{'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'};
		// 计数器(3/4位)
		int count = getCount();
		long time = System.currentTimeMillis();
		int charPos = 8;
		do {
			str[charPos--] = datas[(int)(time & mask)];
			time >>>= 6;
		} while (time != 0);
		
		// 编入计数器
		charPos = str.length - 5;
		do {
			str[charPos--] = datas[(int)(count & mask)];
			count >>>= 6;
		} while (count != 0);
		
		// 编入jvm/ip（6位）
		str[0]= initId[0];
		int r_nums = r.nextInt(rand_limit);
		charPos = str.length - 1;
		do {
			str[charPos--] = datas[(int)(r_nums & mask)];
			r_nums >>>= 6;
		} while (r_nums != 0);
		return new String(str);
	}
	
	/**
	 * 计数器自加
	 * @return
	 */
	private synchronized int getCount() {
		synchronized (_syn) {
			counter += ipJump;
			if (counter <0 || counter > count_limit) {
				counter = ipJump;
				try {
					//等待16，防止重复
					_syn.wait(16);
				} catch (InterruptedException e) {
				}
			}
			return counter;
		}
	}
	
	public String getID() {
		return make();
	}
}
