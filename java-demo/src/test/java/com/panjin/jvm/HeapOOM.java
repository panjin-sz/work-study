package com.panjin.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

	/**
	 * 测试时Run As-->Run Configuration-->arguments里面设置
	 * jvm参数（-verbose:gc -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError）
	 * @param args
	 */
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}

	static class OOMObject {}
}
