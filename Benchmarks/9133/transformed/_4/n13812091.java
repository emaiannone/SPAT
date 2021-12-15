class n13812091 {
	public static void copyFile(IPath fromFileName, IPath toFileName) throws IOException {
		File fromFile = fromFileName.toFile();
		File toFile = toFileName.toFile();
		if (!fromFile.exists())
			throw new IOException("FileCopy: " + "no such source file: " + fromFileName);
		if (!fromFile.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + fromFileName);
		if (!fromFile.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + fromFileName);
		toFile = (toFile.isDirectory()) ? new File(toFile, fromFile.getName()) : toFile;
		if (toFile.exists()) {
			if (!toFile.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + toFileName);
		} else {
			String parent = toFile.getParent();
			parent = (parent == null) ? System.getProperty("user.dir") : parent;
			File dir = new File(parent);
			if (!dir.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + parent);
			if (dir.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + parent);
			if (!dir.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + parent);
		}
		InputStream from = null;
		OutputStream to = null;
		try {
			from = new BufferedInputStream(new FileInputStream(fromFile));
			to = new BufferedOutputStream(new FileOutputStream(toFile));
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
		} finally {
			if (from != null)
				try {
					from.close();
				} catch (IOException e) {
				}
			if (to != null)
				try {
					to.close();
				} catch (IOException e) {
				}
		}
	}

}