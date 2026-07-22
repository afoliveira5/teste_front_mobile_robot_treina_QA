*** Settings ***

Library    AppiumLibrary

Resource    ../Keywords_session.resource
Resource    ../keywords/keywords_local_feature_toggle.resource
Resource    ../keywords/keywords_splash_apresentacao.resource
Resource    ../keywords/keywords_entrar_simular_contratar_previdencia.resource
Resource    ../keywords/keywords_login.resource
Resource    ../keywords/keywords_selecionar_plano.resource
Resource    ../keywords/keywords_home.resource

*** Test Cases ***

Deve acessar extrato via home

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Extrato home
    Close session
