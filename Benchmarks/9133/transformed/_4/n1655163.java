class n1655163 {
	public boolean delwuliao(String pid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pm = null;
		try {
			conn = Pool.getConnection();
			conn.setAutoCommit(false);
			pm = conn.prepareStatement("delete from addwuliao where pid=?");
			pm.setString(1, pid);
			int x = pm.executeUpdate();
			flag = (x == 0) ? false : true;
			conn.commit();
			Pool.close(pm);
			Pool.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			Pool.close(pm);
			Pool.close(conn);
		} finally {
			Pool.close(pm);
			Pool.close(conn);
		}
		return flag;
	}

}