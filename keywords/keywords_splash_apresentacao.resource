*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_splash.resource

*** Keywords ***

Open_App
    Wait Until Element Is Visible    ${Open_App}    50
    Click Element                    ${Open_App}

Splash apresentacao
    Wait Until Element Is Visible    ${proximo}    50
    Click Element                    ${proximo}
    Wait Until Element Is Visible    ${proximo}    50
    Click Element                    ${proximo}
    Wait Until Element Is Visible    ${proximo}    50
    Click Element                    ${proximo}
    Wait Until Element Is Visible    ${proximo}    50
    Click Element                    ${proximo}