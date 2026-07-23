package com.treinaqa.app.domain

object UsuarioValidators {
    /** Ordem igual ao site (`ESTADOS_BR` em validacao.js). */
    val ufs: List<String> = listOf(
        "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG",
        "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO",
    )

    private val estadosBr = ufs.toSet()

    private val senhaRegex =
        Regex("^[a-zA-ZÀ-ÿ]{1,8}[^a-zA-ZÀ-ÿ0-9\\s][a-zA-ZÀ-ÿ]{1,6}\\d{2,4}$")

    fun soDigitos(valor: String?): String = (valor ?: "").replace(Regex("\\D"), "")

    fun nome(valor: String?): String? {
        val v = valor?.trim().orEmpty()
        if (v.isEmpty()) return "Nome é obrigatório. Não pode ser vazio."
        if (Regex("^[^a-zA-ZÀ-ÿ]+$").matches(v)) {
            return "Nome: não aceite enviar só com caracteres especiais."
        }
        val palavras = v.split(Regex("\\s+")).filter { it.isNotEmpty() }
        if (palavras.size < 2) return "Nome: informe dois nomes ou mais."
        if (!palavras.all { Regex("[a-zA-ZÀ-ÿ]").containsMatchIn(it) }) {
            return "Nome: informe dois nomes ou mais (apenas texto)."
        }
        val significativas = palavras.filter {
            it.replace(Regex("[^a-zA-ZÀ-ÿ]"), "").length >= 2
        }
        if (significativas.size < 2) return "Nome: não aceite apenas uma letra."
        return null
    }

    fun email(valor: String?): String? {
        val v = valor?.trim()?.lowercase().orEmpty()
        if (v.isEmpty()) return "E-mail é obrigatório. Não pode ser vazio."
        if (!Regex("@(gmail|yahoo|hotmail|outlook)\\.", RegexOption.IGNORE_CASE).containsMatchIn(v)) {
            return "formato de email errado: formato correto é seu nome @gmail, @yahoo, @hotmail ou @outlook."
        }
        if (!Regex("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$").matches(v)) return "E-mail inválido."
        return null
    }

    fun cpf(valor: String?): String? {
        val v = valor?.trim().orEmpty()
        if (v.isEmpty()) return "CPF é obrigatório. Não pode ser vazio."
        if (Regex("[a-zA-ZÀ-ÿ]").containsMatchIn(v)) return "CPF: não aceite letras."
        if (Regex("[^0-9.\\-\\s]").containsMatchIn(v)) return "CPF: não aceite caracteres especiais."
        val digitos = soDigitos(v)
        if (digitos.length < 11) return "CPF incompleto."
        if (digitos.length > 11) return "CPF com excesso de dígitos."
        if (digitos.toLongOrNull() == 0L) return "CPF: não pode valor zerado."
        return null
    }

    fun celular(valor: String?): String? {
        val v = valor?.trim().orEmpty()
        if (v.isEmpty()) return "Celular é obrigatório. Não pode ser vazio."
        if (Regex("[a-zA-ZÀ-ÿ]").containsMatchIn(v)) return "Celular: não aceite letras."
        if (Regex("[^0-9+\\s()\\-]").containsMatchIn(v)) {
            return "Celular: não aceite caracteres especiais."
        }
        val digitos = soDigitos(v)
        if (digitos.length < 13) return "Celular incompleto."
        if (digitos.length > 13) return "Celular com excesso de dígitos."
        if (digitos.toLongOrNull() == 0L) return "Celular: não pode valor zerado."
        return null
    }

