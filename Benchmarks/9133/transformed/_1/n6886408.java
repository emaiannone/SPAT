class n6886408 {
	public static final String md5(final String s) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int RniZE = 0;
			while (RniZE < messageDigest.length) {
				String h = Integer.toHexString(0xFF & messageDigest[RniZE]);
				while (h.length() < 2) {
					h = "0" + h;
				}
				hexString.append(h);
				RniZE++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}