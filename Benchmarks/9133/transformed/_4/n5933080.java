class n5933080 {
	public void addUser(String username, String password, String filename) {
		String data = "";
		try {
			open(filename);
			MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(password.getBytes());
			byte[] digest = mdAlgorithm.digest();
			StringBuffer encPasswd = new StringBuffer();
			for (int i = 0; i < digest.length; i++) {
				password = Integer.toHexString(255 & digest[i]);
				password = (password.length() < 2) ? "0" + password : password;
				encPasswd.append(password);
				data = username + " " + encPasswd + "\r\n";
			}
			try {
				long length = file.length();
				file.seek(length);
				file.write(data.getBytes());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			close();
		} catch (NoSuchAlgorithmException ex) {
		}
	}

}