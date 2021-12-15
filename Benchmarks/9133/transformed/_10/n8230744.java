class n8230744 {
	protected void performInsertTest() throws Exception {
		Connection conn = connect();
		User testUser = new User();
		EntityDescriptor ed = repository.getEntityDescriptor(User.class);
		Date now = new Date();
		conn.setAutoCommit(false);
		testUser.setUsername("rednose");
		testUser.setUCreated("dbUtilTest");
		testUser.setUModified("dbUtilTest");
		testUser.setDtCreated(now);
		testUser.setDtModified(now);
		String sql = dbUtil.genInsert(ed, testUser);
		long id = 0;
		Statement st = conn.createStatement();
		System.err.println("Insert: " + sql);
		int rv = st.executeUpdate(sql,
				dbUtil.supportsGeneratedKeyQuery() ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		if (rv > 0) {
			if (dbUtil.supportsGeneratedKeyQuery()) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next())
					id = rs.getLong(1);
			} else {
				id = queryId(ed, now, "dbUtilTest", conn, dbUtil);
			}
			if (id > 0)
				testUser.setId(id);
			else
				rv = 0;
		}
		conn.rollback();
		assertTrue("oups, insert failed?", id != 0);
		System.err.println("successfully created user with id #" + id + " temporarily");
	}

}