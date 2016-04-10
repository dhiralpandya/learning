package com.omt.learn.aes;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IpAddress {

	public static void main(String args[]) throws SocketException {
		String ip;
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface iface = interfaces.nextElement();
				// filters out 127.0.0.1 and inactive interfaces
				if (iface.isLoopback() || !iface.isUp())
					continue;

				Enumeration<InetAddress> addresses = iface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress addr = addresses.nextElement();
					ip = addr.getHostAddress();
					System.out.println(iface.getDisplayName() + " " + ip);
				}
			}
		} catch (SocketException e) {
			throw new RuntimeException(e);
		}

		for (String ipAddress : getInet4NetworkAddress()) {
			System.out.println("Parsing :" + ipAddress);
		}

	}

	public static List<String> getInet4NetworkAddress() throws SocketException {

		List<String> ipAddressList = new ArrayList<String>();

		for (Enumeration en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
			NetworkInterface intf = (NetworkInterface) en.nextElement();
			for (Enumeration enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
				InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
				if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
					ipAddressList.add(inetAddress.getHostAddress().toString());
				}
			}
		}
		return ipAddressList;
	}

}
