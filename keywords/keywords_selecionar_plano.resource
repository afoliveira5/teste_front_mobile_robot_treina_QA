*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_selecionar_planos.resource

*** Keywords ***

Selecionar plano
    Wait Until Element Is Visible    ${prevcoop}    180
    Click Element                    ${prevcoop}
    Wait Until Element Is Visible    ${inicio}      180    

