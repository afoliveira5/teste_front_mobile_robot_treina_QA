*** Settings ***

Library    AppiumLibrary

Resource    ../Keywords_session.resource
Resource    ../keywords/keywords_login.resource
Resource    ../keywords/keywords_home.resource

*** Test Cases ***

Deve realizar login com sucesso
    Start session
    Login
    Validar dados demo na home
    Close session

Deve validar email invalido no login
    Start session
    Login email invalido
    Close session

Deve validar senha invalida no login
    Start session
    Login senha invalida
    Close session

Deve abrir tela de cadastro pela login
    Start session
    Abrir cadastro pela login
    Close session

Deve abrir tela esqueci senha pela login
    Start session
    Abrir esqueci senha pela login
    Close session
