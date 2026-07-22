*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_login_cpf.resource
Resource    ../variaveis/variaveis_login_senha.resource
Resource    ../variaveis/cpf.resource

*** Keywords ***
Login
    Wait Until Element Is Visible    ${campocpf}                      50
    Click Element                    ${campocpf}    
    Input Text                       ${campocpf}                      ${cpf}    

    Click Element                    ${botaocontinuar}
    
    Wait Until Element Is Visible    ${camposenha}                    50
    Click Element                    ${camposenha}
    Input Text                       ${camposenha}                    ${senha}

    Click Element    ${botaoacessarconta}

Login CPF Invalido
    Wait Until Element Is Visible    ${campocpf}                      50
    Click Element                    ${campocpf}    
    Input Text                       ${campocpf}                      ${cpfinvalido}    

    Click Element                    ${botaocontinuar}
    
    Wait Until Element Is Visible    ${camposenha}                    50
    Click Element                    ${camposenha}
    Input Text                       ${camposenha}                    ${senha}

    Click Element                    ${botaoacessarconta}

    Wait Until Element Is Visible    ${toastusuariosenhainvalidos}    50
    Element Text Should Be           ${toastusuariosenhainvalidos}    ${mensagemUsuarioSenhaInvalidos}  
    Click Element    ${bntOkToastUserSenhaInvalido}

Login senha invalida
    Wait Until Element Is Visible    ${campocpf}                      50
    Click Element                    ${campocpf}    
    Input Text                       ${campocpf}                      ${cpf}    

    Click Element                    ${botaocontinuar}
    
    Wait Until Element Is Visible    ${camposenha}                    50
    Click Element                    ${camposenha}
    Input Text                       ${camposenha}                    ${senhainvalida}

    Click Element                    ${botaoacessarconta}

    Wait Until Element Is Visible    ${toastusuariosenhainvalidos}    50
    Element Text Should Be           ${toastusuariosenhainvalidos}    ${mensagemUsuarioSenhaInvalidos} 
    Click Element                    ${bntOkToastUserSenhaInvalido}

Login esqueci a senha 
    Wait Until Element Is Visible    ${campocpf}                      50
    Click Element                    ${campocpf}    
    Input Text                       ${campocpf}                      ${cpf}    

    Click Element                    ${botaocontinuar}
    
    Wait Until Element Is Visible    ${camposenha}                    50
    Click Element                    ${bntEsqueciSenha}