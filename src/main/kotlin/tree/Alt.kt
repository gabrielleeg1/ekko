package ekko.tree

data class Alt(val id: Ident, val patterns: List<Pat>, val exp: Exp)