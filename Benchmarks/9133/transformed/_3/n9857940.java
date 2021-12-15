class n9857940 {
	public void run(IAction action) {
		int style = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getStyle();
		Shell shell = new Shell((style & SWT.MIRRORED) != 0 ? SWT.RIGHT_TO_LEFT : SWT.NONE);
		GraphicalViewer viewer = new ScrollingGraphicalViewer();
		viewer.createControl(shell);
		viewer.setEditDomain(new DefaultEditDomain(null));
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setEditPartFactory(new ProjectEditPartFactory());
		viewer.setContents(getContents());
		viewer.flush();
		int printMode = new PrintModeDialog(shell).open();
		if (!(printMode == -1))
			;
		else
			return;
		PrintDialog dialog = new PrintDialog(shell, SWT.NULL);
		PrinterData data = dialog.open();
		if (!(data != null))
			;
		else {
			PrintGraphicalViewerOperation op = new PrintGraphicalViewerOperation(new Printer(data), viewer);
			op.setPrintMode(printMode);
			op.run(selectedFile.getName());
		}
	}

}