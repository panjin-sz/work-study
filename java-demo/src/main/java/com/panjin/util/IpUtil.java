package com.panjin.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IpUtil {

	public static void main(String[] args) {

		try {
			Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (interfaceList.hasMoreElements()) {
				NetworkInterface ni = interfaceList.nextElement();
				Enumeration<InetAddress> inetAddrs = ni.getInetAddresses();
				while (inetAddrs.hasMoreElements()) {
					ip = inetAddrs.nextElement();
					// 此IP不是本地环回地址，并且地址中不包含冒号
					if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(':') == -1) {
						System.out.println(ni.getName() + " " + ip.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

}
