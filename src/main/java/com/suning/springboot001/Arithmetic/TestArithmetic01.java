package com.suning.springboot001.Arithmetic;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 入门/简单
 * Created：Jeffrey
 * date   ：2021/7/9 18:28
 */
public class TestArithmetic01 {
    public static void main(String[] args) {
//        float f=2.63f;
//        System.out.println((int)f);
        String.valueOf(1);
//        Test001();
//        test002();
//        test003();
//        test0031();
//        test004();
//        test005();
//        test006();
//        test007();
//        Scanner scanner = new Scanner(System.in);
//        float f = scanner.nextFloat();
//
//        System.out.println(Math.round(f));

//        test008();
//        test0001();
//        test010();
//        test011();
//        test012();
//        test013();
//        test014();
//        test015();
//        test016();
//        test017();
//        test020()；
//        test022();

//        test030();

//        test031();
//        test032();
//        test034();
//        test035();

//        test036();
        test037();

    }


    // =============scanner.nextLine(); =========== 这行必须要加！！！！不然就死循环

    //    import java.util.Scanner;
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String s = sc.nextLine();

                String nums = s.replaceAll(":", "");
                Set numSet = new HashSet();
                for (int i = 0; i < nums.length(); i++) {
                    numSet.add(nums.charAt(i));
                }
                //组合时间
                List list = new ArrayList();


            }

        }
    }


    public static void die() {

    }


    //======简单0-30========
    //0. 求int型正整数在内存中存储时1的个数
    public static void test000() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            String b = Integer.toBinaryString(a);
            char[] chars = b.toCharArray();
            int tem = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    tem++;
                }
            }
            System.out.println(tem);
        }
    }

    //1.写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
    public static void test001() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            float f = scanner.nextFloat();
            int a = (int) f; //浮点型强转为整型，只保留整数部分
            if ((f - a) >= 0.5) {
                System.out.println(a + 1);
            } else {
                System.out.println(a);
            }
        }
    }

    //2.输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数----见0，转二进制字符串
    public static void test002() {
        int n = new Scanner(System.in).nextInt();
        int count = 0;
        while (n > 0) {
            if ((n & 1) > 0) {
                count++;
            }
            n = n >> 1;

        }
        System.out.println(count);
    }

    //3.接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
    public static void test003() {
        while (true) {
            String a = new Scanner(System.in).nextLine();
            String b = "";
            StringBuilder builder = new StringBuilder();
            for (int i = a.length() - 1; i >= 0; i--) {
                b = b + a.charAt(i);  //直接拼接，不用转成数组，依次填入了
                builder = builder.append(a.charAt(i));
            }
//            System.out.println(b);
            System.out.println(builder);
        }
    }

    //直接用StingBuffer方法-reverse()反转
    public static void test0031() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String a = scanner.nextLine();
            System.out.println(new StringBuffer(a).reverse());
        }

    }

    //4.输入一个整数，将这个整数以字符串的形式逆序输出 --- 可以直接用stringBuffer反转
    public static void test004() {
        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt();
        String g = f + "";
        StringBuilder h = new StringBuilder();
        for (int i = g.length() - 1; i >= 0; i--) {
            h = h.append(g.charAt(i));
        }
    }

    //5.给定一个字符串描述的算术表达式 3+2*{1+2*[-4/(8-6)+7]} ，计算出结果值？？？
    public static void test005() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("js");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            try {
                System.out.println(scriptEngine.eval(scanner.nextLine()));
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
    }

    //6. 杨辉三角：求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。？？？？？
    public static void test006() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n <= 2)
                System.out.println(-1);
            else {
                if (n % 2 == 1)
                    System.out.println(2);
                else if (n % 4 == 0)
                    System.out.println(3);
                else
                    System.out.println(4);
            }
        }
        scanner.close();
    }

    //7.查找输入整数二进制中1的个数
    public static void test007() {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        while (s.hasNextLine()) {
            String b = Integer.toBinaryString(a); //转成二进制的字符
            int count = 0;
            for (int i = 0; i < b.length(); i++) {
                if ('1' == b.charAt(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    //完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身
    //8.遍历每个小于n的数，依次判断
    public static void test008() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int temp = 0;
            for (int i = 1; i <= a; i++) {
                int count = 0;
                for (int j = 1; j < i; j++) {
                    if (i % j == 0) {
                        count += j;
                    }
                }
                //因子和等于数
                if (i == count) {
                    temp++;
                }
            }
            System.out.println(temp);
        }
    }

    //9.递归放苹果:把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。???
    public static void test009() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();  //m个苹果
            int n = scanner.nextInt();  //n个盘子
            System.out.println(getNum(m, n));
        }
    }

    static int getNum(int m, int n) { //7-3
        if (m < 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return getNum(m - n, n) + getNum(m, n - 1); //4-3和7-2
    }


    //10.白钱买百鸡：遍历将所有可能交给计算机去试，相当于解方程
    public static void test010() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            scanner.nextLine();  //这行必须要加！！！！不然就死循环
            for (int i = 0; i <= 20; i++) { //母鸡
                for (int j = 0; j <= 33; j++) { //公鸡
                    for (int k = 0; k <= 100; k += 3) {  //小鸡
                        if ((i + j + k == 100) && (i * 5 + 3 * j + k / 3 == 100)) {
                            System.out.println(i + " " + j + " " + k);
                        }
                    }
                }
            }
        }
    }


    //11.有6条配置命令，它们执行的结果分别是：
    public static void test011() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("reset", "reset what");
        hashMap.put("reset board", "board fault");
        hashMap.put("board add", "where to add");
        hashMap.put("board delete", "no board at all");
        hashMap.put("reboot backplane", "impossible");
        hashMap.put("backplane abort", "install first");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String key = scanner.nextLine();
            if (hashMap.containsKey(key)) {   //直接用Map 的 containsKey去匹配指令
                System.out.println(hashMap.get(key));
            } else {
                System.out.println("unknown command");
            }
        }
    }

    //12. 计算日期到天数转换
    public static void test012() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();

            //1.switch是匹配到后才开始，直到break;
            //2.不是月份就一定要对应当天的天数！！！！！
            switch (month) {
                case 12:
                    day += 30;
                case 11:
                    day += 31;
                case 10:
                    day += 30;
                case 9:
                    day += 31;
                case 8:
                    day += 31;
                case 7:
                    day += 30;
                case 6:
                    day += 31;
                case 5:
                    day += 30;
                case 4:
                    day += 31;
                case 3: {
                    if (year % 4 == 0 && year % 100 != 0) {
                        day += 29;  //闰年2月是29天
                    } else
                        day += 28;
                }
                case 2:
                    day += 31;
                case 1:
                    day += 0;   //最后的1 ：才是自己当月的天数
            }
            System.out.println(day);
        }
    }

    //13. 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
    public static void test013() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int maxCount = 0;
            int count = 0;
            int a = scanner.nextInt();
            String b = Integer.toBinaryString(a);
            char[] chars = b.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    count++;
                    maxCount = Math.max(maxCount, count);
                } else {
                    //1中断了
                    count = 0;
                }
            }
            System.out.println(maxCount);
        }
    }

    //14. 统计大写字母个数
    public static void test014() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int count = 0;
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                //字符比较大小，按照ASCII！！！
                if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    count++;
                }
            }
            System.out.println(count);
        }

    }

    //15. 比较2字符串最大相同串的长度
    public static void test015() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            int num = 0;
            for (int i = 0; i < str1.length(); i++) {       //asgxx 从最右往左滑动；外层决定从哪个字符开始
                for (int j = str1.length(); j >= i; j--) {  //内层决定滑动长度
                    String sub = str1.substring(i, j);
                    if (str2.contains(sub)) {
                        if (sub.length() > num) {
                            num = sub.length();
                        }
                    }
                }
            }
            System.out.println(num);
        }
    }

    // 16. 统计每个月兔子的总数？？？  递归算法
    public static void test016() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int month = sc.nextInt();
            System.out.println(result(month));
        }
    }

    static int result(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        return result(i - 1) + result(i - 2);
    }

    //17. 最长左右对称的字符串(回文串)？？？
    public static void test017() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(getPalindrome(s));
        }
    }

    private static int getPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) + "#");
        }
        s = sb.toString();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = sub(s, i, i);
            if (temp.length() > result.length()) result = temp;
        }
        return result.replace("#", "").length();
    }

    private static String sub(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    //18. 参数解析:xcopy /s c:\ d:\？？？  解析后的参数，每个参数都独占一行
    public static void test018() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //为了处理双引号中的字符串
            if (s.charAt(i) == '\"') {
                flag = flag ? false : true;
                continue;
            }
            if (flag == false && ' ' == s.charAt(i)) {
                sb.append("\r\n");
                count++;
                continue;
            }
            sb.append(s.charAt(i));
        }
        System.out.println(count + 1);
        System.out.print(sb.toString());
    }

    //19. 求等差数列前N项和: 等差数列 2，5，8，11，14... ？？？
    public static void test019() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sn = n * 2 + n * (n - 1) * 3 / 2;
            System.out.println(sn);
        }
    }

    //正整数A和正整数B 的最小公倍数是指 =能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
    // 20. 最小公倍数 = A*B/最大公约数 ！！！
    public static void test020() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();

            //利用BigInteger的方法，先求最大公约数！！！
            BigInteger c = a.gcd(b);
            System.out.println(a.multiply(b).divide(c));
        }
    }

    //21. 密码强度等级：并根据不同的得分(长度/字母/数字等)为密码进行安全等级划分。

    public static void test021() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            password = scan.next();
            int score = 0;
            boolean contUNL = cont("[A-Z]") > 0 && cont("[a-z]") > 0, // 包含大写和小写
                    contURL = cont("[A-Z]") > 0 || cont("[a-z]") > 0, // 包含大写或小写
                    contNums = cont("[0-9]") > 1, // 包含多个数字
                    contNum = cont("[0-9]") > 0, // 包含单个数字
                    contSyms = cont("[^A-Za-z0-9]") > 1, // 包含多个符号
                    contSym = cont("[^A-Za-z0-9]") > 0; // 包含单个符号

            // 各项判断
            int len = password.length();
            score += len >= 8 ? 25 : len > 4 ? 10 : 5; // 长度
            score += contUNL ? 20 : contURL ? 10 : 0; // 字母
            score += contNums ? 20 : contNum ? 10 : 0; // 数字
            score += contSyms ? 25 : contSym ? 10 : 0; // 符号

            // 特殊加分
            score += contNum ? ((contUNL && contSym) ? 5 : (contURL && contSym) ? 3 : contURL ? 2 : 0) : 0;

            // 输出等级
            int[] levelsMin = {90, 80, 70, 60, 50, 25, 0};
            String[] levels = {"VERY_SECURE", "SECURE", "VERY_STRONG", "STRONG", "AVERAGE", "WEAK", "VERY_WEAK"};
            for (int i = 0; i < levels.length; i++) {
                if (levelsMin[i] <= score) {
                    System.out.println(levels[i]);
                    break;
                }
            }
        }
        scan.close();
    }

    static String password;

    // 判断字符串是否包含某种字符，返回包含的数量
    private static int cont(String pattern) {
        return password.length() - password.replaceAll(pattern, "").length();
    }

    //22. 三个空汽水瓶可以换一瓶汽水
    public static void test022() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int line = scan.nextInt();
            if (line <= 0) {
                continue;
            }
            int count = 0; //可以换的汽水数
            // a.每次循环就是一次换汽水的行为;
            // b.小于2或等于2就没有机会了！！！
            for (int k = 0; k < line; k++) {
                int result = line / 3; //除以3后的整数
                int i = line % 3;      //除以3后的取余

                count += result;       //可以换的总瓶数

                line = result + i;     //瓶盖总数
                if (line < 2) {
                    break;
                } else if (line == 2) { //2个盖子可以换一瓶
                    count++;
                    break;
                }
            }
            System.out.println(count);
        }

    }

    //23. 计算字符串中含有的不同字符的个数
    public static void test023() {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        Set set = new HashSet();
        for (int i = 0; i < a.length(); i++) {
            char b = a.charAt(i);
            set.add(b);
        }
        System.out.println(set.size());
    }


    //24.验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。？？？
    public static void test024() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            long n = scan.nextInt();
            long v = n * (n - 1) + 1;
            for (int i = 0; i < n; i++) {
                if (i != 0)
                    System.out.print('+');
                System.out.print(v);
                v += 2;
            }
            System.out.println();
        }
    }

    //25.请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路？？？
    public static void test025() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(getResult(n, m));
        }

    }

    public static int getResult(int n, int m) {
        if (m == 0 || n == 0) return 1;
        return getResult(n - 1, m) + getResult(n, m - 1);
    }

    //26. 二维数组 ： 有一个大小的数据表，你会依次进行以下5种操作；1.输入和，初始化大小的表格。2.
    //3.输入X，在第行上方添加一行。 4.输入，在第列左边添加一列  ？？？？
    public static void test026() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();//行
            int n = sc.nextInt();//列
            int[] zuobiao1 = new int[2];
            zuobiao1[0] = sc.nextInt();
            zuobiao1[1] = sc.nextInt();
            int[] zuobiao2 = new int[2];
            zuobiao2[0] = sc.nextInt();
            zuobiao2[1] = sc.nextInt();
            int x = sc.nextInt();//在第x行左边插入一行
            int y = sc.nextInt();//在第y列上方插入一列
            int searchHang = sc.nextInt();
            int searchLie = sc.nextInt();
            //所有输入数据读取完毕
            //1、
            if (m > 9 || n > 9) {
                //初始化表格失败
                System.out.println(-1);
            } else {
                System.out.println(0);
            }
            //2、
            if (zuobiao1[0] < m && zuobiao2[0] < m && zuobiao2[1] < n && zuobiao2[1] < n) {
                //交换单元格成功
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            //3、
            if (x < m && 1 + m <= 9) {
                //插入行成功
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            //4、
            if (y < n && 1 + n <= 9) {
                //插入列成功
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            //5、
            if (searchHang < m && searchLie < n) {
                //查找成功
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }


    //=======中等30========

    //30.Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024
    public static void test030() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String a = scan.nextLine();
            char[] chars = a.toCharArray();

            Arrays.sort(chars);//按照ASCII来排序的！！！！

            System.out.println(new String(chars));
        }
        scan.close();
    }

    //31. 输入一个字符串和一个整数k，截取字符串的前k个字符并输出
    //要满足多组测试，输入类型就得都是 String。。。。
    public static void test031() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b = scan.nextLine();
            int b1 = Integer.parseInt(b);
            if (b1 > 0) {
                System.out.println(a.substring(0, b1)); //0 --> b-1
            }
        }
    }

    //32.查找组成一个偶数最接近的两个素数
    // 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对？？？
    public static void test032() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int b = a / 2;
            while (true) {
                if (testSu(b) && testSu(a - b)) {
                    System.out.println(b);
                    System.out.println(a - b);
                    break;
                } else {
                    b--;
                }
            }
        }
    }

    //判断是否为素数
    static boolean testSu(int tem) {
        //1，2是素数
        if (tem == 1 || tem == 2) {
            return true;
        } else {
            int count = 0;

            //从2开始到n-1，即除去n和1，能被整除的个数
            for (int i = 2; i < tem; i++) {
                if (tem % i == 0) {
                    count++;
                }
            }
            if (count > 0) {
                return false;
            }
            return true;
        }
    }

    // 33. 矩阵乘法：如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
    //【输入描述】：
    //输入包含多组数据，每组数据包含：
    //第一行包含一个正整数x，代表第一个矩阵的行数
    public static void test033() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int[][] arr1 = new int[x][y];
            int[][] arr2 = new int[y][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    arr1[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    arr2[i][j] = sc.nextInt();
                }
            }
            int[][] res = new int[x][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    int sum = 0;
                    for (int k = 0; k < y; k++) {
                        sum += arr1[i][k] * arr2[k][j];
                    }
                    res[i][j] = sum;
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }

        }


    }

    //34.不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
    public static void test034() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String a = scan.nextLine();
            int b = Integer.parseInt(a);
            int count = 0;
            for (int i = 1; i <= b; i++) {
                if (i % 7 == 0 || String.valueOf(i).contains(String.valueOf(7))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    //35.按照从右向左的阅读顺序，返回一个不含重复数字的新的整数 ：9876673-->37689
    public static void test035() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            String b = String.valueOf(a);
            char[] chars = b.toCharArray();
//            Set set = new HashSet();
            List list = new ArrayList();
            String result = "";
            for (int i = chars.length - 1; i >= 0; i--) {
                char c = chars[i];
                if (!list.contains(c)) {
                    list.add(c);
                    result += c;
                }
            }
            System.out.println(result);
        }

    }

    //36.输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
    public static void test036() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String a = scan.nextLine();
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            int count4 = 0;
//            char[] chars = new char[]{'0', '1', '2'}; 字符可以直接比较大小！！！！！
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if ((c > 'A' && c < 'z') || (c > 'a' && c < 'z')) { //英文字符
                    count1++;
                } else if (' ' == c) {                              //空格
                    count2++;
                } else if (c > '0' && c < '9') {                     //数字
                    count3++;
                } else {
                    count4++;
                }
            }
            System.out.println(count1);
            System.out.println(count2);
            System.out.println(count3);
            System.out.println(count4);

        }

    }

    //37. 输入一个String型基因序列，和int型子串的长度,找出GC比例最高的子串？？？
    public static void test037() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String a = scan.next();
            int b = scan.nextInt();
            float ratioMax = 0f;
            float ratio = 0f;
            int count = 0;
            String subMax = "";
            for (int i = 0; i < a.length(); i++) {
                //截取长度为b子串
                String sub = a.substring(0, b);
                if (a.contains(sub)) {
                    //计算G、C的比例
                    for (int j = 0; j < sub.length(); j++) {
                        if (sub.charAt(j) == 'G' || sub.charAt(j) == 'C') {
                            count++;
                        }
                    }
                    if (count > 0) {
                        ratio = count / b;
                    }
                }
                //求最大比例
                if (ratio > ratioMax) {
                    ratioMax = ratio;
                    subMax = sub;
                }
            }
            System.out.println(subMax);
        }
    }


    //38. 蛇形矩阵 输入正整数N（N不大于100),输出一个N行的蛇形矩阵。???
    // 1 3 6 10 15
    //2 5 9 14
    //4 8 13
    //7 12
    //11
    public static void test038() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int max = in.nextInt();
            int init = 1;
            for (int i = 0; i < max; i++) {
                //第一列
                init = init + i;
                System.out.print(init);
                int temp = init;
                for (int j = i + 2; j <= max; j++) {
                    temp = temp + j;
                    System.out.print(" " + temp);
                }
                System.out.print("\n");
            }
        }
    }

    //39.给定n个字符串，请对n个字符串按照字典序排列
    //输入：
    //2
    //cap
    //boat：

    //输出：
    //boat
    //cap
    public static void test039() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            String[] strings = new String[a];
            for (int i = 0; i < a; i++) {
                strings[i] = scan.next();   //不能用nextLine()，得用next()！！！！
            }
            Arrays.sort(strings);           //Arrays.sort()，按照首字母排序
            for (String s : strings) {
                System.out.println(s);
            }
        }
    }

    //40. 高精度整数加法：输入两个用字符串表示的整数，求它们所表示的数之和。
    public static void test040() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b = scan.nextLine();
            BigDecimal bigDecimal = new BigDecimal(a.trim()); //字符串转成bigDecimal
            BigDecimal bigDecima2 = new BigDecimal(b.trim());
            System.out.println(bigDecimal.add(bigDecima2));
        }
    }

    //41.自守数：自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。
    // 请求出n以内的自守数的个数
    public static void test041() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int count = 0;
            for (int i = 0; i <= a; i++) {
                int b = i * i;
                int blen = String.valueOf(b).length();

                String c = String.valueOf(i);
                int clen = c.length();
                if ((b + "").substring(blen - clen).equals(c)) {  //不能用“==”！！！
                    count++;
                }
            }
            System.out.println(count);
        }

    }

    //42.问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利？？？
    public static void test042() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        while (sc.hasNext()) {
            for (int i = 0; i < 4; i++) {
                nums[i] = sc.nextInt();
            }
            List<Double> list = new ArrayList<>();

            for (int num : nums) {
                list.add((double) num);
            }
            System.out.println(dfs(list));
        }
        sc.close();

    }

    private static boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) <= 0.001;
        } else {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < i; j++) {
                    double a = list.get(i), b = list.get(j);
                    List<Double> listCopy = new ArrayList<>(list);
                    List<Double> vals = new ArrayList<>();
                    listCopy.remove(i);
                    listCopy.remove(j);
                    vals.addAll(Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a));

                    for (double val : vals) {
                        listCopy.add(val);
                        if (dfs(listCopy)) return true;
                        listCopy.remove(listCopy.size() - 1);
                    }
                }
            }
            return false;
        }
    }


    //43.合法IP:输入一个IP地址，保证是xx.xx.xx.xx的形式（xx为整数） :一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位
    //输入：
    //10.138.15.1
    //255.0.0.255
    //255.255.255.1000
    //输出：
    //YES
    //YES
    //NO
    public static void test043() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            boolean re = true;
            String[] strings = s.split("\\.");
            if (strings.length < 4) {
                re = false;
            } else {
                for (String s1 : strings) {
                    int i = Integer.parseInt(s1);
                    if (i > 255 || i < 0) {     //二进制的8位最大255
                        re = false;
                        break;
                    }
                    re = true;
                }
            }
            if (re == false) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }


    }


    //44.迷宫问题：输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
    //啥玩意？？
    public static void test044() {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int[][] maze = new int[a][b];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    maze[i][j] = in.nextInt();
                }
            }
            Deque<Integer[]> route = new ArrayDeque<>();
            //返回false说明没有路，但题目规定是有解的
            //从0 0位置左向右进入迷宫
            getRoute(maze, route, 0, 0, "left");
            while (!route.isEmpty()) {
                Integer[] ints = route.pollLast();
                System.out.println("(" + ints[0] + "," + ints[1] + ")");
            }

        }

    }

    private static boolean getRoute(int[][] maze, Deque<Integer[]> route, int i, int j, String from) {
        //出界
        if (i < 0 || j < 0 || i > maze.length - 1 || j > maze[0].length - 1) {
            return false;
        }
        //撞墙
        if (maze[i][j] == 1) {
            return false;
        }
        //没撞墙就记入路线
        route.push(new Integer[]{i, j});
        //到达终点
        if (i == maze.length - 1 && j == maze[0].length - 1) {
            return true;
        }
        //分别往右、下、上、左 四个方向探路，一条路通即可
        //没有判断是否路径是最短的
        boolean goRight = false;
        boolean goDown = false;
        boolean goUp = false;
        boolean goLeft = false;
        if (!"right".equals(from)) {
            goRight = getRoute(maze, route, i, j + 1, "left");
        }
        if (!goRight) {
            if (!"down".equals(from)) {
                goDown = getRoute(maze, route, i + 1, j, "up");
            }
        }
        if (!(goRight || goDown)) {
            if (!"up".equals(from)) {
                goUp = getRoute(maze, route, i - 1, j, "down");
            }
        }
        if (!(goRight || goDown || goUp)) {
            if (!"left".equals(from)) {
                goLeft = getRoute(maze, route, i, j - 1, "right");
            }
        }

        boolean ret = goRight || goDown || goUp || goLeft;
        //如果除了来向的三个去向都不通，死胡同，弹栈除去无效路线，返回
        if (!ret) {
            route.pop();
        }
        //题目的输入都是有解的，所以最终肯定返回true,探路返回false就是此路不通了
        return ret;
    }


    //45.字符串通配符：
    // 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串 ？？？
    // te?t*.*e  txt12.xls  false
    public static void test045() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String p = scanner.nextLine();
            String s = scanner.nextLine().toLowerCase();
            System.out.println(func(p, s));
        }

    }

    public static boolean func(String p, String s) {
        if (p.equals("") && s.equals("")) return true;
        int i = 0, j = 0;
        boolean flag = true;
        char pre = '*';
        while (i < p.length() && j < s.length()) {
            if (p.charAt(i) == '?' || s.charAt(j) == p.charAt(i)) {
                i++;
                j++;
                continue;
            }
            if (p.charAt(i) == '*') {
                if (func(p.substring(i + 1), s.substring(j)))//不匹配
                    return true;
                pre = s.charAt(j);
                while (j < s.length() - 1 && s.charAt(j) == pre) {//匹配多个
                    if (i < p.length() - 1) {
                        if (func(p.substring(i + 1), s.substring(j + 1)))
                            return true;
                    }
                    j++;
                }
                i++;
                if (s.charAt(j) == pre)
                    j++;//确保*是匹配到了相同的字符
                continue;
            }
            if (s.charAt(j) != p.charAt(i)) {
                break;
            }
        }
        if (i != p.length() || j != s.length()) flag = false;
        return flag;
    }


    //46.假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
    public static void test046() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            double s = 0;
            double s1 = 0;
            for (int i = 1; i < 5; i++) {
                s += (a / Math.pow(2, i)) * 2;
            }
            s += a;
            s1 = (double) a / 32;
            System.out.println(s);
            System.out.println(s1);
        }
    }

    //47.字符串排序： 1.英文字母从 A 到 Z 排列，不区分大小写。 2.同一个英文字母的大小写同时存在时，按照输入顺序排列。 ？？？
    // 3.非英文字母的其它字符保持原来的位置
    public static void test047() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            //1.使用list集合，将字符串中a-z，A-Z之间的字符按照排序顺序添加到list集合中。
            List<Character> list = new ArrayList<>();

            for (int i = 'A'; i <= 'Z'; i++) {              //使用双层循环，外层循环负责添加从A到Z
                for (int j = 0; j < str.length(); j++) {    //内层循环遍历字符串。
                    //当字符串中字符是小写a-z或者大写A-Z等价。小写-大写=32
                    if (str.charAt(j) == i || str.charAt(j) == i + 32) {
                        list.add(str.charAt(j));
                    }
                }
            }
            //2.遍历字符串，找到字符不是a-z,A-Z之间的字符。并将该字符插入到list集合对应位置。
            for (int k = 0; k < str.length(); k++) {
                char c = str.charAt(k);
                if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
                    list.add(k, c);
                }
            }
            //3.遍历list集合，使用StringBuilder添加。输出字符串。
            StringBuilder sb = new StringBuilder(str.length());
            for (Character e : list) {
                sb.append(e);
            }
            System.out.println(sb.toString());
        }
    }

    //48.扑克牌大小：输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如 4 4 4 4-joker JOKER。 ？？？
    public static void test048() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("2", 15);
        map.put("joker", 16);
        map.put("JOKER", 17);

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        // 如果字符串包含王炸，直接输出，排除这种情况
        if (str.contains("joker JOKER")) {
            System.out.println("joker JOKER");
        } else {
            String[] strs = str.split("-");
            String[] poker1 = strs[0].split(" ");
            String[] poker2 = strs[1].split(" ");
            int len1 = poker1.length;
            int len2 = poker2.length;
            // 同类型的牌对比，通过总和的大小来对比
            if (len1 == len2) {
                int sum1 = 0;
                int sum2 = 0;
                for (String s1 : poker1) {
                    sum1 += map.get(s1);
                }
                for (String s2 : poker2) {
                    sum2 += map.get(s2);
                }
                System.out.println(sum1 > sum2 ? strs[0] : strs[1]);
                // 不同类型的牌，如果有炸弹输出炸弹，没有则报 ERROR
            } else {
                if (len1 == 4) {
                    System.out.println(strs[0]);
                } else if (len2 == 4) {
                    System.out.println(strs[1]);
                } else {
                    System.out.println("ERROR");
                }
            }
        }
    }

    //49.名字的漂亮度：给出一个名字，该名字有26个字符组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。 ？？？
    public static void test049() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = sc.next();
            }
            for (int i = 0; i < n; i++) {
                String s = strs[i];
                Map<Character, Integer> map = new HashMap();
                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    map.put(ch, map.getOrDefault(ch, 0) + 1);  //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值
                }
                List<Integer> list = new ArrayList();
                for (Map.Entry mapp : map.entrySet()) {
                    list.add((int) mapp.getValue());
                }
                Collections.sort(list);
                int sum = 0;
                int digit = 26;
                for (int j = list.size() - 1; j >= 0; j--) {
                    sum += (int) list.get(j) * digit;
                    digit--;
                }
                System.out.println(sum);
            }

        }


    }


    //50.从单向链表中删除指定值的节点：输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
    //链表的值不能重复。
    public static void test050() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Integer[] ints = new Integer[n * 2];
            for (int i = 0; i < n * 2; i++) {
                ints[i] = in.nextInt();
            }
            LinkedList<Integer> list = new LinkedList<>();
            //头节点
            list.add(ints[0]);
            //依次插入
            for (int i = 1; i < ints.length - 1; i += 2) {
                list.add(list.indexOf(ints[i + 1]) + 1, ints[i]);
            }
            //删除最后出现的
            list.remove(ints[ints.length - 1]);
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    //51. 合并表记录：数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
    public static void test051() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
            int a = sc.nextInt();
            for (int i = 0; i < a; i++) {
                int key = sc.nextInt();
                int val = sc.nextInt();
                map.put(key, map.getOrDefault(key, 0) + val);
            }
            for (Integer item : map.keySet()) {
                System.out.println(item + " " + map.get(item));
            }
        }

    }

    //52.表示数字：将一个字符中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
    //5151--》*5151*
    public static void test052() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < sb.length(); i++) {
                if ('0' <= sb.charAt(i) && sb.charAt(i) <= '9') {
                    sb.insert(i++, '*');
                    while ('0' <= sb.charAt(i) && sb.charAt(i) <= '9') {
                        if (++i >= sb.length()) break;
                    }
                    sb.insert(i++, '*');
                }
            }
            System.out.println(sb);
        }
    }


    //53.进制转换：写出一个程序，接受一个十六进制的数，输出该数值的十进制表示
    public static void test053() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(Integer.valueOf(s.substring(2, s.length()), 16));

        }
    }

    //54.MP3光标位置：MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。
    // 为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
    //现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
    public static void test054() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), k = 4;
            int cur = 1, start = 1, end = Math.max(n, k);
            char[] s = sc.next().toCharArray();
            for (int i = 0; i < s.length; i++) {
                if (s[i] == 'U') {
                    cur--;
                    if (cur == 0) {
                        cur = n;
                        start = Math.max(n - k + 1, 1);
                        end = n;
                    } else {
                        if (cur < start) {
                            start--;
                            end--;
                        }
                    }
                }
                if (s[i] == 'D') {
                    cur++;
                    if (cur == n + 1) {
                        cur = 1;
                        start = 1;
                        end = Math.min(n, k);
                    } else {
                        if (cur > end) {
                            start++;
                            end++;
                        }
                    }
                }
            }
            for (int i = start; i < end; i++)
                System.out.print(i + " ");
            System.out.println(end);
            System.out.println(cur);
        }

    }


    //55.找出字符串中第一个只出现一次的字符
    public static void test055() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            for (int i = 0; i < input.length(); i++) {
                if (input.indexOf(input.charAt(i)) == input.lastIndexOf(input.charAt(i))) {
                    System.out.println(input.charAt(i));
                    break;
                }
                if (i == input.length() - 1) {
                    System.out.println(-1);
                }
            }
        }
        scanner.close();
    }


    //56.求解立方根：计算一个数字的立方根，不使用库函数
    public static void test056() {
        Scanner scan = new Scanner(System.in);
        double h = scan.nextDouble();
        if (h < 0) {
            h = h * -1;
            System.out.print("-");
        }
        double lo = 0.0, hi = 500;

        while (hi - lo > 0.001) {
            double mid = (hi + lo) / 2;
            if (f(mid) < h) lo = mid;
            else hi = mid;
        }
        System.out.printf("%.1f", hi);
    }

    public static double f(double mid) {
        return mid * mid * mid;
    }


    //57.字符统计：输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，
    // 则按照ASCII码由小到大排序输出。
    public static void test058() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            /**
             定义一个数组索引0存空格，48-57存数字，65-90存大写字母，97-122存小写
             也就是下标索引存对应ASC码值得数字
             */
            int[] arr = new int[128];
            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 'a' & chars[i] <= 'z')
                        || (chars[i] >= 'A' & chars[i] <= 'Z') || (chars[i] == ' ')) {
                    arr[chars[i]]++;
                }
            }
            //找出出现次数最多的值
            int max = 0;
            for (int i = 0; i < 128; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            String res = "";
            //因为arr数组是按照对应的ASC码值按索引存放，所以本身就是排序好的，按索引从小到大搜索，最后输出也是有序的
            for (int i = max; i > 0; i--) {
                for (int j = 0; j < 128; j++) {
                    if (arr[j] == i) {
                        res += (char) j;
                    }
                }
            }
            System.out.println(res);
        }
    }

    //59.质数因子：输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
    //最后一个数后面也要有空格
    //按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
    public static void test059() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long n = in.nextLong();
            for (int i = 2; i <= Math.sqrt(n); i++) {
                while (n % i == 0) {
                    System.out.print(i);
                    System.out.print(" ");
                    n /= i;
                }
            }
            if (n > 1) {
                System.out.print(n);
                System.out.print(" ");
            }

        }

    }

    //60.Redraiment的走法：Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。
    // 他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
    public static void test060() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int[] nums = new int[len];
            int[] dp = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = sc.nextInt();
                dp[i] = 1;
            }
            //dp[i]表示以 nums[i] 开始的最长上升序列的长度
            //状态转移方程为：采用从后往前的查找思路，dp[i] = dp[m]+1 (m>i)前提是找到的第一个比它大的sum[m]的dp[m]+1
            int result = 0;
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] < nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                result = Math.max(result, dp[i]);
            }
            System.out.println(result);
        }
    }


    //61.  购物单：王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：
    // 主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子
    public static void test061() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();    // 总钱数
        int m = scanner.nextInt();    // 购买物品个数或物品id
        int[] dp = new int[N + 1];
        // 分组，0为主件，1为附件1，2为附件2
        int[][] price = new int[60][3];    // 物品价格
        int[][] value = new int[60][3];    // 物品价值
        for (int i = 1; i <= m; i++) {
            int p = scanner.nextInt();
            int v = scanner.nextInt();
            int q = scanner.nextInt();
            if (q == 0) {
                price[i][0] = p;
                value[i][0] = p * v;
            }
            //注意q为主件id对应的附件，被这个坑了好长时间
            else if (price[q][1] == 0) {
                price[q][1] = p;
                value[q][1] = p * v;
            } else {
                price[q][2] = p;
                value[q][2] = p * v;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = N; j >= 0 && price[i][0] != 0; j--) {
                if (j >= price[i][0]) {          //主件的情况
                    dp[j] = Math.max(dp[j], dp[j - price[i][0]] + value[i][0]);
                }                            //主件和一个附件的情况
                if (price[i][1] != 0 && j >= price[i][0] + price[i][1]) {
                    dp[j] = Math.max(dp[j], dp[j - price[i][0] - price[i][1]] + value[i][0] + value[i][1]);
                }                            //主件和两个个附件的情况
                if (price[i][2] != 0 && j >= price[i][0] + price[i][1] + price[i][2]) {
                    dp[j] = Math.max(dp[j], dp[j - price[i][0] - price[i][1] - price[i][2]] + value[i][0] + value[i][1] + value[i][2]);
                }
            }
        }
        System.out.println(dp[N]);

    }


    //62.多线程有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，
    // ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
    //输入描述：
    //本题含有多个样例输入。
    //输入一个int整数
    //
    //输出描述：
    //对于每组样例，输出多个ABCD

    private static int NUM = 0;
    private static ReentrantLock LOCK = new ReentrantLock();

    static class WorkThread extends Thread {
        private char c;
        private int time;
        private int n;
        private CountDownLatch cdl;

        public WorkThread(char c, int time, int n, CountDownLatch cdl) {
            this.c = c;
            this.time = time;
            this.n = n;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            while (NUM < n * 4) {
                synchronized (LOCK) {
                    if (NUM % 4 == time) {
                        NUM++;
                        System.out.print(c);
                        LOCK.notifyAll();
                    } else {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
            cdl.countDown();
        }
    }

    public static void test062() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            NUM = 0;
            CountDownLatch cdl = new CountDownLatch(4);
            int n = sc.nextInt();
            for (int i = 0; i < 4; i++) {
                new WorkThread((char) ('A' + i), i, n, cdl).start();
            }

            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(""); //深坑。。。。
        }
        sc.close();
    }

    //63.矩阵乘法计算量估算如：
    //A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
    //计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
    //输入：
    //3
    //50 10
    //10 20
    //20 5
    //(A(BC))
    //复制
    //输出：
    //3500

    private static class Matrix {
        int row;
        int col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void test063() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int num = sc.nextInt();

            Matrix[] matrix = new Matrix[num];
            for (int i = 0; i < num; i++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                matrix[i] = new Matrix(row, col);
            }

//            TestStack<Matrix> st = new TestStack<>();
            String rule = sc.next();

            int i = 0, k = 0;
            int sum = 0;
//            while (i < rule.length()) {
//                if (rule.charAt(i) == '(') ;
//                else if (rule.charAt(i) == ')') {
//                    Matrix m1 = st.pop();
//                    if (!st.isEmpty()) {
//                        Matrix m2 = st.pop();
//                        sum = sum + m2.row * m2.col * m1.col;
//                        Matrix m3 = new Matrix(m2.row, m1.col);
//                        st.push(m3);
//                    } else {
//                        break;
//                    }
//                } else {
//                    st.push(matrix[k++]);
//                }
//                i++;
//            }

            System.out.println(sum);
        }

    }


    ////64.简单密码   大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，
    // 渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
    //输入：
    //YUANzhi1987

    //输出：
    //zvbo9441987

    public static final Map<Integer, String> MAP = new HashMap<>();

    static {
        MAP.put(2, "abc");
        MAP.put(3, "def");
        MAP.put(4, "ghi");
        MAP.put(5, "jkl");
        MAP.put(6, "mno");
        MAP.put(7, "pqrs");
        MAP.put(8, "tuv");
        MAP.put(9, "wxyz");
    }

    public static void test064() {
        Scanner sc = new Scanner(System.in);
        char[] pwds = sc.next().toCharArray();
        String decyptedPwd = "";
        int step = 32;
        for (Character pwd : pwds) {
            //大写字母范围
            if (pwd >= 65 && pwd <= 90) {
                if (pwd + step == 122) {
                    decyptedPwd += "a";
                } else {
                    decyptedPwd += (char) ((pwd + step) + 1);
                }
            } else {
                for (Map.Entry<Integer, String> map : MAP.entrySet()) {
                    if (map.getValue().contains(String.valueOf(pwd))) {
                        decyptedPwd += map.getKey();
                    }
                }
                if (!(pwd >= 97 && pwd <= 122)) {
                    decyptedPwd += pwd;
                }
            }
        }
        System.out.println(decyptedPwd);
    }

    //65.
    public static void test065() {

    }


}
