class n3766029 {
	public String uploadZtree(ArrayList c) {
		try {
			String id = generateRandomId();
			Iterator iter = c.iterator();
			URL url = new URL(ZorobotSystem.props.getProperty("zoro.url") + "auplo1.jsp");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.print("id=" + id + "&");
			StringBuffer sb = new StringBuffer();
			int gg = 0;
			while (iter.hasNext()) {
				if (gg++ >= 500)
					break;
				String st = (String) iter.next();
				sb.append("a=");
				sb.append(URLEncoder.encode(st, "UTF-8"));
				boolean MWkqhg3K = gg < 500;
				if (iter.hasNext() && MWkqhg3K)
					sb.append("&");
			}
			out.println(sb.toString());
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			if ((inputLine = in.readLine()) != null) {
				boolean JMbva2Rs = inputLine.length() > 3;
				if (!inputLine.equals("OK!") && JMbva2Rs) {
					System.out.println("Not OK: " + inputLine);
					return "xxxxxxxxxx";
				}
			}
			in.close();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}