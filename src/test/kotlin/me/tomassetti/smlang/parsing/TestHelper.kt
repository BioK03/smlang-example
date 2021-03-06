package me.tomassetti.smlang.parsing

import me.tomassetti.smlang.SMLexer
import me.tomassetti.smlang.SMParser
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import java.io.StringReader
import java.util.*


fun tokensNames(lexer: SMLexer): List<String> {
    val tokens = LinkedList<String>()
    do {
        val t = lexer.nextToken()
        when (t.type) {
            -1 -> tokens.add("EOF")
            else -> if (t.type != SMLexer.WS) tokens.add(lexer.vocabulary.getSymbolicName(t.type))
        }
    } while (t.type != -1)
    return tokens
}

fun tokensContent(lexer: SMLexer): List<String> {
    val tokens = LinkedList<String>()
    do {
        val t = lexer.nextToken()
        when (t.type) {
            -1 -> tokens.add("EOF")
            else -> if (t.type != SMLexer.WS) tokens.add(lexer.text)
        }
    } while (t.type != -1)
    return tokens
}

