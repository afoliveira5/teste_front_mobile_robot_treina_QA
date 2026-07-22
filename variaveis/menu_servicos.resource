
*** Settings ***

Library    AppiumLibrary

*** Variables ***

${acessar_menu_servico}                           br.com.quantaPrevidencia.homolog:id/mainTabServicesFragment
${menu_servico_tela}                              //android.widget.TextView[@text="Serviços"]
${beneficiario}                                   //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Beneficiários"]
${beneficiario_tela}                              br.com.quantaPrevidencia.homolog:id/toolbarTextTitle
${simular_aposentadoria}                          //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Simular Aposentadoria"]
${simular_aposentadoria_tela}                     br.com.quantaPrevidencia.homolog:id/btn_simulate_start
${adequar_perfil_de_investimento}                 //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Adequar Perfil de Investimento"]
${adequar_perfil_de_investimento_tela}            //android.widget.TextView[@text="Adequar Perfil"]
${extrato}                                        //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Extratos"]
${extrato_tela}                                   br.com.quantaPrevidencia.homolog:id/text_title
${informe_de_rendimento}                          //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Informe de Rendimentos"]
${informe_de_rendimento_tela}                     //android.widget.TextView[@text="Informe de Rendimentos"]
${documentos}                                     //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Documentos"]
${documentos_tela}                                //android.widget.TextView[@text="Documentos"]
${revisar_plano}                                  //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Revisar Plano"]
${revisar_plano_tela}                             br.com.quantaPrevidencia.homolog:id/titleTextView
${pagamentos}                                     //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Pagamentos"]
${pagamentos_tela}                                br.com.quantaPrevidencia.homolog:id/titleTextView
${comparar_plano}                                 //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Comparar Planos"]
${comparar_plano_tela}                            br.com.quantaPrevidencia.homolog:id/textHomeDesc
${pausar_contribuição}                            //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Pausar Contribuição"]
${pausar_contribuição_tela}                       //android.widget.TextView[@text="Pausa da Contribuição"]
${simular_resgate}                                //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Simular Resgate"]                               
${simular_resgate_tela}                           //android.widget.TextView[@text="Simular Resgate"]
${protecao_familiar}                              //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Proteção Familiar (Coberturas)"]
${protecao_familiar_tela}                         br.com.quantaPrevidencia.homolog:id/text_title
${pagar_menos_imposto}                            //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Pagar menos Imposto de Renda"]
${pagar_menos_imposto_tela}                       br.com.quantaPrevidencia.homolog:id/pay_less_taxes_title
${campo_busca_serviços}                           //android.widget.EditText
${atualizacao_cadastral_tela}                     //android.widget.TextView[@text="Dados Cadastrais"]
${configuracoes}                                  //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_menu" and @text="Configurações"]
${configuracoes_tela}                             br.com.quantaPrevidencia.homolog:id/tv_title_configuration