    fun localidade(valor: String?, rotulo: String, maxLen: Int): String? {
        val v = valor?.trim().orEmpty()
        if (v.isEmpty()) return "$rotulo é obrigatório. Não pode ser vazio."
        if (Regex("^\\d+$").matches(v)) return "$rotulo: não aceite só número."
        if (Regex("^[^a-zA-ZÀ-ÿ0-9]+$").matches(v)) {
            return "$rotulo: não aceite só caracteres especiais."
        }
        if (Regex("^\\d$").matches(v)) return "$rotulo: não aceite só um dígito."
        if (v.length < 4) return "$rotulo: texto muito curto."
        if (v.length > maxLen) return "$rotulo: texto muito longo."
        val palavras = v.split(Regex("\\s+")).filter { it.isNotEmpty() }
        if (palavras.size < 2) {
            return "$rotulo: informe o nome completo (dois nomes ou mais)."
        }
        if (palavras.any { it.replace(Regex("[^a-zA-ZÀ-ÿ]"), "").length == 1 }) {
            return "$rotulo: não aceite só uma letra."
        }
        if (!palavras.all { Regex("[a-zA-ZÀ-ÿ]").containsMatchIn(it) }) {
            return "$rotulo: informe o nome completo (dois nomes ou mais)."
        }
        return null
    }

    fun numeroCasa(valor: String?): String? {
        val v = valor?.trim().orEmpty()
        if (v.isEmpty()) return "Número da casa é obrigatório. Não pode ser vazio."
        if (Regex("[^a-zA-ZÀ-ÿ0-9]").containsMatchIn(v)) {
            return "Número da casa: não aceite caracteres especiais."
        }
        if (Regex("^[a-zA-ZÀ-ÿ]+$").matches(v)) {
            return "Número da casa: não aceite só letras."
        }
        if (!Regex("^(\\d+|[a-zA-ZÀ-ÿ]+\\d+|\\d+[a-zA-ZÀ-ÿ]+)$").matches(v)) {
            return "Número da casa: use só número, ou número + letra."
        }
        return null
    }

    fun estado(valor: String?): String? {
        val v = valor?.trim()?.uppercase().orEmpty()
        if (v.isEmpty()) return "Estado é obrigatório. Selecione um estado."
        if (v !in estadosBr) return "Estado: selecione uma UF válida."
        return null
    }

    fun senha(valor: String?): String? {
        val v = valor ?: ""
        if (v.isEmpty()) return "Senha é obrigatória. Não pode ser vazia."
        if (v.length <= 1) return "Senha: não aceite apenas 1 letra ou caractere."
        if (!senhaRegex.matches(v)) return "Senha fora do padrão permitido."
        return null
    }

    fun validarCadastro(
        nome: String,
        email: String,
        telefone: String,
        cpf: String,
        rua: String,
        numeroCasa: String,
        bairro: String,
        cidade: String,
        estado: String,
        senha: String,
    ): Map<String, String> {
        val erros = linkedMapOf<String, String>()
        nome(nome)?.let { erros["nome"] = it }
        email(email)?.let { erros["email"] = it }
        celular(telefone)?.let { erros["telefone"] = it }
        cpf(cpf)?.let { erros["cpf"] = it }
        localidade(rua, "Nome da rua", 50)?.let { erros["rua"] = it }
        numeroCasa(numeroCasa)?.let { erros["numeroCasa"] = it }
        localidade(bairro, "Bairro", 100)?.let { erros["bairro"] = it }
        localidade(cidade, "Cidade", 100)?.let { erros["cidade"] = it }
        estado(estado)?.let { erros["estado"] = it }
        senha(senha)?.let { erros["senha"] = it }
        return erros
    }

    fun validarAtualizacao(
        nome: String,
        email: String,
        telefone: String,
        rua: String,
        numeroCasa: String,
        bairro: String,
        cidade: String,
        estado: String,
    ): Map<String, String> {
        val erros = linkedMapOf<String, String>()
        nome(nome)?.let { erros["nome"] = it }
        email(email)?.let { erros["email"] = it }
        celular(telefone)?.let { erros["telefone"] = it }
        localidade(rua, "Nome da rua", 50)?.let { erros["rua"] = it }
        numeroCasa(numeroCasa)?.let { erros["numeroCasa"] = it }
        localidade(bairro, "Bairro", 100)?.let { erros["bairro"] = it }
        localidade(cidade, "Cidade", 100)?.let { erros["cidade"] = it }
        estado(estado)?.let { erros["estado"] = it }
        return erros
    }

}
