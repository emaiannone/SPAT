class n22401746 {
	public String sendRequest(java.lang.String servletName, java.lang.String request) {
		org.jdom.Document retdoc = null;
		String reqxml = "";
		String myurl = java.util.prefs.Preferences.systemRoot().get("serverurl", "");
		String myport = java.util.prefs.Preferences.systemRoot().get("portno", "8080");
		if (this.serverURL == null) {
			newgen.presentation.component.IPAddressPortNoDialog ipdig = new newgen.presentation.component.IPAddressPortNoDialog(
					myurl, myport);
			try {
				java.net.URL codebase = newgen.presentation.NewGenMain.getAppletInstance().getCodeBase();
				if (codebase != null)
					serverURL = codebase.getHost();
				else
					serverURL = "localhost";
			} catch (Exception exp) {
				exp.printStackTrace();
				serverURL = "localhost";
			}
			ipdig.show();
			serverURL = myurl = ipdig.getIPAddress();
			myport = ipdig.getPortNo();
			java.util.prefs.Preferences.systemRoot().put("serverurl", serverURL);
			java.util.prefs.Preferences.systemRoot().put("portno", myport);
			System.out.println(serverURL);
		}
		try {
			System.out.println("http://" + serverURL + ":" + myport + "/newgenlibctxt/" + servletName);
			java.net.URL url = new java.net.URL("http://" + serverURL + ":" + myport + "/newgenlibctxt/" + servletName);
			java.net.URLConnection urlconn = (java.net.URLConnection) url.openConnection();
			urlconn.setDoOutput(true);
			urlconn.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
			String req1xml = request;
			java.io.OutputStream os = urlconn.getOutputStream();
			java.util.zip.CheckedOutputStream cos = new java.util.zip.CheckedOutputStream(os,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream gop = new java.util.zip.GZIPOutputStream(cos);
			java.io.OutputStreamWriter dos = new java.io.OutputStreamWriter(gop, "UTF-8");
			System.out.println(req1xml);
			dos.write(req1xml);
			dos.flush();
			dos.close();
			System.out.println("url conn: " + urlconn.getContentEncoding() + "  " + urlconn.getContentType());
			java.io.InputStream ios = urlconn.getInputStream();
			java.util.zip.CheckedInputStream cis = new java.util.zip.CheckedInputStream(ios,
					new java.util.zip.Adler32());
			java.util.zip.GZIPInputStream gip = new java.util.zip.GZIPInputStream(cis);
			java.io.InputStreamReader br = new java.io.InputStreamReader(gip, "UTF-8");
			retdoc = (new org.jdom.input.SAXBuilder()).build(br);
		} catch (java.net.ConnectException conexp) {
			javax.swing.JOptionPane
					.showMessageDialog(null,
							newgen.presentation.NewGenMain.getAppletInstance().getMyResource()
									.getString("ConnectExceptionMessage"),
							"Critical error", javax.swing.JOptionPane.ERROR_MESSAGE);
		} catch (Exception exp) {
			exp.printStackTrace(System.out);
		}
		System.out.println(reqxml);
		return "";
	}

}