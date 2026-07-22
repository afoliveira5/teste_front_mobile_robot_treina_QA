*** Settings ***

Library    AppiumLibrary

Resource    ../Keywords_session.resource
Resource    ../keywords/keywords_local_feature_toggle.resource
Resource    ../keywords/keywords_splash_apresentacao.resource
Resource    ../keywords/keywords_entrar_simular_contratar_previdencia.resource

*** Test Cases ***

Deve acessar contratar previdenciaD

    Start session
    Local feature toggle
    Splash apresentacao
    Contratar previdencia
    Close session