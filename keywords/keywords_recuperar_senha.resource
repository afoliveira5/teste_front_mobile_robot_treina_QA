*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_recuperar_senha_email.resource
Resource    ../variaveis/variaveis_esqueceu_senha_cpf.resource

*** Keywords ***

Recuperar senha
    Wait Until Element Is Visible    ${campoCpfRecuperSenha}              50
    Click Element                    ${bntRecuperarSenha}
    Wait Until Element Is Visible    ${campoMensagemRecuperaSenha}        50
    Element Text Should Be           ${campoMensagemRecuperaSenha}        ${msgRecuperarSenha} 