*** Settings ***

Library    AppiumLibrary

Resource    ../Keywords_session.resource
Resource    ../keywords/keywords_login.resource
Resource    ../keywords/keywords_home.resource

*** Test Cases ***

Deve exibir dados do usuario apos login
    Start session
    Login
    Validar dados demo na home
    Close session

Deve abrir tela de atualizar dados
    Start session
    Login
    Abrir atualizar dados
    Close session

Deve cancelar exclusao de participante
    Start session
    Login
    Cancelar exclusao participante
    Close session

Deve sair da conta
    Start session
    Login
    Sair da conta
    Close session
