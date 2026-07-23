*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_home.resource
Resource    ../variaveis/variaveis_login.resource
Resource    ../variaveis/dados_teste.resource
Resource    ../variaveis/variaveis_atualizar.resource

*** Keywords ***
Aguardar tela home
    Wait Until Element Is Visible    ${pagina_home}    30

Validar dados demo na home
    Aguardar tela home
    Wait Until Element Is Visible    ${valor_nome}     15
    Element Text Should Be           ${valor_nome}     ${NOME_DEMO}
    Element Text Should Be           ${valor_email}    ${EMAIL}

Abrir atualizar dados
    Aguardar tela home
    Click Element                    ${menu_atualizar}
    Wait Until Element Is Visible    ${pagina_atualizar}    20

Sair da conta
    Aguardar tela home
    Click Element                    ${botao_sair}
    Wait Until Element Is Visible    ${pagina_login}    20

Cancelar exclusao participante
    Aguardar tela home
    Click Element                    ${botao_excluir}
    Wait Until Element Is Visible    ${modal_confirmar_exclusao}    10
    Click Element                    ${botao_nao_excluir}
    Wait Until Element Is Visible    ${pagina_home}    10
