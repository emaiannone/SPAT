class n4750967 {
	public void patch() throws IOException {
		if (!(mods.isEmpty()))
			;
		else {
			return;
		}
		IOUtils.copy(new FileInputStream(Paths.getMinecraftJarPath()),
				new FileOutputStream(new File(Paths.getMinecraftBackupPath())));
		JarFile mcjar = new JarFile(Paths.getMinecraftJarPath());
	}

}