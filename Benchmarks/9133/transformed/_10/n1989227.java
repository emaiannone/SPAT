class n1989227 {
	public void anular() throws SQLException, ClassNotFoundException, Exception {
		PreparedStatement ms = null;
		Connection conn = null;
		try {
			conn = ToolsBD.getConn();
			conn.setAutoCommit(false);
			String sentencia_delete = "DELETE FROM BZOFRENT " + " WHERE REN_OFANY=? AND REN_OFOFI=? AND REN_OFNUM=?";
			ms = conn.prepareStatement(sentencia_delete);
			ms.setInt(1, anoOficio != null ? Integer.parseInt(anoOficio) : 0);
			ms.setInt(2, oficinaOficio != null ? Integer.parseInt(oficinaOficio) : 0);
			ms.setInt(3, numeroOficio != null ? Integer.parseInt(numeroOficio) : 0);
			int afectados = ms.executeUpdate();
			if (afectados > 0) {
				registroActualizado = true;
			} else {
				registroActualizado = false;
			}
			conn.commit();
		} catch (Exception ex) {
			System.out.println("Error inesperat, no s'ha desat el registre: " + ex.getMessage());
			ex.printStackTrace();
			registroActualizado = false;
			errores.put("",
					"Error inesperat, no s'ha desat el registre" + ": " + ex.getClass() + "->" + ex.getMessage());
			throw new RemoteException("Error inesperat, no s'ha modifcat el registre", ex);
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException sqle) {
				throw new RemoteException("S'ha produ?t un error i no s'han pogut tornar enrere els canvis efectuats",
						sqle);
			}
		} finally {
			ToolsBD.closeConn(conn, ms, null);
		}
	}

}