# Seletores — treinaQA Android (APK)

No Android **não existe HTML**. Os equivalentes são:

| Web | Android (Compose + Appium) |
|-----|----------------------------|
| **id** (`#loginEmail`) | **resource-id** = `loginEmail` (`testTag`) — **padrão de automação** |
| **cssSelector** (`[data-cy="campoEmail"]`) | Mantido em `Seletores.kt` / esta tabela (paridade web) — **não** vira Accessibility ID no app |
| **xpath** | `//*[@resource-id='loginEmail']` |

Requer `testTagsAsResourceId = true` no app (já configurado).

> **Por que antes misturava Accessibility ID e id?**  
> O `Modifier.seletor()` gravava `id` no `testTag` (resource-id) **e** `cssSelector` no `contentDescription` (Accessibility ID). Quando os valores eram diferentes (ex.: id=`emailCadastro`, css=`email`), o Inspector mostrava os dois. Em alguns nós (TextField / dropdown) só um aparecia. Agora o app aplica **somente o id**.

---

## Login

| Elemento | id (resource-id) | cssSelector | xpath |
|----------|------------------|-------------|-------|
| Página | `view-login` | `paginaLogin` | `//*[@resource-id='view-login']` |
| Marca | `tituloMarca` | `tituloMarca` | `//*[@resource-id='tituloMarca']` |
| E-mail | `loginEmail` | `campoEmail` | `//*[@resource-id='loginEmail']` |
| Senha | `loginSenha` | `campoSenha` | `//*[@resource-id='loginSenha']` |
| Olho senha | `olhoLoginSenha` | `olhoLoginSenha` | `//*[@resource-id='olhoLoginSenha']` |
| Entrar | `botaoEntrar` | `botaoEntrar` | `//*[@resource-id='botaoEntrar']` |
| Criar conta | `linkCadastro` | `linkCadastro` | `//*[@resource-id='linkCadastro']` |
| Esqueci senha | `linkEsqueciSenha` | `linkEsqueciSenha` | `//*[@resource-id='linkEsqueciSenha']` |
| Toast | `toastLogin` | `toastLogin` | `//*[@resource-id='toastLogin']` |

---

## Cadastro

| Elemento | id | cssSelector | xpath | Erro id |
|----------|-----|-------------|-------|---------|
| Página | `view-cadastro` | `paginaCadastro` | `//*[@resource-id='view-cadastro']` | — |
| Voltar | `voltarCadastro` | `botaoVoltarCadastro` | `//*[@resource-id='voltarCadastro']` | — |
| Título | `tituloCadastro` | `tituloCadastro` | `//*[@resource-id='tituloCadastro']` | — |
| Nome | `nome` | `nome` | `//*[@resource-id='nome']` | `erro-nome` |
| E-mail | `emailCadastro` | `email` | `//*[@resource-id='emailCadastro']` | `erro-emailCadastro` |
| Celular | `telefoneCadastro` | `celular` | `//*[@resource-id='telefoneCadastro']` | `erro-telefoneCadastro` |
| CPF | `cpfCadastro` | `cpf` | `//*[@resource-id='cpfCadastro']` | `erro-cpfCadastro` |
| Rua | `ruaCadastro` | `rua` | `//*[@resource-id='ruaCadastro']` | `erro-ruaCadastro` |
| Número | `numeroCasaCadastro` | `numeroCasa` | `//*[@resource-id='numeroCasaCadastro']` | `erro-numeroCasaCadastro` |
| Bairro | `bairroCadastro` | `bairro` | `//*[@resource-id='bairroCadastro']` | `erro-bairroCadastro` |
| Cidade | `cidadeCadastro` | `cidade` | `//*[@resource-id='cidadeCadastro']` | `erro-cidadeCadastro` |
| Estado | `estadoCadastro` | `estado` | `//*[@resource-id='estadoCadastro']` | `erro-estadoCadastro` |
| Lista UF | `listaEstados` | `listaEstados` | `//*[@resource-id='listaEstados']` | — |
| Opção UF | `estado-SP` (ex.) | `estadoSP` | `//*[@resource-id='estado-SP']` | — |
| Senha | `senha` | `campoSenha` | `//*[@resource-id='senha']` | `erro-senha` |
| Cadastrar | `botaoCadastrar` | `botaoCadastrar` | `//*[@resource-id='botaoCadastrar']` | — |
| Toast | `toastCadastro` | `toastCadastro` | `//*[@resource-id='toastCadastro']` | — |
| OK modal | `botaoOkCadastro` | `botaoOkCadastro` | `//*[@resource-id='botaoOkCadastro']` | — |

---

## Esqueci senha

| Elemento | id | cssSelector | xpath |
|----------|-----|-------------|-------|
| Página | `view-esqueci` | `paginaEsqueciSenha` | `//*[@resource-id='view-esqueci']` |
| E-mail | `emailRecuperacao` | `campoEmailRecuperacao` | `//*[@resource-id='emailRecuperacao']` |
| Enviar | `botaoEnviarRecuperacao` | `botaoEnviarRecuperacao` | `//*[@resource-id='botaoEnviarRecuperacao']` |
| Toast | `toastEsqueciSenha` | `toastEsqueciSenha` | `//*[@resource-id='toastEsqueciSenha']` |

