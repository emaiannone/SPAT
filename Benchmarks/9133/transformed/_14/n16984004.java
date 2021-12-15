class n16984004 {
	public String getContentsFromVariant(SelectedVariant selected) {
		if (null == selected) {
			return null;
		}
		ActivatedVariablePolicy policy = selected.getPolicy();
		Variant variant = selected.getVariant();
		if (null == variant) {
			return null;
		}
		Content content = variant.getContent();
		if (content instanceof EmbeddedContent) {
			EmbeddedContent embedded = (EmbeddedContent) content;
			return embedded.getData();
		} else {
			MarinerURL marinerURL = computeURL((Asset) selected.getOldObject());
			URL url;
			try {
				url = context.getAbsoluteURL(marinerURL);
			} catch (MalformedURLException e) {
				logger.warn("asset-mariner-url-retrieval-error",
						new Object[] { policy.getName(), ((null == marinerURL) ? "" : marinerURL.getExternalForm()) },
						e);
				return null;
			}
			String text = null;
			try {
				if (logger.isDebugEnabled()) {
					logger.debug("Retrieving contents of URL " + url);
				}
				URLConnection connection = url.openConnection();
				int contentLength = connection.getContentLength();
				if (contentLength > 0) {
					String charset = connection.getContentEncoding();
					if (null == charset) {
						charset = "UTF-8";
					}
					InputStreamReader is = new InputStreamReader(connection.getInputStream(), charset);
					BufferedReader br = new BufferedReader(is);
					char[] buf = new char[contentLength];
					int length = br.read(buf, 0, buf.length);
					text = String.copyValueOf(buf, 0, length);
				}
			} catch (IOException e) {
				logger.warn("asset-url-retrieval-error", new Object[] { policy.getName(), url }, e);
			}
			return text;
		}
	}

}