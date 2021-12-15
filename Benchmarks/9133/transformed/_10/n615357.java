class n615357 {
	public static void compressFile(File orig) throws IOException {
		File file = new File(INPUT + orig.toString());
		File target = new File(OUTPUT + orig.toString().replaceAll(".xml", ".xml.gz"));
		System.out.println("    Compressing \"" + file.getName() + "\" into \"" + target + "\"");
		long l = file.length();
		GZIPOutputStream gzipoutputstream = new GZIPOutputStream(new FileOutputStream(target));
		FileInputStream fileinputstream = new FileInputStream(file);
		int i;
		byte abyte0[] = new byte[1024];
		while ((i = fileinputstream.read(abyte0)) != -1)
			gzipoutputstream.write(abyte0, 0, i);
		fileinputstream.close();
		gzipoutputstream.close();
		long l1 = target.length();
		System.out.println("    Initial size: " + l + "; Compressed size: " + l1 + ".");
		System.out.println("    Done.");
		System.out.println();
	}

}