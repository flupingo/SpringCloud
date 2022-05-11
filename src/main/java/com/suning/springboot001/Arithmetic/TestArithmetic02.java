package com.suning.springboot001.Arithmetic;

import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * 较难+难
 * Created：Jeffrey
 * date   ：2021/7/17 22:12
 */
public class TestArithmetic02 {
    public static void main(String[] args) {


    }

    //1.将真分数分解为埃及分数:分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
    //注：真分数指分子小于分母的分数，分子和分母有可能gcd不为1！
    //如有多个解，请输出任意一个。
    //请注意本题含有多组样例输入！
    public static void test001() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strs = line.split("/");
            int molecular = Integer.parseInt(strs[0]);
            int denominator = Integer.parseInt(strs[1]);
            System.out.println(getEgyptScores(molecular, denominator));
        }
    }

    /**
     * 辗转相除法求最大公约数
     *
     * @param denominator 分母
     * @param molecular   分子
     * @return
     */
    private static int getGcd(int denominator, int molecular) {
        if (molecular == 0) {
            return denominator;
        }
        return getGcd(molecular, denominator % molecular);
    }

    /**
     * 递归获取结果
     *
     * @param molecular   分子
     * @param denominator 分母
     * @return
     */
    private static String getEgyptScores(int molecular, int denominator) {
        if (molecular == 1) {
            return molecular + "/" + denominator;
        }
        int gcd = getGcd(molecular, denominator);
        if (gcd != 1) {
            molecular /= gcd;
            denominator /= gcd;
        }
        // 利用公式 a/b = 1/(q+1) + (a- r)/b*(q+1)  递归处理
        int quotient = denominator / molecular;  //商数
        int remainder = denominator % molecular;  //余数
        return "1/" + (quotient + 1) + "+" + getEgyptScores(molecular - remainder, denominator * (quotient + 1));
    }

    //2.问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，
    // 并且满足每一行、每一列、每一个3X3粗线宫内的数字均含1-9，并且不重复。

    static int[][] grid;
    static boolean[][] rows, cols;
    static boolean[][][] cell;

    public static void test002() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = 9;
            grid = new int[n][n];
            rows = new boolean[n][n];
            cols = new boolean[n][n];
            cell = new boolean[3][3][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                    if (grid[i][j] != 0) {
                        int u = grid[i][j] - 1;
                        rows[i][u] = cols[j][u] = cell[i / 3][j / 3][u] = true;
                    }
                }
            dfs(0, 0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++)
                    System.out.print(grid[i][j] + " ");
                System.out.println(grid[i][n - 1]);
            }
        }
    }

    static boolean dfs(int x, int y) {
        if (y == 9) {
            x++;
            y = 0;
        }
        if (x == 9) return true;
        if (grid[x][y] != 0)
            return dfs(x, y + 1);
        for (int i = 0; i < 9; i++) {
            if (!rows[x][i] && !cols[y][i] && !cell[x / 3][y / 3][i]) {
                grid[x][y] = i + 1;
                rows[x][i] = cols[y][i] = cell[x / 3][y / 3][i] = true;
                if (dfs(x, y + 1)) return true;
                rows[x][i] = cols[y][i] = cell[x / 3][y / 3][i] = false;
                grid[x][y] = 0;
            }
        }
        return false;
    }

    //3. 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，
    // 从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，
    // 如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，
    // 当然密码学会希望你寻找出“最佳方案”。
    //输入描述：
    //输入说明
    //1 输入一个正偶数n
    //2 输入n个整数
    //注意：数据可能有多组

    static int[][] flags = null;
    static int[] g_boy = null;
    static int[] b_girl = null;
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int count = 0;
    static int[] visited = null;

    static boolean isPrime(int d) {
        if (d == 2) return true;
        for (int i = 2; i <= Math.round(Math.sqrt(d)); i++) {
            if (d % i == 0) return false;
        }
        return true;
    }

    static void test003() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            map.clear();
            String line = sc.nextLine();
            int n = Integer.parseInt(line);
            line = sc.nextLine();
            String[] ss = line.split(" ");
            ArrayList<Integer> odd = new ArrayList<>();
            ArrayList<Integer> even = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                try {
                    int _a = Integer.parseInt(ss[i]);
                    if (_a % 2 == 0) {
                        even.add(_a);
                    } else {
                        odd.add(_a);
                    }
                } catch (Exception e) {
                }
            }
            if (odd.size() > even.size()) {
                ArrayList _c = odd;
                odd = even;
                even = _c;
            }//奇的多 交换
            //标志
            flags = new int[odd.size()][even.size()];
            g_boy = new int[even.size()];
            b_girl = new int[odd.size()];
            visited = new int[even.size()];
            Arrays.fill(visited, 0);
