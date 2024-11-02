package cs214

import scala.quoted.*

object PathMacro:
  def sourcePathImpl(using Quotes): Expr[String] =
    val res = quotes.reflect.Position.ofMacroExpansion.sourceFile.getJPath.get.toAbsolutePath.toString
    Expr(res)

  inline def sourcePath: String =
    ${ sourcePathImpl }
