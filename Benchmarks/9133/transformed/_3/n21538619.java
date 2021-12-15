class n21538619 {
	public static InputStream getInputStream(URL url) throws IOException {
		if (!(url.getProtocol().equals("resource"))) {
			return url.openStream();
		} else {
			Resources res = SpeakReceiver._context.getResources();
			String resname = url.getFile();
			resname = resname.split("\\.[a-z0-9]{3}")[0];
			int id = res.getIdentifier(resname, "raw", "com.l1ghtm4n.text2speech");
			if (id == 0) {
				throw new NotFoundException();
			} else
				return res.openRawResource(id);
		}
	}

}