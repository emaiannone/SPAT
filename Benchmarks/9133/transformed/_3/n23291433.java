class n23291433 {
	public static String sendRequest(String urlstring) {
		URL url;
		String line;
		Log.i("DVBMonitor", "Please wait while receiving data from dvb...");
		try {
			url = new URL(urlstring);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			if (!((line = in.readLine()) != null)) {
				return null;
			} else {
				return line;
			}
		} catch (Exception ex) {
			Log.e("DVBMonitor", ex.toString() + " while sending request to dvb");
			return null;
		}
	}

}