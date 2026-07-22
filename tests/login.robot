*** Settings ***

Library    AppiumLibrary

Resource    ../Keywords_session.resource
Resource    ../keywords/keywords_local_feature_toggle.resource
Resource    ../keywords/keywords_splash_apresentacao.resource
Resource    ../keywords/keywords_entrar_simular_contratar_previdencia.resource
Resource    ../keywords/keywords_login.resource
Resource    ../keywords/keywords_selecionar_plano.resource
Resource    ../keywords/keywords_recuperar_senha.resource


*** Test Cases ***

Deve realizar login

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login 
   #Selecionar plano
    Close session

Deve validar cpf login

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login CPF Invalido    
    Close session

Deve validar senha login

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login senha invalida    
    Close session

Deve acessar o esqueci minha senha

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login esqueci a senha
    Recuperar senha    
    Close session