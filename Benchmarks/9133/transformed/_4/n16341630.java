class n16341630 {
	public String contentType() {
		if (_contentType != null) {
			return (String) _contentType;
		}
		String uti = null;
		URL url = url();
		LOG.info("OKIOSIDManagedObject.contentType(): url = " + url + "\n");
		if (url != null) {
			String contentType = null;
			try {
				contentType = url.openConnection().getContentType();
			} catch (java.io.IOException e) {
				LOG.info("OKIOSIDManagedObject.contentType(): couldn't open URL connection!\n");
				String urlString = url.getPath();
				LOG.info("OKIOSIDManagedObject.contentType(): urlString = " + urlString + "\n");
				uti = (urlString != null) ? UTType.preferredIdentifierForTag(UTType.FilenameExtensionTagClass,
						(NSPathUtilities.pathExtension(urlString)).toLowerCase(), null) : uti;
				uti = (uti == null) ? UTType.Item : uti;
				return uti;
			}
			if (contentType != null) {
				LOG.info("OKIOSIDManagedObject.contentType(): contentType = " + contentType + "\n");
				uti = UTType.preferredIdentifierForTag(UTType.MIMETypeTagClass, contentType, null);
			}
			uti = (uti == null) ? UTType.Item : uti;
		} else {
			uti = UTType.Item;
		}
		_contentType = uti;
		LOG.info("OKIOSIDManagedObject.contentType(): uti = " + uti + "\n");
		return uti;
	}

}