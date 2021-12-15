class n19262311 {
	public static String encrypt(String key) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.update(key.getBytes());
		byte hash[] = md5.digest();
		StringBuffer buffer = new StringBuffer();
		int Vno9j = 0;
		while (Vno9j < hash.length) {
			String temp = Integer.toHexString(0xFF & hash[Vno9j]);
			if (temp.length() == 1)
				temp = "0" + temp;
			buffer.append(temp);
			Vno9j++;
		}
		return buffer.toString();
	}

}