package com.treinaqa.app.ui.seletores

/**
 * Seletores do treinaQA Android — paridade com o site web.
 *
 * No app (Compose + Appium) o padrão de automação é só o **id** (resource-id).
 * cssSelector e xpath ficam aqui para documentação / paridade com o site;
 * o Modifier.seletor() aplica apenas o id.
 */

data class Seletor(
    val id: String,
    val cssSelector: String,
    val xpath: String = "//*[@resource-id='$id']",
) {
    val erroId: String get() = "erro-$id"
    val erroCss: String get() = "erro${cssSelector.replaceFirstChar { it.uppercase() }}"
    val erroXpath: String get() = "//*[@resource-id='$erroId']"
}

object Seletores {
    // ---------- Login ----------
    val paginaLogin = Seletor("view-login", "paginaLogin")
    val tituloMarca = Seletor("tituloMarca", "tituloMarca")
    val subtituloLogin = Seletor("subtituloLogin", "subtituloLogin")
    val tituloLogin = Seletor("tituloLogin", "tituloLogin")
    val dicaLogin = Seletor("dicaLogin", "dicaLogin")
    val loginEmail = Seletor("loginEmail", "campoEmail")
    val loginSenha = Seletor("loginSenha", "campoSenha")
    val olhoLoginSenha = Seletor("olhoLoginSenha", "olhoLoginSenha")
    val botaoEntrar = Seletor("botaoEntrar", "botaoEntrar")
    val linkCadastro = Seletor("linkCadastro", "linkCadastro")
    val linkEsqueciSenha = Seletor("linkEsqueciSenha", "linkEsqueciSenha")
    val toastLogin = Seletor("toastLogin", "toastLogin")

    // ---------- Cadastro ----------
    val paginaCadastro = Seletor("view-cadastro", "paginaCadastro")
    val voltarCadastro = Seletor("voltarCadastro", "botaoVoltarCadastro")
    val tituloCadastro = Seletor("tituloCadastro", "tituloCadastro")
    val formCadastro = Seletor("formCadastro", "formCadastro")
    val dicaCadastro = Seletor("dicaCadastro", "dicaCadastro")
    val nome = Seletor("nome", "nome")
    val emailCadastro = Seletor("emailCadastro", "email")
    val telefoneCadastro = Seletor("telefoneCadastro", "celular")
    val cpfCadastro = Seletor("cpfCadastro", "cpf")
    val grupoEnderecoCadastro = Seletor("grupoEnderecoCadastro", "grupoEndereco")
    val tituloEnderecoCadastro = Seletor("tituloEnderecoCadastro", "tituloEndereco")
    val labelEstadoCadastro = Seletor("labelEstadoCadastro", "labelEstado")
    val ruaCadastro = Seletor("ruaCadastro", "rua")
    val numeroCasaCadastro = Seletor("numeroCasaCadastro", "numeroCasa")
    val bairroCadastro = Seletor("bairroCadastro", "bairro")
    val cidadeCadastro = Seletor("cidadeCadastro", "cidade")
    val estadoCadastro = Seletor("estadoCadastro", "estado")
    /** Mesmo resource-id do campo Estado (abre o combo). */
    val abrirComboEstado = Seletor("estadoCadastro", "abrirComboEstado")
    val listaEstados = Seletor("listaEstados", "listaEstados")
    fun estadoOpcao(uf: String) = Seletor("estado-$uf", "estado$uf")
    val senha = Seletor("senha", "campoSenha")
    val olhoSenhaCadastro = Seletor("olhoSenhaCadastro", "olhoSenhaCadastro")
    val botaoCadastrar = Seletor("botaoCadastrar", "botaoCadastrar")
    val toastCadastro = Seletor("toastCadastro", "toastCadastro")
    val botaoOkCadastro = Seletor("botaoOkCadastro", "botaoOkCadastro")
    val modalCadastroSucesso = Seletor("modalCadastroSucesso", "modalCadastroSucesso")
    val rodapeCadastro = Seletor("rodapeCadastro", "rodapeCadastro")

    // ---------- Esqueci senha ----------
    val paginaEsqueci = Seletor("view-esqueci", "paginaEsqueciSenha")
    val emailRecuperacao = Seletor("emailRecuperacao", "campoEmailRecuperacao")
    val botaoEnviarRecuperacao = Seletor("botaoEnviarRecuperacao", "botaoEnviarRecuperacao")
    val toastEsqueciSenha = Seletor("toastEsqueciSenha", "toastEsqueciSenha")
    val voltarEsqueci = Seletor("voltarEsqueci", "botaoVoltarEsqueci")

