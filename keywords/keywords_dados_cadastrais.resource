*** Settings ***

Library     AppiumLibrary


Resource    ../variaveis/dados_cadastrais.resource
Resource    ../variaveis/busca_servico.resource

*** Keywords ***

atualização_cadastral    
    Wait Until Element Is Visible                   ${atualizacao_cadastral}                           300
    Click Element                                   ${btn_atualizacao_cadastral}
    Wait Until Element Is Visible                   ${atualizacao_cadastral_tela}                      300

dados_básicos
     Wait Until Element Is Visible                   ${atualizacao_cadastral_tela}                      600
     Click Element                                   ${btn_continua_atualizacao_cadastral}
     Wait Until Element Is Visible                   ${dados_basicos_tela}                          600

campos_dados_basicos 
    Wait Until Element Is Visible                   ${dados_basicos_tela}                      600
    Click Element                                   ${combo_box_estado_civil}
    Wait Until Element Is Visible                   ${option_combo_box_estado_civil}                      600
    Click Element                                   ${option_combo_box_estado_civil}
    Wait Until Element Is Visible                   ${combo_box_profissao}                      600
    Click Element                                   ${combo_box_profissao}
    Wait Until Element Is Visible                   ${option_combo_box_profissao}                      600
    Click Element                                   ${option_combo_box_profissao}
    Wait Until Element Is Visible                   ${campo_renda_mensal}                      600
    Clear Text                                      ${campo_renda_mensal}
    Wait Until Element Is Visible                   ${campo_renda_mensal_clean}                      600            
    Click Element                                   ${campo_renda_mensal_clean}
    Input Text                                      ${campo_renda_mensal_clean}                    ${renda_mensal}
    Wait Until Element Is Visible                   ${btn_Continuar_dados_basico}                      600 
    Click Element                                   ${btn_Continuar_dados_basico} 

Tela de PPE
    Wait Until Element Is Visible                   ${PPE_tela}                      600
    Click Element                                   ${Radio_buton_PPE_sim}    
    Wait Until Element Is Visible                   ${btn_continuar_ppe}                      600
    Click Element                                   ${btn_continuar_ppe}  