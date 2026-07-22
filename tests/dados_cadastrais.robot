*** Settings ***

Library    AppiumLibrary

Resource    ../Keywords_session.resource
Resource    ../keywords/keywords_local_feature_toggle.resource
Resource    ../keywords/keywords_splash_apresentacao.resource
Resource    ../keywords/keywords_entrar_simular_contratar_previdencia.resource
Resource    ../keywords/keywords_login.resource
Resource    ../keywords/keywords_selecionar_plano.resource
Resource    ../keywords/keywords_recuperar_senha.resource
Resource    ../keywords/keywords_menu_servico.resource
Resource    ../keywords/keywords_dados_cadastrais.resource
Resource    ../variaveis/busca_servico.resource

*** Test Cases ***

Deve acessar atualização cadastral
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    Buscar_servicos
    atualização_cadastral 
    Close session

Deve acessar a tela de dados básicos
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    Buscar_servicos
    atualização_cadastral 
    dados_básicos 
    Close session

Deve acessar a tela de PPE
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    Buscar_servicos
    atualização_cadastral 
    dados_básicos 
    campos_dados_basicos
    Tela de PPE
    Close session  