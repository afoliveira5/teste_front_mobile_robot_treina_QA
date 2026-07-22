*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_Toggle.resource

*** Keywords ***

Local feature toggle

  Wait Until Element Is Visible    ${liberar1}    50
    Click Element                    ${liberar1}
    Wait Until Element Is Visible    ${continuartoggle}    50
    Click Element                    ${continuartoggle}