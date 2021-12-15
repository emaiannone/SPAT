class n3265819 {
	@Test
	public void testLargePut() throws Throwable {
		int size = CommonParameters.BLOCK_SIZE;
		InputStream is = new FileInputStream(_fileName);
		RepositoryFileOutputStream ostream = new RepositoryFileOutputStream(_nodeName, _putHandle,
				CommonParameters.local);
		int readLen = 0, writeLen = 0;
		byte[] buffer = new byte[CommonParameters.BLOCK_SIZE];
		while ((readLen = is.read(buffer, 0, size)) != -1) {
			ostream.write(buffer, 0, readLen);
			writeLen += readLen;
		}
		ostream.close();
		CCNStats stats = _putHandle.getNetworkManager().getStats();
		Assert.assertEquals(0, stats.getCounter("DeliverInterestFailed"));
	}

}