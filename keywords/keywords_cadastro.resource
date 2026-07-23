*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_cadastro.resource
Resource    ../variaveis/variaveis_home.resource

*** Keywords ***
Aguardar tela cadastro
    Wait Until Element Is Visible    ${pagina_cadastro}    30

Preencher cadastro
    [Arguments]    ${nome}    ${email}    ${telefone}    ${cpf}    ${rua}    ${numero}    ${bairro}    ${cidade}    ${estado}    ${senha}
    Aguardar tela cadastro
    Input Text    ${campo_nome}              ${nome}
    Input Text    ${campo_email_cadastro}    ${email}
    Input Text    ${campo_telefone}          ${telefone}
    Input Text    ${campo_cpf}               ${cpf}
    Input Text    ${campo_rua}               ${rua}
    Input Text    ${campo_numero}            ${numero}
    Input Text    ${campo_bairro}            ${bairro}
    Input Text    ${campo_cidade}            ${cidade}
    Click Element  ${campo_estado}
    Wait Until Page Contains    ${estado}    10
    Click Text                   ${estado}
    Input Text    ${campo_senha_cadastro}    ${senha}

Cadastrar usuario
    [Arguments]    ${nome}    ${email}    ${telefone}    ${cpf}    ${rua}    ${numero}    ${bairro}    ${cidade}    ${estado}    ${senha}
    Preencher cadastro    ${nome}    ${email}    ${telefone}    ${cpf}    ${rua}    ${numero}    ${bairro}    ${cidade}    ${estado}    ${senha}
    Click Element                    ${botao_cadastrar}
    Wait Until Element Is Visible    ${modal_cadastro_sucesso}    20
    Click Element                    ${botao_ok_cadastro}
    Wait Until Element Is Visible    ${pagina_home}               30

Voltar do cadastro
    Click Element                    ${voltar_cadastro}
