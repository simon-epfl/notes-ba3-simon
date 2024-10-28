package recursion

def stringLength(s: String): Int =
  ???

def capitalizeString(s: String): String =
  ???

def discardWord(s: String): String =
  ???

def wordCount(s: String): Int =
  def discardWord(s: String): String =
    if s.isEmpty() then s
    else if !s.head.isWhitespace then discardWord(s.tail)
    else s
  
  if s.isEmpty() then 0 else if !s.head.isWhitespace then 1 + wordCount(discardWord(s)) else wordCount(s.tail)

def isBlank(s: String): Boolean =
  ???

def caesarCipher(s: String, shift: Int): String =
  if s.isEmpty() then s else (((s.head.toInt + shift - 'a'.toInt) % ('z'.toInt - 'a'.toInt + 1)) + 'a'.toInt).toChar.toString() + caesarCipher(s.tail, shift)

def reverseString(s: String): String =
  def reverseStringHelper(s: String, currString: String): String =
    if s.isEmpty() then currString else reverseStringHelper(s.tail, s.head.toString + currString)

  reverseStringHelper(s, "")
