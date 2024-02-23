package com.github.s1xnoh.training.utils;

public class StringUtils {
    public StringUtils() {
    }

    public static String createArgs(int index, String[] args, String defaultArgs, boolean color) {
        StringBuilder sb = new StringBuilder();

        for(int i = index; i < args.length; ++i) {
            sb.append(args[i]).append(i + 1 >= args.length ? "" : " ");
        }

        if (sb.length() == 0) {
            sb.append(defaultArgs);
        }

        return color ? sb.toString().replace("&", "§") : sb.toString();
    }
}