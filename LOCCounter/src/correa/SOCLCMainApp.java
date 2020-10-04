package correa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SOCLCMainApp {

	public static void main(String[] args) throws IOException {
		//Chooser Method for specific Java files
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".java") || f.isDirectory();
			}

			public String getDescription() {
				return "Java Files";
			}
		});

		int r = chooser.showOpenDialog(new JFrame());
		if (r == JFileChooser.APPROVE_OPTION) {
			Reader l = new FileReader(chooser.getSelectedFile());
			Scanner s = new Scanner(chooser.getSelectedFile());
			BufferedReader br = new BufferedReader(l);
			// Number of Lines
			SourceCodeLineCounter soc = new SourceCodeLineCounter();
			String name = chooser.getSelectedFile().getName();
			System.out.println("Number of lines (without comments) of " + name + " is " + soc.getNumberOfLines(br));
			// Number of Control Structures
			String w = "while";
			String f = "for";
			String i = "if";
			int wCount = 0;
			int fCount = 0;
			int iCount = 0;
			while (s.hasNext()) {
				String word = s.next();
				if (word.equals(w)) {
					wCount++;
				}
				if (word.equals(f)) {
					fCount++;
				}
				if (word.equals(i)) {
					iCount++;
				}

			}
			System.out.println("Number of if statements: " + iCount);
			System.out.println("Number of while loops: " + wCount);
			System.out.println("Number of for loops: " + fCount);

		}
		

	}
}
