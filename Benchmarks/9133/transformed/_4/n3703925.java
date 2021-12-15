class n3703925 {
	private static MimeType getMimeType(URL url) {
		String mimeTypeString = null;
		String charsetFromWebServer = null;
		String contentType = null;
		InputStream is = null;
		MimeType mimeTypeFromWebServer = null;
		MimeType mimeTypeFromFileSuffix = null;
		MimeType mimeTypeFromMagicNumbers = null;
		String fileSufix = null;
		if (url == null)
			return null;
		try {
			try {
				is = url.openConnection().getInputStream();
				contentType = url.openConnection().getContentType();
			} catch (IOException e) {
			}
			if (contentType != null) {
				StringTokenizer st = new StringTokenizer(contentType, ";");
				mimeTypeString = (st.hasMoreTokens()) ? st.nextToken().toLowerCase() : mimeTypeString;
				charsetFromWebServer = (st.hasMoreTokens()) ? st.nextToken().toLowerCase() : charsetFromWebServer;
				if (charsetFromWebServer != null) {
					st = new StringTokenizer(charsetFromWebServer, "=");
					charsetFromWebServer = null;
					if (st.hasMoreTokens())
						st.nextToken();
					charsetFromWebServer = (st.hasMoreTokens()) ? st.nextToken().toUpperCase() : charsetFromWebServer;
				}
			}
			mimeTypeFromWebServer = mimeString2mimeTypeMap.get(mimeTypeString);
			fileSufix = getFileSufix(url);
			mimeTypeFromFileSuffix = getMimeType(fileSufix);
			mimeTypeFromMagicNumbers = guessTypeUsingMagicNumbers(is, charsetFromWebServer);
		} finally {
			IOUtils.closeQuietly(is);
		}
		return decideBetweenThreeMimeTypes(mimeTypeFromWebServer, mimeTypeFromFileSuffix, mimeTypeFromMagicNumbers);
	}

}