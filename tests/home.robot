*** Settings ***


Library        AppiumLibrary

Resource    ../Keywords_session.resource
Resource    ../keywords/keywords_local_feature_toggle.resource
Resource    ../keywords/keywords_splash_apresentacao.resource
Resource    ../keywords/keywords_entrar_simular_contratar_previdencia.resource
Resource    ../keywords/keywords_login.resource
Resource    ../keywords/keywords_selecionar_plano.resource
Resource    ../keywords/keywords_home.resource

*** Test Cases ***

Deve acessar app_home

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Close session 

Deve acessar extrato via home

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Extrato home
    Close session

Deve acessar perfil de investimento via home

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Carrossel do inicio da home 2
    Adequar perfil de investimento
    Acessar adequar perfil
    Close session

Deve acessar pague menos imposto via home

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Carrossel do inicio da home 3
    saiba quanto economizar
    Pague menos imposto de renda
    Close session

Deve acessar comprar planos via home

    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    carrosel faça acontecer
    Close session
    
Deve acessar contibuicao extra
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    carrosel_faça_acontecer_2
    Close session

Deve acessar objetivo futuro
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    carrosel_faça_acontecer_3
    Close session

Deve acessar aposentadoria contribuicao mensal via home
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    carrosel_aposentadoria_contribuicao 
    Close session


Deve acessar idade de aposentadoria via home
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    carrosel_idade_aposentadoria 
    Close session

Deve acessar proteção familiar tela via home
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    carrosel_protecao_familiar 
    Swipe_up
    Close session
   