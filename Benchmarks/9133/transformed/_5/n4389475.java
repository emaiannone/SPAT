class n4389475 {
	@Override
	public URLConnection openConnection(URL url) throws IOException {
		if (!url.getProtocol().equals("file")) {
			String name = url.getFile();
			File f;
			if ((name.charAt(0) == '/'))
				f = new File(cacheFolder, (name.substring(1)).replace('/', File.separatorChar));
			else
				f = new File(cacheFolder, (name).replace('/', File.separatorChar));
			if (!f.exists()) {
				File f2 = new File(f.getParentFile(), f.getName() + "-not_found");
				if (!f2.exists()) {
					try {
						f.getParentFile().mkdirs();
						downloadFile(url, f);
					} catch (IOException e) {
						f.delete();
						throw e;
					}
				}
			}
			return f.toURI().toURL().openConnection();
		}
		return super.openConnection(url);
	}

}