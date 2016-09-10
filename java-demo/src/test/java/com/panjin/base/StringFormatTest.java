package com.panjin.base;

public class StringFormatTest {

	public static void main(String[] args) {
		String template = "您的短信验证码是%s。如非本人操作，请忽略此短信。［%s］";
		//Object[] argStr = new Object[]{"658937"};
		Object[] argStr = new Object[]{658937, "中顺易"};
		//Object[] argStr = new Object[]{"658937", "中顺易", "认真"};
		System.out.println(format(template, argStr));
	}

	public static String format(String template, Object... args) {
	    template = String.valueOf(template); // null -> "null"

	    // start substituting the arguments into the '%s' placeholders
	    StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
	    int templateStart = 0;
	    int i = 0;
	    while (i < args.length) {
	      int placeholderStart = template.indexOf("%s", templateStart);
	      if (placeholderStart == -1) {
	        break;
	      }
	      builder.append(template.substring(templateStart, placeholderStart));
	      builder.append(args[i++]);
	      templateStart = placeholderStart + 2;
	    }
	    builder.append(template.substring(templateStart));

	    // if we run out of placeholders, append the extra args in square braces
	    if (i < args.length) {
	      builder.append(" [");
	      builder.append(args[i++]);
	      while (i < args.length) {
	        builder.append(", ");
	        builder.append(args[i++]);
	      }
	      builder.append(']');
	    }

	    return builder.toString();
	  }
}
