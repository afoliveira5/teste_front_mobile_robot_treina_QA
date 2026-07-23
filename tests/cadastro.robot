*** Settings ***

Library    AppiumLibrary

Resource    ../Keywords_session.resource
Resource    ../keywords/keywords_login.resource
Resource    ../keywords/keywords_cadastro.resource

*** Test Cases ***

Deve cadastrar novo usuario
    ${sufixo}=    Get Time    epoch
    Start session
    Abrir cadastro pela login
    Cadastrar usuario
    ...    Usuario Robot ${sufixo}
    ...    robot.${sufixo}@teste.com
    ...    11999998888
    ...    52998224725
    ...    Rua Teste
    ...    100
    ...    Centro
    ...    Sao Paulo
    ...    SP
    ...    Senha@123
    Close session

Deve voltar do cadastro para login
    Start session
    Abrir cadastro pela login
    Aguardar tela cadastro
    Voltar do cadastro
    Aguardar tela login
    Close session
