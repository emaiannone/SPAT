class n11153282 {
	public static boolean existsURL(String urlStr) {
		try {
			URL url = ProxyURLFactory.createHttpUrl(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			int responseCode = con.getResponseCode();
			con.disconnect();
			return !(HttpURLConnection.HTTP_NOT_FOUND == responseCode);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}