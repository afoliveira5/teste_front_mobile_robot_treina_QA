*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_login.resource
Resource    ../variaveis/dados_teste.resource
Resource    ../variaveis/variaveis_home.resource

*** Keywords ***
Aguardar tela login
    Wait Until Element Is Visible    ${pagina_login}    30
    Sleep    3s

Preencher campo
    [Arguments]    ${locator}    ${texto}
    Wait Until Element Is Visible    ${locator}    15
    Click Element                    ${locator}
    Clear Text                       ${locator}
    Input Text                       ${locator}    ${texto}

Login
    Aguardar tela login
    Preencher campo    ${campo_email}    ${EMAIL}
    Preencher campo    ${campo_senha}    ${SENHA}
    Click Element      ${botao_entrar}
    Wait Until Element Is Visible    ${pagina_home}    30

Login com credenciais
    [Arguments]    ${email}    ${senha}
    Aguardar tela login
    Preencher campo    ${campo_email}    ${email}
    Preencher campo    ${campo_senha}    ${senha}
    Click Element      ${botao_entrar}

Login email invalido
    Login com credenciais    ${EMAIL_INVALIDO}    ${SENHA}
    Wait Until Element Is Visible    ${toast_login}     15
    Element Text Should Be           ${toast_login}     ${MSG_LOGIN_INVALIDO}

Login senha invalida
    Login com credenciais    ${EMAIL}    ${SENHA_INVALIDA}
    Wait Until Element Is Visible    ${toast_login}     15
    Element Text Should Be           ${toast_login}     ${MSG_LOGIN_INVALIDO}

Abrir cadastro pela login
    Aguardar tela login
    Click Element                    ${link_cadastro}

Abrir esqueci senha pela login
    Aguardar tela login
    Click Element                    ${link_esqueci_senha}
