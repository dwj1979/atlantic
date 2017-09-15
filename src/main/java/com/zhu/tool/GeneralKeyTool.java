package com.zhu.tool;

import java.util.UUID;

public class GeneralKeyTool {

	public static String getId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
