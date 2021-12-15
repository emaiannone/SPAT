class n22323688 {
	public String makeLeoNounCall(String noun) {
		String ret = "";
		StringBuffer buf = new StringBuffer();
		try {
			URL url = new URL("http://dict.leo.org" + noun);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(url.openStream(), Charset.forName("ISO8859_1")));
			String inputLine;
			boolean display = false;
			for (; (inputLine = in.readLine()) != null;) {
				if (inputLine.contains("contentholder")) {
					display = true;
				}
				if (display)
					buf.append(inputLine);
			}
			ret = FilterFunctions.findEndTag("<td", buf.toString());
			sleepRandomTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}