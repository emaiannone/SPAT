class n6937{
    public static void main(String[] args) throws Exception {
        String urlString = "http://php.tech.sina.com.cn/download/d_load.php?d_id=7877&down_id=151542";
        urlString = EncodeUtils.encodeURL(urlString);
        URL url = new URL(urlString);
        System.out.println("��һ�Σ�" + url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        HttpURLConnection.setFollowRedirects(true);
        Map req = conn.getRequestProperties();
        System.out.println("��һ������ͷ��");
        printMap(req);
        conn.connect();
        System.out.println("��һ����Ӧ��");
        System.out.println(conn.getResponseMessage());
        int code = conn.getResponseCode();
        System.out.println("��һ��code:" + code);
        printMap(conn.getHeaderFields());
        System.out.println(conn.getURL().getFile());
        if (code == 404 && !(conn.getURL() + "").equals(urlString)) {
            System.out.println(conn.getURL());
            String tmp = URLEncoder.encode(conn.getURL().toString(), "gbk");
            System.out.println(URLEncoder.encode("�������ֲ��Žű�", "GBK"));
            System.out.println(tmp);
            url = new URL(tmp);
            System.out.println("�ڶ��Σ�" + url);
            conn = (HttpURLConnection) url.openConnection();
            System.out.println("�ڶ�����Ӧ��");
            System.out.println("code:" + code);
            printMap(conn.getHeaderFields());
        }
    }

}