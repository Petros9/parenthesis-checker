package com.virtuslab

import scala.meta._

object CodeTokenizer {
  
    def tokenizeCode(code: String): Tokenized = code.tokenize

    def redundantTokenFilter(tokens: Tokenized) :String = {
        tokens.get.tokens
          .filter(token => {
              !token.text.startsWith("\"") &&
                !token.text.startsWith("//") &&
                  !token.text.startsWith("/*")
          }).mkString("")
    }
}
