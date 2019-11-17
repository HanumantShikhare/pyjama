package org.h_shikhare.pyjama.string;

import org.apache.commons.lang3.StringUtils;
import org.h_shikhare.pyjama.exception.PendingImplException;
import org.h_shikhare.pyjama.exception.ValueException;

public class PyString {

    /**
     * built on https://docs.python.org/3.8/library/stdtypes.html#str.capitalize
     *
     * @return String with first character in upper case
     */
    public static String capitalize(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }

    /**
     * https://docs.python.org/3.8/library/stdtypes.html#str.casefold
     */
    public static String casefold(String str) throws PendingImplException {
        // TODO pending implementation
        // python changes char ß to ss
        // while java changes it to ÃŸ
        throw new PendingImplException();
    }

    /**
     * https://docs.python.org/3/library/stdtypes.html#str.center
     *
     * @param str
     * @param len
     * @param fillChar
     * @return
     */
    public static String center(String str, int len, char fillChar) {
        if (str == null || str.length() >= len) {
            return str;
        }
        int totalPaddingLength = len - str.length();

        boolean isOdd = (totalPaddingLength & 1) != 0;

        int paddingLength = totalPaddingLength / 2;

        if (isOdd) {
            paddingLength += 1;
        }
        char[] fills = new char[paddingLength];
        for (int j = 0; j < paddingLength; j++) {
            fills[j] = fillChar;
        }
        String padding = String.valueOf(fills);

        return padding.substring(isOdd ? 1 : 0) + str + padding;
    }

    /**
     * https://docs.python.org/3/library/stdtypes.html#str.count
     *
     * @return
     */
    public static int count(String str, String sub, int start, int end) {

        if (StringUtils.isBlank(str) || StringUtils.isBlank(sub) || start < 0 || end < 0) {
            return 0;
        }

        int count = 0;
        boolean keepMatching = true;
        String temp = "";
        while (keepMatching) {
            if (end > 0 && StringUtils.isNotBlank(str) && str.substring(start, end).contains(sub)) {
                count++;
                temp = str.substring(str.indexOf(sub) + sub.length());
                end -= str.length() - temp.length();
                str = temp;
            } else {
                keepMatching = false;
            }
        }

        return count;
    }

    /**
     * https://docs.python.org/3/library/stdtypes.html#str.count
     *
     * @return
     */
    public static int count(String str, String sub) {
        return count(str, sub, 0);
    }

    /**
     * https://docs.python.org/3/library/stdtypes.html#str.count
     *
     * @return
     */
    public static int count(String str, String sub, int start) {
        if (StringUtils.isBlank(str))
            return 0;
        return count(str, sub, start, str.length());
    }

    public static String encode(String str, String encoding) throws PendingImplException {
        throw new PendingImplException();
    }

    public static boolean endsWith(String str, String suffix) {
        if (str == null && suffix == null) {
            return true;
        }
        if (StringUtils.isBlank(str) || suffix == null) {
            return false;
        }
        return endsWith(str, suffix, 0, str.length());
    }

    public static boolean endsWith(String str, String suffix, int start) {
        if (str == null && suffix == null) {
            return true;
        }
        if (StringUtils.isBlank(str) || suffix == null || str.length() <= start) {
            return false;
        }
        return endsWith(str, suffix, start, str.length());
    }

    public static boolean endsWith(String str, String suffix, int start, int end) {
        if (str == null && suffix == null) {
            return true;
        }
        if (StringUtils.isBlank(str) || suffix == null || str.length() <= start || start >= end) {
            return false;
        }
        return str.substring(start, end).endsWith(suffix);
    }

    public static String expandTabs(String str) {
        return expandTabs(str, 8);
    }

    public static String expandTabs(String str, int tabSize) {
        // will have to handle \r character
        if (StringUtils.isBlank(str) || !str.contains("\t")) {
            return str;
        } else if (tabSize == 0) {
            return str.replaceAll("\t", "");
        }

        String[] newLineSplit = str.split("\n");
        StringBuilder result = new StringBuilder(str.length() + 16); // pessimistic size

        char[] spaces = new char[tabSize];
        for (int i = 0; i < tabSize; i++) {
            spaces[i] = ' ';
        }
        String spaceString = String.valueOf(spaces);

        for (String s : newLineSplit) {
            String[] split = s.split("\t");
            for (int i = 0; i < split.length - 1; i++) {
                result.append(split[i]).append(spaceString.substring(split[i].length() % tabSize));
            }
            result.append(split[split.length - 1]).append("\n");
        }
        return result.substring(0, result.length() - 1);
    }

    public static int find(String str, String sub) {
        if (str == null && sub == null || StringUtils.isBlank(str) || sub == null) {
            return -1;
        }
        return find(str, sub, 0, str.length());
    }

    public static int find(String str, String sub, int start) {
        if (str == null && sub == null || StringUtils.isBlank(str) || sub == null || str.length() <= start) {
            return -1;
        }
        return find(str, sub, start, str.length());
    }

    public static int find(String str, String sub, int start, int end) {
        if (str == null && sub == null || StringUtils.isBlank(str) || sub == null || str.length() <= start || start >= end) {
            return -1;
        }
        return str.substring(start, end).indexOf(sub);
    }

    public static String format(String str, String... arg) throws PendingImplException {
        throw new PendingImplException();
    }

    public static String formatMap(String str, String... arg) throws PendingImplException {
        throw new PendingImplException();
    }

    public static int index(String str, String sub) throws ValueException {
        if (str == null && sub == null || StringUtils.isBlank(str) || sub == null) {
            throw new ValueException();
        }
        int index = index(str, sub, 0, str.length());
        if (index == -1) {
            throw new ValueException();
        }
        return index;
    }

    public static int index(String str, String sub, int start) throws ValueException {
        if (str == null && sub == null || StringUtils.isBlank(str) || sub == null || str.length() <= start) {
            throw new ValueException();
        }
        int index = index(str, sub, start, str.length());
        if (index == -1) {
            throw new ValueException();
        }
        return index;
    }

    public static int index(String str, String sub, int start, int end) throws ValueException {
        if (str == null && sub == null || StringUtils.isBlank(str) || sub == null || str.length() <= start || start >= end) {
            throw new ValueException();
        }
        int index = str.substring(start, end).indexOf(sub);
        if (index == -1) {
            throw new ValueException();
        }
        return index;
    }
}
