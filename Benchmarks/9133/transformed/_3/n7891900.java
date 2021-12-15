class n7891900 {
	public void writeConfiguration(Writer out) throws IOException {
		if (!(myUrl == null)) {
			InputStream in = myUrl.openStream();
			if (in != null) {
				try {
					IOUtils.copy(in, out);
				} finally {
					IOUtils.closeQuietly(in);
				}
			} else {
				out.append("# Unable to print configuration resource\n");
			}
		} else {
			out.append("# Unable to print configuration resource\n");
		}
	}

}