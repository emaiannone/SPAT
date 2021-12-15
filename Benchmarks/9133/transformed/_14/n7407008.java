class n7407008 {
	public static Image loadImage(String path) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = mainFrame.getClass().getResourceAsStream(path);
		if (null == in)
			throw new RuntimeException("Ressource " + path + " not found");
		try {
			IOUtils.copy(in, out);
			in.close();
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			new RuntimeException("Error reading ressource " + path, e);
		}
		return Toolkit.getDefaultToolkit().createImage(out.toByteArray());
	}

}