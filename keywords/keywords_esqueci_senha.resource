*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_esqueci_senha.resource
Resource    ../variaveis/dados_teste.resource
Resource    ../variaveis/variaveis_login.resource

*** Keywords ***
Aguardar tela esqueci senha
    Wait Until Element Is Visible    ${pagina_esqueci}    30

Recuperar senha
    [Arguments]    ${email}
    Aguardar tela esqueci senha
    Clear Text                       ${campo_email_recuperacao}
    Input Text                       ${campo_email_recuperacao}    ${email}
    Click Element                    ${botao_enviar_recuperacao}
    Wait Until Element Is Visible    ${toast_esqueci_senha}        15

Voltar do esqueci senha
    Click Element                    ${voltar_esqueci}
    Wait Until Element Is Visible    ${pagina_login}    15
