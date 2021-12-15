class n3365610 {
	private HTMLDocument fetchDocument(String urlString) throws MalformedURLException, IOException {
		try {
			HTMLEditorKit kit = new HTMLEditorKit();
			URL url = new URL(urlString);
			doc = (HTMLDocument) kit.createDefaultDocument();
			doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
			URLConnection con = url.openConnection();
			con.setConnectTimeout(5000);
			con.connect();
			Reader reader = new InputStreamReader(con.getInputStream());
			kit.read(reader, doc, 0);
		} catch (BadLocationException e) {
			logger.error(e.getLocalizedMessage());
		}
		return doc;
	}

}