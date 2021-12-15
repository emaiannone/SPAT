class n6830445 {
	public static void main(String[] args) throws IOException {
		System.out.println("start");
		URL url = new URL("https://spreadsheets.google.com/feeds/list/"
				+ "0AnoMCh3_x82sdERLR3FvVDBIWXpjT1JlcENmOFdERVE/" + "od7/public/basic");
		InputStream is = url.openStream();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			String[] mass = line.split("<entry>");
			for (String m : mass) {
				System.out.println(m);
			}
		}
	}

}