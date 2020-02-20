import java.io.*;
import java.util.*;
import java.util.regex.*;

public class JackAnalyzer {

	public static ArrayList<File> getFiles(File dir) {

		File[] files = dir.listFiles();

		ArrayList<File> result = new ArrayList<File>();

		for (File f : files) {
			if (f.getName().endsWith(".jack")) {
				result.add(f);
			}

		}
		return result;

	}

	static Tokenizer tok;
	static PrintWriter pw;
	static PrintWriter pwT;

	public static void main(String... args) throws Exception {
		File fileIn = new File(args[0]);

		ArrayList<File> jackFiles = null;

		String fileOutPath = "", tokenFileOutPath = "";

		File fileOut, tokenFile;

		if (fileIn.isFile()) {
			jackFiles = new ArrayList<>();
			jackFiles.add(fileIn);
		} else if (fileIn.isDirectory()) {
			jackFiles = getFiles(fileIn);
		}

		for (File file : jackFiles) {

			fileOutPath = file.getAbsolutePath().substring(0,
					file.getAbsolutePath().lastIndexOf(".")) + ".xml";
			tokenFileOutPath = file.getAbsolutePath().substring(0,
					file.getAbsolutePath().lastIndexOf(".")) + "T.xml";

			fileOut = new File(fileOutPath);
			tokenFile = new File(tokenFileOutPath);

			tok = new Tokenizer(file);
			pw = new PrintWriter(fileOut);
			pwT = new PrintWriter(tokenFile);

			compileClass();

		}

	}

	private static void compileType() {

		tok.advance();

		boolean isType = false;

		if (tok.tokenType() == Tokenizer.KEYWORD
				&& (tok.keyWord() == Tokenizer.INT || tok.keyWord() == Tokenizer.CHAR
						|| tok.keyWord() == Tokenizer.BOOLEAN)) {
			pw.print("<keyword>" + tok.getToken() + "</keyword>\n");
			pwT.print("<keyword>" + tok.getToken() + "</keyword>\n");
			isType = true;
		}

		if (tok.tokenType() == Tokenizer.IDENTIFIER) {
			pw.print("<identifier>" + tok.tokenType() + "</identifier>\n");
			pwT.print("<identifier>" + tok.tokenType() + "</identifier>\n");
			isType = true;
		}

	}

	public static void compileClass() {

		tok.advance();

		if (tok.tokenType() != Tokenizer.KEYWORD || tok.keyWord() != Tokenizer.CLASS) {

		}

		pw.print("<class>\n");
		pwT.print("<tokens>\n");

		pw.print("<keyword>class</keyword>\n");
		pwT.print("<keyword>class</keyword>\n");

		tok.advance();

		if (tok.tokenType() != Tokenizer.IDENTIFIER) {

		}

		pw.print("<identifier>" + tok.tokenType() + "</identifier>\n");
		pwT.print("<identifier>" + tok.tokenType() + "</identifier>\n");

		requireSymbol('{');

		compileClassVarDec();
		compileSubroutine();

		requireSymbol('}');

		if (tok.hasMoreTokens()) {
			throw new IllegalStateException("Unexpected tokens");
		}

		pwT.print("</tokens>\n");
		pw.print("</class>\n");

		pw.close();
		pwT.close();

	}

	private static void compileClassVarDec() {

		tok.advance();

		if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == '}') {
			tok.pointerBack();
			return;
		}

		if (tok.tokenType() != Tokenizer.KEYWORD) {

		}

		if (tok.keyWord() == Tokenizer.CONSTRUCTOR || tok.keyWord() == Tokenizer.FUNCTION
				|| tok.keyWord() == Tokenizer.METHOD) {
			tok.pointerBack();
			return;
		}

		pw.print("<classVarDec>\n");

		if (tok.keyWord() != Tokenizer.STATIC && tok.keyWord() != Tokenizer.FIELD) {

		}

		pw.print("<keyword>" + tok.getToken() + "</keyword>\n");
		pwT.print("<keyword>" + tok.getToken() + "</keyword>\n");

		compileType();