//        Arrays.fill(flags, 0);
            Arrays.fill(g_boy, -1);
            Arrays.fill(b_girl, -1);
            for (int i = 0; i < odd.size(); i++) {
                for (int j = 0; j < even.size(); j++) {
                    if (isPrime(odd.get(i) + even.get(j))) {
                        flags[i][j] = 1;
                        if (map.containsKey(i)) {
                            List<Integer> _list = map.get(i);
                            if (_list != null) map.get(i).add(j);
                        } else {
                            ArrayList<Integer> _lst = new ArrayList<>();
                            _lst.add(j);
                            map.put(i, _lst);
                        }
                    }
                }
            }
            List<Map.Entry<Integer, ArrayList<Integer>>> entries = new ArrayList<Map.Entry<Integer, ArrayList<Integer>>>(map.entrySet());
            if (!entries.isEmpty()) Collections.sort(entries, new Comparator<Map.Entry<Integer, ArrayList<Integer>>>() {
                @Override
                public int compare(Map.Entry<Integer, ArrayList<Integer>> o1, Map.Entry<Integer, ArrayList<Integer>> o2) {
                    return Integer.compare(o1.getValue().size(), o2.getValue().size());
                }
            }); //少边的点优先
            //读入数据
            //分两类 girls,boys，少的算boys
            //定义 二维数组 flag[boys][girls.length] 全置false
            //遍历 算出对应的边 置true
            //遍历boy
            //初始化访问状态，用于记录下访问了哪些boy 节点
            count = 0;
            for (Map.Entry<Integer, ArrayList<Integer>> entry : entries) {
                int i = entry.getKey();  //皆为index
                Arrays.fill(visited, 0);
                if (find(i)) {
                    count++;
                }
            }
            System.out.println(count);
            //遍历它的状态 flag[i][x]，若为1且，girl_used[x] 没有占用  ，标上占用 girl_used[x]  g_boy[x]=i  记上它用的是哪个boy
            //若占用了此女孩，将此女孩的g_boy[x]  vis[x]=true, 不能再打这个girl主意，避免死循环。
            //return true;
        }
    }

    static boolean find(int i) {
        ArrayList<Integer> lines = map.get(i);
        for (Integer j : lines) {
            if (visited[j] == 0) { //递归时，没有访问到
                visited[j] = 1;
                if (g_boy[j] == -1) {   //未占用
                    g_boy[j] = i;
                    b_girl[i] = j;
                    return true;
                } else {  //女孩已嫁
                    if (find(g_boy[j])) {
                        g_boy[j] = i;
                        b_girl[i] = j;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void mapAdd(char a, Map<Byte, Integer> map) {
        byte c = (byte) a;
        if (map.containsKey(c)) {
            map.put(c, (map.get(c) + 1));
        } else {
            map.put(c, 1);
        }
    }


    //4.识别有效的IP地址和掩码并进行分类统计: 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
    //输入描述：
    //多行字符串。每行一个IP地址和掩码，用~隔开。
    //输出描述：
    //统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
    public void test004() {
        Scanner scanner = new Scanner(System.in);
        long[][] data = {
                {ipToInt("1.0.0.0"), ipToInt("126.255.255.255")},
                {ipToInt("128.0.0.0"), ipToInt("191.255.255.255")},
                {ipToInt("192.0.0.0"), ipToInt("223.255.255.255")},
                {ipToInt("224.0.0.0"), ipToInt("239.255.255.255")},
                {ipToInt("240.0.0.0"), ipToInt("255.255.255.255")},
        };
        long[][] personal = {
                {ipToInt("10.0.0.0"), ipToInt("10.255.255.255")},
                {ipToInt("172.16.0.0"), ipToInt("172.31.255.255")},
                {ipToInt("192.168.0.0"), ipToInt("192.168.255.255")},
        };

        int[] abcd = new int[5];
        int wrongIp = 0;
        int tmp;
        int personalCount = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] pre = line.split("~");
            long ip = ipToInt(pre[0]);

            if (!validMask(pre[1])) {
                wrongIp++;
            } else {
                if (ip != -1) {
                    for (int i = 0; i < data.length; i++) {
                        if (ip >= data[i][0] && ip <= data[i][1]) {
                            abcd[i]++;
                            break;
                        }
                    }
                } else {
                    wrongIp++;
                }

                for (int i = 0; i < personal.length; i++) {
                    if (ip >= personal[i][0] && ip <= personal[i][1]) {
                        personalCount++;
                        break;
                    }
                }
            }
        }

        System.out.println(abcd[0] + " " + abcd[1] + " " + abcd[2] + " " + abcd[3] + " " + abcd[4] + " " + wrongIp + " " + personalCount);
    }


    public static long ipToInt(String ip) {
        String[] p = ip.split("\\.");
        if (p.length < 4) {
            return -1;
        }
        long result = 0;
        try {
            for (int i = 0; i < 4; i++) {
                long t = Integer.parseInt(p[i]);
                if (t < 0 || t > 255) {
                    return -1;
                }
                result |= (t << (8 * (3 - i)));
            }
        } catch (NumberFormatException ex) {
            return -1;
        }

        return result;
    }

    public static boolean validMask(String mask) {
        long a = 0L;
        long r = ipToInt(mask);

        int m = (int) r;
        if (m == -1) {
            return false;
        }
        while ((m <<= 1) < 0) {
        }

        if (m == 0) {
            return true;
        } else {
            return false;
        }

    }


    //5. 24点运算
    //计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，
    // 本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
    //输入描述：
    //输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
    private static Map<Integer, String> map1 = new HashMap<Integer, String>() {
        {
            put(1, "A");
            put(2, "2");
            put(3, "3");
            put(4, "4");
            put(5, "5");
            put(6, "6");
            put(7, "7");
            put(8, "8");
            put(9, "9");
            // 统一用一个字符存储，后面再替换
            put(10, "T");
            put(11, "J");
            put(12, "Q");
            put(13, "K");
        }
    };

    public void test005() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.contains("joker") || str.contains("JOKER")) {
            System.out.println("ERROR");
        } else {
            // 处理输入，转化成整数数组
            String[] strs = str.split(" ");
            List<Integer> list = new ArrayList<>();
            for (String s : strs) {
                if ("J".equals(s)) {
                    list.add(11);
                } else if ("Q".equals(s)) {
                    list.add(12);
                } else if ("K".equals(s)) {
                    list.add(13);
                } else if ("A".equals(s)) {
                    list.add(1);
                } else {
                    list.add(Integer.parseInt(s));
                }
            }
            boolean flag = false;
            boolean[] used = new boolean[4];
            StringBuilder sb;
            for (int i = 0; i < 4; i++) {
                sb = new StringBuilder(map1.get(list.get(i)));
                used[i] = true;
                if (find(list, 1, sb, list.get(i), used)) {
                    flag = true;
                    break;
                }
                // 回溯
                used[i] = false;
            }
            if (!flag) {
                System.out.println("NONE");
            }
        }
    }

    private static boolean find(List<Integer> list, int cnt, StringBuilder sb, int temp, boolean[] used) {
        if (cnt == 4) {
            if (temp == 24) {
                System.out.println(sb.substring(0).replaceAll("T", "10"));
            }
            return temp == 24;
        }
        for (int j = 0; j < list.size(); j++) {
            if (used[j]) {
                continue;
            }
            used[j] = true;
            int y = list.get(j);
            int len;
            // +，回溯
            sb.append("+").append(map.get(y));
            if (find(list, cnt + 1, sb, temp + y, used)) {
                return true;
            }
            len = sb.length();
            sb.delete(len - 2, len);
            // -
            sb.append("-").append(map.get(y));
            if (find(list, cnt + 1, sb, temp - y, used)) {
                return true;
            }
            len = sb.length();
            sb.delete(len - 2, len);
            // *
            sb.append("*").append(map.get(y));
            if (find(list, cnt + 1, sb, temp * y, used)) {
                return true;
            }
            len = sb.length();
            sb.delete(len - 2, len);
            // /
            if (y != 0) {
                sb.append("/").append(map.get(y));
                if (find(list, cnt + 1, sb, temp / y, used)) {
                    return true;
                }
                len = sb.length();
                sb.delete(len - 2, len);
            }
            // 回溯
            used[j] = false;
        }
        return false;
    }


    //6.单词倒排
    //输入描述：1、构成单词的字符只有26个大写或小写英文字母；
    //2、非构成单词的字符均视为单词间隔符；
    //输入一行以空格来分隔的句子
    //输出描述：
    //输出句子的逆序
    public static void test006() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length - 1; i++) {
            if (!(cs[i] >= 'a' && cs[i] <= 'z' || cs[i] >= 'A' && cs[i] <= 'Z')) {
                cs[i] = 32;
            }
        }
        String[] str2 = String.valueOf(cs).split(" ");
        for (int i = str2.length - 1; i >= 0; i--) {
            System.out.print(str2[i] + " ");
        }
    }

    //7.简单错误记录
    //开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
    //输入描述：
    //每组只包含一个测试用例。一个测试用例包含一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
    //输出描述：
    //将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
    public static void tst007() {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> ll = new LinkedHashMap();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int index = str.lastIndexOf(" ");
            String lineNum = str.substring((index + 1));
            String[] strs = str.substring(0, index).split("\\\\");
            String name = strs[strs.length - 1];
            String key = name + " " + lineNum;
            if (name.length() > 16) {
                key = name.substring(name.length() - 16) + " " + lineNum;
            }
            if (ll.containsKey(key)) {
                ll.put(key, ll.get(key) + 1);
            } else {
                ll.put(key, 1);
            }
        }
        int j = 0;
        for (Map.Entry entry : ll.entrySet()) {
            if (ll.size() > 8) {
                j++;
                if (j > ll.size() - 8) System.out.println(entry.getKey() + " " + entry.getValue());
            } else {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }


    //8. 查找兄弟单词
    //输入描述：
    //先输入单词的个数n，再输入n个单词。 再输入一个单词，为待查找的单词x 最后输入数字k
    //输出描述：
    //输出查找到x的兄弟单词的个数m 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
    public static void test008() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; ++i) {
                strs[i] = sc.next();
            }
            String pattern = sc.next();
            int k = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (match(strs[i], pattern) && !strs[i].equals(pattern))
                    list.add(strs[i]);
            }
            Collections.sort(list);
            System.out.println(list.size());
            if (list.size() != 0 && list.size() >= k)
                System.out.println(list.get(k - 1));
        }
    }

    public static boolean match(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 != l2) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < l2; i++) {
            char ch = s2.charAt(i);
            if (!map.containsKey(ch))
                map.put(ch, 1);
            else
                map.put(ch, map.get(ch) + 1);
        }
        for (int i = 0; i < l1; i++) {
            char ch = s1.charAt(i);
            if (!map.containsKey(ch))
                return false;
            else {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    map.remove(ch);
            }
        }
        return map.size() == 0;
    }


    //9. 火车进站
    //输入描述：
    //有多组测试用例，每一组第一行输入一个正整数N（0
    //输出描述：
    //输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
    public static void test009() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Set<String> set = new TreeSet<>();
            solve(arr, 0, "", new ArrayList<>(), set);
            for (String s : set) {
                System.out.println(s.trim());
            }

        }
        sc.close();
    }

    private static void solve(int[] arr, int index, String res, List<Integer> list, Set<String> set) {
        if (index == arr.length) {
            for (int i = list.size() - 1; i >= 0; i--) {
                res = res + " " + list.get(i);
            }
            set.add(res);
            return;
        }
        while (true) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(arr[index]);
            solve(arr, index + 1, res, tmp, set);
            if (list.size() == 0)
                break;
            res = res + " " + list.remove(list.size() - 1);
        }
    }


    //10 称砝码
    //现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
    //输入描述：
    //输入包含多组测试数据。
    //对于每组测试数据：
    //第一行：n --- 砝码数(范围[1,10])
    //第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
    //第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
    //输出描述：
    //利用给定的砝码可以称出的不同的重量数.
    public static void test010() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m[] = new int[n];
            int x[] = new int[n];
            for (int i = 0; i < n; i++)
                m[i] = in.nextInt();
            for (int i = 0; i < n; i++)
                x[i] = in.nextInt();
            category(n, m, x);
        }
        in.close();
    }

    public static void category(int n, int m[], int x[]) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<Integer>(set);
            for (int j = 0; j <= x[i]; j++) {
                for (int k = 0; k < list.size(); k++) {
                    set.add(list.get(k) + j * m[i]);
                }
            }
        }
        System.out.println(set.size());
    }


    //11.句子逆序:将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
    //所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
    //输入：
    //I am a boy
    //复制
    //输出：
    //boy a am I
    public static void test011() {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine(); //一个包含空格的字符串

        String str[] = str1.split(" ");  //以空格截取分组

        for (int i = 0; i < str.length; i++) {  //倒序遍历
            System.out.print(str[str.length - i - 1] + " ");
        }
    }

    //12. 数组分组 ：输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，输出true；不满足时输出false。
    //本题含有多组样例输入。
    //输入描述：
    //第一行是数据个数，第二行是输入的数据
    //输出描述：
    //返回true或者false
    public static void test012() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int a3 = 0, a5 = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();

                if (a % 5 == 0) {
                    a5 += a;
                } else if (a % 3 == 0) {
                    a3 += a;
                } else {
                    list.add(Math.abs(a));
                }
            }
            for (int i : list) {
                sum += i;
            }
            int target = Math.abs(a5 - a3);
            int diff = sum - target;
            if (diff < 0 || diff % 2 != 0) {
                System.out.println(false);
                continue;
            }
            int neg = (sum - target) / 2;
            Integer[] nums = new Integer[list.size()];
            list.toArray(nums);
            boolean[] dp = new boolean[neg + 1];
            dp[0] = true;
            for (int i : nums) {
                for (int j = neg; j > 0; j--) {
                    if (j >= i) {
                        dp[j] = dp[j - i];
                    }
                }
            }
            System.out.println(dp[neg]);
        }
    }

    //13.输入n个整数，输出其中最小的k个
    //输入描述：
    //第一行输入两个整数n和k
    //第二行输入一个整数数组
    //输出描述：
    //输出一个从小到大排序的整数数组
    public static void test013() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt(); //指定整数的数量
            int k = in.nextInt();
            int[] total = new int[n];
            //初始化
            for (int j = 0; j < n; j++) {
                total[j] = in.nextInt();
            }

            Arrays.sort(total);

            StringBuilder res = new StringBuilder();
            res.append(total[0]);
            for (int i = 1; i < k; i++) {
                res.append(" ");
                res.append(total[i]);
            }
            System.out.println(res);
        }
    }


    //14.整型数组合并：
    //将两个整型数组按照升序合并，并且过滤掉重复数组元素。
    //输出时相邻两数之间没有空格。
    //请注意本题有多组样例。
    //输入描述：
    //输入说明，按下列顺序输入：
    //1 输入第一个数组的个数
    //2 输入第一个数组的数值
    //3 输入第二个数组的个数
    //4 输入第二个数组的数值
    //输出描述：
    //输出合并之后的数组
    public static void test014() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n1 = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n1; i++) {
                set.add(sc.nextInt());
            }
            int n2 = sc.nextInt();
            for (int i = 0; i < n2; i++) {
                set.add(sc.nextInt());
            }
            Object[] res = set.toArray();
            Arrays.sort(res);
            for (int i = 0; i < res.length; i++) {
                System.out.print((int) res[i]);
            }
            System.out.println();
        }
    }


    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int n = sc.nextInt();

                int sn = n * 2 + n * (n - 1) * 3 / 2;


            }


        }
    }


    //15.删除字符串中出现次数最少的字符
    //输入：
    //abcdd
    //aabcddd
    //输出：
    //dd
    //aaddd
    public static void test015() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            char[] arr = str.toCharArray();

            Map<Character, Integer> map = new LinkedHashMap(); //用map存储每个字符的个数 char --> count ！！！

            for (int i = 0; i < arr.length; i++) {
                if (map.keySet().contains(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }
            }
            int min = arr.length;  //最小字符的个数
            for (Integer i : map.values()) {
                if (i < min) {
                    min = i;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (map.get(arr[i]) != min) {   //过滤掉最小字符并输出
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        }
    }


    //15.1 字符串最后一个单词的长度
    //输入：
    //hello nowcoder

    //输出：
    //8
    //说明：
    //最后一个单词为nowcoder，长度为8
    public static void test00001() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String a = in.nextLine();
            int ret = a.substring(a.lastIndexOf(" ") + 1).length();
            System.out.println(ret);
        }
    }


    //16.整数与IP地址间的转换
    //ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
    //一个长整数。
    //输入描述：
    //输入
    //1 输入IP地址
    //2 输入10进制型的IP地址
    //输出描述：
    //输出
    //1 输出转换成10进制的IP地址
    //2 输出转换后的IP地址
    public static void test016() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] ip = scanner.nextLine().split("\\.");
            String binary = "";
            for (String str : ip) {
                String temp = Integer.toBinaryString(Integer.parseInt(str));
                for (int i = temp.length(); i < 8; i++) {
                    temp = "0" + temp;
                }
                binary += temp;
            }
            char[] c = binary.toCharArray();
            System.out.println(toDec(c));
            long in = Long.parseLong(scanner.nextLine());
            String bin = Long.toBinaryString(in);
            for (int i = bin.length(); i < 32; i++) {
                bin = "0" + bin;
            }
            //System.out.println(bin);
            String out = "";
            for (int i = 0; i < 4; i++) {
                out += toDec(bin.substring(i * 8, i * 8 + 8).toCharArray()) + (i == 3 ? "" : ".");
            }
            System.out.println(out);
        }
        scanner.close();
    }

    public static String toDec(char[] in) {
        long out = 0L;
        long one = 1L;
        for (int i = in.length - 1; i >= 0; i--) {
            if (in[i] == '1') out += (one << (in.length - 1 - i));
        }
        return out + "";
    }


    //17.Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
    //如22：twenty two ;  123:one hundred and twenty three。
    //输入描述：
    //输入一个long型整数
    //输出描述：
    //输出相应的英文写法
    public static void test017() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            System.out.println(getResult(input));
        }
    }

    public static String getResult(int input) {
        if (input < 0 || input >= 1000000000) {
            return "error";
        }
        String[] words = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"}; //1-10
        //11-19
        String[] specialWords = new String[]{"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        //10-90
        String[] tenWords = new String[]{"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        //100 100万
        String[] thousandWords = new String[]{"thousand", "million"};

        int thousandIndex = -1;

        StringBuilder resultBuilder = new StringBuilder();
        do {
            int cur = input % 1000;
            StringBuilder builder = new StringBuilder();
            if (cur >= 100) {
                builder.append(words[cur / 100 - 1]).append(" hundred");
                cur %= 100;
                if (cur > 0) {
                    builder.append(" and ");
                }
            }
            if (cur >= 11 && cur <= 19) {
                builder.append(specialWords[cur - 11]);
            } else {
                if (cur >= 10) {
                    builder.append(tenWords[cur / 10 - 1]).append(" ");
                    cur %= 10;
                }
                if (cur > 0) {
                    builder.append(words[cur % 10 - 1]);
                }
            }
            if (thousandIndex == -1) {
                resultBuilder.append(builder);
            } else {
                resultBuilder.insert(0, builder.append(" ").append(thousandWords[thousandIndex]).append(" "));
            }
            thousandIndex++;
        } while ((input /= 1000) > 0);

        return resultBuilder.toString().replaceAll("\\s+", " ");
    }


    //18.字符串字符匹配:判断短字符串中的所有字符是否在长字符串中全部出现。
    //输入：
    //bc
    //abc
    //输出：
    //true
    public static void test018() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String short_string = scanner.nextLine();
            String long_string = scanner.nextLine();
            char[] chars = short_string.toCharArray();
            boolean res = true;
            for (char aChar : chars) {
                if (long_string.indexOf(aChar) == -1) {
                    res = false;
                    break;
                }
            }
            System.out.println(res);
        }
    }


    //19.计算某字母出现次数:写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。
    //不区分大小写，字符串长度小于500。
    //输入：
    //ABCabc
    //A
    //输出：
    //2
    public static void test019() {
        Scanner in = new Scanner(System.in);
        String s1 = "";
        String s2 = "";
        s1 = in.nextLine();
        s2 = in.nextLine();
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            String s = s1.substring(i, i + s2.length());
            if (s2.equalsIgnoreCase(s)) {
                count++;
            }
        }
        System.out.println(count);
    }


    //20.人民币转换: 中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、
    // 捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
    //输入：
    //151121.15
    //10012.02
    //输出：
    //人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
    //人民币壹万零拾贰元贰分
    public static void test020() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String money = sc.next();
            String[] str = money.split("\\.");

            StringBuilder sb = new StringBuilder();
            while (str[0].length() % 4 != 0) {
                str[0] = "0" + str[0];
            }
            for (int i = str[0].length() / 4 - 1, j = 0; i >= 0; i--, j += 4) {
                sb.append(toStr(str[0].substring(j, j + 4), i));
            }

            if (sb.toString().equals("元")) {
                sb = new StringBuilder();
            }

            if (str[1].length() == 0 || str[1].equals("0") || str[1].equals("00")) {
                if (sb.length() != 0) {
                    sb.append("整");
                }
            } else {
                while (str[1].length() % 4 != 0) {
                    str[1] = "0" + str[1];
                }
                str[1] = toStr(str[1], 3).replace("拾", "角");
                while (str[1].startsWith("零")) {
                    str[1] = str[1].substring(1);
                }
                if (!str[1].endsWith("角")) {
                    str[1] = str[1] + "分";
                }
                sb.append(str[1]);
            }


            money = sb.toString();
            if (money.startsWith("零")) {
                money = money.substring(1);
            }
            money = money.replace("壹拾", "拾");

            System.out.println("人民币" + money);
        }
    }

    public static String toStr(String val, int flag) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length(); i++) {
            switch (val.charAt(i)) {
                case '0':
                    sb.append("零");
                    break;
                case '1':
                    sb.append("壹");
                    break;
                case '2':
                    sb.append("贰");
                    break;
                case '3':
                    sb.append("叁");
                    break;
                case '4':
                    sb.append("肆");
                    break;
                case '5':
                    sb.append("伍");
                    break;
                case '6':
                    sb.append("陆");
                    break;
                case '7':
                    sb.append("柒");
                    break;
                case '8':
                    sb.append("捌");
                    break;
                case '9':
                    sb.append("玖");
                    break;
            }
            switch (i) {
                case 0:
                    sb.append("仟");
                    break;
                case 1:
                    sb.append("佰");
                    break;
                case 2:
                    sb.append("拾");
                    break;
            }
        }
        String str = sb.toString();
        str = str.replaceAll("(零.)+", "零");
        while (str.endsWith("零")) {
            str = str.substring(0, str.length() - 1);
        }

        switch (flag) {
            case 0:
                str = str + "元";
                break;
            case 1:
                str = str + "万";
                break;
            case 2:
                str = str + "亿";
                break;
            case 3:
                break;
        }
        return str;
    }


    //21.在字符串中找出连续最长的数字串
    //输入：
    //abcd12345ed125ss123058789
    //a8a72a6a5yy98y65ee1r2
    //输出：
    //123058789,9
    //729865,2
    public static void test021() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            //(1)\d 匹配一个数字字符。等价于 [0-9]  (2)\D 匹配一个非数字字符。等价于 [^0-9]。

            String[] s = str.replaceAll("\\D+", ",").split(",");

            int max = 0;
            //先找到
            for (String ss : s) {
                if (ss.length() > max)
                    max = ss.length();
            }

            //再取出来
            String result_string = "";
            for (String ss : s) {
                if (ss.length() == max)
                    result_string += ss;
            }
            System.out.println(result_string + "," + max);
        }
        scan.close();
    }

    //22.密码截取:他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但
    // 是他们有时会在开始或结束时加入一些无关的字符以防止别国破解
    //输入描述：
    //输入一个字符串
    //输出描述：
    //返回有效密码串的最大长度
    public static void test022() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            int res = getMaxEchoSubstring(s);
            System.out.println(res);
        }
        sc.close();
    }

    private static int getMaxEchoSubstring(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        int max = 0;
        for (int j = 0; j < n + 1; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j || j - 1 == i) {
                    dp[i][j] = true;
                } else if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j - 1)) {
                    dp[i][j] = true;
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }


    //23.字符串分隔：连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
    //长度不是8整数倍的字符串请在后面补数字0，空字符串不处理
    //输入：
    //abc
    //123456789
    //输出：
    //abc00000
    //12345678
    //90000000
    public static void test023() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = new String(sc.nextLine());
            if (s.length() % 8 != 0)
                s = s + "00000000";

            while (s.length() >= 8) {
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }
    }

    //24.密码验证合格程序
    //1.长度超过8位
    //2.包括大小写字母.数字.其它符号,以上四种至少三种
    //3.不能有相同长度大于2的子串重复

    //输入：
    //021Abc9000
    //021Abc9Abc1
    //021ABC9000
    //021$bc9000
    //输出：
    //OK
    //NG
    //NG
    //OK
    public static void test024() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (checkPassword(str)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }

    }


    public static Boolean checkPassword(String str) {
        // 验证长度
        if (str.length() <= 8) return false;
        // 验证包括的字符种类
        int low = 0, up = 0, num = 0, other = 0;
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= 'a' && tmp <= 'z') {
                low = 1;
            } else if (tmp >= 'A' && tmp <= 'Z') {
                up = 1;
            } else if (tmp >= '0' && tmp <= '9') {
                num = 1;
            } else {
                other = 1;
            }
        }
        if (low + up + num + other < 3) return false;
        // 验证是否有长度大于2的子串重复
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 3; j < str.length(); j++) {
                String tmp = str.substring(i, j);
                if (str.substring(j).contains(tmp)) {
                    return false;
                }
            }
        }
        // 以上false都没有出现，返回true
        return true;
    }

    //25.记票统计 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
    //输入：
    //4
    //A B C D
    //8
    //A D E CF A GG A B

    //输出：
    //A : 3
    //B : 1
    //C : 0
    //D : 1
    //Invalid : 3
    public static void test025() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Map<String, Integer> map = new LinkedHashMap<String, Integer>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                map.put(in.next(), 0);
            }
            map.put("Invalid", 0);
            int m = in.nextInt();
            int count = 0;
            for (int i = 0; i < m; i++) {
                String str = in.next();
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put("Invalid", map.get("Invalid") + 1);
                }
            }
            for (String ss : map.keySet()) {
                System.out.println(ss + " : " + map.get(ss));
            }
        }
        in.close();
    }


    //26.记负均正II 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
    //输入：
    //-13
    //-4
    //-7
    //输出：
    //3
    //0.0
    public static void test026() {
        Scanner scan = new Scanner(System.in);
        int index = 0, num = 0;
        int sum = 0;
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            if (n < 0)
                index++;
            else {
                num++;
                sum += n;
            }
        }
        System.out.println(index);
        if (num == 0)
            System.out.println(0.0);
        else {
            double result = (double) sum / num;
            System.out.println(String.format("%.1f", result));

        }
        scan.close();
    }

    //27.字符串加解密、对输入的字符串进行加解密，并输出。
    //2、加密方法为：
    //当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；

    //输入：
    //abcdefg
    //BCDEFGH
    //输出：
    //BCDEFGH
    //abcdefg
    public static void test027() {
        Scanner sc = new Scanner(System.in);
        String before = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String after = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza1234567890";
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            for (int i = 0; i < s1.length(); i++) {
                System.out.print(after.charAt(before.indexOf(s1.charAt(i))));
            }
            System.out.println();
            for (int i = 0; i < s2.length(); i++) {
                System.out.print(before.charAt(after.indexOf(s2.charAt(i))));
            }
            System.out.println();
        }
    }

    //28.输入整型数组和排序标识，对其元素按照升序或降序进行排序
    //输入：
    //8
    //1 2 4 9 3 55 64 25
    //0
    //5
    //1 2 3 4 5
    //1

    //输出：
    //1 2 3 4 9 25 55 64
    //5 4 3 2 1
    public static void test028() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            ArrayList<Integer> list = new ArrayList();
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int t = sc.nextInt();
                list.add(t);
            }
            int flag = sc.nextInt();
            if (flag == 0) {
                Collections.sort(list);
                for (Integer i : list
                ) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            if (flag == 1) {
                Collections.sort(list);
                Collections.reverse(list);
                for (Integer i : list
                ) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    //29.字符串合并处理:对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
    //输入：
    //dec fab
    //复制
    //输出：
    //5D37BF
    public static void test029() {
        Scanner scanner = new Scanner(System.in);
        String base = "00112233445566778899AaBbCcDdEeFf";
        String reve = "084C2A6E195D3B7F";
        while (scanner.hasNextLine()) {
            ArrayList<String> ji = new ArrayList<String>();
            ArrayList<String> ou = new ArrayList<String>();
            String[] input = scanner.nextLine().split(" ");
            char[] in = (input[0] + input[1]).toCharArray();
            for (int i = 0; i < in.length; i++) {
                if (i % 2 == 0) {
                    ou.add(Character.toString(in[i]));
                    continue;
                }
                ji.add(Character.toString(in[i]));
            }
            Collections.sort(ji);
            Collections.sort(ou);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < in.length; i++) {
                if (i % 2 == 0) {
                    if (base.indexOf(ou.get(i / 2)) >= 0) {
                        sb.append(reve.charAt(base.indexOf(ou.get(i / 2)) / 2));
                        continue;
                    }
                    sb.append(ou.get(i / 2));
                } else {
                    if (base.indexOf(ji.get(i / 2)) >= 0) {
                        sb.append(reve.charAt(base.indexOf(ji.get(i / 2)) / 2));
                        continue;
                    }
                    sb.append(ji.get(i / 2));
                }
            }
            System.out.println(sb);
        }
    }

    //30. 合唱队:计算最少出列多少位同学，使得剩下的同学排成合唱队形
    //输入：
    //8
    //186 186 150 200 160 130 197 200

    //输出：
    //4
    public static void test030() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            String[] c = s.split(" ");
            int[] arr = new int[c.length];
            for (int i = c.length - 1; i >= 0; i--) {
                int max = -1;
                for (int j = i + 1; j < c.length; j++) {
                    if (Integer.parseInt(c[i]) > Integer.parseInt(c[j])) {
                        if (max < arr[j] + 1)
                            max = arr[j] + 1;
                    }
                }
                if (max == -1)
                    max = 0;
                arr[i] = max;
            }
            int[] brr = new int[c.length];
            for (int i = 0; i < c.length; i++) {
                int max = -1;
                for (int j = i - 1; j >= 0 && j < i; j--) {
                    if (Integer.parseInt(c[i]) > Integer.parseInt(c[j])) {
                        if (max < brr[j] + 1)
                            max = brr[j] + 1;
                    }
                }
                if (max == -1)
                    max = 0;
                brr[i] = max;
            }
            int max = 0;
            for (int i = 0; i < c.length; i++) {

                if (arr[i] + brr[i] > max)
                    max = arr[i] + brr[i];
            }
            System.out.println(n - max - 1);
        }
    }

    //31.输出单向链表中倒数第k个结点:输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
    //输入：
    //8
    //1 2 3 4 5 6 7 8
    //4
    //复制
    //输出：
    //5

    static class Node<T> {
        T value;
        Node next;

        public T getValue() {
            return value;
        }

        void setValue(T value) {
            this.value = value;
        }

    }

    static class LinkedList<T> {
        Node<T> first;

        LinkedList() {
            this.first = null;
        }

        void addNode(T t) {
            if (this.first == null) {
                this.first = new Node<>();
                this.first.setValue(t);
            } else {
                Node<T> value = new Node<T>();
                value.setValue(t);
                Node current = this.first;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = value;
            }
        }
    }

    public static void test031() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            int num = 0;
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            while (scanner.hasNext()) {
                if (size > 0) {
                    linkedList.addNode(scanner.nextInt());
                    size--;
                } else {
                    num = scanner.nextInt();
                    break;
                }
            }
            Node current = linkedList.first;
            Node order = linkedList.first;
            while (current != null) {
                if (num != 0) {
                    num--;
                } else {
                    order = order.next;
                }
                current = current.next;
            }

            System.out.println(order == null ? 0 : order.value);

        }
    }


    //32.成绩排序:输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩,都按先录入排列在前的规则处理。
    //输入：
    //3
    //0
    //fang 90
    //yang 50
    //ning 70

    //输出：
    //fang 90
    //ning 70
    //yang 50

    static class Student {
        String name;
        int score;

        public Student(String n, int s) {
            this.name = n;
            this.score = s;
        }
    }

    public static void test032() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int order = sc.nextInt();
            Student[] stus = new Student[num];
            for (int i = 0; i < num; i++) {
                stus[i] = new Student((String) sc.next(), sc.nextInt());
            }
            if (order == 0) {
                Arrays.sort(stus, new Comparator<Student>() {
                    public int compare(Student stu1, Student stu2) {
                        if (stu1.score == stu2.score) return 0;
                        else if (stu1.score > stu2.score) return -1;
                        else return 1;
                    }
                });
            } else if (order == 1) {
                Arrays.sort(stus, new Comparator<Student>() {
                    public int compare(Student stu1, Student stu2) {
                        if (stu1.score == stu2.score) return 0;
                        else if (stu1.score < stu2.score) return -1;
                        else return 1;
                    }
                });
            }
            for (Student stu : stus) {
                System.out.println(stu.name + " " + stu.score);
            }
        }
        sc.close();
    }


    //33.坐标移动A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，
    // 并将最终输入结果输出到输出文件里面。
    //输入：
    //A10;S20;W10;D30;X;A1A;B10A11;;A10;
    //输出：
    //10,-10
    public static void test033() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine().toUpperCase();
            String[] strs = str.split(";");
            int[] zb = {0, 0};
            for (String s : strs) {
                if (s.matches("[ADWS]\\d{1,2}")) {
                    int num = Integer.valueOf(s.substring(1));
                    if (s.charAt(0) == 'A') {
                        zb[0] -= num;
                    } else if (s.charAt(0) == 'W') {
                        zb[1] += num;
                    } else if (s.charAt(0) == 'S') {
                        zb[1] -= num;
                    } else if (s.charAt(0) == 'D') {
                        zb[0] += num;
                    }
                }
            }
            System.out.println(zb[0] + "," + zb[1]);
        }
    }


    //34.数据分类处理 :﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；
    // 整数范围为0~0xFFFFFFFF，序列个数不限
    //输入：
    //15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
    //5 6 3 6 3 0
    //复制
    //输出：
    //30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
    public static void test034() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n1 = sc.nextInt();
            int[] arr1 = new int[n1];
            for (int i = 0; i < n1; i++) {
                arr1[i] = sc.nextInt();
            }
            int n2 = sc.nextInt();
            //int[] arr2=new int[n2];
            Set<Integer> set = new TreeSet();
            for (int i = 0; i < n2; i++) {
                set.add(sc.nextInt());
            }
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            int count1 = 0;
            for (int num : set) {
                StringBuilder sb1 = new StringBuilder();
                int count = 0;
                for (int i = 0; i < n1; i++) {
                    if (String.valueOf(arr1[i]).contains(String.valueOf(num))) {
                        count++;
                        sb1.append(i).append(" ").append(arr1[i]).append(" ");
                    }
                }
                if (count == 0) {
                    continue;
                } else {
                    count1++;
                    sum += count;
                    String s = num + " " + count + " " + sb1.toString();
                    sb.append(s);
                }

            }
            System.out.println(2 * (sum + count1) + " " + sb.toString());
        }
    }


    //35.明明的随机数:他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
    // 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
    //输入：
    //3
    //2
    //2
    //1
    //11
    //10
    //20
    //40
    //32
    //67
    //40
    //20
    //89
    //300
    //400
    //15
    //复制
    //输出：
    //1
    //2
    //10
    //15
    //20
    //32
    //40
    //67
    //89
    //300
    //400
    public static void test036() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            Set<Integer> ts = new TreeSet<Integer>();
            int N = sc.nextInt();
            for (int i = 0; i < N; i++)
                ts.add(sc.nextInt());
