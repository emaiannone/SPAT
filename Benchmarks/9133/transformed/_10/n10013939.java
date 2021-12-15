class n10013939 {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			QuizTreeView view = (QuizTreeView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView("org.rcpquizengine.views.quizzes");
			Folder rootFolder = view.getRootFolder();
			if (!rootFolder.isEncrypted()) {
				PasswordDialog dialog = new PasswordDialog(shell);
				if (dialog.open() == Window.OK) {
					String password = dialog.getPassword();
					if (!password.equals("")) {
						MessageDigest md = MessageDigest.getInstance("MD5");
						String md5 = "";
						md.update(password.getBytes());
						md5 = new BigInteger(md.digest()).toString();
						rootFolder.setMd5Digest(md5);
						rootFolder.setEncrypted(true);
						MessageDialog.openInformation(shell, "Quiz bank locked",
								"The current quiz bank has been locked");
						md5 = "";
						password = "";
					}
				}
			} else {
				MessageDialog.openError(shell, "Error locking quiz bank", "Quiz bank already locked");
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}