class n12883117 {
	public PhoneSetImpl(URL url) throws IOException {
        BufferedReader reader;
        String line;
        phonesetMap = new HashMap();
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        line = reader.readLine();
        lineCount += 1;
        while (line != null) {
            if (!line.startsWith("***")) {
                parseAndAdd(line);
            }
            line = reader.readLine();
        }
        reader.close();
    }

}