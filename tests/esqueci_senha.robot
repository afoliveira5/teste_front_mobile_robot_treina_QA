*** Settings ***

Library    AppiumLibrary

Resource    ../Keywords_session.resource
Resource    ../keywords/keywords_login.resource
Resource    ../keywords/keywords_esqueci_senha.resource

*** Test Cases ***

Deve solicitar recuperacao de senha
    Start session
    Abrir esqueci senha pela login
    Recuperar senha    ${EMAIL}
    Close session

Deve voltar do esqueci senha para login
    Start session
    Abrir esqueci senha pela login
    Voltar do esqueci senha
    Close session
