*** Settings ***

Library     AppiumLibrary


Resource    ../variaveis/menu_servicos.resource
Resource    ../variaveis/busca_servico.resource

*** Keywords ***

Menu_Servicos
    Wait Until Element Is Visible                   ${acessar_menu_servico}                  
    Click Element                                   ${acessar_menu_servico}
    Wait Until Element Is Visible                   ${menu_servico_tela}         

beneficiario
    Wait Until Element Is Visible                   ${beneficiario}         
    Click Element                                   ${beneficiario}
    Wait Until Element Is Visible                   ${beneficiario_tela}                         300

simular_aposentadoria
    Wait Until Element Is Visible                   ${simular_aposentadoria}
    Click Element                                   ${simular_aposentadoria}
    Wait Until Element Is Visible                   ${simular_aposentadoria_tela}                300

adequar_perfil_de_investimento
    Wait Until Element Is Visible                   ${adequar_perfil_de_investimento}
    Click Element                                   ${adequar_perfil_de_investimento}
    Wait Until Element Is Visible                   ${adequar_perfil_de_investimento_tela}       300

extrato
    Wait Until Element Is Visible                   ${extrato}
    Click Element                                   ${extrato}
    Wait Until Element Is Visible                   ${extrato_tela}                              300

informe_de_rendimento
    Wait Until Element Is Visible                   ${informe_de_rendimento}
    Click Element                                   ${informe_de_rendimento}
    Wait Until Element Is Visible                   ${informe_de_rendimento_tela}                300

documentos
    Wait Until Element Is Visible                   ${documentos}
    Click Element                                   ${documentos}
    Wait Until Element Is Visible                   ${documentos_tela}                          300

revisar_plano
    Wait Until Element Is Visible                   ${revisar_plano}
    Click Element                                   ${revisar_plano}
    Wait Until Element Is Visible                   ${revisar_plano_tela}                       300

pagamentos
    Wait Until Element Is Visible                   ${pagamentos}
    Click Element                                   ${pagamentos}
    Wait Until Element Is Visible                   ${pagamentos_tela}                          300

comparar_plano
    Wait Until Element Is Visible                   ${comparar_plano}
    Click Element                                   ${comparar_plano}
    Wait Until Element Is Visible                   ${comparar_plano_tela}                          300

pausar_contribuição
    Wait Until Element Is Visible                   ${pausar_contribuição}
    Click Element                                   ${pausar_contribuição}
    Wait Until Element Is Visible                   ${pausar_contribuição_tela}                     300

simular_resgate
    Wait Until Element Is Visible                   ${simular_resgate}
    Click Element                                   ${simular_resgate}
    Wait Until Element Is Visible                   ${simular_resgate_tela}                        300

protecao_familiar
    Wait Until Element Is Visible                   ${protecao_familiar}
    Click Element                                   ${protecao_familiar}
    Wait Until Element Is Visible                   ${protecao_familiar_tela}                      300

pagar_menos_imposto
    Wait Until Element Is Visible                   ${pagar_menos_imposto}
    Click Element                                   ${pagar_menos_imposto}
    Wait Until Element Is Visible                   ${pagar_menos_imposto_tela}                    300

configuracoes
    Wait Until Element Is Visible                   ${configuracoes}
    Click Element                                   ${configuracoes}
    Wait Until Element Is Visible                   ${configuracoes_tela}                         300

	

atualizacao_cadastral_servico
    Wait Until Element Is Visible                   ${atualizacao_cadastral}                           300
    Click Element                                   ${atualizacao_cadastral}
    Wait Until Element Is Visible                   ${atualizacao_cadastral_tela}                      300

Buscar_servicos
    wait Until Element Is Visible                   ${campo_busca_serviços}                           300
    Click Element                                   ${campo_busca_serviços}    

    Input Text                                      ${campo_busca_serviços}                         ${atualizacao_cadastral}
