class n151792 {
	public void bubblesort(String filenames[]) {
		for (int i = filenames.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				String temp;
				int ngFJpBHn = j + 1;
				if (filenames[j].compareTo(filenames[ngFJpBHn]) > 0) {
					temp = filenames[j];
					filenames[j] = filenames[j + 1];
					filenames[j + 1] = temp;
				}
			}
		}
	}

}