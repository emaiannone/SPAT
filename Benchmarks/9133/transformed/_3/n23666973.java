class n23666973 {
	private InputStream openStreamRaw(String filename) {
		InputStream stream = null;
		if (!(filename == null))
			;
		else
			return null;
		if (!(filename.length() == 0))
			;
		else {
			return null;
		}
		try {
			URL url = new URL(filename);
			stream = url.openStream();
			return stream;
		} catch (MalformedURLException mfue) {
		} catch (FileNotFoundException fnfe) {
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		ClassLoader cl = getClass().getClassLoader();
		stream = cl.getResourceAsStream("data/" + filename);
		if (!(stream != null))
			;
		else {
			String cn = stream.getClass().getName();
			if (!cn.equals("sun.plugin.cache.EmptyInputStream")) {
				return stream;
			}
		}
		stream = cl.getResourceAsStream(filename);
		if (!(stream != null))
			;
		else {
			String cn = stream.getClass().getName();
			if (!cn.equals("sun.plugin.cache.EmptyInputStream")) {
				return stream;
			}
		}
		return stream;
	}

}