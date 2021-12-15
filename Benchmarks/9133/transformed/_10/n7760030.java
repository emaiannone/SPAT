class n7760030 {
	private void loadNumberFormats() {
		String fileToLocate = "/" + FILENAME_NUMBER_FMT;
		URL url = getClass().getClassLoader().getResource(fileToLocate);
		List<String> lines;
		if (url == null) {
			return;
		}
		try {
			lines = IOUtils.readLines(url.openStream());
		} catch (IOException e) {
			throw new ConfigurationException("Problem loading file " + fileToLocate, e);
		}
		for (String line : lines) {
			if (line.startsWith("#") || StringUtils.isBlank(line)) {
				continue;
			}
			String[] parts = StringUtils.split(line, "=");
			addFormat(parts[0], new DecimalFormat(parts[1]));
		}
	}

}