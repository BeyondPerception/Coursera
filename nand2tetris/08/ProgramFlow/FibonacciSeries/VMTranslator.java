import java.io.*;
import java.util.*;

public class VMTranslator {

	public static ArrayList<File> getVMFiles(File dir) {

		File[] files = dir.listFiles();

		ArrayList<File> result = new ArrayList<File>();

		for (File f : files) {
			if (f.getName().endsWith(".vm")) {
				result.add(f);
			}

		}
		return result;

	}

	public static void main(String... args) throws Exception {
		String file2 = args[0];

		File fileIn = new File(file2);

		PrintWriter out = null;

		int eqCount = 0;
		int gtCount = 0;
		int ltCount = 0;
		int staticCount = 0;

		ArrayList<File> vmFiles = new ArrayList<File>();

		if (fileIn.isFile()) {

			String path = fileIn.getAbsolutePath();

			vmFiles.add(fileIn);

			out = new PrintWriter(new FileWriter(new File(
					fileIn.getName().substring(0, fileIn.getName().indexOf(".")) + ".asm")
							.getAbsolutePath()));

		} else if (fileIn.isDirectory()) {

			vmFiles = getVMFiles(fileIn);

			out = new PrintWriter(new FileWriter(new File(fileIn.getName() + ".asm")));

		}

		for (File fileEntry : vmFiles) {

			Scanner file = new Scanner(fileEntry);
			String fileName = fileEntry.getName();
			while (file.hasNext()) {
				String line = file.nextLine();
				if (line.startsWith("//")) {
					continue;
				}

				line = line.replaceAll("//+", "");

				String[] arr = line.split(" ");

				if (arr[0].equals("push")) {
					switch (arr[1]) {
						case "constant":
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@SP");
							out.println("A = M");
							out.println("M = D");
							out.println("@SP");
							out.println("M = M + 1");
							break;
						case "local":
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@LCL");
							out.println("M = M + D");
							out.println("A = M");
							out.println("D = M");
							out.println("@SP");
							out.println("A = M");
							out.println("M = D");
							out.println("@SP");
							out.println("M = M + 1");
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@LCL");
							out.println("M = M - D");
							break;
						case "argument":
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@ARG");
							out.println("M = M + D");
							out.println("A = M");
							out.println("D = M");
							out.println("@SP");
							out.println("A = M");
							out.println("M = D");
							out.println("@SP");
							out.println("M = M + 1");
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@ARG");
							out.println("M = M - D");
							break;
						case "this":
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@THIS");
							out.println("M = M + D");
							out.println("A = M");
							out.println("D = M");
							out.println("@SP");
							out.println("A = M");
							out.println("M = D");
							out.println("@SP");
							out.println("M = M + 1");
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@THIS");
							out.println("M = M - D");
							break;
						case "that":
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@THAT");
							out.println("M = M + D");
							out.println("A = M");
							out.println("D = M");
							out.println("@SP");
							out.println("A = M");
							out.println("M = D");
							out.println("@SP");
							out.println("M = M + 1");
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@THAT");
							out.println("M = M - D");
							break;
						case "temp":
							out.println("@" + (5 + Integer.parseInt(arr[2])));
							out.println("D = M");
							out.println("@SP");
							out.println("A = M");
							out.println("M = D");
							out.println("@SP");
							out.println("M = M + 1");
							break;
						case "pointer":
							if (arr[2].equals("0")) {
								out.println("@THIS");
								out.println("D = M");
							} else {
								out.println("@THAT");
								out.println("D = M");
							}
							out.println("@SP");
							out.println("A = M");
							out.println("M = D");
							out.println("@SP");
							out.println("M = M + 1");
							break;
						case "static":
							out.println("@" + fileName + "." + arr[2]);
							out.println("D = M");
							out.println("@SP");
							out.println("A = M");
							out.println("M = D");
							out.println("@SP");
							out.println("M = M + 1");
							break;
					}

				}
				if (arr[0].equals("pop")) {
					switch (arr[1]) {
						case "local":
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@LCL");
							out.println("M = M + D");
							out.println("@SP");
							out.println("M = M - 1");
							out.println("A = M");
							out.println("D = M");
							out.println("@LCL");
							out.println("A = M");
							out.println("M = D");
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@LCL");
							out.println("M = M - D");
							break;
						case "argument":
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@ARG");
							out.println("M = M + D");
							out.println("@SP");
							out.println("M = M - 1");
							out.println("A = M");
							out.println("D = M");
							out.println("@ARG");
							out.println("A = M");
							out.println("M = D");
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@ARG");
							out.println("M = M - D");
							break;
						case "this":
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@THIS");
							out.println("M = M + D");
							out.println("@SP");
							out.println("M = M - 1");
							out.println("A = M");
							out.println("D = M");
							out.println("@THIS");
							out.println("A = M");
							out.println("M = D");
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@THIS");
							out.println("M = M - D");
							break;
						case "that":
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@THAT");
							out.println("M = M + D");
							out.println("@SP");
							out.println("M = M - 1");
							out.println("A = M");
							out.println("D = M");
							out.println("@THAT");
							out.println("A = M");
							out.println("M = D");
							out.println("@" + arr[2]);
							out.println("D = A");
							out.println("@THAT");
							out.println("M = M - D");
							break;
						case "temp":
							out.println("@SP");
							out.println("M = M - 1");
							out.println("A = M");
							out.println("D = M");
							out.println("@" + (5 + Integer.parseInt(arr[2])));
							out.println("M = D");
							break;
						case "pointer":
							out.println("@SP");
							out.println("M = M - 1");
							out.println("A = M");
							out.println("D = M");
							if (arr[2].equals("0")) {
								out.println("@THIS");
								out.println("M = D");
							} else {
								out.println("@THAT");
								out.println("M = D");
							}
							break;
						case "static":
							out.println("@SP");
							out.println("M = M - 1");
							out.println("A = M");
							out.println("D = M");
							out.println("@" + fileName + "." + arr[2]);
							out.println("M = D");
							break;
					}
				}

				if (arr[0].equals("add")) {
					out.println("@SP\r\n" + "A=M\r\n" + "A=A-1\r\n" + "A=A-1\r\n"
							+ "D=M\r\n" + "A=A+1\r\n" + "D=D+M\r\n" + "@SP\r\n"
							+ "M=M-1\r\n" + "M=M-1\r\n" + "A=M\r\n" + "M=D\r\n"
							+ "@SP\r\n" + "M=M+1");

				}

				if (arr[0].equals("sub")) {
					out.println("@SP\r\n" + "A=M\r\n" + "A=A-1\r\n" + "A=A-1\r\n"
							+ "D=M\r\n" + "A=A+1\r\n" + "D=D-M\r\n" + "@SP\r\n"
							+ "M=M-1\r\n" + "M=M-1\r\n" + "A=M\r\n" + "M=D\r\n"
							+ "@SP\r\n" + "M=M+1");

				}

				if (arr[0].equals("neg")) {
					out.println("@SP");
					out.println("A = M");
					out.println("A = A - 1");
					out.println("M = -M");
				}

				if (arr[0].equals("lt")) {
					out.println("@SP");
					out.println("M = M - 1");
					out.println("A = M");
					out.println("D = M");
					out.println("A = A - 1");
					out.println("D = D - M");
					out.println("@LT" + ltCount);
					out.println("D;JGT");
					out.println("@0");
					out.println("D = A");
					out.println("@SP");
					out.println("A = M - 1");
					out.println("M = D");
					out.println("@SKIPLT" + ltCount);
					out.println("0;JMP");
					out.println("(LT" + ltCount + ")");
					out.println("@1");
					out.println("D = A");
					out.println("@SP");
					out.println("A = M - 1");
					out.println("M = -D");
					out.println("(SKIPLT" + ltCount + ")");
					ltCount++;
				}

				if (arr[0].equals("gt")) {
					out.println("@SP");
					out.println("M = M - 1");
					out.println("A = M");
					out.println("D = M");
					out.println("A = A - 1");
					out.println("D = M - D");
					out.println("@GT" + gtCount);
					out.println("D;JGT");
					out.println("@0");
					out.println("D = A");
					out.println("@SP");
					out.println("A = M - 1");
					out.println("M = D");
					out.println("@SKIPGT" + gtCount);
					out.println("0;JMP");
					out.println("(GT" + gtCount + ")");
					out.println("@1");
					out.println("D = A");
					out.println("@SP");
					out.println("A = M - 1");
					out.println("M = -D");
					out.println("(SKIPGT" + gtCount + ")");
					gtCount++;
				}

				if (arr[0].equals("eq")) {
					out.println("@SP");
					out.println("M = M - 1");
					out.println("A = M");
					out.println("D = M");
					out.println("A = A - 1");
					out.println("D = D - M");
					out.println("@EQ" + eqCount);
					out.println("D;JEQ");
					out.println("@0");
					out.println("D = A");
					out.println("@SP");
					out.println("A = M - 1");
					out.println("M = D");
					out.println("@SKIPEQ" + eqCount);
					out.println("0;JMP");
					out.println("(EQ" + eqCount + ")");
					out.println("@1");
					out.println("D = A");
					out.println("@SP");
					out.println("A = M - 1");
					out.println("M = -D");
					out.println("(SKIPEQ" + eqCount + ")");
					eqCount++;
				}

				if (arr[0].equals("not")) {
					out.println("@SP");
					out.println("A = M");
					out.println("A = A - 1");
					out.println("M = !M");
				}

				if (arr[0].equals("and")) {
					out.println("@SP");
					out.println("M = M - 1");
					out.println("A = M");
					out.println("D = M");
					out.println("A = A - 1");
					out.println("M = D&M");
				}

				if (arr[0].equals("or")) {
					out.println("@SP");
					out.println("M = M - 1");
					out.println("A = M");
					out.println("D = M");
					out.println("A = A - 1");
					out.println("M = D|M");
				}

				if (arr[0].equals("label")) {
					out.println("(" + arr[1] + ")");
				}

				if (arr[0].equals("if-goto")) {
					out.println("@SP");
					out.println("M = M - 1");
					out.println("A = M");
					out.println("D = M");
					out.println("@" + arr[1]);
					out.println("D;JGT");
				}
				if (arr[0].equals("goto")) {
					out.println("@" + arr[1]);
					out.println("0;JMP");
				}

			}
			file.close();
		}
		out.close();
	}

}
