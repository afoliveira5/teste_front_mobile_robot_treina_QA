*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_entrar.resource

*** Keywords ***

Entrar na conta
    Wait Until Element Is Visible    ${entrarnaconta}           50
    Click Element                    ${entrarnaconta}

Simular previdencia 
    Wait Until Element Is Visible    ${simularPrevidencia}      50
    Click Element                    ${simularPrevidencia}

Contratar previdencia
    Wait Until Element Is Visible    ${contratarPrevidencia}    50
    Click Element                    ${contratarPrevidencia}
     Wait Until Element Is Visible   ${telacontratarPrevidencia}