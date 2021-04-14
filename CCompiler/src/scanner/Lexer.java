// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: Lexer.flex

package scanner;
import static scanner.TokenType.*;
import static scanner.Token.*;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class Lexer {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\1\1\2\22\0\1\1"+
    "\1\0\1\4\4\0\1\5\2\0\1\6\1\7\1\0"+
    "\1\7\1\0\1\10\1\11\7\12\2\13\3\0\1\7"+
    "\3\0\6\14\21\15\1\16\2\15\1\0\1\17\2\0"+
    "\1\20\1\0\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\15\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\15\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\12\0\1\3\u01a2\0\2\3"+
    "\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\1\2\3\2\4\20\5\1\0"+
    "\1\6\4\0\1\2\1\4\1\0\6\5\1\7\4\5"+
    "\1\7\13\5\1\10\1\0\1\4\30\5\1\2\27\5";

  private static int [] zzUnpackAction() {
    int [] result = new int[108];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\122\0\173\0\244\0\51\0\315\0\366"+
    "\0\u011f\0\u0148\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215\0\u023e"+
    "\0\u0267\0\u0290\0\u02b9\0\u02e2\0\u030b\0\u0334\0\u035d\0\u0386"+
    "\0\u03af\0\173\0\51\0\u03d8\0\u0401\0\u042a\0\u0453\0\u047c"+
    "\0\u04a5\0\u04ce\0\u04f7\0\u0520\0\u0549\0\u0572\0\u059b\0\u05c4"+
    "\0\u05ed\0\u0616\0\u063f\0\u0668\0\u0691\0\u0148\0\u06ba\0\u06e3"+
    "\0\u070c\0\u0735\0\u075e\0\u0787\0\u07b0\0\u07d9\0\u0802\0\u082b"+
    "\0\u0854\0\51\0\u087d\0\u04ce\0\u08a6\0\u08cf\0\u08f8\0\u0921"+
    "\0\u094a\0\u0973\0\u099c\0\u09c5\0\u09ee\0\u0a17\0\u0a40\0\u0a69"+
    "\0\u0a92\0\u0abb\0\u0ae4\0\u0b0d\0\u0b36\0\u0b5f\0\u0b88\0\u0bb1"+
    "\0\u0bda\0\u0c03\0\u0c2c\0\u0c55\0\51\0\u0c7e\0\u0ca7\0\u0cd0"+
    "\0\u0cf9\0\u0d22\0\u0d4b\0\u0d74\0\u0d9d\0\u0dc6\0\u0def\0\u0e18"+
    "\0\u0e41\0\u0e6a\0\u0e93\0\u0ebc\0\u0ee5\0\u0f0e\0\u0f37\0\u0f60"+
    "\0\u0f89\0\u0fb2\0\u0fdb\0\u1004";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[108];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\0\1\4\1\5\2\6\1\7\1\10"+
    "\2\11\3\12\2\2\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\12\1\22\1\12\1\23\4\12\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\3\12\52\0\2\3"+
    "\46\0\2\32\1\0\1\32\1\33\12\32\1\34\31\32"+
    "\2\35\1\0\2\35\1\0\11\35\1\36\31\35\6\0"+
    "\1\37\1\0\1\40\51\0\2\41\3\0\1\42\27\0"+
    "\1\42\13\0\3\11\46\0\6\12\1\0\31\12\11\0"+
    "\6\12\1\0\23\12\1\43\5\12\11\0\6\12\1\0"+
    "\20\12\1\44\10\12\11\0\6\12\1\0\1\12\1\45"+
    "\6\12\1\46\5\12\1\47\12\12\11\0\6\12\1\0"+
    "\5\12\1\50\10\12\1\51\12\12\11\0\6\12\1\0"+
    "\13\12\1\45\1\12\1\52\10\12\1\53\2\12\11\0"+
    "\6\12\1\0\13\12\1\54\2\12\1\55\12\12\11\0"+
    "\6\12\1\0\16\12\1\43\12\12\11\0\6\12\1\0"+
    "\6\12\1\56\6\12\1\57\13\12\11\0\6\12\1\0"+
    "\16\12\1\60\12\12\11\0\6\12\1\0\5\12\1\61"+
    "\23\12\11\0\6\12\1\0\10\12\1\62\1\63\10\12"+
    "\1\64\2\12\1\65\3\12\11\0\6\12\1\0\27\12"+
    "\1\66\1\12\11\0\6\12\1\0\15\12\1\67\13\12"+
    "\11\0\6\12\1\0\16\12\1\70\12\12\11\0\6\12"+
    "\1\0\10\12\1\71\20\12\4\0\2\32\11\0\1\32"+
    "\2\0\1\32\3\0\1\32\6\0\1\32\2\0\1\32"+
    "\1\0\1\32\13\0\1\72\47\0\2\35\11\0\1\35"+
    "\2\0\1\35\3\0\1\35\6\0\1\35\2\0\1\35"+
    "\1\0\1\35\6\0\6\37\1\73\42\37\2\40\1\0"+
    "\46\40\11\0\2\41\47\0\4\74\4\0\6\74\33\0"+
    "\6\12\1\0\22\12\1\75\6\12\11\0\6\12\1\0"+
    "\5\12\1\76\23\12\11\0\6\12\1\0\21\12\1\77"+
    "\7\12\11\0\6\12\1\0\1\12\1\55\27\12\11\0"+
    "\6\12\1\0\15\12\1\100\13\12\11\0\6\12\1\0"+
    "\6\12\1\101\22\12\11\0\6\12\1\0\23\12\1\102"+
    "\5\12\11\0\6\12\1\0\23\12\1\103\5\12\11\0"+
    "\6\12\1\0\22\12\1\104\6\12\11\0\6\12\1\0"+
    "\16\12\1\105\12\12\11\0\6\12\1\0\20\12\1\56"+
    "\10\12\11\0\6\12\1\0\22\12\1\56\6\12\11\0"+
    "\6\12\1\0\15\12\1\106\13\12\11\0\6\12\1\0"+
    "\7\12\1\107\12\12\1\110\6\12\11\0\6\12\1\0"+
    "\16\12\1\111\12\12\11\0\6\12\1\0\7\12\1\112"+
    "\20\12\1\113\11\0\6\12\1\0\1\12\1\114\16\12"+
    "\1\115\10\12\11\0\6\12\1\0\11\12\1\116\17\12"+
    "\11\0\6\12\1\0\17\12\1\117\11\12\11\0\6\12"+
    "\1\0\11\12\1\120\7\12\1\121\7\12\11\0\6\12"+
    "\1\0\11\12\1\122\1\12\1\123\15\12\11\0\6\12"+
    "\1\0\11\12\1\124\17\12\6\37\1\73\1\37\1\125"+
    "\40\37\11\0\6\12\1\0\16\12\1\56\12\12\11\0"+
    "\6\12\1\0\1\12\1\126\27\12\11\0\6\12\1\0"+
    "\5\12\1\56\23\12\11\0\6\12\1\0\21\12\1\57"+
    "\1\127\6\12\11\0\6\12\1\0\1\12\1\130\27\12"+
    "\11\0\6\12\1\0\2\12\1\124\26\12\11\0\6\12"+
    "\1\0\14\12\1\56\14\12\11\0\6\12\1\0\5\12"+
    "\1\131\23\12\11\0\6\12\1\0\1\12\1\57\27\12"+
    "\11\0\6\12\1\0\7\12\1\56\21\12\11\0\6\12"+
    "\1\0\11\12\1\132\17\12\11\0\6\12\1\0\23\12"+
    "\1\131\5\12\11\0\6\12\1\0\20\12\1\57\10\12"+
    "\11\0\6\12\1\0\15\12\1\133\13\12\11\0\6\12"+
    "\1\0\5\12\1\134\23\12\11\0\6\12\1\0\22\12"+
    "\1\135\6\12\11\0\6\12\1\0\23\12\1\136\5\12"+
    "\11\0\6\12\1\0\22\12\1\137\6\12\11\0\6\12"+
    "\1\0\5\12\1\140\23\12\11\0\6\12\1\0\16\12"+
    "\1\141\12\12\11\0\6\12\1\0\11\12\1\142\17\12"+
    "\11\0\6\12\1\0\4\12\1\56\24\12\11\0\6\12"+
    "\1\0\1\12\1\143\27\12\11\0\6\12\1\0\13\12"+
    "\1\77\15\12\11\0\6\12\1\0\12\12\1\56\16\12"+
    "\11\0\6\12\1\0\11\12\1\144\17\12\11\0\6\12"+
    "\1\0\23\12\1\145\5\12\11\0\6\12\1\0\20\12"+
    "\1\141\10\12\11\0\6\12\1\0\21\12\1\146\7\12"+
    "\11\0\6\12\1\0\5\12\1\122\23\12\11\0\6\12"+
    "\1\0\16\12\1\147\12\12\11\0\6\12\1\0\11\12"+
    "\1\150\17\12\11\0\6\12\1\0\3\12\1\57\25\12"+
    "\11\0\6\12\1\0\3\12\1\151\25\12\11\0\6\12"+
    "\1\0\4\12\1\152\24\12\11\0\6\12\1\0\15\12"+
    "\1\56\13\12\11\0\6\12\1\0\7\12\1\112\21\12"+
    "\11\0\6\12\1\0\22\12\1\71\6\12\11\0\6\12"+
    "\1\0\15\12\1\153\13\12\11\0\6\12\1\0\13\12"+
    "\1\57\15\12\11\0\6\12\1\0\22\12\1\154\6\12"+
    "\11\0\6\12\1\0\6\12\1\56\22\12\11\0\6\12"+
    "\1\0\3\12\1\56\25\12\11\0\6\12\1\0\10\12"+
    "\1\56\20\12\11\0\6\12\1\0\5\12\1\147\23\12"+
    "\11\0\6\12\1\0\23\12\1\77\5\12\11\0\6\12"+
    "\1\0\5\12\1\55\23\12";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4141];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\23\1\1\0\1\11\4\0"+
    "\2\1\1\0\27\1\1\11\1\0\31\1\1\11\27\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[108];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
    private Token token(TokenType type, Object value){
        return new Token(type, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token nextToken() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return token(ERROR, yytext());
            }
            // fall through
          case 9: break;
          case 2:
            { /*Ignore*/
            }
            // fall through
          case 10: break;
          case 3:
            { return token(OPERATOR, yytext());
            }
            // fall through
          case 11: break;
          case 4:
            { return token(INTEGER, yytext());
            }
            // fall through
          case 12: break;
          case 5:
            { return token(IDENTIFIER, yytext());
            }
            // fall through
          case 13: break;
          case 6:
            { return token(STRING, yytext());
            }
            // fall through
          case 14: break;
          case 7:
            { return token(KEYWORD, yytext());
            }
            // fall through
          case 15: break;
          case 8:
            { return token(CHAR, yytext());
            }
            // fall through
          case 16: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
