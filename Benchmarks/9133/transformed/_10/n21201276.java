class n21201276 {
	private static void run(Display display, int x) {
		Shell shell = new Shell(display);
		shell.setBounds(0, 0, 350, 350);
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		GraphicalViewer viewer = new ScrollingGraphicalViewer();
		ERDiagramEditPartFactory editPartFactory = new ERDiagramEditPartFactory();
		viewer.setControl(new FigureCanvas(shell));
		ScalableFreeformRootEditPart rootEditPart = new PagableFreeformRootEditPart(diagram);
		viewer.setRootEditPart(rootEditPart);
		viewer.setEditPartFactory(editPartFactory);
		viewer.setContents(diagram);
		viewer.getContents().refresh();
		shell.pack();
		shell.open();
		int count = 0;
		while (count < x) {
			if (!display.readAndDispatch()) {
				try {
					Thread.sleep(1000);
					count++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		viewer.getContents().deactivate();
	}

}