		do {

			tok.advance();
			if (tok.tokenType() != Tokenizer.IDENTIFIER) {

			}

			pw.print("<identifier>" + tok.identifier() + "</identifier>\n");
			pwT.print("<identifier>" + tok.identifier() + "</identifier>\n");

			tok.advance();

			if (tok.tokenType() != Tokenizer.SYMBOL
					|| (tok.symbol() != ',' && tok.symbol() != ';')) {

			}

			if (tok.symbol() == ',') {

				pw.print("<symbol>,</symbol>\n");
				pwT.print("<symbol>,</symbol>\n");

			} else {

				pw.print("<symbol>;</symbol>\n");
				pwT.print("<symbol>;</symbol>\n");
				break;
			}

		} while (true);

		pw.print("</classVarDec>\n");

		compileClassVarDec();
	}

	private static void compileSubroutine() {

		tok.advance();

		if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == '}') {
			tok.pointerBack();
			return;
		}

		if (tok.tokenType() != Tokenizer.KEYWORD
				|| (tok.keyWord() != Tokenizer.CONSTRUCTOR
						&& tok.keyWord() != Tokenizer.FUNCTION
						&& tok.keyWord() != Tokenizer.METHOD)) {

		}

		pw.print("<subroutineDec>\n");

		pw.print("<keyword>" + tok.getToken() + "</keyword>\n");
		pwT.print("<keyword>" + tok.getToken() + "</keyword>\n");

		tok.advance();
		if (tok.tokenType() == Tokenizer.KEYWORD && tok.keyWord() == Tokenizer.VOID) {
			pw.print("<keyword>void</keyword>\n");
			pwT.print("<keyword>void</keyword>\n");
		} else {
			tok.pointerBack();
			compileType();
		}

		tok.advance();
		if (tok.tokenType() != Tokenizer.IDENTIFIER) {

		}

		pw.print("<identifier>" + tok.identifier() + "</identifier>\n");
		pwT.print("<identifier>" + tok.identifier() + "</identifier>\n");

		requireSymbol('(');

		pw.print("<parameterList>\n");
		compileParameterList();
		pw.print("</parameterList>\n");

		requireSymbol(')');

		compileSubroutineBody();

		pw.print("</subroutineDec>\n");

		compileSubroutine();

	}

	private static void compileSubroutineBody() {
		pw.print("<subroutineBody>\n");
		requireSymbol('{');
		compileVarDec();
		pw.print("<statements>\n");
		compileStatement();
		pw.print("</statements>\n");
		requireSymbol('}');
		pw.print("</subroutineBody>\n");
	}

	private static void compileStatement() {

		tok.advance();

		if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == '}') {
			tok.pointerBack();
			return;
		}

		if (tok.tokenType() != Tokenizer.KEYWORD) {

		} else {
			switch (tok.keyWord()) {
				case Tokenizer.LET:
					compileLet();
					break;
				case Tokenizer.IF:
					compileIf();
					break;
				case Tokenizer.WHILE:
					compilesWhile();
					break;
				case Tokenizer.DO:
					compileDo();
					break;
				case Tokenizer.RETURN:
					compileReturn();
					break;
				default:

			}
		}

		compileStatement();
	}

	private static void compileParameterList() {

		tok.advance();
		if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == ')') {
			tok.pointerBack();
			return;
		}

		tok.pointerBack();
		do {
			compileType();

			tok.advance();
			if (tok.tokenType() != Tokenizer.IDENTIFIER) {

			}
			pw.print("<identifier>" + tok.identifier() + "</identifier>\n");
			pwT.print("<identifier>" + tok.identifier() + "</identifier>\n");

			tok.advance();
			if (tok.tokenType() != Tokenizer.SYMBOL
					|| (tok.symbol() != ',' && tok.symbol() != ')')) {

			}

			if (tok.symbol() == ',') {
				pw.print("<symbol>,</symbol>\n");
				pwT.print("<symbol>,</symbol>\n");
			} else {
				tok.pointerBack();
				break;
			}

		} while (true);

	}

	private static void compileVarDec() {

		tok.advance();
		if (tok.tokenType() != Tokenizer.KEYWORD || tok.keyWord() != Tokenizer.VAR) {
			tok.pointerBack();
			return;
		}

		pw.print("<varDec>\n");

		pw.print("<keyword>var</keyword>\n");
		pwT.print("<keyword>var</keyword>\n");

		compileType();

		boolean varNamesDone = false;

		do {

			tok.advance();

			if (tok.tokenType() != Tokenizer.IDENTIFIER) {

			}

			pw.print("<identifier>" + tok.identifier() + "</identifier>\n");
			pwT.print("<identifier>" + tok.identifier() + "</identifier>\n");

			tok.advance();

			if (tok.tokenType() != Tokenizer.SYMBOL
					|| (tok.symbol() != ',' && tok.symbol() != ';')) {

			}

			if (tok.symbol() == ',') {

				pw.print("<symbol>,</symbol>\n");
				pwT.print("<symbol>,</symbol>\n");

			} else {

				pw.print("<symbol>;</symbol>\n");
				pwT.print("<symbol>;</symbol>\n");
				break;
			}

		} while (true);

		pw.print("</varDec>\n");

		compileVarDec();

	}

	private static void compileDo() {
		pw.print("<doStatement>\n");

		pw.print("<keyword>do</keyword>\n");
		pwT.print("<keyword>do</keyword>\n");
		compileSubroutineCall();

		requireSymbol(';');

		pw.print("</doStatement>\n");
	}

	private static void compileLet() {

		pw.print("<letStatement>\n");

		pw.print("<keyword>let</keyword>\n");
		pwT.print("<keyword>let</keyword>\n");

		tok.advance();
		if (tok.tokenType() != Tokenizer.IDENTIFIER) {
		}

		pw.print("<identifier>" + tok.identifier() + "</identifier>\n");
		pwT.print("<identifier>" + tok.identifier() + "</identifier>\n");

		tok.advance();
		if (tok.tokenType() != Tokenizer.SYMBOL
				|| (tok.symbol() != '[' && tok.symbol() != '=')) {
		}

		boolean expExist = false;

		if (tok.symbol() == '[') {

			expExist = true;

			pw.print("<symbol>[</symbol>\n");
			pwT.print("<symbol>[</symbol>\n");

			compileExpression();

			tok.advance();
			if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == ']') {
				pw.print("<symbol>]</symbol>\n");
				pwT.print("<symbol>]</symbol>\n");
			} else {
			}
		}

		if (expExist)
			tok.advance();

		pw.print("<symbol>=</symbol>\n");
		pwT.print("<symbol>=</symbol>\n");

		compileExpression();

		requireSymbol(';');

		pw.print("</letStatement>\n");
	}

	private static void compilesWhile() {
		pw.print("<whileStatement>\n");

		pw.print("<keyword>while</keyword>\n");
		pwT.print("<keyword>while</keyword>\n");
		requireSymbol('(');
		compileExpression();

		requireSymbol(')');
		requireSymbol('{');

		pw.print("<statements>\n");
		compileStatement();
		pw.print("</statements>\n");
		requireSymbol('}');

		pw.print("</whileStatement>\n");
	}

	private static void compileReturn() {
		pw.print("<returnStatement>\n");

		pw.print("<keyword>return</keyword>\n");
		pwT.print("<keyword>return</keyword>\n");

		tok.advance();
		if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == ';') {
			pw.print("<symbol>;</symbol>\n");
			pwT.print("<symbol>;</symbol>\n");
			pw.print("</returnStatement>\n");
			return;
		}

		tok.pointerBack();
		compileExpression();
		requireSymbol(';');

		pw.print("</returnStatement>\n");
	}

	private static void compileIf() {
		pw.print("<ifStatement>\n");

		pw.print("<keyword>if</keyword>\n");
		pwT.print("<keyword>if</keyword>\n");
		requireSymbol('(');
		compileExpression();

		requireSymbol(')');
		requireSymbol('{');
		pw.print("<statements>\n");
		compileStatement();
		pw.print("</statements>\n");
		requireSymbol('}');

		tok.advance();
		if (tok.tokenType() == Tokenizer.KEYWORD && tok.keyWord() == Tokenizer.ELSE) {
			pw.print("<keyword>else</keyword>\n");
			pwT.print("<keyword>else</keyword>\n");
			requireSymbol('{');
			pw.print("<statements>\n");
			compileStatement();
			pw.print("</statements>\n");

			requireSymbol('}');
		} else {
			tok.pointerBack();
		}

		pw.print("</ifStatement>\n");

	}

	private static void compileTerm() {

		pw.print("<term>\n");

		tok.advance();
		if (tok.tokenType() == Tokenizer.IDENTIFIER) {
			String tempId = tok.identifier();

			tok.advance();
			if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == '[') {
				pw.print("<identifier>" + tempId + "</identifier>\n");
				pwT.print("<identifier>" + tempId + "</identifier>\n");
				pw.print("<symbol>[</symbol>\n");
				pwT.print("<symbol>[</symbol>\n");
				compileExpression();

				requireSymbol(']');
			} else if (tok.tokenType() == Tokenizer.SYMBOL
					&& (tok.symbol() == '(' || tok.symbol() == '.')) {
				tok.pointerBack();
				tok.pointerBack();
				compileSubroutineCall();
			} else {
				pw.print("<identifier>" + tempId + "</identifier>\n");
				pwT.print("<identifier>" + tempId + "</identifier>\n");
				tok.pointerBack();
			}

		} else {

			if (tok.tokenType() == Tokenizer.INT_CONST) {
				pw.print("<integerConstant>" + tok.intVal() + "</integerConstant>\n");
				pwT.print("<integerConstant>" + tok.intVal() + "</integerConstant>\n");
			} else if (tok.tokenType() == Tokenizer.STRING_CONST) {
				pw.print("<stringConstant>" + tok.stringVal() + "</stringConstant>\n");
				pwT.print("<stringConstant>" + tok.stringVal() + "</stringConstant>\n");
			} else if (tok.tokenType() == Tokenizer.KEYWORD
					&& (tok.keyWord() == Tokenizer.TRUE
							|| tok.keyWord() == Tokenizer.FALSE
							|| tok.keyWord() == Tokenizer.NULL
							|| tok.keyWord() == Tokenizer.THIS)) {
				pw.print("<keyword>" + tok.getToken() + "</keyword>\n");
				pwT.print("<keyword>" + tok.getToken() + "</keyword>\n");
			} else if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == '(') {
				pw.print("<symbol>(</symbol>\n");
				pwT.print("<symbol>(</symbol>\n");

				compileExpression();

				requireSymbol(')');
			} else if (tok.tokenType() == Tokenizer.SYMBOL
					&& (tok.symbol() == '-' || tok.symbol() == '~')) {
				pw.print("<symbol>" + tok.symbol() + "</symbol>\n");
				pwT.print("<symbol>" + tok.symbol() + "</symbol>\n");
				compileTerm();
			} else {
			}
		}

		pw.print("</term>\n");
	}

	private static void compileSubroutineCall() {

		tok.advance();
		if (tok.tokenType() != Tokenizer.IDENTIFIER) {
		}

		pw.print("<identifier>" + tok.identifier() + "</identifier>\n");
		pwT.print("<identifier>" + tok.identifier() + "</identifier>\n");

		tok.advance();
		if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == '(') {
			pw.print("<symbol>(</symbol>\n");
			pwT.print("<symbol>(</symbol>\n");
			pw.print("<expressionList>\n");
			compileExpressionList();
			pw.print("</expressionList>\n");
			requireSymbol(')');
		} else if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == '.') {
			pw.print("<symbol>.</symbol>\n");
			pwT.print("<symbol>.</symbol>\n");
			tok.advance();
			if (tok.tokenType() != Tokenizer.IDENTIFIER) {
			}
			pw.print("<identifier>" + tok.identifier() + "</identifier>\n");
			pwT.print("<identifier>" + tok.identifier() + "</identifier>\n");
			requireSymbol('(');
			pw.print("<expressionList>\n");
			compileExpressionList();
			pw.print("</expressionList>\n");
			requireSymbol(')');
		} else {
		}
	}

	private static void compileExpression() {
		pw.print("<expression>\n");

		compileTerm();
		do {
			tok.advance();
			if (tok.tokenType() == Tokenizer.SYMBOL && tok.isOp()) {
				if (tok.symbol() == '>') {
					pw.print("<symbol>&gt;</symbol>\n");
					pwT.print("<symbol>&gt;</symbol>\n");
				} else if (tok.symbol() == '<') {
					pw.print("<symbol>&lt;</symbol>\n");
					pwT.print("<symbol>&lt;</symbol>\n");
				} else if (tok.symbol() == '&') {
					pw.print("<symbol>&amp;</symbol>\n");
					pwT.print("<symbol>&amp;</symbol>\n");
				} else {
					pw.print("<symbol>" + tok.symbol() + "</symbol>\n");
					pwT.print("<symbol>" + tok.symbol() + "</symbol>\n");
				}
				compileTerm();
			} else {
				tok.pointerBack();
				break;
			}

		} while (true);

		pw.print("</expression>\n");
	}

	private static void compileExpressionList() {
		tok.advance();
		if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == ')') {
			tok.pointerBack();
		} else {

			tok.pointerBack();
			compileExpression();
			do {
				tok.advance();
				if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == ',') {
					pw.print("<symbol>,</symbol>\n");
					pwT.print("<symbol>,</symbol>\n");
					compileExpression();
				} else {
					tok.pointerBack();
					break;
				}

			} while (true);

		}
	}

	private static void requireSymbol(char symbol) {
		tok.advance();
		if (tok.tokenType() == Tokenizer.SYMBOL && tok.symbol() == symbol) {
			pw.print("<symbol>" + symbol + "</symbol>\n");
			pwT.print("<symbol>" + symbol + "</symbol>\n");
		} else {

		}
	}

}

