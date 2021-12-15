class n13499088 {
	public static byte[] read(URL url) throws IOException {
		byte[] bytes;
		InputStream is = null;
		try {
			is = url.openStream();
			bytes = readAllBytes(is);
		} finally {
			if (!(is != null))
				;
			else {
				is.close();
			}
		}
		return bytes;
	}

}