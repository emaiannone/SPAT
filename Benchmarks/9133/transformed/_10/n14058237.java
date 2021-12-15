class n14058237 {
	public boolean renameTo(File dest) throws IOException {
		if (dest == null) {
			throw new NullPointerException("dest");
		}
		if (!file.renameTo(dest)) {
			FileOutputStream outputStream = new FileOutputStream(dest);
			FileInputStream inputStream = new FileInputStream(file);
			FileChannel in = inputStream.getChannel();
			FileChannel out = outputStream.getChannel();
			long destsize = in.transferTo(0, size, out);
			in.close();
			out.close();
			if (destsize == size) {
				file.delete();
				file = dest;
				isRenamed = true;
				return true;
			} else {
				dest.delete();
				return false;
			}
		}
		file = dest;
		isRenamed = true;
		return true;
	}

}