package ekko.typing

typealias Environment = Map<String, Forall>

fun emptyEnvironment(): Environment = emptyMap()

fun environmentOf(vararg pairs: Pair<String, Forall>): Environment = mapOf(pairs = pairs)

fun Environment.ftv(): Set<String> = values.flatMap { it.ftv() }.toSet()

fun Environment.extendEnv(vararg pairs: Pair<String, Forall>): Environment {
  return this + environmentOf(pairs = pairs)
}

fun Environment.apply(subst: Subst): Environment {
  return mapValues { it.value.apply(subst) }
}
