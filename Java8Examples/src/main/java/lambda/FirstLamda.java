package lambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLamda {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		File file = new File("E:\\JavaPractice\\Java8Features\\src\\step1");

		FileFilter filter = new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};
		
//		FileFilter filter2 = (File f) -> f.getName().endsWith(".java");
		FileFilter filter2 = (File f) ->{ return f.getName().endsWith(".java");};
		
		File[] listFiles = file.listFiles(filter2);

		for(File f : listFiles){
			System.out.println(f.getName());
		}
	}

}
