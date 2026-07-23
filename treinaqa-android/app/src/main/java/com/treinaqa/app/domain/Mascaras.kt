package com.treinaqa.app.domain

/** Máscaras iguais ao site (`validacao.js`). */
object Mascaras {
    fun soDigitos(valor: String?): String = (valor ?: "").replace(Regex("\\D"), "")

    /** +55 (00) 00000-0000 — máx. 13 dígitos; prefixa 55 se necessário */
    fun celular(valor: String?): String {
        var d = soDigitos(valor).take(13)
        if (d.isNotEmpty() && d.length <= 11 && !d.startsWith("55")) {
            d = ("55$d").take(13)
        }
        val out = StringBuilder()
        if (d.isNotEmpty()) out.append('+').append(d.take(2))
        if (d.length > 2) out.append(" (").append(d.substring(2, minOf(4, d.length)))
        if (d.length >= 4) out.append(')')
        if (d.length > 4) out.append(' ').append(d.substring(4, minOf(9, d.length)))
        if (d.length > 9) out.append('-').append(d.substring(9, minOf(13, d.length)))
        return out.toString()
    }

    /** 000.000.000-00 */
    fun cpf(valor: String?): String {
        val d = soDigitos(valor).take(11)
        return when {
            d.length <= 3 -> d
            d.length <= 6 -> "${d.take(3)}.${d.drop(3)}"
            d.length <= 9 -> "${d.take(3)}.${d.drop(3).take(3)}.${d.drop(6)}"
            else -> "${d.take(3)}.${d.drop(3).take(3)}.${d.drop(6).take(3)}-${d.drop(9)}"
        }
    }

    /** Só letras/números; no máximo 1 letra. */
    fun numeroCasa(valor: String?): String {
        val limpo = (valor ?: "").replace(Regex("[^a-zA-ZÀ-ÿ0-9]"), "")
        var letra = ""
        var numeros = ""
        var letraNoInicio = false
        for (ch in limpo) {
            if (ch.isLetter()) {
                if (letra.isEmpty()) {
                    letra = ch.uppercaseChar().toString()
                    letraNoInicio = numeros.isEmpty()
                }
            } else if (ch.isDigit()) {
                numeros += ch
            }
        }
        if (letra.isEmpty()) return numeros
        return if (letraNoInicio) letra + numeros else numeros + letra
    }
}