    // ---------- Home / Meus Dados ----------
    val paginaDados = Seletor("view-home", "paginaDados")
    val menuMeusDados = Seletor("menuMeusDados", "menu_meus_dados")
    val menuAtualizar = Seletor("menuAtualizar", "menu_atualizar_dados")
    val botaoSair = Seletor("botaoSair", "botaoSair")
    val botaoEditar = Seletor("botaoEditar", "botaoEditar")
    val botaoExcluirParticipante = Seletor("botaoExcluirParticipante", "botaoExcluirParticipante")
    val valorNome = Seletor("valorNome", "valorNome")
    val valorEmail = Seletor("valorEmail", "valorEmail")
    val valorCelular = Seletor("valorCelular", "valorCelular")
    val valorCpf = Seletor("valorCpf", "valorCpf")
    val valorRua = Seletor("valorRua", "valorRua")
    val valorNumeroCasa = Seletor("valorNumeroCasa", "valorNumeroCasa")
    val valorBairro = Seletor("valorBairro", "valorBairro")
    val valorCidade = Seletor("valorCidade", "valorCidade")
    val valorEstado = Seletor("valorEstado", "valorEstado")

    // ---------- Atualizar ----------
    val paginaAtualizar = Seletor("view-atualizar", "paginaAtualizarDados")
    val voltarAtualizar = Seletor("voltarAtualizar", "botaoVoltarAtualizar")
    val tituloAtualizar = Seletor("tituloAtualizar", "tituloAtualizarUsuario")
    val dicaAtualizar = Seletor("dicaAtualizar", "dicaAtualizar")
    val formAtualizar = Seletor("formAtualizar", "formAtualizarDados")
    val nomeEdit = Seletor("nomeEdit", "nome")
    val emailEdit = Seletor("emailEdit", "email")
    val telefoneEdit = Seletor("telefoneEdit", "celular")
    val cpfEdit = Seletor("cpfEdit", "cpf")
    val grupoEnderecoAtualizar = Seletor("grupoEnderecoAtualizar", "grupoEndereco")
    val tituloEnderecoAtualizar = Seletor("tituloEnderecoAtualizar", "tituloEndereco")
    val labelEstadoAtualizar = Seletor("labelEstadoAtualizar", "labelEstado")
    val ruaEdit = Seletor("ruaEdit", "rua")
    val numeroCasaEdit = Seletor("numeroCasaEdit", "numeroCasa")
    val bairroEdit = Seletor("bairroEdit", "bairro")
    val cidadeEdit = Seletor("cidadeEdit", "cidade")
    val estadoEdit = Seletor("estadoEdit", "estado")
    /** Mesmo resource-id do campo Estado na tela Atualizar. */
    val abrirComboEstadoAtualizar = Seletor("estadoEdit", "abrirComboEstado")
    val listaEstadosAtualizar = Seletor("listaEstadosAtualizar", "listaEstados")
    fun estadoOpcaoAtualizar(uf: String) = Seletor("estadoEdit-$uf", "estado$uf")
    val botaoSalvar = Seletor("botaoSalvar", "botaoSalvar")
    val linkCancelar = Seletor("linkCancelar", "linkCancelar")
    val toastAtualizar = Seletor("toastAtualizar", "toastAtualizar")
    val botaoOkAtualizar = Seletor("botaoOkAtualizar", "botaoOkAtualizar")
    val modalAtualizarSucesso = Seletor("modalAtualizarSucesso", "modalAtualizarSucesso")
    val textoModalAtualizar = Seletor("textoModalAtualizar", "textoModalAtualizar")
    val rodapeAtualizar = Seletor("rodapeAtualizar", "rodapeAtualizar")

    // ---------- Exclusão ----------
    val modalConfirmarExclusao = Seletor("modalConfirmarExclusao", "modalConfirmarExclusao")
    val textoModalConfirmarExclusao = Seletor("textoModalConfirmarExclusao", "textoModalConfirmarExclusao")
    val botaoNaoExcluir = Seletor("botaoNaoExcluir", "botaoNaoExcluir")
    val botaoSimExcluir = Seletor("botaoSimExcluir", "botaoSimExcluir")
    val modalExclusaoSucesso = Seletor("modalExclusaoSucesso", "modalExclusaoSucesso")
    val textoModalExclusaoSucesso = Seletor("textoModalExclusaoSucesso", "textoModalExclusaoSucesso")
    val botaoOkExclusao = Seletor("botaoOkExclusao", "botaoOkExclusao")
}
