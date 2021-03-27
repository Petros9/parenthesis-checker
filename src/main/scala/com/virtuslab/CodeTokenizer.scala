package com.virtuslab

import scala.meta._

object CodeTokenizer {
  
    def tokenizeCode(code: String): Tokenized = code.tokenize

  // this function is responsible for mapping tokens such as comments and
  // quotes into string of " " of equal length to maintain accurate positioning
    def redundantTokenMapper(tokens: Tokenized) :String = {
        tokens.get.tokens
          .map(token => {
            if(token.text.startsWith("\"") ||
                token.text.startsWith("//") ||
                  token.text.startsWith("/*")) token.formatted(" " * token.text.length)

            else token
          }).mkString("")
    }
}
