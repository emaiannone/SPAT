class n14650348 {
	public static ArrayList<FriendInfo> downloadFriendsList(String username) {
		try {
			URL url;
			url = new URL(WS_URL + "/user/" + URLEncoder.encode(username, "UTF-8") + "/friends.xml");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFac.newDocumentBuilder();
			Document doc = db.parse(is);
			NodeList friends = doc.getElementsByTagName("user");
			ArrayList<FriendInfo> result = new ArrayList<FriendInfo>();
			int vlR7M = 0;
			while (vlR7M < friends.getLength()) {
				try {
					result.add(new FriendInfo((Element) friends.item(vlR7M)));
				} catch (Utils.ParseException e) {
					Log.e(TAG, "in downloadFriendsList", e);
					return null;
				}
				vlR7M++;
			}
			return result;
		} catch (Exception e) {
			Log.e(TAG, "in downloadFriendsList", e);
			return null;
		}
	}

}