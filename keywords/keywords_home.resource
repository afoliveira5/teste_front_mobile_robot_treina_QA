*** Settings ***

Library     AppiumLibrary

Resource    ../variaveis/variaveis_home.resource

*** Keywords ***

Extrato home
    Wait Until Element Is Visible    ${botaoSaldoExtratoHome}           200
    Click Element                    ${botaoSaldoExtratoHome}
 
Carrossel do inicio da home 2
    Wait Until Element Is Visible    ${carrosel2}                       200
    Click Element                    ${carrosel2}

Carrossel do inicio da home_3
    Wait Until Element Is Visible    ${carrosel3}                       200
    Click Element                    ${carrosel3}

Adequar perfil de investimento
    Wait Until Element Is Visible    ${perfil_de_investimeto}           200
    Click Element                    ${perfil_de_investimeto}

Acessar adequar perfil
    Wait Until Element Is Visible    ${tela_do_adequar_perfil_Title}    200
    Element Text Should Be           ${tela_do_adequar_perfil_Title}    ${adequar_perfil_title_mensager} 

Saiba quanto economizar
    Wait Until Element Is Visible    ${Saiba_quanto_economizar}         200
    Click Element                    ${saiba_quanto_economizar}

Pague menos imposto de renda
    Wait Until Element Is Visible    ${pague_menos_imposto}             200
    Element Text Should Be           ${pague_menos_imposto}             ${pague_menos_imposto_message} 

carrosel faça acontecer
    Wait Until Element Is Visible    ${carrosel_faça_acontecer_message}         400
    Click Element                    ${comprar_plano}
    Wait Until Element Is Visible    ${comprar_plano_tela}

carrosel_faça_acontecer_2
    Wait Until Element Is Visible    ${carrosel_faça_acontecer_message}         400
    Click Element                    ${carrosel_faça_acontecer_2}
    Click Element                    ${contribuicao_extra}               
    Wait Until Element Is Visible    ${contribuicao_extra_tela} 

carrosel_faça_acontecer_3
    Wait Until Element Is Visible    ${carrosel_faça_acontecer_message}         400
    Click Element                    ${carrosel_faça_acontecer_3}
    Click Element                    ${objetivo_futuro}
    Wait Until Element Is Visible    ${objetivo_futuro_tela}

carrosel_aposentadoria_contribuicao 
    Wait Until Element Is Visible    ${carrosel_aposentadoria}         400
    Click Element                    ${contribuicao_mensal_aposentadoria}
    Wait Until Element Is Visible    ${contribuicao_mensal_aposentadoria_tela}

carrosel_idade_aposentadoria 
    Wait Until Element Is Visible    ${carrosel_aposentadoria}         400
    Click Element                    ${idade_da_aposentadoria}
    Wait Until Element Is Visible    ${idade_da_aposentadoria_modal}


carrosel_protecao_familiar
    Wait Until Element Is Visible    ${carrosel_protecao_familiar}         400