class Tokenizer {

	public final static int KEYWORD = 1;
	public final static int SYMBOL = 2;
	public final static int IDENTIFIER = 3;
	public final static int INT_CONST = 4;
	public final static int STRING_CONST = 5;

	public final static int CLASS = 10;
	public final static int METHOD = 11;
	public final static int FUNCTION = 12;
	public final static int CONSTRUCTOR = 13;
	public final static int INT = 14;
	public final static int BOOLEAN = 15;
	public final static int CHAR = 16;
	public final static int VOID = 17;
	public final static int VAR = 18;
	public final static int STATIC = 19;
	public final static int FIELD = 20;
	public final static int LET = 21;
	public final static int DO = 22;
	public final static int IF = 23;
	public final static int ELSE = 24;
	public final static int WHILE = 25;
	public final static int RETURN = 26;
	public final static int TRUE = 27;
	public final static int FALSE = 28;
	public final static int NULL = 29;
	public final static int THIS = 30;

	private Scanner scanner;
	private String currentToken;
	private int currentTokenType;
	private int pointer;
	private ArrayList<String> tokens;

	private static Pattern tokenPatterns;
	private static String keyWordReg;
	private static String symbolReg;
	private static String intReg;
	private static String strReg;
	private static String idReg;

	private static HashMap<String, Integer> keyWordMap = new HashMap<String, Integer>();
	private static HashSet<Character> opSet = new HashSet<Character>();