---

## Home / Meus Dados

| Elemento | id | cssSelector | xpath |
|----------|-----|-------------|-------|
| Página | `view-home` | `paginaDados` | `//*[@resource-id='view-home']` |
| Menu Meus Dados | `menuMeusDados` | `menu_meus_dados` | `//*[@resource-id='menuMeusDados']` |
| Menu Atualizar | `menuAtualizar` | `menu_atualizar_dados` | `//*[@resource-id='menuAtualizar']` |
| Sair | `botaoSair` | `botaoSair` | `//*[@resource-id='botaoSair']` |
| Editar | `botaoEditar` | `botaoEditar` | `//*[@resource-id='botaoEditar']` |
| Excluir | `botaoExcluirParticipante` | `botaoExcluirParticipante` | `//*[@resource-id='botaoExcluirParticipante']` |
| valorNome…valorEstado | `valorNome` etc. | mesmo nome | `//*[@resource-id='valorNome']` |

---

## Atualizar dados

| Elemento | id | cssSelector | xpath |
|----------|-----|-------------|-------|
| Página | `view-atualizar` | `paginaAtualizarDados` | `//*[@resource-id='view-atualizar']` |
| Voltar | `voltarAtualizar` | `botaoVoltarAtualizar` | `//*[@resource-id='voltarAtualizar']` |
| Marca | `tituloMarca` | `tituloMarca` | `//*[@resource-id='tituloMarca']` |
| Título | `tituloAtualizar` | `tituloAtualizarUsuario` | `//*[@resource-id='tituloAtualizar']` |
| Dica | `dicaAtualizar` | `dicaAtualizar` | `//*[@resource-id='dicaAtualizar']` |
| Form | `formAtualizar` | `formAtualizarDados` | `//*[@resource-id='formAtualizar']` |
| Nome | `nomeEdit` | `nome` | `//*[@resource-id='nomeEdit']` |
| E-mail | `emailEdit` | `email` | `//*[@resource-id='emailEdit']` |
| Celular | `telefoneEdit` | `celular` | `//*[@resource-id='telefoneEdit']` |
| CPF (readonly) | `cpfEdit` | `cpf` | `//*[@resource-id='cpfEdit']` |
| Grupo endereço | `grupoEnderecoAtualizar` | `grupoEndereco` | `//*[@resource-id='grupoEnderecoAtualizar']` |
| Título endereço | `tituloEnderecoAtualizar` | `tituloEndereco` | `//*[@resource-id='tituloEnderecoAtualizar']` |
| Label estado | `labelEstadoAtualizar` | `labelEstado` | `//*[@resource-id='labelEstadoAtualizar']` |
| Rua | `ruaEdit` | `rua` | `//*[@resource-id='ruaEdit']` |
| Número | `numeroCasaEdit` | `numeroCasa` | `//*[@resource-id='numeroCasaEdit']` |
| Bairro | `bairroEdit` | `bairro` | `//*[@resource-id='bairroEdit']` |
| Cidade | `cidadeEdit` | `cidade` | `//*[@resource-id='cidadeEdit']` |
| Estado | `estadoEdit` | `estado` | `//*[@resource-id='estadoEdit']` |
| Lista UF | `listaEstadosAtualizar` | `listaEstados` | `//*[@resource-id='listaEstadosAtualizar']` |
| Opção UF | `estadoEdit-SP` (ex.) | `estadoSP` | `//*[@resource-id='estadoEdit-SP']` |
| Salvar | `botaoSalvar` | `botaoSalvar` | `//*[@resource-id='botaoSalvar']` |
| Toast | `toastAtualizar` | `toastAtualizar` | `//*[@resource-id='toastAtualizar']` |
| Modal sucesso | `modalAtualizarSucesso` | `modalAtualizarSucesso` | `//*[@resource-id='modalAtualizarSucesso']` |
| Texto modal | `textoModalAtualizar` | `textoModalAtualizar` | `//*[@resource-id='textoModalAtualizar']` |
| OK modal | `botaoOkAtualizar` | `botaoOkAtualizar` | `//*[@resource-id='botaoOkAtualizar']` |
| Rodapé | `rodapeAtualizar` | `rodapeAtualizar` | `//*[@resource-id='rodapeAtualizar']` |
| Cancelar | `linkCancelar` | `linkCancelar` | `//*[@resource-id='linkCancelar']` |

---

## Exclusão

| Elemento | id | cssSelector | xpath |
|----------|-----|-------------|-------|
| Texto confirma | `textoModalConfirmarExclusao` | `textoModalConfirmarExclusao` | `//*[@resource-id='textoModalConfirmarExclusao']` |
| Não | `botaoNaoExcluir` | `botaoNaoExcluir` | `//*[@resource-id='botaoNaoExcluir']` |
| Sim | `botaoSimExcluir` | `botaoSimExcluir` | `//*[@resource-id='botaoSimExcluir']` |
| OK sucesso | `botaoOkExclusao` | `botaoOkExclusao` | `//*[@resource-id='botaoOkExclusao']` |