//             for(int i:ts)
//                 System.out.println(i);
            Iterator<Integer> it = ts.iterator();
            while (it.hasNext())
                System.out.println(it.next());
        }
        sc.close();
    }

    //37.记负均正:首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
    //输入：
    //5
    //1 2 3 4 5
    //复制
    //输出：
    //0 3.0
    public static void test037() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int numFu = 0;
            int numZheng = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                if (t < 0)
                    numFu++;
                if (t > 0) {
                    numZheng++;
                    sum += t;
                }
            }
            System.out.println(numFu + " " + String.format("%.1f", (double) sum / numZheng));
        }
        in.close();
    }


    //38.判断两个IP是否属于同一子网:通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
    //输入描述：
    //多组输入，一组3行，第1行是输入子网掩码、第2，3行是输入两个ip地址
    //
    //输出描述：
    //若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2
    public static void test038() {
        Scanner in = new Scanner(System.in);
        String input;
        while (in.hasNext()) {
            String[] masks = in.nextLine().split("\\.");
            String[] ip1 = in.nextLine().split("\\.");
            String[] ip2 = in.nextLine().split("\\.");
            StringBuilder checkMask = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            int maskElementHasZeroCount = 0;
            boolean valid = true;
            if (masks.length < 4 || ip1.length < 4 || ip2.length < 4) {
                System.out.print("1");
                continue;
            }


            for (int i = 0; i < masks.length; i++) {
                if (Integer.parseInt(masks[i]) < 0 || Integer.parseInt(masks[i]) > 255) {
                    System.out.println("1");
                    valid = false;
                    break;
                } else {

                    String binaryMask = Integer.toBinaryString(Integer.parseInt(masks[i]));
                    if (binaryMask.length() < 8 && binaryMask.contains("0") && binaryMask.length() > 1) {
                        System.out.println("1");
                        valid = false;
                        break;
                    }
                    if (Integer.parseInt(masks[i]) == 1) {
                        System.out.println("1");
                        valid = false;
                        break;
                    } else if (binaryMask.length() == 8) {
                        if (binaryMask.contains("0")) {
                            if (binaryMask.lastIndexOf("0") == binaryMask.indexOf("0") && binaryMask.indexOf("0") == binaryMask.length() - 1) {
                                checkMask.append(1);
                            } else if (binaryMask.lastIndexOf("0") != binaryMask.indexOf("0") && binaryMask.lastIndexOf("0") == binaryMask.length() - 1) {
                                if (!binaryMask.substring(binaryMask.indexOf("0"), binaryMask.lastIndexOf("0")).contains("1")) {
                                    checkMask.append(1);
                                } else {
                                    System.out.println("1");
                                    valid = false;
                                }
                            } else {
                                System.out.println("1");
                                valid = false;
                            }
                        } else {
                            checkMask.append(0);
                        }
                    }
                }
                if (Integer.parseInt(ip1[i]) < 0 || Integer.parseInt(ip1[i]) > 255) {
                    System.out.println("1");
                    valid = false;
                    break;
                }
                if (Integer.parseInt(ip2[i]) < 0 || Integer.parseInt(ip2[i]) > 255) {
                    System.out.println("1");
                    valid = false;
                    break;
                }
            }

            if (checkMask.toString().contains("1")) {
                if (checkMask.toString().indexOf("1") == checkMask.toString().lastIndexOf("1") && checkMask.toString().lastIndexOf("1") != checkMask.length() - 1) {
                    System.out.println("1");
                    continue;
                } else if (checkMask.toString().indexOf("1") != checkMask.toString().lastIndexOf("1") && checkMask.toString().substring(checkMask.toString().indexOf("1"), checkMask.toString().lastIndexOf("1")).contains("0")) {
                    System.out.println("1");
                    continue;
                }
            }

            if (!valid) {
                continue;
            }
            for (int i = 0; i < masks.length; i++) {

                int result1 = Integer.parseInt(ip1[i]) & Integer.parseInt(masks[i]);
                int result2 = Integer.parseInt(ip2[i]) & Integer.parseInt(masks[i]);
                if (result1 == result2) {
                    sb.append("1");
                } else {
                    System.out.println("2");
                    break;
                }
            }
            if (sb.length() == 4 && sb.toString().equals("1111")) {
                System.out.println("0");
            }
        }
    }


}


