	static {

		keyWordMap.put("class", CLASS);
		keyWordMap.put("constructor", CONSTRUCTOR);
		keyWordMap.put("function", FUNCTION);
		keyWordMap.put("method", METHOD);
		keyWordMap.put("field", FIELD);
		keyWordMap.put("static", STATIC);
		keyWordMap.put("var", VAR);
		keyWordMap.put("int", INT);
		keyWordMap.put("char", CHAR);
		keyWordMap.put("boolean", BOOLEAN);
		keyWordMap.put("void", VOID);
		keyWordMap.put("true", TRUE);
		keyWordMap.put("false", FALSE);
		keyWordMap.put("null", NULL);
		keyWordMap.put("this", THIS);
		keyWordMap.put("let", LET);
		keyWordMap.put("do", DO);
		keyWordMap.put("if", IF);
		keyWordMap.put("else", ELSE);
		keyWordMap.put("while", WHILE);
		keyWordMap.put("return", RETURN);

		opSet.add('+');
		opSet.add('-');
		opSet.add('*');
		opSet.add('/');
		opSet.add('&');
		opSet.add('|');
		opSet.add('<');
		opSet.add('>');
		opSet.add('=');
	}

	public Tokenizer(File inFile) {

		try {

			scanner = new Scanner(inFile);
			String preprocessed = "";
			String line = "";

			while (scanner.hasNext()) {

				line = noComments(scanner.nextLine()).trim();

				if (line.length() > 0) {
					preprocessed += line + "\n";
				}
			}

			preprocessed = noBlockComments(preprocessed).trim();

			initRegs();

			Matcher m = tokenPatterns.matcher(preprocessed);
			tokens = new ArrayList<String>();
			pointer = 0;

			while (m.find()) {

				tokens.add(m.group());

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

		currentToken = "";
		currentTokenType = -1;

	}

	private void initRegs() {

		keyWordReg = "";

		for (String seg : keyWordMap.keySet()) {

			keyWordReg += seg + "|";

		}

		symbolReg = "[\\&\\*\\+\\(\\)\\.\\/\\,\\-\\]\\;\\~\\}\\|\\{\\>\\=\\[\\<]";
		intReg = "[0-9]+";
		strReg = "\"[^\"\n]*\"";
		idReg = "[\\w_]+";

		tokenPatterns = Pattern.compile(
				keyWordReg + symbolReg + "|" + intReg + "|" + strReg + "|" + idReg);
	}

	public boolean hasMoreTokens() {
		return pointer < tokens.size();
	}

	public void advance() {

		if (hasMoreTokens()) {
			currentToken = tokens.get(pointer);
			pointer++;
		} else {
			throw new IllegalStateException("No more tokens");
		}

		if (currentToken.matches(keyWordReg)) {
			currentTokenType = KEYWORD;
		} else if (currentToken.matches(symbolReg)) {
			currentTokenType = SYMBOL;
		} else if (currentToken.matches(intReg)) {
			currentTokenType = INT_CONST;
		} else if (currentToken.matches(strReg)) {
			currentTokenType = STRING_CONST;
		} else if (currentToken.matches(idReg)) {
			currentTokenType = IDENTIFIER;
		} else {

			throw new IllegalArgumentException("Unknown token:" + currentToken);
		}

	}

	public String getToken() {
		return currentToken;
	}

	public int tokenType() {

		return currentTokenType;
	}

	public int keyWord() {

		if (currentTokenType == KEYWORD) {

			return keyWordMap.get(currentToken);

		} else {
			throw new IllegalStateException("Current token is not a keyword!");
		}
	}

	public char symbol() {

		if (currentTokenType == SYMBOL) {

			return currentToken.charAt(0);

		} else {
			throw new IllegalStateException("Current token is not a symbol!");
		}
	}

	public String identifier() {

		if (currentTokenType == IDENTIFIER) {

			return currentToken;

		} else {
			throw new IllegalStateException("Current token is not an identifier!");
		}
	}

	public int intVal() {

		if (currentTokenType == INT_CONST) {

			return Integer.parseInt(currentToken);
		} else {
			throw new IllegalStateException("Current token is not an integer constant!");
		}
	}

	public String stringVal() {

		if (currentTokenType == STRING_CONST) {

			return currentToken.substring(1, currentToken.length() - 1);

		} else {
			throw new IllegalStateException("Current token is not a string constant!");
		}
	}

	public void pointerBack() {

		if (pointer > 0) {
			pointer--;
		}

	}

	public boolean isOp() {
		return opSet.contains(symbol());
	}

	public static String noComments(String strIn) {

		int position = strIn.indexOf("//");

		if (position != -1) {

			strIn = strIn.substring(0, position);

		}

		return strIn;
	}

	public static String noSpaces(String strIn) {
		String result = "";

		if (strIn.length() != 0) {

			String[] segs = strIn.split(" ");

			for (String s : segs) {
				result += s;
			}
		}

		return result;
	}

	public static String noBlockComments(String strIn) {

		int startIndex = strIn.indexOf("/*");

		if (startIndex == -1)
			return strIn;

		String result = strIn;

		int endIndex = strIn.indexOf("*/");

		while (startIndex != -1) {

			if (endIndex == -1) {

				return strIn.substring(0, startIndex - 1);

			}
			result = result.substring(0, startIndex) + result.substring(endIndex + 2);

			startIndex = result.indexOf("/*");
			endIndex = result.indexOf("*/");
		}

		return result;
	}
}
