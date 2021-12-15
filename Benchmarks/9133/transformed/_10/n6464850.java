class n6464850 {
	private void exportJar(File root, List<File> list, Manifest manifest) throws Exception {
		FileInputStream fin = null;
		JarOutputStream jarOut = null;
		try {
			jarOut = new JarOutputStream(new FileOutputStream(jarFile), manifest);
			for (int i = 0; i < list.size(); i++) {
				String filename = list.get(i).getAbsolutePath();
				filename = filename.substring(root.getAbsolutePath().length() + 1);
				JarEntry entry = new JarEntry(filename.replace('\\', '/'));
				fin = new FileInputStream(list.get(i));
				jarOut.putNextEntry(entry);
				int read;
				byte[] buf = new byte[4096];
				while ((read = fin.read(buf)) != -1) {
					jarOut.write(buf, 0, read);
				}
				jarOut.closeEntry();
				jarOut.flush();
			}
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (Exception e) {
					ExceptionOperation.operate(e);
				}
			}
			if (jarOut != null) {
				try {
					jarOut.close();
				} catch (Exception e) {
				}
			}
		}
	}

}