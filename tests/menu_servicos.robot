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

*** Test Cases ***

Deve acessar menu servicos
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    beneficiario
    Close session        

Deve acessar simular aposentadoria
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    simular_aposentadoria
    Close session 

Deve acessar adequar_perfil_de_investimento
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    adequar_perfil_de_investimento
    Close session 

Deve acessar extrato
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    extrato
    Close session

 Deve acessar informe_de_rendimento
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    informe_de_rendimento
    Close session   

Deve acessar documentos
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    documentos
    Close session     

Deve acessar revisar plano
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    revisar_plano
    Close session 

Deve acessar pagamentos
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    pagamentos
    Close session 


Deve acessar comparar_plano
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    comparar_plano
    Close session

Deve acessar pausar_contribuição
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_down
    pausar_contribuição
    Close session

Deve acessar simular_resgate
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_up
    simular_resgate
    Close session

Deve acessar protecao_familiar
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_up
    protecao_familiar
    Close session

Deve acessar pagar_menos_imposto
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_up
    pagar_menos_imposto
    Close session

Deve acessar dados cadastrais
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_up
    dados_cadastrais
    Close session    

Deve acessar configuracoes
    Start session
    Local feature toggle
    Splash apresentacao
    Entrar na conta
    Login
    Selecionar plano
    Menu_Servicos
    swipe_up
    configuracoes
    Close session  