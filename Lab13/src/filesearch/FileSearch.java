package filesearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
//PSEUDO-CODE
boolean searchForFile(Object file, Object startDir) {
	Object[] fileSystemObjects =
						startDir.getContents();
	for(Object o: fileSystemObjects) {
		//base case
		if(isFile(o) && isSameFile(o,f)) {
			return true;
		}

		if(isDirectory(o)) {
			searchForFile(file, o);
		}
	}
	//file not found in startDir
	return false;
}
*/
public class FileSearch {
	static boolean found = false;
	//Store the text that is found in the
	//file that is found in this String variable
	static String discoveredText = null;
	static String startDirectory = "C:\\testCode";
	static String fileName = "seek.txt";
	public static boolean searchForFile(String filename, String startDir) {
		File ff = new File(startDir);
		File[] o = ff.listFiles();
		for(File obj : o) {
			if(obj.isFile() && obj.getName().equals(filename) ) {
				//System.out.println("file found at " + obj.getAbsolutePath());
				try{FileReader fr = new FileReader(obj.getAbsolutePath());
				BufferedReader bf = new BufferedReader(fr);
				discoveredText = bf.readLine();
				System.out.println(discoveredText);
				}catch(IOException e) {
					System.out.print("Error while reading " + obj.getAbsolutePath());
				}
				//return true;
				
			}
			if(obj.isDirectory()) {
				searchForFile(filename,obj.getAbsolutePath());
			}
		}
		//System.out.println(Arrays.toString(o));
		//implement
		return discoveredText!=null;	
	}
	
public static void main(String[] args) {
	FileSearch fs = new FileSearch();
	//System.out.println(fs.searchForFile(fileName, startDirectory));
}	

}
